package service.impl;

import dao.TShirtDao;
import dao.impl.TShirtDaoImpl;
import model.TShirt;
import service.TShirtService;

import java.util.List;

public class TShirtServiceImpl implements TShirtService {
    public void save(TShirt tShirt) {
        TShirtDao tShirtDao = new TShirtDaoImpl();
        tShirtDao.save(tShirt);
    }

    @Override
    public List<TShirt> getAll() {
        TShirtDao tShirtDao = new TShirtDaoImpl();
        return tShirtDao.getAll();
    }

    @Override
    public void update(TShirt tShirt) {
        TShirtDao tShirtDao = new TShirtDaoImpl();
        tShirtDao.update(tShirt);
    }
    @Override
    public void delete(int id) {
        TShirtDao tShirtDao = new TShirtDaoImpl();
        tShirtDao.delete(id);
    }
}
