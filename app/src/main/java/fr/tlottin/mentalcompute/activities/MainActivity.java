package fr.tlottin.mentalcompute.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import fr.tlottin.mentalcompute.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button play_button = findViewById(R.id.play_button);
        Button score_view_button = findViewById(R.id.score_view_button);

        play_button.setOnClickListener(view -> openComputeActivity());
        score_view_button.setOnClickListener(view -> openPreviousActivity());
    }

    private void openComputeActivity(){
        Intent intent = new Intent(this, MentalActivity.class);
        startActivity(intent);
    }

    private void openPreviousActivity() {
        Intent intent = new Intent(this, ScoreActivity.class);
        startActivity(intent);
    }
}