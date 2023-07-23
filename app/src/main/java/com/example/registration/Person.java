package com.example.registration;

public class Person {
    String firstName;
    String lastName;
    String email;

    public Person(String one, String two, String three){
        firstName = one;
        lastName = two;
        email = three;
    }

    public String infoString(){
        return "Name: " + firstName +lastName +"\n" +"Email: "+ email +"\n";

    }


}
