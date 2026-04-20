package org.example.ex1.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class RepositoryImpl<T extends IEntity<ID>, ID> implements Repository<T, ID> {
    protected List<T> items = new ArrayList<>();
    protected abstract ID generateNextId();
    @Override
    public void add(T entity) {
        if(entity == null) {
            throw new RuntimeException("Can not add null entity");
        }

        if(entity.getId() == null) {
            entity.setId(generateNextId());
        }
        items.add(entity);
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(items);
    }

    @Override
    public Optional<T> findById(ID id) {
        return items.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst();
    }

    @Override
    public void deleteById(ID id) {
        items.removeIf(item -> item.getId().equals(id));
    }

    @Override
    public boolean exitsById(ID id) {
        return items.stream().anyMatch(item -> item.getId().equals(id));
    }
}
