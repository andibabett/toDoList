package org.fasttrackit.todolist.service;

import org.fasttrackit.todolist.domain.ToDoItem;
import org.fasttrackit.todolist.persistance.ToDoItemRepository;
import org.fasttrackit.todolist.transfer.CreateToDoItemRequest;
import org.fasttrackit.todolist.transfer.CreateToDoItemRequest;
import org.fasttrackit.todolist.transfer.UpdateToDoItemRequest;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ToDoItemService {

    private ToDoItemRepository toDoItemRepository = new ToDoItemRepository();

    public ToDoItemService() throws SQLException, IOException, ClassNotFoundException {
    }

    public void createToDoItem(CreateToDoItemRequest request) throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Creating to-do-item: " + request);
        toDoItemRepository.creatToDoIthem(request);
    }

    public void updateToDoItem(long id, UpdateToDoItemRequest request) throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Update to-do-item: " + request);
        toDoItemRepository.updateToDoItem(id, request.isDone());
    }
    public void deleteToDoItem(long id) throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Deleting item " + id);
        toDoItemRepository.deleteToDoItem(id);
    }

    public List<ToDoItem> getToDoItems() throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Retrieving to-do-items...");
        return toDoItemRepository.getToDoItems();
    }
}
