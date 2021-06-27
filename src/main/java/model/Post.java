package model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "postId")
    private int postId;
    @Column(columnDefinition = "NVARCHAR(500)")
    private String title;
    @Column(columnDefinition = "NVARCHAR(MAX)")
    private String description;
    @Column(columnDefinition = "NVARCHAR(MAX)")
    private String content;
    @Temporal(TemporalType.DATE)
    private Date updateTime;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private User user;

    @ManyToMany
    @JoinTable(name = "PostTag",
            joinColumns = {@JoinColumn(name = "post_id")},
            inverseJoinColumns = {@JoinColumn(name = "tag_id")})
    private Set<Tag> tags = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "category_id", referencedColumnName = "categoryId")
    private Category category;
}
