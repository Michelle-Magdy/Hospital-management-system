package Hospital;

import java.util.*;

abstract class Person {
    private String name;
    private int age;
    private String gender;

    abstract String getDetails();

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }
}
