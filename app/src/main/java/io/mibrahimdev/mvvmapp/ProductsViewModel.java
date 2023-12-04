package io.mibrahimdev.mvvmapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import io.mibrahimdev.mvvmapp.model.DataManager;
import io.mibrahimdev.mvvmapp.model.Product;
import kotlin.Unit;

public class ProductsViewModel extends ViewModel {

    private final DataManager manager = DataManager.INSTANCE;

    private final MutableLiveData<List<Product>> productsLiveData = new MutableLiveData<>();
    LiveData<List<Product>> products = productsLiveData;

    private final MutableLiveData<String> errorLiveData = new MutableLiveData<>();
    LiveData<String> error = errorLiveData;


    void retrieveProducts() {
        productsLiveData.setValue(manager.retrieveProducts());
    }


    void updateProduct(Product product, Boolean isFavorite) {
        manager.updateFavorite(product.getProductId(), isFavorite, () -> {

            productsLiveData.setValue(manager.retrieveProducts());

            return Unit.INSTANCE;
        }, () -> {

            errorLiveData.setValue("Error happened while favouring your item, Sorry!");

            return Unit.INSTANCE;
        });
    }

}
