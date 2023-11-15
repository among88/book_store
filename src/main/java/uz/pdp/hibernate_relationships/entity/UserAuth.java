package uz.pdp.hibernate_relationships.entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString(exclude = {"user"})
public class UserAuth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Username;
    private String email;
    private String password;
    @OneToOne(fetch = FetchType.LAZY)
    private User user;
}
