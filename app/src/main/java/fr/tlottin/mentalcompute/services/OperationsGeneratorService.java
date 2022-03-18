package fr.tlottin.mentalcompute.services;

import fr.tlottin.mentalcompute.models.Operation;
import fr.tlottin.mentalcompute.models.OperationModel;

public class OperationsGeneratorService {

    private int numbersGenerator() {
        return (int) (11*Math.random());
    }

    private Operation OperationGenerator() {
        Operation typeOp;
        switch ((int) (4*Math.random())) {
            case 0:
                typeOp = Operation.PLUS;
                break;
            case 1:
                typeOp = Operation.MINUS;
                break;
            case 2:
                typeOp = Operation.BY;
                break;
            case 3:
                typeOp = Operation.DIVIDE;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + (int) (3 * Math.random()));
        }

        return typeOp;
    }

    public OperationModel CallFunctions() {
        int n1 = numbersGenerator();
        int n2 = numbersGenerator();
        Operation operator = OperationGenerator();

        if (operator == Operation.DIVIDE){
            if (n1 < n2) {
                int temp = n1;
                n1 = n2;
                n2 = temp;
            }

            if (n2 == 0)
                n2++;

            int result = n1; //(n1*n2)/n2 = n1
            n1 *= n2; //Guarantee a rest of 0

            return new OperationModel(n1, n2, operator, result);
        }

        return new OperationModel(n1, n2, operator);
    }
}
