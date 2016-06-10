angular.module('addMovie')
       .controller('AddMovieController', function($scope, $location, $http) {
    	   $scope.addMovie = function(isValid) {
    		   if (isValid) {
	    		   $http.post('/movies/add', $scope.movie)
					    .then(function success(response) {
					    	$location.path('/');
					    }
				   );
    		   }
    	   }
       });