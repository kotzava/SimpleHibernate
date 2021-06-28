package model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long roleId;

    @Column(columnDefinition = "NVARCHAR(50)")
    private String name;

    @OneToOne(mappedBy = "role")
    private User user;
}
