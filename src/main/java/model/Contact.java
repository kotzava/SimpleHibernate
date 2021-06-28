package model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long contactId;

    @Column(columnDefinition = "NVARCHAR(100)")
    private String name;

    @Column(columnDefinition = "VARCHAR(100)")
    private String email;

    @Column(columnDefinition = "NVARCHAR(500)")
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
