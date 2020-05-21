import javax.persistence.EntityManager;
import java.util.Scanner;

public class MainApp {
    static Scanner scn = new Scanner(System.in); // for String
    static Scanner sn = new Scanner(System.in); // for int
     static Repository repository = new Repository();

    public static void main(String[] args) {
        System.out.println("для добавления продукта в меню нажмите 1");
        System.out.println("для выбора продукта по цене нажмите 2");
        System.out.println("для выбора продукта писключительно со скидкой нажмите 3");
        System.out.println("для выбора продуктов общий вес которых меньше 1 кг нажмите 4");
        int choice = sn.nextInt();
        switch (choice){
            case 1:
                addNote();
                break;
            case 2:
                choiceByCost();
                break;
            case 3:
                onlyDiscount();
                break;
            case 4:
                weightDish();
                break;
        }
    }

    private static void addNote() {
        System.out.println("Введите название блюда");
        String dish = scn.nextLine();
        System.out.println("Ввелите стоимость блюда");
        int cost = sn.nextInt();
        System.out.println("Введите вес блюда");
        int weight = sn.nextInt();
        System.out.println("Цена указано со скидкой?");
        String price = scn.nextLine();
        repository.addNewNote(dish, cost, weight, price);

    }
    private static void choiceByCost(){
        System.out.println("Выберите блюда по стоимости от и до");
        System.out.println("Введите от");
        int min = sn.nextInt();
        System.out.println("Введите до");
        int max = sn.nextInt();
        repository.choiceBycost(min,max);
    }
    private static void onlyDiscount(){
        System.out.println("Сегодня у нас со скидкой :");
        repository.onlyDiscount();
    }
    private static void weightDish(){
        String cake = "cake";
        String chicken = "chicken";
        String coffee = "coffee";
        String soup = "soup";
        System.out.println("Блюда которые вместе весят меньше 1 кг :");
        repository.weightDish(cake, chicken, coffee, soup);
    }

}
