package lu.atozdigital.api.Controller;
import lu.atozdigital.api.Model.ArticlesEntity;
import lu.atozdigital.api.Model.OrdersEntity;
import lu.atozdigital.api.Service.ArticleDetailsService;
import lu.atozdigital.api.Service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path="/articles", produces="application/json")
@CrossOrigin("*")
public class MainController {

    private ArticleDetailsService articleDetailsService;
    private OrderDetailsService orderDetailsService;
    @Autowired
    public MainController(ArticleDetailsService articleDetailsService, OrderDetailsService orderDetailsService) {
        this.articleDetailsService = articleDetailsService;
        this.orderDetailsService = orderDetailsService;
    }

    @PostMapping("/articles")
    public ResponseEntity<ArticlesEntity> AddArticle(@RequestBody ArticlesEntity article) {

      ArticlesEntity NewArticle=  articleDetailsService.saveArticle(article);
        return new ResponseEntity<>(NewArticle,HttpStatus.OK);

    }

    @GetMapping("/articles")
    @ResponseBody
    public ResponseEntity<List<ArticlesEntity>> listArticle(){
        List<ArticlesEntity> articles = articleDetailsService.findAllArticles();
        if (articles!=null) {
    return new ResponseEntity<>(articles,HttpStatus.OK);
     }
     else{   return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);}

    }

    @GetMapping("/articles/{id_article}")
    @ResponseBody
    public ResponseEntity<ArticlesEntity> getArticleById (@PathVariable("id_article") Long id_article) {
        ArticlesEntity article = articleDetailsService.findArticleByName(id_article);
          if(article != null){
                return  new ResponseEntity<>(article, HttpStatus.OK);}
        else{   return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);} }

    @GetMapping("/orders")
    @ResponseBody
    public ResponseEntity<List<OrdersEntity>> listOrders(){
        List<OrdersEntity> orders = orderDetailsService.findAllOrders();
        if (orders!=null) {
            return new ResponseEntity<>(orders,HttpStatus.OK);
        }
        else{   return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);}


    }

    @PostMapping("/orders")
    public ResponseEntity<OrdersEntity> AddOrder(@RequestBody OrdersEntity order) {
        order.setReference(UUID.randomUUID().toString());
        OrdersEntity NewOrder=  orderDetailsService.saveArticle(order);
        return new ResponseEntity<>(NewOrder,HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id_order}")
    @ResponseBody
    public ResponseEntity<?> deleteOrder(@PathVariable("id_order") Long id_order) {
        orderDetailsService.delete(id_order);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/orders/{id_order}/article/{id_article}")
    @ResponseBody
    public OrdersEntity AssignarticleToOrder(
            @PathVariable Long id_order,
            @PathVariable Long id_article
    ){
        return orderDetailsService.assignArticleToOrder(id_order, id_article);}


    @PutMapping("/orders/{id_order}/delarticle/{id_article}")
    @ResponseBody
    public OrdersEntity DeleterticleToOrder(
            @PathVariable Long id_order,
            @PathVariable Long id_article
    ){
        return orderDetailsService.DeleteArticleToOrder(id_order, id_article);
    }

}
