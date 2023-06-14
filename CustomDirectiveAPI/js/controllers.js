angular.module('myControllers', [])
  .controller('MyController', function($scope, $http) {
    var apiUrl = 'https://hub.dummyapis.com/employee?noofRecords=10&idStarts=1001';

    $http.get(apiUrl)
      .then(function(response) {
        $scope.employees = response.data;
      });
      $scope.showContainer = false;
      
      $scope.showEditForm = function(employee) {
        $scope.editData = angular.copy(employee);
        $scope.showContainer = true;
      };  
      $scope.hideEditForm = function() {
        $scope.showContainer = false;
      };
    $scope.editEmployee = function(employee) {
      $scope.editData = angular.copy(employee);
    };
    
    $scope.saveEmployee = function() {
      var index = $scope.employees.findIndex(function(employee) {
        return employee.id === $scope.editData.id;
      });
      if (index != -1) {
        $scope.employees[index] = angular.copy($scope.editData);
      }
    };


    $scope.deleteRow = function(employee) {
      var index = $scope.employees.indexOf(employee);
      if (index != -1) {
        $scope.employees.splice(index, 1);
      }
  };
  });
  