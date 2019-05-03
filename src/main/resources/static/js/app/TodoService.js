'use strict'

angular.module('todo.services', []).factory('TodoService',
		[ "$http", "CONSTANTS", function($http, CONSTANTS) {
			var service = {};
			service.displayTodo = function() {
				var url = CONSTANTS.displayTodo;
				return $http.get(url);
			}
			
			service.clearAll = function() {
				var url = CONSTANTS.clearAll;
				return $http.get(url);
			}
			service.addTodo = function(item) {
				console.log("service item > add > "+item);
				var data={itemName: item,itemStatus: "Pending"};
				return $http.post(CONSTANTS.addTodo, data);
			}
			service.removeTodo = function(item) {
				var data={itemName: item,itemStatus: "Deleted"};
				return $http.post(CONSTANTS.removeTodo, data);
			}
			
			
			return service;
		} ]);