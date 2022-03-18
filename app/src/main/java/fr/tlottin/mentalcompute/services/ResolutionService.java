package fr.tlottin.mentalcompute.services;

import androidx.annotation.NonNull;

import fr.tlottin.mentalcompute.models.Operator;
import fr.tlottin.mentalcompute.models.OperationModel;
import fr.tlottin.mentalcompute.models.exception.NoAnswerException;
import fr.tlottin.mentalcompute.models.exception.WrongAnswerException;

public class ResolutionService {

    public int compute(@NonNull OperationModel operation) {
        if(operation == null){
            throw new NullPointerException("operation can not be null");
        }

        int number1 = operation.getNumber1();
        int number2 = operation.getNumber2();
        Operator operator = operation.getTypeOperator();

        int result;
        switch (operator) {
            case PLUS:
                result = number1 + number2;
                break;
            case MINUS:
                result = number1 - number2;
                break;
            case BY:
                result = number1 * number2;
                break;
            case DIVIDE:
                result = number1 / number2;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + operator);
        }

        return result;
    }

    public void CorrectAnswer(String aZ, OperationModel oM) throws NoAnswerException, WrongAnswerException {
        if (aZ.equals("")){
            throw new NoAnswerException("Operation skipped");
        }

        int proposedAnswer = Integer.parseInt(aZ);
        int answer = compute(oM);
        if (proposedAnswer != answer){
            throw new WrongAnswerException("Wrong Answer proposed");
        }
    }
}
