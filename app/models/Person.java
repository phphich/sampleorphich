package models;

/**
 * Created by COM-1 on 13/5/2561.
 */
public class Person {
    private String  id, name, surname, address;
    private int age;
    private  double salary;

    //Constructor method
    public Person() {
    }

    public Person(String id, String name, String surname, String address, int age, double salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.age = age;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

}
