'use strict';

App.factory('CarService', ['$http', '$q', function($http, $q){

	return {
		
			fetchAll: function() {
					return $http.get('http://localhost:8080/Spring4MVCCRUDRestService/car/')
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while fetching cars');
										return $q.reject(errResponse);
									}
							);
			},
		    
		    create: function(obj){
					return $http.post('http://localhost:8080/Spring4MVCCRUDRestService/car/', obj)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while creating car');
										return $q.reject(errResponse);
									}
							);
		    },
		    
		    update: function(obj, id){
					return $http.put('http://localhost:8080/Spring4MVCCRUDRestService/car/'+id, obj)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while updating car');
										return $q.reject(errResponse);
									}
							);
			},
		    
			deleteObject: function(id){
					return $http.delete('http://localhost:8080/Spring4MVCCRUDRestService/car/'+id)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while deleting car');
										return $q.reject(errResponse);
									}
							);
			}
		
	};

}]);
