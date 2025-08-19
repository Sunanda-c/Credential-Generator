package com.CredentialService;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import com.Employee.Employee;

public class CredentialService {

    public String generateEmailAddress(String firstName, String lastName, String department) {
        return (firstName + lastName + "@" + department + ".skit.ac.in").toLowerCase();
    }

    public String generatePassword(int length) {
        String caps = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String small = "abcdefghijklmnopqrstuvwxyz";
        String nums = "0123456789";
        String symbols = "!@#$%^&*_=+-/.?<>)";
        String allChars = caps + small + nums + symbols;
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        password.append(caps.charAt(random.nextInt(caps.length())));
        password.append(small.charAt(random.nextInt(small.length())));
        password.append(nums.charAt(random.nextInt(nums.length())));
        password.append(symbols.charAt(random.nextInt(symbols.length())));

        for (int i = 4; i < length; i++) {
            password.append(allChars.charAt(random.nextInt(allChars.length())));
        }

        return password.toString();
    }

    public void showCredentials(Employee emp, String email, String password) {
        System.out.println("\nDear " + emp.getFirstName() + ", your generated credentials are as follows:");
        System.out.println("Email    ---> " + email);
        System.out.println("Password ---> " + password);
        System.out.println("\nThank you & welcome to SKIT!");
    }

    public void saveCredentialsToFile(Employee emp, String email, String password, String department) {
        String fileName = emp.getFirstName() + "_" + emp.getLastName() + "_credentials.txt";
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("SKIT - Employee Credentials\n");
            writer.write("===========================\n");
            writer.write("Name      : " + emp.getFullName() + "\n");
            writer.write("Department: " + department + "\n");
            writer.write("Email     : " + email + "\n");
            writer.write("Password  : " + password + "\n");
            writer.write("Generated : " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")) + "\n");
            System.out.println("\nCredentials saved to file: " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing credentials to file.");
            e.printStackTrace();
        }
    }
}
