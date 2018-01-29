package service.impl;

import dao.RoleDao;
import dao.impl.RoleDaoImpl;
import model.Role;
import service.RoleService;

import java.util.List;

public class RoleServiceImpl implements RoleService {
    public void save(Role role) {
        RoleDao roleDao = new RoleDaoImpl();
        roleDao.save(role);
    }

    @Override
    public List<Role> getAll() {
        RoleDao roleDao = new RoleDaoImpl();
        return roleDao.getAll();
    }

    @Override
    public void update(Role role) {
        RoleDao roleDao = new RoleDaoImpl();
        roleDao.update(role);
    }

    @Override
    public void delete(int id) {
        RoleDao roleDao = new RoleDaoImpl();
        roleDao.delete(id);
    }
}
