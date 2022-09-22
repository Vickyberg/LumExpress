package africa.volacode.lumexpress.data.models;

import lombok.*;

import java.util.Set;

import javax.persistence.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Buyer extends LumExpressUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private Cart cart;
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Address> addresses;
}
