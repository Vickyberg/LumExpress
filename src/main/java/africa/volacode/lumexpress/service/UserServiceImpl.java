package africa.volacode.lumexpress.service;

import africa.volacode.lumexpress.data.dtos.request.LoginRequest;
import africa.volacode.lumexpress.data.dtos.response.LoginResponse;
import africa.volacode.lumexpress.data.models.Admin;
import africa.volacode.lumexpress.data.models.Customer;
import africa.volacode.lumexpress.data.models.LumExpressUser;
import africa.volacode.lumexpress.data.models.Vendor;
import africa.volacode.lumexpress.data.repository.AdminRepository;
import africa.volacode.lumexpress.data.repository.CustomerRepository;
import africa.volacode.lumexpress.data.repository.VendorRepository;
import africa.volacode.lumexpress.exception.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@AllArgsConstructor
public class UserServiceImpl implements  UserService{

    private final CustomerRepository customerRepository;
    private final VendorRepository vendorRepository;
    private  final AdminRepository adminRepository;
    @Override
    public LoginResponse login(LoginRequest loginRequest) {
       Optional<Customer> customer = customerRepository.findByEmail(loginRequest.getEmail());
        if (customer.isPresent() && customer.get().getPassword().equals(loginRequest.getPassword()))return  buildSuccessfulLoginResponse(customer.get());
        Optional<Admin> admin = adminRepository.findByEmail(loginRequest.getEmail());
        if (admin.isPresent() && admin.get().getPassword().equals(loginRequest.getPassword())) return  buildSuccessfulLoginResponse(admin.get());
        Optional<Vendor> vendor = vendorRepository.findByEmail(loginRequest.getEmail());
        if (vendor.isPresent()  && vendor.get().getPassword().equals(loginRequest.getPassword())) return buildSuccessfulLoginResponse(vendor.get());

        return LoginResponse.builder()
                .code(400)
                .message("Login failed. Bad credentials")
                .build();

    }

    @Override
    public LumExpressUser getUserByUsername(String email) throws UserNotFoundException {
        Optional<Admin> foundAdmin = adminRepository.findByEmail(email);
        if(foundAdmin.isPresent()) return foundAdmin.get();

        Optional<Customer> foundCustomer = customerRepository.findByEmail(email);
        if(foundCustomer.isPresent()) return foundCustomer.get();

        Optional<Vendor> foundVendor = vendorRepository.findByEmail(email);
        if (foundVendor.isPresent()) return  foundVendor.get();

         throw new UserNotFoundException("User not found!!!");
    }

    private LoginResponse buildSuccessfulLoginResponse(LumExpressUser user) {
        return LoginResponse.builder()
                .message("user logged in successfully")
                .code(200)
                .build();

    }
}
