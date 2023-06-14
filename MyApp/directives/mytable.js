app.directive('myTable', function() {
    return {
      restrict: 'E',
      scope: {
        employees: '=',
        onEdit: '&',
        onDelete: '&'
      },
      controller: 'TableController',
      templateUrl: '../views/table.html'
    };
  })
 app.controller('TableController', function($scope) {
    $scope.editEmployee = function(employee) {
      $scope.onEdit({ employee: employee });
    };

    $scope.deleteEmployee = function(employee) {
      $scope.onDelete({ employee: employee });
    };
  })