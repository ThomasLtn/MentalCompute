package fr.tlottin.mentalcompute.models;

public enum Operation {
    PLUS("+"),
    MINUS("-"),
    BY("*");

    final String type;
    Operation(String operator) {
        this.type = operator;
    }

    public String getOperator(){
        return type;
    }
}
