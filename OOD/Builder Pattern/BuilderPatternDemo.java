public class BuilderPatternDemo {
    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();

        Meal vegMeal = mealBuilder.prepareVegMeal();
        Meal nonVegMeal = mealBuilder.prepareNonVegMeal();

        System.out.println("Veg meal:");
        vegMeal.showItems();
        System.out.println("Total cost :"+vegMeal.getTotalCost());

        System.out.println("Non Veg meal:");
        nonVegMeal.showItems();
        System.out.println("Total cost :"+nonVegMeal.getTotalCost());
    }
}
