app.controller('datatableController', function($scope, $http) {
    $scope.gridOptions = {
      enableSorting: true,
      enableFiltering: true,
      enablePaginationControls: true,
      paginationPageSize: 5,
      columnDefs: [
        { field: 'id', displayName: 'ID', width: 80 },
        { field: 'firstName', displayName: 'FirstName' },
        { field: 'lastName', displayName: 'lastName' },
        { field: 'email', displayName: 'Email' },
        { field: 'contactNumber', displayName: 'Phone' },
        { field: 'age', displayName: 'Age' },
        { field: 'salary', displayName: 'Salary' },
        { field: 'dob', displayName: 'DOB' },
        { field: 'address', displayName: 'Address' },
        ]
    };

    $http.get('https://hub.dummyapis.com/employee?noofRecords=10&idStarts=1001')
      .then(function(response) {
        $scope.gridOptions.data = response.data;
      })
      .catch(function(error) {
        console.log('Error fetching data:', error);
      });
  });
