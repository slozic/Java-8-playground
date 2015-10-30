/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java8test.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 *
 * @author slozic
 */
public class Person {

    private String givenName;
    private String surName;
    private int age;
    private String eMail;
    private String phone;
    private String address;

    public static List<Person> createShortList() {
        List<Person> people = new ArrayList<>();

        Person p = new Person();
        p.setGivenName("Bob");
        p.setSurName("Baker");
        p.setAge(21);
        p.seteMail("bob.baker@example.com");
        p.setPhone("201-121-4678");
        p.setAddress("44 4th St, Smallville, KS 12333");
        people.add(p);
        return people;
    }

    public String printCustom(Function<Person, String> f) {
        return f.apply(this);
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
