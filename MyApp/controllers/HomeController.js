app.controller('HomeController', function($scope, $location, $rootScope) {
     $scope.name = 'kminchelle' //$scope.users[0].username;
    // $scope.username = $rootScope.users[0].username;
    $scope.task = function() {    
        $location.path('/table')
    }
    $scope.profile = function() {    
        $location.path('/profile')
    }
    $scope.logout = function(){
        $location.path('/logout')
    }
})