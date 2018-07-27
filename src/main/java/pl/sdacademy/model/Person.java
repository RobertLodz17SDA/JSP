package pl.sdacademy.model;

import pl.sdacademy.model.enums.Sex;

import java.util.Date;

public class Person {

    private String name;
    private String surname;
    private int bornYear;
    private int phoneNumber;
    private Sex sex;

    public Person(String name,
                  String surname,
                  int bornYear,
                  int phoneNumber,
                  Sex sex) {
        this.name = name;
        this.surname = surname;
        this.bornYear = bornYear;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getBornYear() {
        return bornYear;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Sex getSex() {
        return sex;
    }
}
