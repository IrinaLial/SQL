package service;

import model.Laptop;

import java.util.List;

public interface LaptopService {
    void save(Laptop laptop);
    List<Laptop> getAll();
    void update(Laptop laptop);
    void delete(int id);
}
