import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class Repository {
    static EntityManagerFactory emf = EntityManegerFactoryCreater.entityManagerFactory();
    static EntityManager em;
    MenuOfRestaurant menu = new MenuOfRestaurant();

    public void addNewNote(String dish, int cost, int weight, String discount) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        menu.setName(dish);
        menu.setCost(cost);
        menu.setWeight(weight);
        menu.setDiscount(discount);
        em.persist(menu);
        em.getTransaction().commit();
    }

    public void choiceBycost(int min, int max) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("select m.name from MenuOfRestaurant m WHERE m.cost >= :min and m.cost < :max");
        query.setParameter("min", min);
        query.setParameter("max", max);
        List<String> list = query.getResultList();
        System.out.println(list);
        em.getTransaction().commit();
    }

    public void onlyDiscount() {
        String answer = "yes";
        em = emf.createEntityManager();
        em.getTransaction().begin();

        Query query = em.createQuery("select m.name from MenuOfRestaurant m WHERE m.discount = :answer");
        query.setParameter("answer", answer);
        List<String> list = query.getResultList();
        System.out.println(list);
        em.getTransaction().commit();
    }

    public void weightDish(String cake, String chicken, String coffee, String soup) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        int totalWeight = 1000;
        Query query = em.createQuery("SELECT m.weight from MenuOfRestaurant m WHERE m.name = :cake");
        query.setParameter("cake", cake);
        int cakeWeight = (int) query.getSingleResult();

        Query queryTwo = em.createQuery("SELECT m.weight from MenuOfRestaurant m WHERE m.name = :chicken");
        queryTwo.setParameter("chicken", chicken);
        int chickenWeight = (int) queryTwo.getSingleResult();

        Query queryThree = em.createQuery("SELECT m.weight from MenuOfRestaurant m WHERE m.name = :coffee");
        queryThree.setParameter("coffee", coffee);
        int coffeeWeight = (int) queryThree.getSingleResult();

        Query queryFour = em.createQuery("SELECT m.weight from MenuOfRestaurant m WHERE m.name = :soup");
        queryFour.setParameter("soup", soup);
        int soupWeight = (int) queryFour.getSingleResult();
        if (cakeWeight + chickenWeight + coffeeWeight + soupWeight < totalWeight) {
            System.out.println(cake + " " + chicken + " " + coffee + " " + soup);
        } else if (cakeWeight + chickenWeight + coffeeWeight < totalWeight) {
            System.out.println(cake + " " + chicken + " " + coffee);
        } else if (cakeWeight + chickenWeight + soupWeight < totalWeight) {
            System.out.println(cake + " " + chicken + " " + soup);
        } else if (cakeWeight + coffeeWeight + soupWeight < totalWeight) {
            System.out.println(cake + " " + coffee + " " + soup);
        } else if (chickenWeight + coffeeWeight + totalWeight < totalWeight) {
            System.out.println(chicken + " " + coffee + " " + soup);
        }
    }

}
