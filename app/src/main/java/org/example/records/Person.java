package org.example.records;

public record Person(String name, int age, String email) {

    public Person{
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name cannot be null or blank");
        }

        if (age < 0) {
            throw new IllegalArgumentException("age cannot be negative");
        }

        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("email cannot be null or blank");
        }
    }

    public String getFullDetails(){
        return "Name: " + name + ", Age: " + age + ", Email: " + email;
    }

    public static Person createDefault(){
        return new Person("John Doe", 23, "johndoe@example.com");
    }
}
