package chalmers.talex.learninggit.ModelTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

import chalmers.talex.learninggit.DietModel.FoodManager;
import chalmers.talex.learninggit.Interfaces.Model.IFoodManager;

/**
 * Created by SAMSUNG on 2017-03-25.
 */

public class FoodManagerTest {

    @Test
    public void assertFoodHasBeenAdded() {
        IFoodManager foodmanager = new FoodManager();
        String name = "Chicken Wings";
        foodmanager.addFood(name, 0, 0, 0, 0, 0);
        assertTrue(foodmanager.getAllFood().containsKey(name));
    }

    @Test(expected=IllegalArgumentException.class)
    public void assertNoDuplicatesAllowed(){
        IFoodManager foodmanager = new FoodManager();
        String name = "Chicken Wings";
        foodmanager.addFood(name, 0, 0, 0, 0, 0);
        foodmanager.addFood(name, 0, 0, 0, 0, 0);
    }

    @Test
    public void assertCorrectCategory(){
        IFoodManager foodmanager = new FoodManager();

        List<String> name = new ArrayList<String>();
        name.add("Chicken Wings");
        name.add("Chicken Breast");
        name.add("Chicken Leg");

        List<String> category = new ArrayList<String>();
        category.add("Chicken");
        category.add("Pork");
        category.add("Beef");

        for(int i = 0; i < name.size(); i++){
            foodmanager.addFood(name.get(i), 0,0,0,0,0, category.get(i));
            assertTrue(foodmanager.getCategory(name.get(i)).equals(category.get(i)));
        }
    }

    @Test
    public void assertCorrectCategoryOnChange(){
        IFoodManager foodmanager = new FoodManager();

        List<String> name = new ArrayList<String>();
        name.add("Chicken Wings");
        name.add("Chicken Breast");
        name.add("Chiken Leg");

        foodmanager.addFood(name.get(1), 0, 0, 0, 0, 0, "Chicken");
        foodmanager.addFood(name.get(2), 0, 0, 0, 0, 0, "Pork");
        foodmanager.addFood(name.get(0), 0, 0, 0, 0, 0, "Beef");

        foodmanager.setCategory(name, "Chicken");

        Map<String, Map<String, Integer>> chickenFood = foodmanager.getFoodByCategory("Chicken");
        for(String current : name){
            assertTrue(chickenFood.containsKey(current));
        }
    }
}
