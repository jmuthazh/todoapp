'use strict'

var module = angular.module('todo.controllers', []);
module.controller("TodoController", [ "$scope", "TodoService",
		function($scope, TodoService) {
	
			$scope.item = null;
			$scope.displayTodo = function() {
			TodoService.displayTodo().then(function(value) {
				$scope.itemslist = value.data
				console.log(value.data);
			}, function(reason) {
				console.log("error occured");
			}, function(value) {
				console.log("no callback");
			});
			}
			
			$scope.addTodo = function() {
			TodoService.addTodo($scope.item).then(function() {
				$scope.displayTodo();
				console.log("Add Todo"+$scope.item);
			}, function(reason) {
				console.log("error occured");
			}, function(value) {
				console.log("no callback");
			});
			
			}
			
			$scope.clearAll = function() {
			TodoService.clearAll().then(function(value) {
				$scope.displayTodo();
				console.log("Clear All");
					alert(value.data.message)
					
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});
				
				}
			
			$scope.removeTodo = function(item) {
			TodoService.removeTodo(item).then(function() {
				$scope.displayTodo();
				console.log("remove Todo"+item);
			}, function(reason) {
				console.log("error occured");
			}, function(value) {
				console.log("no callback");
			});
			
			}
		} ]);