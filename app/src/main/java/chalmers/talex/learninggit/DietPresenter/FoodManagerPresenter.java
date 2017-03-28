package chalmers.talex.learninggit.DietPresenter;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import chalmers.talex.learninggit.DietModel.FoodManager;
import chalmers.talex.learninggit.DietView.FoodManagerFraction;
import chalmers.talex.learninggit.Interfaces.Model.IFoodManager;
import chalmers.talex.learninggit.Interfaces.View.IFoodManagerFraction;

/**
 * Created by SAMSUNG on 2017-03-25.
 */

public class FoodManagerPresenter implements PropertyChangeListener{
    private IFoodManager fm;
    private IFoodManagerFraction fmf;


    public FoodManagerPresenter(FoodManager manager, FoodManagerFraction view){
        fm = manager;
        fmf = view;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case "updateFood": return;
            case "updateNutritients": return;
            case "updateName": return;
            case "updateCategory": return;
        }
    }
}
