package org.fasttrackit.todolist;

import org.fasttrackit.todolist.domain.ToDoItem;
import org.fasttrackit.todolist.persistance.ToDoItemRepository;
import org.fasttrackit.todolist.transfer.CreateToDoItemRequest;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;


public class App {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        CreateToDoItemRequest request = new CreateToDoItemRequest();
        request.setDescription("Learn JDBC");
        request.setDeadline(LocalDate.now().plusWeeks(1));

        ToDoItemRepository toDoIthemRepository = new ToDoItemRepository();
        toDoIthemRepository.creatToDoIthem(request);

        toDoIthemRepository.updateToDoItem(1, true);
        toDoIthemRepository.deleteToDoItem(1);

      List<ToDoItem> toDoItems = toDoIthemRepository.getToDoItems();

        System.out.println(toDoItems);
    }


}
