package com.example.imc;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    private TextView bmiResult, bmiCategory;
    private Button backButton;

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Houni n3awdo l'éléments li fi layout (l'affichage) li fel screen
        bmiResult = findViewById(R.id.textViewBMI);  // TextView li bch ywarri l'IMC
        bmiCategory = findViewById(R.id.textViewCategory);  // TextView li bch ywarri l'category ta3 l'IMC
        backButton = findViewById(R.id.buttonBack);  // Bouton li y5alik terja3 l'écran li 9bl

        // Jibna l'IMC min l'intent (l'information li tjina mn activité okhra)
        Intent intent = getIntent();
        double bmi = intent.getDoubleExtra("BMI", 0.0);

        // N3ammlo affichage ta3 l'IMC
        bmiResult.setText(String.format("Your BMI: %.2f", bmi));
        // N3ammlo affichage ta3 l'category ta3 l'IMC
        bmiCategory.setText(getBMICategory(bmi));

        // Idha l'utilisateur 3amal click 3la bouton, n9idmo l'activity
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();  // Ykhlass l'activité w yerja3 l'écran li 9bel
            }
        });
    }

    // Houni n7otou el catégorie ta3 l'IMC selon l'valeur ta3 l'IMC
    private String getBMICategory(double bmi) {
        if (bmi < 18.5) {
            return "Category: Underweight";  // Idha l'IMC a7adh min 18.5, ykoun underweight
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            return "Category: Normal weight";  // Idha l'IMC bin 18.5 w 24.9, ykoun normal weight
        } else if (bmi >= 25 && bmi <= 29.9) {
            return "Category: Overweight";  // Idha l'IMC bin 25 w 29.9, ykoun overweight
        } else {
            return "Category: Obesity";  // Idha l'IMC fawq 30, ykoun obesity
        }
    }
}
