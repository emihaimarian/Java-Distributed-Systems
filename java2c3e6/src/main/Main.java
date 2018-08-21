package main;

import dao.ArticleDao;
import dao.BookDao;
import db.Article;
import db.Author;
import db.Book;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
    
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("java2c3e6PU");
        EntityManager em = emf.createEntityManager();
        
        BookDao bookDao = new BookDao(em);
        ArticleDao articleDao =  new ArticleDao(em);
        
        Author author = new Author();
        author.setFirstName("Mihai");
        author.setLastName("Enache");
        
        Book book = new Book();
        book.setTitle("Titlu carte");
        book.setAuthor(author);
        
        Article article = new Article();
        article.setId(10);
        article.setAuthor(author);
        
        em.getTransaction().begin();
        bookDao.addBook(book);
        articleDao.addArticle(article);
        em.getTransaction().commit();
    }
}