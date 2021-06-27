package model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "categoryId")
    private int categoryId;
    @Column(columnDefinition = "NVARCHAR(100)")
    private String name;

    @OneToOne(mappedBy = "category", cascade = CascadeType.ALL)
    private Post post;
}
