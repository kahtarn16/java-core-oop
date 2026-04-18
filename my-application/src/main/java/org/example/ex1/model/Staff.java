package org.example.ex1.model;

import org.example.ex1.common.GenderEnum;

public class Staff extends Officer{
    private String job;

    public Staff(Integer id, String fullName, Integer age, String address, GenderEnum gender, String job) {
        super(id, fullName, age, address, gender);
        setJob(job);
    }

    public Staff(String fullName, Integer age, String address, GenderEnum gender, String job) {
        this(null, fullName, age, address, gender, job);
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        if(job == null || job.isBlank()) {
            throw new IllegalArgumentException("Job is required");
        }
        this.job = job;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "job='" + job + '\'' +
                ", id=" + id +
                ", fullName='" + fullName + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", gender=" + gender +
                '}';
    }
}
