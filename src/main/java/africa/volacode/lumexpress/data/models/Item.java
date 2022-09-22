package africa.volacode.lumexpress.data.models;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    @OneToOne(fetch = FetchType.EAGER)
    private Product products;
}
