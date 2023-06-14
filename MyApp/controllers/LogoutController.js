app.controller('LogoutController', function($scope, $location,$rootScope) {
    $scope.logout = function() {
        var confirmLogout = window.confirm("Do you want to logout?");
      
        if (confirmLogout) {
          // Redirect to the login page
          $rootScope.isAuthenticated = false;
          $location.path('/login')
        } else {
          // Go back to the previous page
          $location.path('/home')
        }
      }
})