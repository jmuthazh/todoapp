package com.workfront.todo.service.impl;


import java.util.List;

import org.springframework.stereotype.Service;

import com.workfront.todo.TodoApp;
import com.workfront.todo.model.Item;
import com.workfront.todo.service.TodoService;

@Service
public class TodoServiceImpl implements TodoService {
	

	@Override
	public List<String> displayTodo() {
		TodoApp app = new TodoApp();
		return app.displayTodo();
	}

	@Override
	public void addTodo(Item item) {
		System.out.println("TodoServiceImpl: addTodo: "+item);
		TodoApp app = new TodoApp();
		app.addTodo(item);
	}

	@Override
	public List<String> removeTodo(Item item) {
		TodoApp app = new TodoApp();
		return app.removeTodo(item);
	}
	
	@Override
	public String clearAll() {
		TodoApp app = new TodoApp();
		return app.clearAll();
	}
}
