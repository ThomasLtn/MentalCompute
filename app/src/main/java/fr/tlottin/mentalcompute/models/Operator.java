package fr.tlottin.mentalcompute.models;

public enum Operator {
    PLUS("+"),
    MINUS("-"),
    BY("*"),
    DIVIDE("/");

    final String type;
    Operator(String operator) {
        this.type = operator;
    }

    public String getOperator(){
        return type;
    }
}
