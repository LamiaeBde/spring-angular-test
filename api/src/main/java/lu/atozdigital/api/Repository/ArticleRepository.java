package lu.atozdigital.api.Repository;
import lu.atozdigital.api.Model.ArticlesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;




public interface ArticleRepository extends JpaRepository<ArticlesEntity,Long> {



    @Query("SELECT o FROM ArticlesEntity o WHERE o.id_article =:id_article")

    ArticlesEntity findArticleByName(Long id_article);



}
