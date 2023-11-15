package uz.pdp.hibernate_relationships.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String first_name;
    private String last_name;
    private String imgLink;
    @OneToOne(cascade = CascadeType.PERSIST)
    private UserAuth userAuth;

}
