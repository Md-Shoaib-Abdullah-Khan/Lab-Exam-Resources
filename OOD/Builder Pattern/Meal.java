
import java.util.ArrayList;

public class Meal {
    private ArrayList<Item> meal = new ArrayList<>();

    public void addItem(Item item){
        meal.add(item);
    }

    public float getTotalCost(){
        float cost = (float)0.0;

        for(Item i : meal){
            cost += i.price();
        }
        return cost;
    }

    public void showItems(){
        for(Item i : meal){
            System.out.print("Item : "+ i.name());
            System.out.print(" Packing : "+ i.packing());
            System.out.println(" Price : "+ i.price());
        }
        System.out.println(meal.get(0).name());
    }
}
