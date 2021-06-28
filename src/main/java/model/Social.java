package model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Social {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long socialId;
    @Column(columnDefinition = "VARCHAR(500)")
    private String name;
    @Column(columnDefinition = "VARCHAR(500)")
    private String link;
    @Column(columnDefinition = "VARCHAR(MAX)")
    private String image;
    @ManyToMany(mappedBy = "socials")
    private Set<User> users = new HashSet<>();
}
