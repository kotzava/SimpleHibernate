package model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
@Data
@NoArgsConstructor
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long statusId;
    @Column(columnDefinition = "VARCHAR(50)")
    private String name;
    @OneToMany(mappedBy = "status")
    private Set<User> users;

    public Status(String name) {
        this.name = name;
    }
}
