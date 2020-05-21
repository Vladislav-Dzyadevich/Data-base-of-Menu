import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManegerFactoryCreater {
    private static EntityManagerFactory emf;

    public static EntityManagerFactory entityManagerFactory(){
        if(emf == null){
            emf = Persistence.createEntityManagerFactory("MenuProject");
        }
        return emf;
    }
}
