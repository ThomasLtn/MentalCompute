package fr.tlottin.mentalcompute.services;

import fr.tlottin.mentalcompute.models.Operation;
import fr.tlottin.mentalcompute.models.OperationModel;

public class OperationsGeneratorService {

    private int numbersGenerator() {
        return (int) (11*Math.random());
    }

    private Operation OperationGenerator() {
        Operation typeOp;
        switch ((int) (3*Math.random())) {
            case 0:
                typeOp = Operation.PLUS;
                break;
            case 1:
                typeOp = Operation.MINUS;
                break;
            case 2:
                typeOp = Operation.BY;
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

        return new OperationModel(n1, n2, operator);
    }
}
