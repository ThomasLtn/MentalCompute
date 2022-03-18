package fr.tlottin.mentalcompute.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import fr.tlottin.mentalcompute.R;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        Button previous_button = findViewById(R.id.previous_button);
        previous_button.setOnClickListener(view -> goToPreviousActivity());
    }

    private void goToPreviousActivity() {
        finish();
    }
}