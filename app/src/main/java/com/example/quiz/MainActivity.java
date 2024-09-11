package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg1, rg2, rg3;
    Button btnSubmit, btnReset;
    TextView feedback;
    int correctAnswers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referências para os RadioGroups e botões
        rg1 = findViewById(R.id.radioGroup1);
        rg2 = findViewById(R.id.radioGroup2);
        rg3 = findViewById(R.id.radioGroup3);
        btnSubmit = findViewById(R.id.btn_submit);
        btnReset = findViewById(R.id.btn_reset);
        feedback = findViewById(R.id.feedback);

        // Botão "Verificar Respostas"
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correctAnswers = 0;
                checkAnswer(rg1, R.id.option1_3, "Questão 1 correta!");
                checkAnswer(rg2, R.id.option2_1, "Questão 2 correta!");
                checkAnswer(rg3, R.id.option3_2, "Questão 3 correta!");

                String resultMessage = "Você acertou " + correctAnswers + " de 3!";
                feedback.setText(resultMessage); // Exibe o resultado diretamente no TextView
            }
        });

        // Botão "Reiniciar Quiz"
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rg1.clearCheck();
                rg2.clearCheck();
                rg3.clearCheck();
                feedback.setText(""); // Limpa o feedback anterior
                correctAnswers = 0;
            }
        });
    }

    // Função para verificar as respostas
    private void checkAnswer(RadioGroup group, int correctOptionId, String successMessage) {
        int selectedId = group.getCheckedRadioButtonId();
        if (selectedId == correctOptionId) {
            correctAnswers++;
            feedback.append(successMessage + "\n"); // Exibe o feedback diretamente no TextView
        } else {
            feedback.append("Resposta errada!\n"); // Exibe o feedback diretamente no TextView
        }
    }
}