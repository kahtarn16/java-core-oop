package org.example.ex1.repository;

import org.example.ex1.common.RepositoryImpl;
import org.example.ex1.model.Officer;

import java.util.List;
import java.util.stream.Collectors;

public class OfficerRepository extends RepositoryImpl<Officer, Integer> {
    @Override
    protected Integer generateNextId() {
        return items.stream()
                .mapToInt(o -> (Integer)o.getId()).max().orElse(0) + 1;
    }

    @Override
    public List<Officer> findByName(String name) {
        return items.stream().filter(o -> o.getFullName().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());
    }
}
