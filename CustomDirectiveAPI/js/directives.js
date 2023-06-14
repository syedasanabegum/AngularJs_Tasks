angular.module('myDirectives', [])
  .directive('myForm', function() {
    return {
      restrict: 'E',
      templateUrl:'my-form.html',
    };
  })
  .directive('myTable', function() {
    return {
      restrict: 'E',
     // template: '<div>This is my other directive</div>',
      templateUrl:'my-table.html'
      
    };
  });
