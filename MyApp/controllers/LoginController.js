//username: 'kminchelle',
//password: '0lelplR',

app.controller('LoginController', function($scope, $http, $location,$rootScope) {
    $scope.signup = function() {
      $rootScope.isAuthenticated = true;
      // Send user data to server
      $http.post('https://dummyjson.com/auth/login',JSON.stringify({
        username: $scope.signupUsername,
        password: $scope.signupPassword
      })).then(function(response) {
        console.log('POST Successfull');
        console.log(response.data);
        
        //saving token in local storage
        var token = response.data.token;
        localStorage.setItem('token', token);

        // Add user data to controller
        $scope.$parent.users = response.data;
         console.log($scope.users);
        
      /* providing token in bearer */
      /*$scope.resource = fetch('https://dummyjson.com/auth/RESOURCE', {
        method: 'GET', 
        headers: {
          'Authorization': `Bearer ${token}`, 
          'Content-Type': 'application/json'
        }, 
      })
      .then(res => res.json())
      .then(console.log);*/
        // Redirect to login page
        $location.path('/home');
      });
    };
  });