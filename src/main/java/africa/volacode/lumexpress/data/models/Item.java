package africa.volacode.lumexpress.data.models;

import javax.persistence.*;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    @OneToOne
    private Product products;
}
