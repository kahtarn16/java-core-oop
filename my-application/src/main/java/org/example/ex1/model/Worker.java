package org.example.ex1.model;

import org.example.ex1.common.GenderEnum;

public class Worker extends Officer{
    private String major;

    public Worker(Integer id, String fullName, Integer age, String address, GenderEnum gender, String major) {
        super(id, fullName, age, address, gender);
        setMajor(major);
    }

    public Worker(String fullName, Integer age, String address, GenderEnum gender, String major) {
        this(null, fullName, age, address, gender, major);
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        if(major == null || major.isBlank()) {
            throw new IllegalArgumentException("Major is required");
        }
        this.major = major;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "major='" + major + '\'' +
                ", id=" + id +
                ", fullName='" + fullName + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", gender=" + gender +
                '}';
    }
}
