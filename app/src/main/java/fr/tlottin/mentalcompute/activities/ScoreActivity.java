package fr.tlottin.mentalcompute.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import fr.tlottin.mentalcompute.R;
import fr.tlottin.mentalcompute.models.Operator;

public class ScoreActivity extends AppCompatActivity {
    public final static String NUMBER1_KEY = "NUMBER1";
    public final static String NUMBER2_KEY = "NUMBER2";
    public final static String TYPE_OPERATOR_KEY = "TYPE_OPERATOR";
    public final static String ANSWER_KEY = "ANSWER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        TextView lastOperationTV = findViewById(R.id.last_operation_text);

        Intent intent = getIntent();
        int number1 = intent.getIntExtra(NUMBER1_KEY, 0);
        int number2 = intent.getIntExtra(NUMBER2_KEY, 0);
        Operator typeOperator = intent.getParcelableExtra(TYPE_OPERATOR_KEY);
        int answer = intent.getIntExtra(ANSWER_KEY, 0);

        Button previous_button = findViewById(R.id.previous_button);
        previous_button.setOnClickListener(view -> goToPreviousActivity());

        //String text = getString(R.string.last_operation_label, number1, typeOperator, number2, answer);
        //lastOperationTV.setText(text);
    }

    private void goToPreviousActivity() {
        finish();
    }
}