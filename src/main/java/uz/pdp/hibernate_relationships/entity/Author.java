package uz.pdp.hibernate_relationships.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@Table(name = "authors")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Book> listOfBooks;
}
