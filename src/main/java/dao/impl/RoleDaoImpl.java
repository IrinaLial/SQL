package dao.impl;

import config.Database;
import dao.RoleDao;
import lombok.Cleanup;
import lombok.SneakyThrows;
import model.Role;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class RoleDaoImpl implements RoleDao {
    private static final String INSERT_ROLE = "INSERT INTO miracle.role (name) VALUES (?)";
    private static final String SELECT_ROLE = "SELECT * FROM miracle.role";
    private static final String UPDATE_ROLE = "UPDATE miracle.role SET name =? WHERE id = ?";
    private static final String DELETE_ROLE = "DELETE FROM miracle.role WHERE id = ?";

    @SneakyThrows
    @Override
    public void save(Role role) {
        @Cleanup
        Connection connection = Database.getConnection();
        @Cleanup
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ROLE);
        preparedStatement.setString(1, role.getName());
        preparedStatement.execute();
    }

    @SneakyThrows
    public List<Role> getAll() {
        List<Role> roles = new LinkedList<>();
        @Cleanup
        Connection connection = Database.getConnection();
        @Cleanup
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ROLE);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Role role = new Role();
            role.setId(resultSet.getInt("id"));
            role.setName(resultSet.getString("name"));
            roles.add(role);
        }
        return roles;
    }

    public void update(Role role) {
        Connection connection = Database.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ROLE);
            preparedStatement.setString(1, role.getName());
            preparedStatement.setLong(2, role.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        Connection connection = Database.getConnection();
        try {
            @Cleanup
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ROLE);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
