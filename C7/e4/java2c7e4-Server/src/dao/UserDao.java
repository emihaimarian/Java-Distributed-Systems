package dao;

import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.User;

public class UserDao {
 
    private EntityManager em;
    
    public UserDao(EntityManager em){
        this.em = em;
    }
    
    public Optional<User> findUserByUserName(String username){
        
        String sql = "SELECT user FROM User user WHERE user.username = :username";
        TypedQuery<User> typedQuery = em.createQuery(sql, User.class);
        typedQuery.setParameter("username", username);
        
        try{
            return Optional.of(typedQuery.getSingleResult());
        } catch (Exception e){
            return Optional.empty();
        }
    }
    
    public void addUser(User user){
        em.persist(user);
    }
}