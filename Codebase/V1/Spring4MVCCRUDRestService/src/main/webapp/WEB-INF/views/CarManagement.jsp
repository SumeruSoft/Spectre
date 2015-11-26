<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>  
    <title>Sumeru Car Rental - Add Car</title>  
    <style>
      .username.ng-valid {
          background-color: lightgreen;
      }
      .username.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .username.ng-dirty.ng-invalid-minlength {
          background-color: yellow;
      }

      .email.ng-valid {
          background-color: lightgreen;
      }
      .email.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .email.ng-dirty.ng-invalid-email {
          background-color: yellow;
      }

    </style>
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
     <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
  </head>
  <body ng-app="myApp" class="ng-cloak">
      <div class="generic-container" ng-controller="CarController as ctrl">   
          <div class="panel panel-default">
              <div class="panel-heading"><span class="lead">Car Registration Form </span></div>
              <div class="formcontainer">
                  <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                      <input type="hidden" ng-model="ctrl.car.id" />
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Car Type</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.car.carType" name="carType" class="username form-control input-sm" placeholder="Enter your Car Type" required ng-minlength="3"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.carType.$error.required">This is a required field</span>
                                      <span ng-show="myForm.carType.$error.minlength">Minimum length required is 3</span>
                                      <span ng-show="myForm.carType.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>
                        
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Short Name</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.car.shortName" name="shortName" class="form-control input-sm" placeholder="Enter Car Short Name." required ng-minlength="3"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.shortName.$error.required">This is a required field</span>
                                      <span ng-show="myForm.shortName.$error.minlength">Minimum length required is 3</span>
                                      <span ng-show="myForm.shortName.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">No. Of Passengers</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.car.capacity" name="capacity" class="form-control input-sm" placeholder="Enter No of passengers." required />
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.capacity.$error.required">This is a required field</span>
                                      <span ng-show="myForm.capacity.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Rate Per Km</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.car.ratePerKm" name="ratePerKm" class="form-control input-sm" placeholder="Enter rate per Km." required />
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.ratePerKm.$error.required">This is a required field</span>
                                      <span ng-show="myForm.ratePerKm.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="form-actions floatRight">
                              <input type="submit"  value="{{!ctrl.user.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
                              <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
                          </div>
                      </div>
                  </form>
              </div>
          </div>
          <div class="panel panel-default">
                <!-- Default panel contents -->
              <div class="panel-heading"><span class="lead">List of Cars </span></div>
              <div class="tablecontainer">
                  <table class="table table-hover">
                      <thead>
                          <tr>  
                              <th>ID.</th>
                              <th>Car Type</th>
                              <th>Short Name</th>
                              <th>Capacity</th>
                              <th>Rate per Km</th>
                              <th width="20%"></th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="u in ctrl.cars">
                              <td><span ng-bind="u.id"></span></td>
                              <td><span ng-bind="u.carType"></span></td>
                              <td><span ng-bind="u.shortName"></span></td>
                              <td><span ng-bind="u.capacity"></span></td>
                              <td><span ng-bind="u.ratePerKm"></span></td>
                              <td>
                              <button type="button" ng-click="ctrl.edit(u.id)" class="btn btn-success custom-width">Edit</button>  <button type="button" ng-click="ctrl.remove(u.id)" class="btn btn-danger custom-width">Remove</button>
                              </td>
                          </tr>
                      </tbody>
                  </table>
              </div>
          </div>
      </div>
      
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
      <script src="<c:url value='/static/js/app.js' />"></script>
      <script src="<c:url value='/static/js/service/car_service.js' />"></script>
      <script src="<c:url value='/static/js/controller/car_controller.js' />"></script>
  </body>
</html>