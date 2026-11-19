package kh.edu.istad.m2restapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "thanu_categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 30, nullable = false)
    private String name;
    @Column(length = 255, nullable = false)
    private String icon;

    @OneToMany(mappedBy = "category")
    private List<Product> products;

}
