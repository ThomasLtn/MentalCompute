package fr.tlottin.mentalcompute;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        Button score_view_menu_button = findViewById(R.id.score_view_menu_button);
        score_view_menu_button.setOnClickListener(view -> goToPreviewActivity());
    }

    private void goToPreviewActivity() {
        finish();
    }
}