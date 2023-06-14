app.controller('ProfileController', function($scope, $location,) {
   $scope.profile = function() {
       
       $location.path('/table')
   }
   
})