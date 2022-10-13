package africa.volacode.lumexpress.service.customer;

import africa.volacode.lumexpress.data.dtos.request.CustomerRegistrationRequest;
import africa.volacode.lumexpress.data.dtos.request.EmailNotificationRequest;
import africa.volacode.lumexpress.data.dtos.request.LoginRequest;
import africa.volacode.lumexpress.data.dtos.request.UpdateCustomerDetails;
import africa.volacode.lumexpress.data.dtos.response.CustomerRegistrationResponse;
import africa.volacode.lumexpress.data.dtos.response.LoginResponse;
import africa.volacode.lumexpress.data.models.Address;
import africa.volacode.lumexpress.data.models.Cart;
import africa.volacode.lumexpress.data.models.Customer;
import africa.volacode.lumexpress.data.models.VerificationToken;
import africa.volacode.lumexpress.data.repository.CustomerRepository;
import africa.volacode.lumexpress.exception.UserNotFoundException;
import africa.volacode.lumexpress.service.notifications.EmailNotificationService;
import africa.volacode.lumexpress.service.token.VerificationTokenService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;
    private final ModelMapper mapper = new ModelMapper() ;
    private final EmailNotificationService emailNotificationService;
    private final VerificationTokenService verificationTokenService;


    @Override
    public CustomerRegistrationResponse register(CustomerRegistrationRequest registerRequest) {
        Customer customer = mapper.map(registerRequest, Customer.class);
        customer.setCart(new Cart());
        setCustomerAddress(registerRequest,customer);
        Customer savedCustomer = customerRepository.save(customer);
        log.info("customer to be saved in db :: {}",savedCustomer);
        var token = verificationTokenService.createToken(savedCustomer.getEmail());
        emailNotificationService.sendHtmlMail(buildEmailNotificationRequest(token, savedCustomer.getFirstName()));
        return registrationResponseBuilder(savedCustomer);
    }

    private void setCustomerAddress(CustomerRegistrationRequest registerRequest, Customer customer) {
        Address customerAddress = new Address();
        customerAddress.setCountry(registerRequest.getCountry());
        customer.getAddresses().add(customerAddress);
    }

    private EmailNotificationRequest buildEmailNotificationRequest(VerificationToken verificationToken, String customerName) {
        var message = getEmailTemplate();
        String mail = null;
        if(message != null){
            var verificationUrl = "http://localhost:8080//api//v1//customer//verify//" + verificationToken.getToken();
            mail= String.format(message,customerName,verificationUrl);
            log.info("mailed url-->{}",verificationUrl);
        }
        return EmailNotificationRequest.builder()
                .userEmail(verificationToken.getUserEmail())
                .mailContent(mail)
                .build();
    }

    private String getEmailTemplate(){
        try(BufferedReader bufferedReader =new BufferedReader( new FileReader("C:\\Users\\Olamide\\Documents\\SpringBootProject\\lum-express\\src\\main\\resources\\welcome.txt"))){
            return  bufferedReader.lines().collect(Collectors.joining());
        }catch (IOException exception){
        exception.printStackTrace();
        }
        return null;
    }

    private CustomerRegistrationResponse registrationResponseBuilder(Customer customer){
       return CustomerRegistrationResponse.builder()
                .message("success")
                .userId(customer.getId())
                .code(201)
                .build();
    }



    @Override
    public String updateProfile(UpdateCustomerDetails updateCustomerDetails) {
     Customer customerToUpdate =   customerRepository.findById(updateCustomerDetails.getCustomerId())
                .orElseThrow(()->new UserNotFoundException(
                        String.format("Customer with the id %d, not found",
                                updateCustomerDetails.getCustomerId())));
     mapper.map(updateCustomerDetails,customerToUpdate);
     Set<Address> customerAddressList = customerToUpdate.getAddresses();
     Optional<Address> foundAddress = customerToUpdate.getAddresses().stream().findFirst();
     if(foundAddress.isPresent()) applyAddressUpdate(foundAddress.get(),updateCustomerDetails);
     customerToUpdate.getAddresses().add(foundAddress.get());
     Customer updatedCustomer = customerRepository.save(customerToUpdate);

        return String.format("%s details updated successful",updatedCustomer.getFirstName());
    }

    private void applyAddressUpdate(Address address, UpdateCustomerDetails updateCustomerDetails) {
        address.setBuildingNumber(updateCustomerDetails.getBuildingNumber());
        address.setCity(updateCustomerDetails.getCity());
        address.setStreet(updateCustomerDetails.getStreet());
        address.setState(updateCustomerDetails.getState());
    }
}
