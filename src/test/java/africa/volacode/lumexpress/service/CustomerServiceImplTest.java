package africa.volacode.lumexpress.service;

import africa.volacode.lumexpress.data.dtos.request.CustomerRegistrationRequest;
import africa.volacode.lumexpress.data.dtos.response.CustomerRegistrationResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CustomerServiceImplTest {



    @Autowired
    private CustomerService customerService;
    private CustomerRegistrationRequest request;


    @BeforeEach
    void setUp() {
        request = CustomerRegistrationRequest
                .builder()
                .email("olamide@gmail.com")
                .password("olamide")
                .country("Nigeria")
                .build();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void register() {

        CustomerRegistrationResponse customerRegistrationResponse =  customerService.register(request);
        assertThat(customerRegistrationResponse).isNotNull();
        assertThat(customerRegistrationResponse.getMessage()).isNotNull();
        assertThat(customerRegistrationResponse.getUserId()).isGreaterThan(0);
        assertThat(customerRegistrationResponse.getCode()).isEqualTo(201);



    }

    @Test
    void login() {
    }

    @Test
    void completeProfile() {
    }
}