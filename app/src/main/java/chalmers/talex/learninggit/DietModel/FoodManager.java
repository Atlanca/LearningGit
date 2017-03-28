package chalmers.talex.learninggit.DietModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
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
    private PropertyChangeSupport pcs;

    public FoodManager(){
        pcs = new PropertyChangeSupport(this);
        foodItems = new HashMap<String, Map<NutritientType, Integer>>();
        categorizedFoods = new HashMap<String, Categories>();
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
        pcs.firePropertyChange("updateFood", null, getEntry(name));
        return true;
    }

    @Override
    public boolean removeFood(String name) {
        checkValidName(name);
        if(!foodItems.keySet().contains(name)) {
            throw new IllegalArgumentException("No such food item exists");
        }
        foodItems.remove(name);
        removeCategorization(name);
        pcs.firePropertyChange("updateFood", getEntry(name), null);
        return true;
    }

    private void removeCategorization(String name){
        if(!categorizedFoods.keySet().contains(name)) {
            throw new NullPointerException("This food item is not categorized");
        }
        categorizedFoods.remove(name);
    }

    private Map.Entry<String, Map<NutritientType,Integer>> getEntry(String key){
        for(Map.Entry<String, Map<NutritientType,Integer>> current : foodItems.entrySet()) {
            if (current.getKey().equals(key)) {
                return current;
            }
        }
        throw new NullPointerException("Entry with given key does not exist");
    }

    @Override
    public void setNutritients(String name, Map<NutritientType, Integer> nutritients) {
        Map<NutritientType,Integer> oldNutritients = foodItems.get(name);
        foodItems.get(name).clear();
        foodItems.get(name).putAll(nutritients);
        pcs.firePropertyChange("updateNutritients", oldNutritients, foodItems.get(name));
    }

    @Override
    public void setCategory(List<String> food, Categories category) {
        for(String name : food){
            setCategory(name, category);
        }
    }

    private void checkValidName(String name){
        if(name.isEmpty()){
            throw new IllegalArgumentException("Names cannot be empty");
        }
        if(name == null){
            throw new NullPointerException("Name cannot be null");
        }
    }

    @Override
    public void setCategory(String name, Categories category) {
        checkValidName(name);

        if(!foodItems.containsKey(name)){
            throw new IllegalArgumentException("No such food exists");
        }
        if(category == null) {
            throw new NullPointerException("Category cannot be null");
        }
        Categories oldCategory = categorizedFoods.get(name);
        categorizedFoods.put(name, category);

        pcs.firePropertyChange("updateCategory", oldCategory, categorizedFoods.get(name));
    }

    @Override
    public void setName(String oldName, String newName) {
        checkValidName(oldName);
        if(foodItems.containsKey(newName)){
            throw new IllegalArgumentException("A food item with this name already exists");
        }
        Map<NutritientType, Integer> nutritient = foodItems.get(oldName);
        foodItems.remove(oldName);
        foodItems.put(newName, nutritient);
        pcs.firePropertyChange("updateName","oldName","newName");
    }

    @Override
    public Map<String, Map<NutritientType, Integer>> getAllFood() {
        return foodItems;
    }

    @Override
    public Map<String, Map<NutritientType, Integer>> getFoodByCategory(Categories category) {

        Map<String, Map<NutritientType, Integer>> foodByCat = new HashMap<String, Map<NutritientType, Integer>>();

        for(Map.Entry<String, Categories> current : categorizedFoods.entrySet()){
            if(current.getValue().equals(category)){
                foodByCat.put(current.getKey(), foodItems.get(current.getKey()));
            }
        }

        return foodByCat;
    }

    @Override
    public Map<NutritientType, Integer> getNutritients(String food) {
        return foodItems.get(food);
    }

    @Override
    public Categories getCategory(String food) {
        return categorizedFoods.get(food);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        pcs.addPropertyChangeListener(pcl);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        pcs.removePropertyChangeListener(pcl);
    }

}
