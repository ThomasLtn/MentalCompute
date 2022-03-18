package fr.tlottin.mentalcompute.models;

public enum Operation {
    PLUS("+"),
    MINUS("-"),
    BY("*"),
    DIVIDE("/");

    final String type;
    Operation(String operator) {
        this.type = operator;
    }

    public String getOperator(){
        return type;
    }
}
