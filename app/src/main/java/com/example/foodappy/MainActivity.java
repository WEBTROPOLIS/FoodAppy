package com.example.foodappy;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodappy.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent foodIntent = new Intent(MainActivity.this, food.class);

        animateTextFromLeft(binding.txt1, "Food");
        animateTextFromRight(binding.txt2, "Appy");

        binding.userTxt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(binding.userTxt.getText().toString().trim().isEmpty()){
                    binding.divTxt.setError(null);
                }
            }
        });

        binding.nextBtm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.userTxt.getText().toString().trim().isEmpty()){
                    binding.divTxt.setError("Debe Ingresar su Nombre! ");
                    Toast.makeText(MainActivity.this,"Para una mejor experiencia" +
                            "en nuestra app por favor ingrese su nombre",Toast.LENGTH_LONG).show();
                }else{
                    foodIntent.putExtra("userNom",binding.userTxt.getText().toString().trim().toUpperCase());
                    startActivity(foodIntent);
                }

            }
        });

        binding.exitBtm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void animateTextFromLeft(final TextView textView, final String text) {
        textView.setText("");

        AnimatorSet animatorSet = new AnimatorSet();

        for (int i = 0; i < text.length(); i++) {
            final char letter = text.charAt(i);

            ObjectAnimator translateAnimator = ObjectAnimator.ofFloat(textView, "translationX", -200f, 0f);
            translateAnimator.setDuration(800);
            translateAnimator.setStartDelay(i * 300);

            translateAnimator.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animator) {
                    textView.setText(textView.getText().toString() + letter);
                }

                @Override
                public void onAnimationEnd(Animator animator) {
                }

                @Override
                public void onAnimationCancel(Animator animator) {
                }

                @Override
                public void onAnimationRepeat(Animator animator) {
                }
            });

            animatorSet.play(translateAnimator);
        }

        animatorSet.start();
    }

    private void animateTextFromRight(final TextView textView, final String text) {
        textView.setText("");

        AnimatorSet animatorSet = new AnimatorSet();

        for (int i = 0; i < text.length(); i++) {
            final char letter = text.charAt(i);

            ObjectAnimator translateAnimator = ObjectAnimator.ofFloat(textView, "translationX", 200f, 0f);
            translateAnimator.setDuration(800);
            translateAnimator.setStartDelay(i * 300);

            translateAnimator.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animator) {
                    textView.setText(textView.getText().toString() + letter);
                }

                @Override
                public void onAnimationEnd(Animator animator) {
                }

                @Override
                public void onAnimationCancel(Animator animator) {
                }

                @Override
                public void onAnimationRepeat(Animator animator) {
                }
            });

            animatorSet.play(translateAnimator);
        }

        animatorSet.start();
    }
}