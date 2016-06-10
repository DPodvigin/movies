angular.module('listMovies')
	   .controller('ListMoviesController', function($scope, $http, $location, $rootScope, data) {
			$scope.findMovie = function() {
				var searchUrl = $scope.searchBox ? '/movies/findByName/' + $scope.searchBox :
								'/movies/findAll';
				$http.get(searchUrl)
					 .then(function success(response) {
						 $scope.movies = response.data;
					 }, function error(response) {
						 console.log(response);
					 });
			}
			
			$scope.foundMovie = function(movieId) {
				data.set(movieId);
				$location.path('/view')
			}
			
			$scope.addMovie = function() {
				$location.path('addMovie');
			}
			
	   });