package com.beglyak_project.connection;

import com.beglyak_project.dao.PersonDaoImpl;
import com.beglyak_project.model.Person;

import java.sql.*;

public class Application {

    /*private static final String SQL_CREATE_TABLE = "CREATE TABLE products (id INT PRIMARY KEY AUTO_INCREMENT,name VARCHAR(20),price INT)";
    private static final String INSERT = "INSERT products (name,price) VALUES ('carrots',8000),('mile',200)";
    private static final String UPDATE = "UPDATE products SET price=price-1000 where id=1";
    private static final String DELETE = "DELETE FROM products WHERE id=2";
    private static final String SELECT = "SELECT * FROM products";*/
    //private static final String TABLE_PEOPLE = "CREATE TABLE people (id INT PRIMARY KEY AUTO_INCREMENT,firstName VARCHAR(20), lastName VARCHAR(20), age INT)";




    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Person person = new Person("Vova", "Ivanov", 20);
        PersonDaoImpl personDao = new PersonDaoImpl();
        System.out.println(personDao.add(person));


        /*try (Connection connect = new DBConnection().getConnect()) {
            //System.out.println("Succes");

            //statement.executeUpdate(DELETE);
            //statement.executeUpdate(INSERT);
            *//*PreparedStatement preparedStatement = connect.prepareStatement(TABLE_PEOPLE);
            preparedStatement.setString(1,"coffee");
            preparedStatement.setInt(2,5);
            preparedStatement.executeUpdate();*//*






            //Statement statement = connect.createStatement();
            //statement.executeUpdate(TABLE_PEOPLE);
            *//*ResultSet resultSet = statement.executeQuery(SELECT);
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int price = resultSet.getInt(3);
                System.out.printf("%d. %s - %d \n",id,name,price);
            }*//*

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Failed");
            e.printStackTrace();
        }*/
    }
}
