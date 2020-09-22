package ru.geekbrains.hibernate.crud;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private int price;

    public Product() {
    }

    @ManyToMany
    @JoinTable(
            name = "card",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "buyer_id")
    )
    private List<Buyer> buyer;

    public List<Buyer> getBuyer() {
        return buyer;
    }

    public void setBuyers(List<Buyer> buyer) {
        this.buyer = buyer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
