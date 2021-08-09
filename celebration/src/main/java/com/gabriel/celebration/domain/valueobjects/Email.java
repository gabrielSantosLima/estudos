package com.gabriel.celebration.domain.valueobjects;

public class Email {
    private String value;

    public Email(String value) throws Exception {
        this.value = validate(value);
    }

    private String validate(String value) throws Exception {
        if(value.isEmpty()){
           throw new Exception("Email não pode ser vazio.");
        }
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return getValue();
    }
}
