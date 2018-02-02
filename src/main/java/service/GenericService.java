package service;

import java.util.List;

public interface GenericService <T,Id> {

    List<T> getAll();
    void update(T t);
    void delete(Id id);
    void save(T t);
}
