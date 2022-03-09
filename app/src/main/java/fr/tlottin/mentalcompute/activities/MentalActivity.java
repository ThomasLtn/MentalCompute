package fr.tlottin.mentalcompute.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import fr.tlottin.mentalcompute.R;

public class MentalActivity extends AppCompatActivity {

    public enum Operation {
        PLUS("+"),
        MINUS("-"),
        BY("*");

        final String type;
        Operation(String operator) {
            this.type = operator;
        }

        String getOperator(){
            return type;
        }
    }

    private TextView operationText;
    private int number1;
    private int number2;
    private Operation typeOperation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mental);

        operationText = findViewById(R.id.operation);
        ImageButton home_imagebutton = findViewById(R.id.home_imageButton);
        EditText editText = (EditText) findViewById(R.id.AnswerZone);

        home_imagebutton.setOnClickListener(view -> goToPreviewActivity());
        editText.requestFocus();

        numbersAndOperationGenerator();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.score_view_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.score_view_menu_button:
                Intent intent = new Intent(this, ScoreActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void goToPreviewActivity() {
        finish();
    }

    private void numbersAndOperationGenerator() {
        number1 = (int) (11*Math.random());
        number2 = (int) (11*Math.random());

        switch ((int) (3*Math.random())) {
            case 0:
                typeOperation = Operation.PLUS;
                break;
            case 1:
                typeOperation = Operation.MINUS;
                break;
            case 2:
                typeOperation = Operation.BY;
                break;
        }

        displayOperation(number1, number2, typeOperation);
    }

    private void displayOperation(int n1, int n2, Operation typeOp) {
        String compute = n1 + " " + typeOp.getOperator() + " " + n2;
        operationText.setText(compute);
    }
}