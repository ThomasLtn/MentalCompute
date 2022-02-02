package fr.tlottin.mentalcompute;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        Button retry_button = findViewById(R.id.retry_button);
        retry_button.setOnClickListener(view -> goToPreviewActivity());
    }

    private void goToPreviewActivity() {
        finish();
    }
}