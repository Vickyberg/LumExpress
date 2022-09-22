package africa.volacode.lumexpress.data.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class User {
    private String firstName;
    private String lastName;
    private  String email;
    private  String password;
    private String phoneNumber;
}
