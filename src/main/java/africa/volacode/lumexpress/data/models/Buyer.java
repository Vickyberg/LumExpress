package africa.volacode.lumexpress.data.models;

import java.util.Set;

import javax.persistence.*;

@Entity
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private Cart cart;
    @OneToMany
    private Set<Address> addresses;
}
