package org.example.ex1.common;

import java.util.List;
import java.util.Optional;

public interface Repository<T, ID> {
    void add(T entity);
    List<T> findAll();
    Optional<T> findById(ID id);
    void deleteById(ID id);
    boolean exitsById(ID id);
    List<T> findByName(String name);
}
