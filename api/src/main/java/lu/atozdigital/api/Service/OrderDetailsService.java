package lu.atozdigital.api.Service;
import lu.atozdigital.api.Model.ArticlesEntity;
import lu.atozdigital.api.Model.OrdersEntity;
import lu.atozdigital.api.Repository.ArticleRepository;
import lu.atozdigital.api.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional

public class OrderDetailsService {

    private OrderRepository orderRepository;
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    public OrderDetailsService(OrderRepository orderRepository) {

        this.orderRepository = orderRepository;
    }
    public List<OrdersEntity> findAllOrders() {

        return orderRepository.findAll();
    }

    public OrdersEntity saveArticle(OrdersEntity orders) {


        return orderRepository.save(orders);
    }
    public OrdersEntity assignArticleToOrder(Long id_order, Long id_article) {
        List<ArticlesEntity> articles = null;
        OrdersEntity oders = orderRepository.findById(id_article).get();
        ArticlesEntity article = articleRepository.findById(id_article).get();
        articles =  oders.getArticles();
        articles.add(article);
        oders.setArticles(articles);
        return orderRepository.save(oders);
    }

    public OrdersEntity DeleteArticleToOrder(Long id_order, Long id_article) {
        List<ArticlesEntity> articles = null;
        OrdersEntity oders = orderRepository.findById(id_article).get();
        ArticlesEntity article = articleRepository.findById(id_article).get();
        articles =  oders.getArticles();
        articles.remove(article);
        oders.setArticles(articles);
        return orderRepository.save(oders);
    }

    public void delete(Long id_order) {
        orderRepository.deleteById(id_order);

    }
}
