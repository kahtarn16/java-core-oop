package org.example.ex1.service;

import org.example.ex1.model.Officer;
import org.example.ex1.repository.OfficerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class OfficerService {
    private final OfficerRepository repository;

    public OfficerService(OfficerRepository repository) {
        this.repository = repository;
    }

    public void addOfficer(Officer officer) {
        repository.add(officer);
    }

    public List<Officer> findAll() {
        return repository.findAll();
    }

    public Officer findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("The officer with ID: " + id + " is not found"));

    }

    public void deleteById(Integer id) {
        if(!repository.exitsById(id)) {
            throw new RuntimeException("The office with ID: " + id + " not found");
        }

        repository.deleteById(id);
    }

    public boolean exitsById(Integer id) {
        return repository.exitsById(id);
    }

    public List<Officer> findByName(String name) {
        List<Officer> officers = repository.findByName(name);

        if(officers.isEmpty()) {
            throw new RuntimeException("These officers with name: " + name + " not found");
        }

        return officers;
    }
}
