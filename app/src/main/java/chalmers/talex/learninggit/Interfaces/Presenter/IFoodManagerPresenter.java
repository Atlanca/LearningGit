package chalmers.talex.learninggit.Interfaces.Presenter;

import chalmers.talex.learninggit.DietModel.Categories;

/**
 * Created by SAMSUNG on 2017-03-25.
 */

public interface IFoodManagerPresenter {
    void createFoodItem(String name, int cal, int carbs, int prot, int fibs, int fat, Categories category);
    void removeFoodItem(String name);

    void setNutritients(int cal, int carbs, int prot, int fibs, int fat);

    int getCal(String food);
    int getCarbs(String food);
    int getFibers(String food);
    int getFat(String food);
    int getProtein(String food);

}
