package fr.tlottin.mentalcompute.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import fr.tlottin.mentalcompute.R;
import fr.tlottin.mentalcompute.models.Operator;
import fr.tlottin.mentalcompute.models.OperationModel;
import fr.tlottin.mentalcompute.models.exception.NoAnswerException;
import fr.tlottin.mentalcompute.models.exception.WrongAnswerException;
import fr.tlottin.mentalcompute.services.OperationsGeneratorService;
import fr.tlottin.mentalcompute.services.ResolutionService;

public class MentalActivity extends AppCompatActivity {

    private TextView operationText;
    private int _number1;
    private int _number2;
    private Operator _typeOperation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mental);

        operationText = findViewById(R.id.operation_text);
        ImageButton home_image_button = findViewById(R.id.home_image_button);
        EditText editText = findViewById(R.id.answer_zone);
        TextView correctTV = findViewById(R.id.correct_text);
        TextView incorrectTV = findViewById(R.id.incorrect_text);
        TextView skipTV = findViewById(R.id.skip_text);
        TextView answerTV = findViewById(R.id.answer_text);
        Button validButton =  findViewById(R.id.valid_button);

        OperationsGeneratorService calculator = new OperationsGeneratorService();
        OperationModel operationG = calculator.CallFunctions();

        home_image_button.setOnClickListener(view -> goToPreviousActivity());
        editText.requestFocus();
        validButton.setOnClickListener(view -> Answer(editText.getText().toString(), operationG, correctTV, incorrectTV, skipTV, answerTV));

        setAttributes(operationG);
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

    private void goToPreviousActivity() {
        finish();
    }

    private void displayOperation() {
        String compute = getString(R.string.operation_template, getNumber1(), getTypeOperator().getOperator(), getNumber2());
        operationText.setText(compute);
    }
    
    private void setAttributes(OperationModel opModel){
        setNumber1(opModel.getNumber1());
        setNumber2(opModel.getNumber2());
        setTypeOperator(opModel.getTypeOperator());
        displayOperation();
    }

    private void Answer(String answerZone, OperationModel opModel, TextView cTV, TextView iTV, TextView sTV, TextView aTV) {
        ResolutionService answer = new ResolutionService();
        int result = answer.compute(opModel);

        try {
            answer.CorrectAnswer(answerZone, opModel);
            cTV.setVisibility(View.VISIBLE);
        } catch (NoAnswerException e) {
            String text = getString(R.string.answer, result);
            aTV.setText(text);
            aTV.setVisibility(View.VISIBLE);
            sTV.setVisibility(View.VISIBLE);
        } catch (WrongAnswerException e) {
            String text = getString(R.string.answer, result);
            aTV.setText(text);
            aTV.setVisibility(View.VISIBLE);
            iTV.setVisibility(View.VISIBLE);
        }
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

    private Operator getTypeOperator() {
        return _typeOperation;
    }

    private void setTypeOperator(Operator typeOperation) {
        this._typeOperation = typeOperation;
    }
}