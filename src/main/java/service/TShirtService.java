package service;

import model.TShirt;

import java.util.List;

public interface TShirtService {
    void save(TShirt tShirt);
    List<TShirt> getAll();
    void update(TShirt tShirt);
    void delete(int id);
}
