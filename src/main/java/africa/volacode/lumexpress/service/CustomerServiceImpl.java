package africa.volacode.lumexpress.service;

import africa.volacode.lumexpress.data.dtos.request.CustomerRegistrationRequest;
import africa.volacode.lumexpress.data.dtos.request.LoginRequest;
import africa.volacode.lumexpress.data.dtos.request.UpdateCustomerDetails;
import africa.volacode.lumexpress.data.dtos.response.CustomerRegistrationResponse;
import africa.volacode.lumexpress.data.dtos.response.LoginResponse;
import africa.volacode.lumexpress.data.models.Address;
import africa.volacode.lumexpress.data.models.Cart;
import africa.volacode.lumexpress.data.models.Customer;
import africa.volacode.lumexpress.data.repository.CustomerRepository;
import com.cloudinary.Cloudinary;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;
    private final ModelMapper mapper = new ModelMapper() ;

    @Override
    public CustomerRegistrationResponse register(CustomerRegistrationRequest registerRequest) {
        Customer customer = mapper.map(registerRequest, Customer.class);
        customer.setCart(new Cart());
        Address customerAddress = new Address();
        customerAddress.setCountry(registerRequest.getCountry());
        customer.getAddresses().add(customerAddress);
        Customer savedCustomer = customerRepository.save(customer);
        log.info("customer to be saved in db :: {}",savedCustomer);
        return registrationResponseBuilder(savedCustomer);
    }

    private CustomerRegistrationResponse registrationResponseBuilder(Customer customer){
       return CustomerRegistrationResponse.builder()
                .message("success")
                .userId(customer.getId())
                .code(201)
                .build();
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        return null;
    }

    @Override
    public String completeProfile(UpdateCustomerDetails updateCustomerDetails) {
        return null;
    }
}
