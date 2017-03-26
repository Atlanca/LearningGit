package chalmers.talex.learninggit.Interfaces.Model;

import java.util.List;
import java.util.Map;

import chalmers.talex.learninggit.DietModel.Categories;

/**
 * Created by SAMSUNG on 2017-03-25.
 */

public interface IFoodManager {
    public boolean addFood(String name, int cal, int carbs, int fib, int fat, int protein, String category);
    public boolean addFood(String name, int cal, int carbs, int fib, int fat, int protein);
    public boolean removeFood(String name);

    public void setNutritients(String name, int cal, int carbs, int fib, int fat, int protein);
    public void setCategory(List<String> food, String category);
    public void setCategory(String name, String category);
    public void setName(String oldName, String newName);

    public Map<String,Map<String, Integer>> getAllFood();
    public Map<String, Map<String, Integer>> getFoodByCategory(String category);

    public Map<String, Integer> getNutritients(String food);
    public String getCategory(String food);
}
