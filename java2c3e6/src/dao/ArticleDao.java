package dao;

import db.Article;
import javax.persistence.EntityManager;

public class ArticleDao {
 
    private EntityManager em;
    
    public ArticleDao(EntityManager em){
        this.em = em;
    }
    
    public void addArticle(Article article){
        em.persist(article);
    }
}