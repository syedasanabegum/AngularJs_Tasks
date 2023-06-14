var app = angular.module('myApp', ['ngRoute']);

app.config(function($routeProvider) {
  $routeProvider
    .when('/login', {
      templateUrl: './views/login.html',
      controller: 'LoginController'
    })
    
    .when('/home', {
      templateUrl: './views/home.html',
      controller: 'HomeController'
    })
    .when('/logout',{
      templateUrl:'./views/logout.html',
      controller:'LogoutController'
    })
    .otherwise({
      redirectTo: '/'
    });
});

