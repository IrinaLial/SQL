package dao;

import model.TShirt;

import java.util.List;

public interface TShirtDao {
    void  save(TShirt tShirt);
    List<TShirt> getAll();
    void update(TShirt tShirt);
    void delete(int id);
}
