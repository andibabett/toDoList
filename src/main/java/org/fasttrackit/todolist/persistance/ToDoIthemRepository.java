package org.fasttrackit.todolist.persistance;

import org.fasttrackit.todolist.domain.ToDoIthem;
import org.fasttrackit.todolist.transfer.CreateToDoIthemRequest;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ToDoIthemRepository {

    public ToDoIthemRepository() throws SQLException, IOException, ClassNotFoundException {
    }

    public void creatToDoIthem(CreateToDoIthemRequest request) throws IOException, ClassNotFoundException, SQLException {
        String sql = "INSERT INTO to_do_item (description, deadline) VALUES (?, ?)";

        //try with recources
        try (Connection connection = DatabaseConfiguration.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, request.getDescription());
            preparedStatement.setDate(2, Date.valueOf(request.getDeadline()));

            preparedStatement.executeUpdate();

        }
    }

    public void updateToDoItem(long id, boolean done) throws SQLException, IOException, ClassNotFoundException {
        String sql = "UPDATE to_do_item SET done=? WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setBoolean(1, done);
            preparedStatement.setLong(2, id);

            preparedStatement.executeUpdate();
        }
    }

    public void deleteToDoItem(long id) throws SQLException, IOException, ClassNotFoundException {
        String sql = "DELETE FROM to_do_list WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();

        }
    }

    public List<ToDoIthem> getToDoItem() throws SQLException, IOException, ClassNotFoundException {
        String sql = "SELECT id, description, deadline, done FRO to_do_item";

        List<ToDoIthem> toDoIthems = new ArrayList<>();

        try (Connection connection = DatabaseConfiguration.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                ToDoIthem toDoIthem = new ToDoIthem();

                toDoIthem.setId(resultSet.getLong("id"));
                toDoIthem.setDescription(resultSet.getString("description"));
                toDoIthem.setDeadline(resultSet.getDate("deadline").toLocalDate());
                toDoIthem.setDone(resultSet.getBoolean("done"));

                toDoIthems.add(toDoIthem);
            }

        }
        return toDoIthems;
    }
}