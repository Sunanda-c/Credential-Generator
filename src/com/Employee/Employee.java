package com.Employee;

public class Employee {
    private String firstName;
    private String lastName;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName.trim().toLowerCase();
        this.lastName = lastName.trim().toLowerCase();
    }

    public String getFirstName() {
        return capitalize(firstName);
    }

    public String getLastName() {
        return capitalize(lastName);
    }

    private String capitalize(String str) {
        if (str == null || str.isEmpty()) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }
}
