package service.impl;

import dao.LaptopDao;
import dao.impl.LaptopDaoImpl;
import model.Laptop;
import service.LaptopService;

import java.util.List;

public class LaptopServiceImpl implements LaptopService {
    public void save(Laptop laptop) {
        LaptopDao laptopDao = new LaptopDaoImpl();
        laptopDao.save(laptop);
    }
    public List<Laptop> getAll() {
      LaptopDao laptopDao = new LaptopDaoImpl();
        return laptopDao.getAll();
    }
    public void update(Laptop laptop) {
        LaptopDao laptopDao = new LaptopDaoImpl();
        laptopDao.update(laptop);
    }
    public void delete(int id) {
        LaptopDao laptopDao = new LaptopDaoImpl();
        laptopDao.delete(id);
    }
}
