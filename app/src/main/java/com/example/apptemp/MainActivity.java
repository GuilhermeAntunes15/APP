package com.example.apptemp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.apptemp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        Button buttonProductDetail = findViewById(R.id.buttonProductDetail);
        buttonProductDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openProductDescriptionFragment();
            }
        });
    }

    private void openProductDescriptionFragment() {
        // Crie uma instância do fragmento de descrição do produto
        ProductDescriptionFragment descriptionFragment = new ProductDescriptionFragment();

        // Inicie a transação do fragmento
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        // Substitua o conteúdo atual pelo fragmento de descrição do produto
        transaction.replace(R.id.container, descriptionFragment);

        // Adicione a transação à pilha de fragmentos (opcional)
        transaction.addToBackStack(null);

        // Execute a transação
        transaction.commit();
    }


}