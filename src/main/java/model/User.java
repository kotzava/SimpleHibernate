package model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Users")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    @Column(length = 50)
    private String userName;
    @Column(length = 500)
    private String password;
    @Column(length = 100)
    private String email;
    @Column(columnDefinition = "NVARCHAR(100)")
    private String fullName;
    @Column(columnDefinition = "NVARCHAR(MAX)")
    private String biography;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "UserRole",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "userId")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "roleId")})
    private Role role;
    @OneToMany(mappedBy = "user")
    private Set<Contact> contacts;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "UserSocial",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "social_id")})
    private Set<Social> socials;

    @OneToMany(mappedBy = "user")
    private Set<Post> posts;

    public User(String userName, String password, String email, String fullName, String biography) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.fullName = fullName;
        this.biography = biography;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", biography='" + biography + '\'' +
                '}';
    }
}
