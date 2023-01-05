package lu.atozdigital.api.Service;
import lu.atozdigital.api.Model.ArticlesEntity;
import lu.atozdigital.api.Repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional


public  class ArticleDetailsService {
    private  ArticleRepository articleRepository;
    @Autowired
    public ArticleDetailsService(ArticleRepository articleRepository)
    {
        this.articleRepository = articleRepository;
    }

    public ArticlesEntity saveArticle(ArticlesEntity articles) {

       return articleRepository.save(articles);
    }

    public void deleteArticle(Long id_article) {
       articleRepository.deleteById(id_article);
    }

    public ArticlesEntity findArticleByName(Long id_article) {
        return articleRepository.findArticleByName(id_article);

    }

    public List<ArticlesEntity> findAllArticles() {
        return articleRepository.findAll();
    }


}
