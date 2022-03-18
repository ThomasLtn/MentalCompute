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
import fr.tlottin.mentalcompute.models.Operation;
import fr.tlottin.mentalcompute.models.OperationModel;
import fr.tlottin.mentalcompute.services.OperationsGeneratorService;

public class MentalActivity extends AppCompatActivity {
    //TODO: Call to Resolution service
    //TODO: Display if the answer is incorrect or if there is no answer
    //TODO: Display if the answer is correct

    private TextView operationText;
    private int _number1;
    private int _number2;
    private Operation _typeOperation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mental);

        operationText = findViewById(R.id.operation_text);
        ImageButton home_image_button = findViewById(R.id.home_image_button);
        EditText editText = findViewById(R.id.answer_zone);

        OperationsGeneratorService calculator = new OperationsGeneratorService();
        OperationModel operationG = calculator.CallFunctions();

        home_image_button.setOnClickListener(view -> goToPreviewActivity());
        editText.requestFocus();

        setNumber1(operationG.getNumber1());
        setNumber2(operationG.getNumber2());
        setTypeOperation(operationG.getTypeOperation());
        displayOperation();
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

    private void displayOperation() {
        String compute = getString(R.string.operation_template, getNumber1(), getTypeOperation().getOperator(), getNumber2());
        operationText.setText(compute);
    }

    private int getNumber1() {
        return _number1;
    }

    private void setNumber1(int number1) {
        this._number1 = number1;
    }

    private int getNumber2() {
        return _number2;
    }

    private void setNumber2(int number2) {
        this._number2 = number2;
    }

    private Operation getTypeOperation() {
        return _typeOperation;
    }

    private void setTypeOperation(Operation typeOperation) {
        this._typeOperation = typeOperation;
    }
}