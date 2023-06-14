var app = angular.module('myApp', ['ngRoute','ui.grid','ui.grid.pagination']);



app.controller('MainController', function($scope, $location,) {
  $scope.users = {}; // To store user data
});

