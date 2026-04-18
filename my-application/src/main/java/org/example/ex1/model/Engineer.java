package org.example.ex1.model;

import org.example.ex1.common.GenderEnum;

public class Engineer extends Officer{
    private Integer level;

    public Engineer(Integer id, String fullName, Integer age, String address, GenderEnum gender, Integer level) {
        super(id, fullName, age, address, gender);
        setLevel(level);
    }

    public Engineer(String fullName, Integer age, String address, GenderEnum gender, Integer level) {
        this(null, fullName, age, address, gender, level);
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        if(level == null) {
            throw new IllegalArgumentException("Level is required");
        }
        this.level = level;
    }

    @Override
    public String toString() {
        return "Engineer{" +
                "level=" + level +
                ", id=" + id +
                ", fullName='" + fullName + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", gender=" + gender +
                '}';
    }
}
