package chalmers.talex.learninggit.DietModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.IllegalFormatCodePointException;
import java.util.List;
import java.util.Map;

import chalmers.talex.learninggit.Interfaces.Model.IFoodManager;

/**
 * Created by SAMSUNG on 2017-03-25.
 */

public class FoodManager implements IFoodManager {

    private Map<String, Map<NutritientType, Integer>> foodItems;
    private Map<String, Categories> categorizedFoods;

    public FoodManager(){
        foodItems = new HashMap<String, Map<NutritientType, Integer>>();
    }

    public FoodManager(Map<String, Map<NutritientType, Integer>> foods){
        this();
        for(Map.Entry<String, Map<NutritientType, Integer>> current : foods.entrySet()) {

            if(current.getValue().keySet().contains(NutritientType.values())) {
                String name = current.getKey();
                addFood(name, current.getValue(), null);
            }else{
                throw new IllegalArgumentException("Not all categories are included");
            }
        }
    }

    @Override
    public boolean addFood(String name, Map<NutritientType, Integer> nutritients, Categories category) {
        addFood(name, nutritients);
        if(category != null){
            categorizedFoods.put(name, category);
        }
        return true;
    }

    @Override
    public boolean addFood(String name, Map<NutritientType, Integer> nutritients) {
        if(name == null){
            throw new NullPointerException("Name cannot be null");
        }

        if(name.isEmpty()){
            throw new IllegalArgumentException("Name cannot be an empty string");
        }

        if(foodItems.keySet().contains(name)){
            throw new IllegalArgumentException("A food item by this name already exists");
        }

        if(nutritients == null){
            Map<NutritientType, Integer> zeroNutritients = new HashMap<NutritientType, Integer>();
            for(NutritientType current : NutritientType.values()){
                zeroNutritients.put(current, 0);
            }
            foodItems.put(name, zeroNutritients);
        }else{
            foodItems.put(name, nutritients);
        }

        return true;
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

}
