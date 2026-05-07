package com.global.book.service;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

// R now extends MongoRepository, and the ID type is String
public abstract class BaseService<T, R extends MongoRepository<T, String>> {

    protected final R repo;

    public BaseService(R repo) {
        this.repo = repo;
    }

    public T findById(String id) {
        return repo.findById(id)
                   .orElseThrow(() -> new RuntimeException(getEntityName() + " not found with id: " + id));
    }

    public List<T> findAll() {
        return repo.findAll();
    }

    public T insert(T entity) {
        return repo.insert(entity); // .insert() is specific to Mongo for new docs
    }

    public T update(T entity) {
        return repo.save(entity); // .save() works for updates in Mongo
    }

    public List<T> bulkInsert(List<T> entities) {
        return repo.insert(entities);
    }

    public void deleteById(String id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException(getEntityName() + " not found with id: " + id);
        }
        repo.deleteById(id);
    }

    protected String getEntityName() {
        return "Entity";
    }
}