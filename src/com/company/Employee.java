package com.company;

public class Employee {
    private final String name;
    private final String surname;
    private final String patronymic;
    private final String sex;

    public Employee(String name, String surname, String patronymic, String sex) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getSex() {
        return sex;
    }
// эти сеттеры не принято использовать
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setSurname(String surname) {
//        this.surname = surname;
//    }
//
//    public void setPatronymic(String patronymic) {
//        this.patronymic = patronymic;
//    }
//
//    public void setSex(String sex) {
//        this.sex = sex;
//    }
    // круто использовать вот эти методы с сетерами
    public Employee withDetermineSex(String sex) {
        return new Employee(this.getName(), this.getSurname(), this.getPatronymic(), sex);
    }
}
