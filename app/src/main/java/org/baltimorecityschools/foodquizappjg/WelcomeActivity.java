package org.baltimorecityschools.foodquizappjg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class WelcomeActivity extends AppCompatActivity {

    EditText typenameET;
    Button next2BTN;
    Intent returnToGameIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        typenameET = findViewById(R.id.typenameET);
        next2BTN = findViewById(R.id.next2BTN);

        next2BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnToGameIntent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(returnToGameIntent);
            }
        });


    }
}