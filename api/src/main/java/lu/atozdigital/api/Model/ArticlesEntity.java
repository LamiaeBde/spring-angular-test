package lu.atozdigital.api.Model;
import javax.persistence.*;
import java.io.Serializable;
import javax.persistence.Entity;

@Entity
@Table(name = "articles")

public class ArticlesEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_article", nullable = false)
        private Long id_article;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private float price;

    @Column(name = "picture")
    private String picture;

    @Override
    public String toString() {
        return "Articles{" +
                "id_article=" + id_article +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", picture=" +picture +
                '}';
    }

    public void setId_article(Long id_article) {
        this.id_article = id_article;
    }

    public Long getId_article() {
        return id_article;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public String getPicture() {
        return picture;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
