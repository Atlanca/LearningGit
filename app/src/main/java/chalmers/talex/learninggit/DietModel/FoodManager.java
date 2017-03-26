package chalmers.talex.learninggit.DietModel;

import java.util.List;
import java.util.Map;

import chalmers.talex.learninggit.Interfaces.Model.IFoodManager;

/**
 * Created by SAMSUNG on 2017-03-25.
 */

public class FoodManager implements IFoodManager {

    private Map<String, Map<String, Integer>> foodItems;

    public FoodManager(){

    }

    public FoodManager(Map<String, Nutritients> foods){

    }

    public FoodManager(List<String> foods){

    }

    @Override
    public boolean addFood(String name, int cal, int carbs, int fib, int fat, int protein, String category) {
        return false;
    }

    @Override
    public boolean addFood(String name, int cal, int carbs, int fib, int fat, int protein) {
        return false;
    }

    @Override
    public boolean removeFood(String name) {
        return false;
    }

    @Override
    public void setNutritients(String name, int cal, int carbs, int fib, int fat, int protein) {

    }

    @Override
    public void setCategory(List<String> food, String category) {

    }

    @Override
    public void setCategory(String name, String category) {

    }

    @Override
    public void setName(String oldName, String newName) {

    }


    @Override
    public Map<String, Map<String, Integer>> getAllFood() {
        return null;
    }

    @Override
    public Map<String, Map<String, Integer>> getFoodByCategory(String category) {
        return null;
    }

    @Override
    public Map<String, Integer> getNutritients(String food) {
        return null;
    }

    @Override
    public String getCategory(String food) {
        return null;
    }

    private class FoodItem {

        private String name;
        private Categories category;
        private Nutritients nutritients;

        private FoodItem(String name, Categories category, Nutritients nutritients) {
            this.name = name;
            this.category = category;
            this.nutritients = nutritients;
        }
    }


}
