package com.Main;

import java.util.Scanner;

import com.CredentialService.CredentialService;
import com.Employee.Employee;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("====================================");
        System.out.println("  SKIT - New Employee Onboarding");
        System.out.println("====================================");

        System.out.print("Enter First Name: ");
        String firstName = sc.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = sc.nextLine();

        String department = "";
        boolean validDept = false;

        while (!validDept) {
            System.out.println("\nChoose Department:");
            System.out.println("1. Technical");
            System.out.println("2. Admin");
            System.out.println("3. Human Resource");
            System.out.println("4. Legal");
            System.out.print("Enter option (1-4): ");

            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    department = "tech";
                    validDept = true;
                    break;
                case 2:
                    department = "admin";
                    validDept = true;
                    break;
                case 3:
                    department = "hr";
                    validDept = true;
                    break;
                case 4:
                    department = "legal";
                    validDept = true;
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }

        System.out.print("Enter desired password length (minimum 8): ");
        int passLength = sc.nextInt();
        if (passLength < 8) passLength = 8;

        Employee emp = new Employee(firstName, lastName);
        CredentialService cs = new CredentialService();

        String email = cs.generateEmailAddress(emp.getFirstName(), emp.getLastName(), department);
        String password = cs.generatePassword(passLength);

        cs.showCredentials(emp, email, password);
        cs.saveCredentialsToFile(emp, email, password, department);

        sc.close();
    }
}
