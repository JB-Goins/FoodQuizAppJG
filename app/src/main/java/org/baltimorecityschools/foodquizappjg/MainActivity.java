package org.baltimorecityschools.foodquizappjg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView QuestionTV;
    Button trueBTN, falseBTN, nextBTN;
    int score, duration;
    String toastMsg;
    Toast myToast;
    Intent goToSA;
    Question[] questions;
    Question q1, q2, q3, q4, q5, currentQ;
    int currentIndex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        score = 0; duration = 0;
        QuestionTV = findViewById(R.id.QuestionTv);
        trueBTN = findViewById(R.id.trueBTN);
        falseBTN = findViewById(R.id.falseBTN);
        nextBTN = findViewById(R.id.nextBTN);
        toastMsg = "Wrong answer";
        q1 = new Question("is mac and cheese a pasta", true);
        q2 = new Question("Yams and sweet potatoes are the same?", false);
        q3 = new Question("Casu marzu is an illegal cheese made from sheep’s milk?", true);
        q4 = new Question("French Fries were made in Greece?", false);
        q5 = new Question("It takes up to 10 years for an avocado to fully grow? ", false);
        questions = new Question[] {q1, q2, q3, q4, q5};
        currentIndex = 0;
        currentQ = questions[currentIndex];






        trueBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentQ.getCorrectAns() == true){
                    toastMsg = "Right answer";
                    score++;
                }else{
                    toastMsg = "Wrong  answer";
                }

                duration = Toast.LENGTH_SHORT;
                myToast = Toast.makeText( MainActivity.this, toastMsg, duration);
                myToast.show();


            }
        });

        falseBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentQ.getCorrectAns() == true){
                    toastMsg = "Wrong answer";
                }else{
                    toastMsg = "Right  answer";
                    score++;

                }


                duration = Toast.LENGTH_SHORT;
                myToast = Toast.makeText(MainActivity.this, toastMsg, duration);
                myToast.show();


            }
        });

        nextBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 if(currentIndex == 4){
                     goToSA = new Intent(MainActivity.this, ScoreActivity.class);
                     goToSA.putExtra("score", score);
                     startActivity(goToSA);
                 }else{
                     currentIndex += 1;
                     currentQ = questions[currentIndex];
                     QuestionTV.setText(currentQ.getqText());
                 }

            }
        });


    }

}