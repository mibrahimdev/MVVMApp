package io.mibrahimdev.mvvmapp;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import io.mibrahimdev.mvvmapp.model.DataManager;
import io.mibrahimdev.mvvmapp.model.Product;
import io.mibrahimdev.mvvmapp.ui.ProductAdapter;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class MainActivity extends AppCompatActivity {

    private final DataManager manager = DataManager.INSTANCE;

    @Nullable
    private RecyclerView productsRecyclerView;

    @Nullable
    private ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupRecyclerView();

        //Getting products
        List<Product> products = manager.retrieveProducts();
        productAdapter.submitList(products);

    }

    private void setupRecyclerView() {
        productsRecyclerView = findViewById(R.id.productsRecyclerView);
        productAdapter = new ProductAdapter((Function1<Product, Unit>) product -> {

            updateProduct(product, !product.isFavorite());

            return Unit.INSTANCE;
        });

        productsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        productsRecyclerView.setAdapter(productAdapter);
    }

    private void updateProduct(Product product, Boolean isFavorite) {
        manager.updatProduct(product.getProductId(), isFavorite, () -> {

            productAdapter.submitList(manager.retrieveProducts());

            return Unit.INSTANCE;
        }, () -> {

            showError("Error happened while favouring your item, Sorry!");

            return Unit.INSTANCE;
        });
    }

    private void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}