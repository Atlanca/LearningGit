package chalmers.talex.learninggit.ModelTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

import chalmers.talex.learninggit.DietModel.Categories;
import chalmers.talex.learninggit.DietModel.FoodManager;
import chalmers.talex.learninggit.DietModel.NutritientType;
import chalmers.talex.learninggit.Interfaces.Model.IFoodManager;

/**
 * Created by SAMSUNG on 2017-03-25.
 */

public class FoodManagerTest {

    @Test
    public void assertFoodHasBeenAdded() {
        IFoodManager foodmanager = new FoodManager();
        String name = "Chicken Wings";
        foodmanager.addFood(name, new HashMap<NutritientType, Integer>());
        assertTrue(foodmanager.getAllFood().containsKey(name));
    }

    @Test(expected=IllegalArgumentException.class)
    public void assertNoDuplicatesAllowed(){
        IFoodManager foodmanager = new FoodManager();
        String name = "Chicken Wings";
        foodmanager.addFood(name, new HashMap<NutritientType, Integer>());
        foodmanager.addFood(name, new HashMap<NutritientType, Integer>());
    }

    @Test
    public void assertCorrectCategory(){
        IFoodManager foodmanager = new FoodManager();

        List<String> name = new ArrayList<String>();
        name.add("Chicken Wings");
        name.add("Chicken Breast");
        name.add("Chicken Leg");

        List<Categories> category = new ArrayList<Categories>();
        category.add(Categories.CHICKEN);
        category.add(Categories.BEEF);
        category.add(Categories.PORK);

        for(int i = 0; i < name.size(); i++){
            foodmanager.addFood(name.get(i), new HashMap<NutritientType, Integer>(), category.get(i));
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

        foodmanager.addFood(name.get(0), new HashMap<NutritientType, Integer>(), Categories.BEEF);
        foodmanager.addFood(name.get(1), new HashMap<NutritientType, Integer>(), Categories.CHICKEN);
        foodmanager.addFood(name.get(2), new HashMap<NutritientType, Integer>(), Categories.FISH);

        foodmanager.setCategory(name, Categories.CHICKEN);

        Map<String, Map<NutritientType, Integer>> chickenFood = foodmanager.getFoodByCategory(Categories.CHICKEN);
        for(String current : name){
            assertTrue(chickenFood.containsKey(current));
        }
    }
}
