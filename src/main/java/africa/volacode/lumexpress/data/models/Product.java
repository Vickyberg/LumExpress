package africa.volacode.lumexpress.data.models;



import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name ;
    private BigDecimal price;
    private int quantity;
    @ElementCollection
    private List<Category> category;
    private String imageUrl;

}
