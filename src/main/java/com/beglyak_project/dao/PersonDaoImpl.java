package com.beglyak_project.dao;

import com.beglyak_project.connection.DBConnection;
import com.beglyak_project.model.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDaoImpl implements BaseDAO<Person> {

    private static final String INSERT="INSERT people (firstName, lastName,age ) VALUES (?,?,?)";
    private static final String DELETE="DELETE FROM people WHERE firstName=? AND lastName=? AND age=?";
    private static final String FIND_ALL="SELECT * FROM people";
    private static final String FIND_FROM_ID="SELECT * FROM people WHERE id=?";


    @Override
    public boolean add(Person person) throws SQLException, ClassNotFoundException {

        Connection connect = DBConnection.getConnect();

        int rows=0;

        try (connect) {

            PreparedStatement preparedStatement = connect.prepareStatement(INSERT);
            preparedStatement.setString(1,person.getFirstName());
            preparedStatement.setString(2,person.getLastName());
            preparedStatement.setInt(3,person.getAge());
            rows = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows!=0;
    }

    @Override
    public boolean delete(Person person) {

        int rows=0;
        try (Connection connect = DBConnection.getConnect()) {

            PreparedStatement preparedStatement = connect.prepareStatement(DELETE);
            preparedStatement.setString(1,person.getFirstName());
            preparedStatement.setString(2,person.getLastName());
            preparedStatement.setInt(3,person.getAge());

            rows = preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return rows!=0;
    }

    @Override
    public Person findId(int id) {
        Person person=null;
        try (Connection connection = DBConnection.getConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_FROM_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                id = resultSet.getInt("id");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                int age = resultSet.getInt("age");
                person = new Person(id,firstName,lastName,age);
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return person;
    }

    @Override
    public List<Person> findAll() {
        List<Person> people = new ArrayList<>();
        try (Connection connect = DBConnection.getConnect()) {
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(FIND_ALL);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                int age = resultSet.getInt("age");

                people.add(new Person(id,firstName,lastName,age));
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        return people;
    }


}
