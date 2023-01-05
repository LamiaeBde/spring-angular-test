package lu.atozdigital.api.Model;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")

public class OrdersEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_order", nullable = false)
    private Long id_order;

    @Column(name = "reference", nullable = false)
    private String reference;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date", nullable = false)
    private Date date;

    @Override
    public String toString() {
        return "OrdersEntity{" +
                "id_order=" + id_order +
                ", reference='" + reference + '\'' +
                ", date=" + date +
                ", articles=" + articles +
                '}';
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "Lines_item",
            joinColumns = @JoinColumn(
                    name = "id_order", referencedColumnName = "id_order"),
            inverseJoinColumns = @JoinColumn(
                    name = "id_article", referencedColumnName = "id_article"))
    private List<ArticlesEntity> articles;

    public List<ArticlesEntity> getArticles() {
        return articles;
    }
    public void setArticles(List<ArticlesEntity> articles) {
        this.articles = articles;
    }

    public void setId_order(Long id_order) {
        this.id_order = id_order;
    }
    public void setReference(String reference) {
        this.reference = reference;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getId_order() {
        return id_order;
    }

    public String getReference() {
        return reference;
    }

    public Date getDate() {
        return date;
    }
}
