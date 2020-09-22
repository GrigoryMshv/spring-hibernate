package ru.geekbrains.hibernate.crud;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "buyer")
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name_buyer")
    private String name;

    @ManyToMany
    @JoinTable(
            name = "card",
            joinColumns = @JoinColumn(name = "buyer_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )

    private List<Product> product;

    public List<Product> getProduct() {
        return product;
    }

    public void setProducts(List<Product> product) {
        this.product = product;
    }

    public Buyer() {
    }

    public Buyer(String name) {
        this.name = name;
    }

    public Buyer(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return id +  " " + name;
    }
}
