app.config(function($routeProvider) {
    $routeProvider
      .when('/login', {
        templateUrl: './views/login.html',
        controller: 'LoginController'
      })
      .when('/home',{
        templateUrl:'./views/home.html',
        controller:'HomeController',
        requiresAuth: true
      })
      .when('/profile', {
        templateUrl:'./views/profile.html',
        controller:'ProfileController',
        requiresAuth: true
      })
      .when('/modal',{
        templateUrl:'./views/Modal.html',
        requiresAuth:false
      })
      .when('/table',{
        templateUrl:'./views/tableAPI.html',
        controller:'EmployeeController',
        requiresAuth: false
      })
      .when('/dataTable',{
        templateUrl:'./views/dataTable.html',
        
        requiresAuth:false
      })
      .when('/logout',{
        templateUrl:'./views/logout.html',
        controller:'LogoutController',
        requiresAuth: true
      })
      .otherwise({
        redirectTo: '/login'
      });
  });

  app.run(function($rootScope, $location) {
    $rootScope.$on('$routeChangeStart', function(event, next, current) {
      if (next.requiresAuth && !$rootScope.isAuthenticated) {
        // User is not authenticated, redirect to the login page
        event.preventDefault();
        $location.path('/login');
      }
    });
  });
