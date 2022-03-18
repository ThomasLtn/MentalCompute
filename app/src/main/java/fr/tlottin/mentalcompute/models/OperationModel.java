package fr.tlottin.mentalcompute.models;

public class OperationModel {

    private final int number1;
    private final int number2;
    private final Operator typeOperation;
    private final int result;

    public OperationModel(int n1, int n2, Operator tO) {
        this.number1 = n1;
        this.number2 = n2;
        this.typeOperation = tO;
        this.result = 0;
    }

    public OperationModel(int n1, int n2, Operator tO, int result) {
        this.number1 = n1;
        this.number2 = n2;
        this.typeOperation = tO;
        this.result = result;
    }

    public int getNumber1() {
        return number1;
    }

    public int getNumber2() {
        return number2;
    }

    public Operator getTypeOperator() {
        return typeOperation;
    }

    public int getResult() {
        return result;
    }
}
