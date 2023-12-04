package io.mibrahimdev.mvvmapp;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import io.mibrahimdev.mvvmapp.model.Product;
import io.mibrahimdev.mvvmapp.ui.ProductAdapter;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class MainActivity extends AppCompatActivity {

    @Nullable
    private RecyclerView productsRecyclerView;

    @Nullable
    private ProductAdapter productAdapter;

    private ProductsViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initializing viewModel component
        viewModel = new ViewModelProvider(this).get(ProductsViewModel.class);

        setupRecyclerView();

        //Listen to viewModel Observables (LiveData, Rx, Kotlin Flow ..)
        setupObservables();

        //We translate any User interaction into a function in ViewModel
        //ViewModel manipulate MODEL then notify UI with updates through observers
        //
        viewModel.retrieveProducts();
    }

    private void setupObservables() {
        viewModel.products.observe(this, products -> {
            productAdapter.submitList(products);
        });

        viewModel.error.observe(this, s -> showError(s));
    }

    private void setupRecyclerView() {
        productsRecyclerView = findViewById(R.id.productsRecyclerView);
        productAdapter = new ProductAdapter((Function1<Product, Unit>) product -> {

            viewModel.updateProduct(product, !product.isFavorite());

            return Unit.INSTANCE;
        });

        productsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        productsRecyclerView.setAdapter(productAdapter);
    }


    private void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}