package com.workfront.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.workfront.todo.model.Item;
import com.workfront.todo.service.TodoService;
import com.workfront.todo.utils.Constants;

@RequestMapping("/user")
@RestController
public class TodoController {
	@Autowired
	TodoService todoService;

	@RequestMapping(Constants.DISPLAY_TODO)
	public List<String> displayTodo() {
		return todoService.displayTodo();
	}
	
	@RequestMapping(Constants.CLEAR_ALL)
	public String clearAll() {
		return todoService.clearAll();
	}
	
	@RequestMapping(value=Constants.ADD_TODO, method= RequestMethod.POST)
	public void addTodo(@RequestBody Item item) {
		  todoService.addTodo(item);
	}
	
	@RequestMapping(value= Constants.REMOVE_TOOD, method= RequestMethod.POST)
	public List<String> removeTodo(@RequestBody Item item) {
		return todoService.removeTodo(item);
	}
}
