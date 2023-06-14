
app.controller('LoginController', function($scope, $location) {
    $scope.login = function() {
      
    $location.path('/home');
    };
  });
  
  app.controller('HomeController', function($scope, $location) {    
    $scope.logout = function() {
      $location.path('/logout');
    };
  });

  app.controller('LogoutController', function($scope, $location){
    $scope.rejoin = function(){
      $location.path('/login')
    }
    $scope.home = function(){
      $location.path('/home')
    }
  })
  
  
  
 
  
  
  
  