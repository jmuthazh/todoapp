'use strict'

var todoApp = angular.module('todo', [ 'ui.bootstrap', 'todo.controllers',
		'todo.services' ]);
todoApp.constant("CONSTANTS", {
	displayTodo : "/user/displayTodo",
	addTodo : "/user/addTodo",
	removeTodo : "/user/removeTodo"
});