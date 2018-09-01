package service;

import dao.UserDao;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.User;

public class RegisterService {
    
    private EntityManagerFactory emf;
    
    private RegisterService(){
        emf = Persistence.createEntityManagerFactory("java2c7e4-ServerPU");
    }
    
    public static final class SingletonHolder{
        private static final RegisterService SINGLETON = new RegisterService();
    }
    
    public static RegisterService getInstance(){
        return SingletonHolder.SINGLETON;
    }
    
    public boolean register(User user){
        
        EntityManager em = emf.createEntityManager();
        UserDao userDao = new UserDao(em);
        
        try{
            em.getTransaction().begin();
            
            Optional<User> existentUser = userDao.findUserByUserName(user.getUsername());
            
            if (existentUser.isPresent()){
                return false;
            }
            userDao.addUser(user);
            
            em.getTransaction().commit();
        } finally{
            em.close();
        }
        return true; 
    }
}