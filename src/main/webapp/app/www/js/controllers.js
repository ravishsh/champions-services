angular.module('app.controllers', [])

.controller('menuCtrl', function($scope, $state, $ionicLoading, $rootScope) {
	$scope.signOut = function(){
		$ionicLoading.show({
			template: 'Signing Out...'
		});
		firebase.auth().signOut().then(function() {
			$rootScope.user = null;
			$ionicLoading.hide();
			$state.go('login');
		}, function(error) {
			$ionicPopup.alert({
				title: 'Operation failed',
				template: error.message
			});
			$ionicLoading.hide();
		});
	}
})
     
.controller('championshipsCtrl', function($scope,$http,serviceEndPoint) {
	
        $http.get(serviceEndPoint.url + '/event/all')
            .then(function(response){
                    $scope.championships = response.data;
                    $scope.championshiplogopath = "img/BreastStroke.png";
                });
})

.controller('scoresCtrl', function($scope, $http,$stateParams, serviceEndPoint) {
        
        $http.get(serviceEndPoint.url + '/score/all?eventTrackId=' + $stateParams.id)
            .then(function(response){
                    $scope.scores = response.data;
                });
})

.controller('trackCtrl', function($scope, $http,$stateParams, serviceEndPoint) {
        
        $http.get(serviceEndPoint.url + '/eventTrack/all?eventId=' + $stateParams.id)
            .then(function(response){
                    $scope.eventTracks = response.data;
                });
})   
   
.controller('myAccountCtrl', function($scope) {

})

.controller('loginCtrl', function($scope, $state, $ionicLoading, $rootScope, $ionicPopup) {

	$scope.signIn = function (user) {

		if (user && user.email && user.password) {
			$ionicLoading.show({
				template: 'Signing In...'
			});
			firebase.auth().signInWithEmailAndPassword(user.email, user.password)
			.then(function (authData) {
				console.log("Logged in as:" + authData.uid);
				$rootScope.user = authData;
				$ionicLoading.hide();
				$state.go('tabsController.championships');
			}).catch(function (error) {
				$ionicPopup.alert({
					title: 'Authentication failed',
					template: error.message
				});
				$ionicLoading.hide();
			});
		} else {
			$ionicPopup.alert({
				title: 'Error',
				template: "Please enter email and password both"
			});
		}
	};
})
 