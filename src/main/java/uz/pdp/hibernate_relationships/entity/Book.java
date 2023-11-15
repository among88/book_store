package uz.pdp.hibernate_relationships.entity;

import jakarta.persistence.*;
import lombok.*;

import java.security.PrivateKey;
import java.util.List;

@Getter
@Setter
@Builder
@Table(name = "books")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Author author;
    private String linkImg;
    private String summary;
    private boolean isAvailable;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Author authors;
}
