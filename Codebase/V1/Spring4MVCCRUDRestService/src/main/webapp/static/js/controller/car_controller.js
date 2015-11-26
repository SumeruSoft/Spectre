'use strict';

App.controller('CarController', ['$scope', 'CarService', function($scope, CarService) {
          var self = this;
          self.car={id:null,carType:'',shortName:'',capacity:'',ratePerKm:''};
          self.cars=[];
              
          self.fetchAll = function(){
              CarService.fetchAll()
                  .then(
      					       function(d) {
      						        self.cars = d;
      					       },
            					function(errResponse){
            						console.error('Error while fetching Cars');
            					}
      			       );
          };
           
          self.create = function(obj){
              CarService.create(obj)
		              .then(
                      self.fetchAll, 
				              function(errResponse){
					               console.error('Error while creating car.');
				              }	
                  );
          };

         self.update = function(obj, id){
              CarService.update(obj, id)
		              .then(
				              self.fetchAll, 
				              function(errResponse){
					               console.error('Error while updating car.');
				              }	
                  );
          };

         self.deleteObject = function(id){
              CarService.deleteObject(id)
		              .then(
				              self.fetchAll, 
				              function(errResponse){
					               console.error('Error while deleting car.');
				              }	
                  );
          };

          self.fetchAll();

          self.submit = function() {
              if(self.car.id==null){
                  console.log('Saving New car', self.car);    
                  self.create(self.car);
              }else{
                  self.update(self.car, self.car.id);
                  console.log('car updated with id ', self.car.id);
              }
              self.reset();
          };
              
          self.edit = function(id){
              console.log('id to be edited', id);
              for(var i = 0; i < self.cars.length; i++){
                  if(self.cars[i].id == id) {
                     self.car = angular.copy(self.cars[i]);
                     break;
                  }
              }
          };
              
          self.remove = function(id){
              console.log('id to be deleted', id);
              for(var i = 0; i < self.cars.length; i++){
                  if(self.cars[i].id == id) {
                     self.reset();
                     break;
                  }
              }
              self.deleteObject(id);
          };

          
          self.reset = function(){  
              self.car={id:null,carType:'',shortName:'',capacity:'',ratePerKm:''};
              $scope.myForm.$setPristine(); //reset Form
          };

      }]);
