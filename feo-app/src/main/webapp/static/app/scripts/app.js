'use strict';

angular.module('staticApp', [
  'ngCookies',
  'ngResource',
  'ngSanitize'
])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl'
      })
        .when('/users', {
            templateUrl: 'views/users.html',
            controller: 'UserCtrl'
        })
      .otherwise({
        redirectTo: '/'
      });
  });
