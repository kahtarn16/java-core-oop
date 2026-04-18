package org.example.ex1.common;

public enum GenderEnum {
    FEMALE("Female"),
    MALE("Male"),
    OTHER("Other");

    private final String value;

    GenderEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
