package demo;

import config.Database;
import model.Laptop;
import model.TShirt;
import model.User;
import service.LaptopService;
import service.TShirtService;
import service.UserService;
import service.impl.LaptopServiceImpl;
import service.impl.TShirtServiceImpl;
import service.impl.UserServiceImpl;

import java.sql.*;
import java.util.List;

public class Demo {

    public static void main(String[] args) throws SQLException {

//        User user = new User();
//        user.setName("Julia");
//        user.setSkills("PHP");
//
//        UserService userService = new UserServiceImpl();
//        userService.save(user);
//
//        List<User> users = userService.getAll();
//        users.forEach(System.out::println);
//
//        userService.update(user);
//        userService.delete(11);

        Laptop laptop = new Laptop();
        laptop.setName("Sony");

        LaptopService laptopService = new LaptopServiceImpl();
        laptopService.save(laptop);

        List<Laptop> laptops = laptopService.getAll();
        laptops.forEach(System.out::println);

        laptopService.delete(8);
        laptopService.update(laptop);

//        TShirt tShirt = new TShirt();
//        tShirt.setSize(3);
//        tShirt.setColor("Blue");
//
//        TShirtService tShirtService = new TShirtServiceImpl();
//        tShirtService.save(tShirt);
//
//        List<TShirt> tShirts = tShirtService.getAll();
//        tShirts.forEach(System.out::println);
//
//        tShirtService.delete(4);
//        tShirtService.update(tShirt);
    }
}
