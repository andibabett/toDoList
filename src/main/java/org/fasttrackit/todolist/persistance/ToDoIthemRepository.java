package org.fasttrackit.todolist.persistance;

import org.fasttrackit.todolist.transfer.CreateToDoIthemRequest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ToDoIthemRepository {

    public void creatToDoIthem(CreateToDoIthemRequest request) throws IOException, ClassNotFoundException, SQLException {
        String sql = "INSERT INTO to_do_list (description, deadline) VALUES (?, ?)";

    //try with recources
        try (Connection connection = DatabaseConfiguration.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql))    {

            preparedStatement.setString(1, request.getDescription());
            preparedStatement.setDate(2, Date.valueOf(request.getDeadline()));

            preparedStatement.executeUpdate();

        }


    }
}
