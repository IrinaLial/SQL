package demo;

import config.Database;
import model.Laptop;
import model.User;
import service.LaptopService;
import service.UserService;
import service.impl.LaptopServiceImpl;
import service.impl.UserServiceImpl;

import java.sql.*;
import java.util.List;

public class Demo {

    public static void main(String[] args) throws SQLException {

//       User user = new User();
//       user.setName("Julia");
//       user.setSkills("PHP");
//
//       UserService userService = new UserServiceImpl();
//       userService.save(user);
//
//       List<User> users = userService.getAll();
//       users.forEach(System.out::println);

//     userService.update(user);
//     userService.delete(11);

        Laptop laptop = new Laptop();
        laptop.setName("Sony");

        LaptopService laptopService = new LaptopServiceImpl();
        laptopService.save(laptop);


        Connection connection = Database.getConnection();
//
        Statement statement = connection.createStatement();
//       statement.execute("INSERT INTO miracle.users (name,skills) VALUES ('Ann','JAVA')");
//       statement.executeUpdate("UPDATE miracle.users SET name = 'Alex', skills = 'Java' WHERE id = 1");
//       statement.executeUpdate("DELETE FROM miracle.users WHERE id = 5");

//       ResultSet resultSet = statement.executeQuery("SELECT * FROM miracle.users");
//       while (resultSet.next()) {
//           String name = resultSet.getString("name");
//           String skills = resultSet.getString("skills");
//          System.out.println(name + " " + skills);
//        }
//        connection.close();

//       statement.execute("INSERT INTO miracle.laptop (name) VALUES ('MAC')");
//       ResultSet resultSet = statement.executeQuery("SELECT * FROM miracle.laptop");
//       while (resultSet.next()) {
//           String name = resultSet.getString("name");
//           String id = resultSet.getString("id");
//          System.out.println(name + " " + id);
//        }
//        connection.close();
    }
}
