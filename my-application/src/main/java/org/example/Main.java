package org.example;

import org.example.ex1.controller.OfficerController;
import org.example.ex1.repository.OfficerRepository;
import org.example.ex1.service.OfficerService;

public class Main {
    public static void main(String[] args) {
        OfficerController controller = new OfficerController(new OfficerService(new OfficerRepository()));

        controller.start();
    }
}