angular.module('listActors')
	   .controller('ListActorsController', function($scope, $http) {
			$scope.findActor = function() {
				var searchUrl = $scope.searchBox ? '/actors/findByName/' + $scope.searchBox :
								'/actors/findAll';
				$http.get(searchUrl)
					 .then(function success(response) {
						 $scope.actors = response.data;
					 }, function error(response) {
						 console.log(response);
					 });
			}
			
			$scope.foundActor = function(movieId) {
				data.set(actorId);
				$location.path('/viewActor')
			}
			
			$scope.addActor = function() {
				$location.path('addActor');
			}
	   });