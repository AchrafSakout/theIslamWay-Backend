package a3.emsi.theislamway.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String image;
    private String alias;
    private String mail;
    private String passWord;
    private int points;
    private int capLecture;
    private int absence;
    private String privilege;
    @ManyToOne
    private Group group;
    @OneToMany(mappedBy = "user")
    private Collection<Hizb> Hizbs;
}
