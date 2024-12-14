package com.example.imc;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText weightInput, heightInput;  // Houni n3arfo les champs li fi les entrées (poids w hauteur)
    private Button calculateButton;  // Bouton li bch 7isseb l'IMC

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // N3amlou lier les éléments de l'interface avec l'id mta3hom fi layout
        weightInput = findViewById(R.id.editTextWeight);  // EditText ta3 poids
        heightInput = findViewById(R.id.editTextHeight);  // EditText ta3 hauteur
        calculateButton = findViewById(R.id.buttonCalculate);  // Bouton ta3 calcul

        // Houni idha l'utilisateur 3amal click 3la bouton
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Njibou les valeurs li l'utilisateur dakhilhoum fi les champs
                String weightStr = weightInput.getText().toString();
                String heightStr = heightInput.getText().toString();

                // Idha ma dakhilch poids w hauteur, njibou message
                if (weightStr.isEmpty() || heightStr.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter both weight and height", Toast.LENGTH_SHORT).show();
                    return;  // Kima ma3netha, ma3adich ncontinué l'exécution
                }

                try {
                    // N7awlu l'input mta3 l'utilisateur l'numéro
                    double weight = Double.parseDouble(weightStr);
                    double height = Double.parseDouble(heightStr);

                    // Houni 7issebna l'IMC
                    double bmi = weight / (height * height);
                    Log.d("BMI_DEBUG", "Weight: " + weight + ", Height: " + height + ", BMI: " + bmi);  // N5arjou l'IMC fi log l'debug
                    // N7allou l'activité ResultActivity w n7awlu l'IMC
                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    intent.putExtra("BMI", bmi);  // Bch n7awlou l'IMC lil activité okhra
                    startActivity(intent);  // N7allou l'activité ResultActivity
                } catch (NumberFormatException e) {
                    // Idha l'utilisateur dakhil valeur ghala6 (exemple: texte mkan el numéro), nwarri message
                    Toast.makeText(MainActivity.this, "Invalid input", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
