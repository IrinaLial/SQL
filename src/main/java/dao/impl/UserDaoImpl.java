package dao.impl;

import config.Database;
import dao.UserDao;
import lombok.Cleanup;
import lombok.SneakyThrows;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class UserDaoImpl implements UserDao {

    private static final String INSERT_USER = "INSERT INTO miracle.users (name, skills) VALUES (?,?)";
    private static final String SELECT_USERS = "SELECT * FROM miracle.users";
    private static final String UPDATE_USERS = "UPDATE miracle.users SET name =?, skills =? WHERE id = ?";
    private static final String DELETE_USERS = "DELETE FROM miracle.users WHERE id = ?";

    @SneakyThrows
    @Override
    public void save(User user) {
        @Cleanup
        Connection connection = Database.getConnection();
        @Cleanup
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getSkills());
        preparedStatement.execute();
    }

    @SneakyThrows
    public List<User> getAll() {
        List<User> users = new LinkedList<>();
        @Cleanup
        Connection connection = Database.getConnection();
        @Cleanup
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USERS);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getLong("id"));
            user.setName(resultSet.getString("name"));
            user.setSkills(resultSet.getString("skills"));
            users.add(user);
        }
        return users;
    }

    public void update(User user) {
        Connection connection = Database.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSkills());
            preparedStatement.setLong(3, user.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        Connection connection = Database.getConnection();
        try {
            @Cleanup
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}