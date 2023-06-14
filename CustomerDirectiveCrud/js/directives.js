angular.module('myDirectives', [])
  .directive('myDirective', function() {
    return {
      restrict: 'E',
      templateUrl:'my-form.html',
    };
  })
  .directive('myOtherDirective', function() {
    return {
      restrict: 'E',
     // template: '<div>This is my other directive</div>',
      templateUrl:'my-table.html'
      
    };
  });
