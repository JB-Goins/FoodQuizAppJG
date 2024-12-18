package org.baltimorecityschools.foodquizappjg;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HighSEActivity extends AppCompatActivity {
    TextView p1TV, p2TV, p3TV;
    FirebaseDatabase database;
    DatabaseReference myRef;
    public static final String TAG = "AHHHHHH";
    ArrayList<HighScoresEntry> HSEntrties;
    HighScoresEntry lola;
    String hseName;
    int hseScore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_seactivity);
        p1TV = findViewById(R.id.p1TV);
        p2TV = findViewById(R.id.p2TV);
        p3TV = findViewById(R.id.p3TV);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");
        HSEntrties = new ArrayList<HighScoresEntry>();

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                for(DataSnapshot hseSnapShot : dataSnapshot.getChildren()){
                    HighScoresEntry value = hseSnapShot.getValue(HighScoresEntry.class);
                    Log.d(TAG, "Value is: " + value.getName());
                    HSEntrties.add(value);
                }
                lola = HSEntrties.get(0);
                hseScore = lola.getScores();
                hseName = lola.getName();
                p1TV.setText(hseName + ":  " + hseScore);


            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


    }
}