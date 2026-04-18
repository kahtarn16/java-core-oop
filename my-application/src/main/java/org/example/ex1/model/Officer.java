package org.example.ex1.model;

import org.example.ex1.common.GenderEnum;
import org.example.ex1.common.IEntity;

import java.util.Objects;

public abstract class Officer implements IEntity<Integer> {
    protected Integer id;
    protected String fullName;
    protected Integer age;
    protected String address;
    protected GenderEnum gender;

    public Officer() {

    }

    //Invoking Setters inside Constructure(Validation Constructure Pattern)
    public Officer(Integer id, String fullName, Integer age, String address, GenderEnum gender) {
        setId(id);
        setFullName(fullName);
        setAge(age);
        setAddress(address);
        setGender(gender);
    }


    //Overload
    public Officer(String fullName, Integer age, String address, GenderEnum gender) {
        this(null, fullName, age, address, gender);
    }


    //Getter and Validation inside Setter
    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setId(Integer id) {
        if(id != null && id < 0) {
            throw new IllegalArgumentException("ID must be positive");
        }
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public final void setFullName(String fullName) {
        if(fullName == null || fullName.isBlank()) {
            throw new IllegalArgumentException("Full name is required");
        }
        this.fullName = fullName;
    }

    public  Integer getAge() {
        return age;
    }

    public final void setAge(Integer age) {
        if(age == null) {
            throw new IllegalArgumentException("Age is required");
        }
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public final void setAddress(String address) {
        if(address == null || address.isBlank()) {
            throw new IllegalArgumentException("Address is required");
        }
        this.address = address;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public final void setGender(GenderEnum gender) {
        if(gender == null || gender.getValue().isBlank()) {
            throw new IllegalArgumentException("Gender is required");
        }
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Officer officer = (Officer) o;
        return Objects.equals(id, officer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Officer{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", gender=" + gender +
                '}';
    }
}
