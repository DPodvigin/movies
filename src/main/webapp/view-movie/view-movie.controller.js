angular.module('viewMovie')
	   .controller('ViewMovieController', function($scope, $http, $location, data) {
			$scope.init = function() {
				$http.get('/movies/findById/' + data.get())
					 .then(function success(response) {
						 $scope.movie = response.data;
					 }, function error(response) {
						 console.log(response);
					 });
			}
			
			$scope.listMovies = function() {
				$location.path('/');
			}
			
			$scope.addComment = function() {
				var commentMovie = {
						movieId: $scope.movie.id,
						comment: $scope.comment
				}
				$http.post('/movies/comment/add', commentMovie)
					 .then(function success(response) {
						 $scope.init();
					 });
			}
	   });
		