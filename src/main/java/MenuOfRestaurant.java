import javax.persistence.*;

@Entity
@Table(name = "menu_of_restaurant")
public class MenuOfRestaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "dishName")
    private String name;

    @Column(name = "dishCost")
    private int cost;

    @Column(name = "dishWeight")
    private int weight;

    @Column(name = "discount")
    private String discount;

    public MenuOfRestaurant() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "MenuOfRestaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", weight=" + weight +
                ", discount='" + discount + '\'' +
                '}';
    }
}
