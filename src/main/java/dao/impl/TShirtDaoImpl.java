package dao.impl;

import config.Database;
import dao.TShirtDao;
import lombok.Cleanup;
import lombok.SneakyThrows;
import model.Role;
import model.TShirt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class TShirtDaoImpl implements TShirtDao {
    private static final String INSERT_TSHIRT = "INSERT INTO miracle.t_shirt (color,size) VALUES (?,?)";
    private static final String SELECT_TSHIRT = "SELECT * FROM miracle.role";
    private static final String UPDATE_TSHIRT = "UPDATE miracle.role SET name =? WHERE id = ?";
    private static final String DELETE_TSHIRT = "DELETE FROM miracle.role WHERE id = ?";

    @SneakyThrows
    @Override
    public void save(TShirt tShirt) {
        @Cleanup
        Connection connection = Database.getConnection();
        @Cleanup
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TSHIRT);
        preparedStatement.setString(1, tShirt.getColor());
        preparedStatement.setInt(1, tShirt.getSize());
        preparedStatement.execute();
    }

    @SneakyThrows
    public List<TShirt> getAll() {
        List<TShirt> tShirts = new LinkedList<>();
        @Cleanup
        Connection connection = Database.getConnection();
        @Cleanup
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TSHIRT);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
           TShirt tShirt = new TShirt();
            tShirt.setId(resultSet.getInt("id"));
            tShirt.setColor(resultSet.getString("color"));
            tShirt.setSize(resultSet.getInt("size"));
            tShirts.add(tShirt);
        }
        return tShirts;
    }

    public void update(TShirt tShirt) {
        Connection connection = Database.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TSHIRT);
            preparedStatement.setString(1, tShirt.getColor());
            preparedStatement.setInt(2, tShirt.getSize());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        Connection connection = Database.getConnection();
        try {
            @Cleanup
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_TSHIRT);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
