package org.baltimorecityschools.foodquizappjg;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ScoreActivity extends AppCompatActivity {
    TextView scoreTv;
    int score;
    Intent welcomeToSA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_score);

        scoreTv = findViewById(R.id.scoreTV);
        score = 0;
        welcomeToSA = getIntent();
        score = welcomeToSA.getIntExtra("score", 0);
        scoreTv.setText("" + score);



    }
}