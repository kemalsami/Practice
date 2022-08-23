package entity;

import annotations.RunMethodImmediately;
import annotations.Seruvent;

import java.util.Objects;

@Seruvent
public class Person {

    int id;
    String name;

    public Person(){
    }

    @RunMethodImmediately(times = 2)
    public void printRecord(){
        System.out.println("Person id: " + this.id + " - name: " + this.name);
    }

    @RunMethodImmediately
    public void increaseId(){
        this.id++;
    }

    public Person(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
