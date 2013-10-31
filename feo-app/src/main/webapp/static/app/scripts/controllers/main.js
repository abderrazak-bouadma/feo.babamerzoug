'use strict';

angular.module('staticApp')
  .controller('MainCtrl', function ($scope) {
        $scope.title = "This is main view";
  }).controller('UserCtrl', function ($scope) {
        $scope.mainTitle = 'User Manager';
    });

