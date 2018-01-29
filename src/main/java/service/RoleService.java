package service;

import model.Role;
import model.User;

import java.util.List;

public interface RoleService {
    void save(Role role);
    List<Role> getAll();
    void update(Role role);
    void delete(int id);
}
