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
         
.controller('residentsCtrl', function($scope) {
	
})
      
.controller('visitorCtrl', function($scope, $stateParams, $firebaseObject) {
	$scope.visitor = $firebaseObject(firebase.database().ref('Championships/' + $stateParams.id));
})
   
.controller('residentCtrl', function($scope) {

})
   
.controller('entryCtrl', function($scope, Camera, $stateParams, $firebaseObject) {
	
	var visId = $stateParams.id;
	
	if(visId == 0) {
		$scope.visitor = {};
	}else{
		$scope.visitor = $firebaseObject(firebase.database().ref('visitors/' + $stateParams.id));
	}
	
	$scope.visit = {}
	
	
	$scope.takePicture = function (options) {
	
		var options = {
			quality : 75,
			targetWidth: 200,
			targetHeight: 200,
			sourceType: 1
		};

		Camera.getPicture(options).then(function(imageData) {
			$scope.picture = imageData;;
		}, function(err) {
			console.log(err);
		});
		
	};
	
	$scope.save = function(){
		var newVisitorKey = firebase.database().ref().child('visitors').push().key;
	};
})
   
.controller('myAccountCtrl', function($scope) {

})
   
.controller('newVisitorCtrl', function($scope, $firebaseObject, $state) {
	
	$scope.formData = {};
	
	$scope.search = function(){
		firebase.database().ref('visitors').orderByChild("mobile").equalTo($scope.formData.mobile).limitToLast(1).on('value', function(snapshot){
			var key;
			if(snapshot.exists()){
				snapshot.forEach(function(visitorSnapshot) {
					key = visitorSnapshot.key;
				});
			}else{
				key = 0;
			}
			$state.go('tabsController.entry',{id: key});
		});
		
	}
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
 