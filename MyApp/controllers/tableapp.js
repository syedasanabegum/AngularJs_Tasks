app.controller('EmployeeController', function($scope, $http) {
  $scope.selectedEmployee = null;
  $scope.employees = [];
  $scope.showForm = false;

  // Fetch employee data from API
  $http.get('https://hub.dummyapis.com/employee?noofRecords=10&idStarts=1001')
    .then(function(response) {
      $scope.employees = response.data;
    })
    .catch(function(error) {
      console.log('Error fetching employees:', error);
    });

  // Add a new employee record
  $scope.addEmployee = function(employee) {
   $scope.employees.push(angular.copy(employee));
   $scope.showForm = true;
    $scope.resetForm();
  };

  // Edit an employee record
  $scope.editEmployee = function(employee) {
    $scope.selectedEmployee = angular.copy(employee);
    //$scope.showForm = true;
  };
  
  
  // Delete an employee record
  $scope.deleteEmployee = function(employee) {
    var index = $scope.employees.indexOf(employee);
    if (index !== -1) {
      $scope.employees.splice(index, 1);
    }
  };

  // Save changes to an employee record
  $scope.saveEmployee = function(employee) {
    if (employee && employee.id) {
      if (employee.id) {
        // Existing employee, update record
        var index = $scope.employees.findIndex(function(emp) {
          return emp.id === employee.id;
        });
        if (index !== -1) {
          $scope.employees[index] = angular.copy(employee);
        }
      } else {
        // New employee, add record
        $scope.addEmployee(employee);
        console.log('working');
      }
    }
  
    $scope.resetForm();
  };
  

  

  // Reset the form
  $scope.resetForm = function() {
    $scope.selectedEmployee = null;
    $scope.showForm = false;
  };
});

app.directive('myTable', function() {
  return {
    restrict: 'E',
    scope: {
      employees: '=',
      onEdit: '&',
      onDelete: '&'
    },
    controller: 'TableController',
    templateUrl: './views/table.html'
  };
});

app.directive('myForm', function() {
  return {
    restrict: 'E',
    scope: {
      employee: '=',
      onSave: '&',
      onHide: '&'
    },
    controller: 'FormController',
    templateUrl: './views/form.html'
  };
});

app.controller('TableController', function($scope, $http) {


  $scope.editEmployee = function(employee) {
    $scope.onEdit({ employee: employee });
  };

  $scope.deleteEmployee = function(employee) {
    $scope.onDelete({ employee: employee });
  };
  

});

app.controller('FormController', function($scope) {
  $scope.saveEmployee = function() {
    if ($scope.myForm.$valid) {
    $scope.onSave({ employee: $scope.employee });
    $scope.onHide();
  }
    
  };
});


app.controller('ContactController', function($scope)
{
  $scope.showMessage = false;

  $scope.toggleMessage = function() {
    $scope.showMessage = !$scope.showMessage;
  };
  console.log('working')
	var uid = 1010;
    $scope.newcontact = {};
    $scope.contacts = [ ];
    $scope.saveContact = function() { 
      if ($scope.myForm.$valid) {    
        if($scope.newcontact.id == null) {
             $scope.newcontact.id = uid++;
             $scope.contacts.push($scope.newcontact);
        } else {            
             for(i in $scope.contacts) {
                    if($scope.contacts[i].id == $scope.newcontact.id) {
                        $scope.contacts[i] = $scope.newcontact;
                    }
             }                
        }
        $scope.newcontact = {};
      }
      $scope.showMessage = false;
    }
    
    $scope.delete = function(id) {
        for(i in $scope.contacts) {
            if($scope.contacts[i].id == id) {
                $scope.contacts.splice(i,1);
                $scope.newcontact = {};
            }
        }        
    }
        
    $scope.edit = function(id) {
      $scope.showMessage = true;
        for(i in $scope.contacts) {
            if($scope.contacts[i].id == id) {
                $scope.newcontact = angular.copy($scope.contacts[i]);
            }
        }
    }
    });


