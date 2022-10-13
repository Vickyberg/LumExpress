package africa.volacode.lumexpress.service;

import africa.volacode.lumexpress.data.dtos.request.CustomerRegistrationRequest;
import africa.volacode.lumexpress.data.dtos.request.UpdateCustomerDetails;
import africa.volacode.lumexpress.data.dtos.response.CustomerRegistrationResponse;
import africa.volacode.lumexpress.service.customer.CustomerService;
import africa.volacode.lumexpress.util.LumExpressUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
class CustomerServiceImplTest {



    @Autowired
    private CustomerService customerService;
    private CustomerRegistrationRequest request;


    @BeforeEach
    void setUp() {
        request = CustomerRegistrationRequest
                .builder()
                .email("akinnusivictor098@gmail.com")
                .password("olamide")
                .country("Nigeria")
                .build();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void registerCustomerTest() {

        CustomerRegistrationResponse customerRegistrationResponse =  customerService.register(request);
        assertThat(customerRegistrationResponse).isNotNull();
        assertThat(customerRegistrationResponse.getMessage()).isNotNull();
        assertThat(customerRegistrationResponse.getUserId()).isGreaterThan(0);
        assertThat(customerRegistrationResponse.getCode()).isEqualTo(201);



    }

    @Test
    void updateProfileTest() {
        CustomerRegistrationResponse customerRegistrationResponse = customerService.register(request);
        UpdateCustomerDetails details =UpdateCustomerDetails
                .builder()
                .customerId(customerRegistrationResponse.getUserId())
                .imageUrl(LumExpressUtils.getMockCloudinaryImageUrl())
                .lastName("test lastName")
                .phoneNumber("12334567344").city("lagos").state("lagos state").buildingNumber(23).street("semicolon street")
                .build();
        var updatedCustomer = customerService.updateProfile(details);
        log.info("updated customer -->{}",updatedCustomer);
        assertThat(updatedCustomer).isNotNull();
        assertThat(updatedCustomer.contains("success")).isTrue();
    }
}