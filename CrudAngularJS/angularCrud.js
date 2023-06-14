var app = angular.module('App',[]);

app.controller('ContactController', function($scope)
{
	var uid = 1;
    $scope.newcontact = {};
    $scope.contacts = [ ];
    $scope.saveContact = function() {     
        if($scope.newcontact.id == null) {
             $scope.newcontact.id = uid++;
             $scope.contacts.push($scope.newcontact);
        } else {            
             for(i in $scope.contacts) {
                    if($scope.contacts[i].id == $scope.newcontact.id) {
                        $scope.contacts[i] = $scope.newcontact;
                    }
             }                
        }
        $scope.newcontact = {};
    }
    
    $scope.delete = function(id) {
        for(i in $scope.contacts) {
            if($scope.contacts[i].id == id) {
                $scope.contacts.splice(i,1);
                $scope.newcontact = {};
            }
        }        
    }
        
    $scope.edit = function(id) {
        for(i in $scope.contacts) {
            if($scope.contacts[i].id == id) {
                $scope.newcontact = angular.copy($scope.contacts[i]);
            }
        }
    }
    });