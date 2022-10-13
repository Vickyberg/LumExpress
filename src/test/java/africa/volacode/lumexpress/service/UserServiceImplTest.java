package africa.volacode.lumexpress.service;

import africa.volacode.lumexpress.data.dtos.request.LoginRequest;
import africa.volacode.lumexpress.data.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Sql(scripts = "insert.sql")
class UserServiceImplTest {
    @Autowired
    private  UserService userService;
    private LoginRequest loginRequest;


    @BeforeEach
    void setUp() {
        loginRequest= LoginRequest.builder()
                .email("test@email.com")
                .password("password")
                .build();
    }

    @Test
    void loginUserTest() {

        var response = userService.login(loginRequest);
        assertThat(response).isNotNull();
        assertThat(response.getCode()).isEqualTo(200);
    }
}