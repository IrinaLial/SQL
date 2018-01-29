package dao;

import model.Laptop;

import java.util.List;

public interface LaptopDao {
    void save(Laptop laptop);
    List<Laptop> getAll();
    void update(Laptop laptop);
    void delete(int id);
}
