package org.example.ex1.controller;

import org.example.ex1.service.OfficerService;

import java.util.Scanner;

public class OfficerController {
    private final OfficerService service;
    Scanner sc = new Scanner(System.in);

    public OfficerController(OfficerService service) {
        this.service = service;
    }


}
