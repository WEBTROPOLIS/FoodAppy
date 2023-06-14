package com.example.foodappy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.foodappy.databinding.ActivityFoodBinding;
import com.example.foodappy.databinding.ActivityMainBinding;

public class food extends AppCompatActivity {
    private ActivityFoodBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFoodBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent desIntent = new Intent(food.this, descripcion.class);
        Intent mainIntent = getIntent();
        String nombreUser = mainIntent.getStringExtra("userNom");
        binding.txtBienvenida.setText("Bienvenid@ " + nombreUser);
        binding.ratingBarSushi.setRating(4);
        binding.ratingBarPizza.setRating(4);
        binding.ratingBarSand.setRating(3);

        binding.btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        binding.btmPedirSushi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                desIntent.putExtra("imgId",R.drawable.prodsushi);
                desIntent.putExtra("imgMapa",R.drawable.direccionsushi);
                desIntent.putExtra("userNom",nombreUser);
                desIntent.putExtra("nombreNegocio",binding.txtSushi.getText().toString().trim());
                desIntent.putExtra("valoracion",binding.ratingBarSushi.getRating());
                desIntent.putExtra("direccion","Av Independencia 594, Puente Alto");
                desIntent.putExtra("horarios","Miercoles a Sabado de 13 a 01:30");
                desIntent.putExtra("entrega","24 minutos");
                startActivity(desIntent);
            }
        });

        binding.btmPedirPizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                desIntent.putExtra("imgId",R.drawable.prodpizza);
                desIntent.putExtra("imgMapa",R.drawable.direccionpizza);
                desIntent.putExtra("userNom",nombreUser);
                desIntent.putExtra("nombreNegocio",binding.txtPizza.getText().toString().trim());
                desIntent.putExtra("valoracion",binding.ratingBarPizza.getRating());
                desIntent.putExtra("direccion","Av San Carlos 633, Puente Alto");
                desIntent.putExtra("horarios","Martes a Sabado de 12:00 a 02:30");
                desIntent.putExtra("entrega","18 minutos");
                startActivity(desIntent);
            }
        });

        binding.btmPedirSand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                desIntent.putExtra("imgId",R.drawable.prodsandwich);
                desIntent.putExtra("imgMapa",R.drawable.direccionsand);
                desIntent.putExtra("userNom",nombreUser);
                desIntent.putExtra("nombreNegocio",binding.txtSand.getText().toString().trim());
                desIntent.putExtra("valoracion",binding.ratingBarSand.getRating());
                desIntent.putExtra("direccion","El compas 2655, Puente Alto");
                desIntent.putExtra("horarios","Lunes a Sabado de 12:00 a 02:00");
                desIntent.putExtra("entrega","28 minutos");
                startActivity(desIntent);
            }
        });
    }
}