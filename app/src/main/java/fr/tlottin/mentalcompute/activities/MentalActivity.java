package fr.tlottin.mentalcompute.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import fr.tlottin.mentalcompute.R;

public class MentalActivity extends AppCompatActivity {
    //TODO: Call to services
    //TODO: Display if the answer is incorrect or if there is no answer
    //TODO: Display if the answer is correct

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
    private int _number1;
    private int _number2;
    private Operation _typeOperation;

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
        int n1 = (int) (11*Math.random());
        int n2 = (int) (11*Math.random());
        setNumber1(n1);
        setNumber2(n2);

        Operation typeOp;
        switch ((int) (3*Math.random())) {
            case 0:
                typeOp = Operation.PLUS;
                setTypeOperation(typeOp);
                break;
            case 1:
                typeOp = Operation.MINUS;
                setTypeOperation(typeOp);
                break;
            case 2:
                typeOp = Operation.BY;
                setTypeOperation(typeOp);
                break;
        }

        displayOperation(_number1, _number2, _typeOperation);
    }

    private void displayOperation(int n1, int n2, Operation typeOp) {
        //TODO: Display the operation by a configurable resource
        String compute = n1 + " " + typeOp.getOperator() + " " + n2;
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