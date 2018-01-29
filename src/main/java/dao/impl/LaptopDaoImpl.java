package dao.impl;

import config.Database;
import dao.LaptopDao;
import lombok.Cleanup;
import lombok.SneakyThrows;
import model.Laptop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class LaptopDaoImpl implements LaptopDao {
        private static final String INSERT_LAPTOP = "INSERT INTO miracle.laptop (name) VALUES (?)";
        private static final String SELECT_LAPTOP = "SELECT * FROM miracle.laptop";
        private static final String UPDATE_LAPTOP = "UPDATE miracle.laptop SET name =? WHERE id = ?";
        private static final String DELETE_LAPTOP = "DELETE FROM miracle.laptop WHERE id = ?";

    @SneakyThrows
    @Override
    public void save(Laptop laptop) {
        @Cleanup
        Connection connection = Database.getConnection();
        @Cleanup
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_LAPTOP);
        preparedStatement.setString(1, laptop.getName());
        preparedStatement.execute();
    }
    @SneakyThrows
    public List<Laptop> getAll() {
        List<Laptop> laptops = new LinkedList<>();
        @Cleanup
        Connection connection = Database.getConnection();
        @Cleanup
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LAPTOP);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Laptop laptop = new Laptop();
            laptop.setId(resultSet.getInt("id"));
            laptop.setName(resultSet.getString("name"));
            laptops.add(laptop);
        }
        return laptops;
    }

    public void update(Laptop laptop) {
        Connection connection = Database.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_LAPTOP);
            preparedStatement.setString(1, laptop.getName());
            preparedStatement.setLong(2, laptop.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void delete(int id) {
        Connection connection = Database.getConnection();
        try {
            @Cleanup
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_LAPTOP);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

