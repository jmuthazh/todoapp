package com.workfront.todo.service;

import java.util.List;

import com.workfront.todo.model.Item;


public interface TodoService {
    List<String> displayTodo();
    void addTodo(Item item);
    List<String> removeTodo(Item item);
    String clearAll();
}
