app.directive('navigationBar', function() {
    return {
      restrict: 'E',
      template: `
        <nav class="py-2" style="background-color:#da3e56;">
        <a href="#!/login" class="text-decoration-none px-3" style="color:white" >Login</a>
        <a href="#!/home" class="text-decoration-none px-3" style="color:white">Home</a>
        <a href="#!/profile" class="text-decoration-none px-3" style="color:white">Profile</a>
        <a href="#!/table" class="text-decoration-none px-3" style="color:white">Table</a>
        <a href="#!/dataTable" class="text-decoration-none px-3" style="color:white">Datatable</a>    
        <a href="#!/modal" class="text-decoration-none px-3" style="color:white">Modal</a>
        <a href="#!/logout" class="text-decoration-none px-3" style="color:white">Logout</a>    
        </nav>
      `
    };
  });