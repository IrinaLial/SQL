package dao;

import model.Laptop;
import model.Role;

import java.util.List;

public interface RoleDao {
    void save(Role role);
    List<Role> getAll();
    void update(Role role);
    void delete(int id);
}
