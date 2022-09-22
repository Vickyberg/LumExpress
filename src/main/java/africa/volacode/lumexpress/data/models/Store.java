package africa.volacode.lumexpress.data.models;

import javax.persistence.*;
import java.util.Set;
@Entity
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany
    private Set<Product> products;
}
