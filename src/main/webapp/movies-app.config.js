angular.module('moviesApp')
	   .config(['$routeProvider', 
	            function config($routeProvider) {
			   		$routeProvider.
				   		when('/', {
				   			controller: 'ListMoviesController',
				   			templateUrl: 'list-movies/list-movies.template.html'
				   		}).
				   		when('/view',  {
				   			controller: 'ViewMovieController',
				   			templateUrl: 'view-movie/view-movie.template.html'
				   		}).
				   		when('/addMovie', {
				   			controller: 'AddMovieController',
				   			templateUrl: 'add-movie/add-movie.template.html'
				   		});
	   			}
	   ]);