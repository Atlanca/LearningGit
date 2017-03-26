package chalmers.talex.learninggit.Interfaces.Model;

import java.util.List;
import java.util.Map;

import chalmers.talex.learninggit.DietModel.Categories;
import chalmers.talex.learninggit.DietModel.NutritientType;

/**
 * Created by SAMSUNG on 2017-03-25.
 */

public interface IFoodManager {
    public boolean addFood(String name, Map<NutritientType, Integer> nutritients, Categories category);
    public boolean addFood(String name, Map<NutritientType, Integer> nutritients);
    public boolean removeFood(String name);

    public void setNutritients(String name, Map<NutritientType, Integer> nutritients);
    public void setCategory(List<String> food, Categories category);
    public void setCategory(String name, Categories category);
    public void setName(String oldName, String newName);

    public Map<String, Map<NutritientType, Integer>> getAllFood();
    public Map<String, Map<NutritientType, Integer>> getFoodByCategory(Categories category);

    public Map<NutritientType, Integer> getNutritients(String food);
    public Categories getCategory(String food);
}
