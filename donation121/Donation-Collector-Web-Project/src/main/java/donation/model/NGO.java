package donation.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "NGO")
@Data
public class NGO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String password;

    private String imgUrl;

    private String email;

    private String phoneNum;

    private String coverArea;

    private String description;

    @OneToOne(cascade = CascadeType.ALL,targetEntity = Address.class)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;
}
