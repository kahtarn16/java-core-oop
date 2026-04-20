package org.example.ex1.controller;

import org.example.ex1.common.GenderEnum;
import org.example.ex1.model.Engineer;
import org.example.ex1.model.Officer;
import org.example.ex1.model.Staff;
import org.example.ex1.model.Worker;
import org.example.ex1.service.OfficerService;

import java.util.Scanner;

public class OfficerController {
    private final OfficerService service;
    private final Scanner sc = new Scanner(System.in);

    public OfficerController(OfficerService service) {
        this.service = service;
    }

    public void start() {
        while(true) {
            System.out.println("\n--- OFFICER MANAGEMENT SYSTEM ---");
            System.out.println("1. Add Officer");
            System.out.println("2. Search by Name");
            System.out.println("3. Show All");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(sc.nextLine());

            try {
                switch (choice) {
                    case 1:
                        handleAdd();
                        break;
                    case 2:
                        handleSearch();
                        break;
                    case 3:
                        handleShowAll();
                        break;
                    case 4:
                        System.out.println("Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid option!");
                }
            } catch (Exception e) {
                System.out.println(">>> ERROR: " + e.getMessage());
            }
        }
    }

    private GenderEnum enterGender() {
        System.out.print("Select GENDET(1.FEMALE - 2.MALE - 3.OTHER");
        while(true) {
            try {
                int gender = Integer.parseInt(sc.nextLine());
                return switch (gender) {
                    case 1 -> GenderEnum.FEMALE;
                    case 2 -> GenderEnum.MALE;
                    case 3 -> GenderEnum.OTHER;
                    default -> throw new Exception();
                };
            } catch (Exception e) {
                System.out.println("Invalid choice! Please select 1, 2, or 3: ");
            }
        }
    }

    private void handleAdd() {
        System.out.println("--- Add New Officer ---");
        System.out.print("Enter Full Name: ");
        String fullName = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = Integer.parseInt(sc.nextLine());
        GenderEnum gender = enterGender();
        System.out.print("Enter Address: ");
        String address = sc.nextLine();

        boolean isCreated = false;
        Officer officer = null;

        while(!isCreated) {
            System.out.print("1.Staff - 2.Engineer - 3.Worker: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter job: ");
                    String job = sc.nextLine();
                    officer = new Staff(null, fullName, age, address, gender, job);
                    isCreated = true;
                    break;
                case 2:
                    System.out.print("Enter level(1 - 10): ");
                    int level = Integer.parseInt(sc.nextLine());
                    officer = new Engineer(null, fullName, age, address, gender, level);
                    isCreated = true;
                    break;
                case 3:
                    System.out.print("Enter major: ");
                    String major = sc.nextLine();
                    officer = new Worker(null, fullName, age, address, gender, major);
                    isCreated = true;
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }

        if (officer != null) {
            service.addOfficer(officer);
            System.out.println("Add officer successfully");
        }
    }

    private void handleShowAll() {
        System.out.println("\n--- LIST OF ALL OFFICERS ---");
        service.findAll().forEach(System.out::println);
    }

    private void handleSearch() {
        System.out.print("Enter name to search: ");
        String name = sc.nextLine();
        service.findByName(name).forEach(System.out::println);
    }
}
