package org.baltimorecityschools.foodquizappjg;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ScoreActivity extends AppCompatActivity {
    TextView scoreTv;
    Button shsBTN,resetBTN;
    EditText nameET;
    String name;
    int score;
    Intent welcomeToSA;
    Intent gotoHSA;
    FirebaseDatabase database;
    DatabaseReference myRef;
    Intent returnToTheBIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        scoreTv = findViewById(R.id.scoreTV);
        resetBTN = findViewById(R.id.resetBTN);
        shsBTN = findViewById(R.id.shsBTN);
        nameET = findViewById(R.id.nameET);
        score = 0;
        welcomeToSA = getIntent();
        score = welcomeToSA.getIntExtra("score", 0);
        scoreTv.setText("" + score);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("message");



        shsBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = nameET.getText().toString();
                HighScoresEntry myHighScoresEntry = new HighScoresEntry (name,score);
                String key = myRef.push().getKey();
                myRef.child(key).setValue(myHighScoresEntry);
                gotoHSA = new Intent(ScoreActivity.this, HighSEActivity.class);
                startActivity(gotoHSA);

            }
        });

        resetBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnToTheBIntent = new Intent(ScoreActivity.this, MainActivity.class);
                startActivity(returnToTheBIntent);
            }
        });




    }
}