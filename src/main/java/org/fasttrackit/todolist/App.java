package org.fasttrackit.todolist;

import org.fasttrackit.todolist.domain.ToDoIthem;
import org.fasttrackit.todolist.persistance.ToDoIthemRepository;
import org.fasttrackit.todolist.transfer.CreateToDoIthemRequest;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;


public class App {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        CreateToDoIthemRequest request = new CreateToDoIthemRequest();
        request.setDescription("Learn JDBC");
        request.setDeadline(LocalDate.now().plusWeeks(1));

        ToDoIthemRepository toDoIthemRepository = new ToDoIthemRepository();
        toDoIthemRepository.creatToDoIthem(request);

//        toDoIthemRepository.updateToDoItem(1, true);
//        toDoIthemRepository.deleteToDoItem(1);
//
//        toDoIthemRepository.getToDoItem();
    }


}
