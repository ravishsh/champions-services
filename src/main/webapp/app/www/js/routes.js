angular.module('app.routes', [])

.config(function($stateProvider, $urlRouterProvider) {

  // Ionic uses AngularUI Router which uses the concept of states
  // Learn more here: https://github.com/angular-ui/ui-router
  // Set up the various states which the app can be in.
  // Each state's controller can be found in controllers.js
  $stateProvider
  
      .state('tabsController.championships', {
    url: '/championships',
    views: {
      'tab1': {
        templateUrl: 'templates/championships.html',
        controller: 'championshipsCtrl'
      }
    }
  })
  
    .state('tabsController.scores', {
    url: '/scores/:id',
    views: {
      'tab1': {
        templateUrl: 'templates/scores.html',
        controller: 'scoresCtrl'
      }
    }
  })
  
      .state('tabsController.eventtracks', {
    url: '/tracks/:id',
    views: {
      'tab1': {
        templateUrl: 'templates/tracks.html',
        controller: 'trackCtrl'
      }
    }
  })

      .state('tabsController.visitors', {
    url: '/visitors',
    views: {
      'tab1': {
        templateUrl: 'templates/visitors.html',
        controller: 'visitorsCtrl'
      }
    }
  })

  .state('tabsController.residents', {
    url: '/residents',
    views: {
      'tab2': {
        templateUrl: 'templates/residents.html',
        controller: 'residentsCtrl'
      }
    }
  })

  .state('tabsController', {
    url: '/home',
    templateUrl: 'templates/tabsController.html',
    abstract:true
  })

  .state('tabsController.visitor', {
    url: '/visitor/:id',
    views: {
      'tab1': {
        templateUrl: 'templates/visitor.html',
        controller: 'visitorCtrl'
      }
    }
  })

  .state('tabsController.resident', {
    url: '/resident',
    views: {
      'tab2': {
        templateUrl: 'templates/resident.html',
        controller: 'residentCtrl'
      }
    }
  })

  .state('tabsController.entry', {
    url: '/entry/:id',
    views: {
      'tab3': {
        templateUrl: 'templates/entry.html',
        controller: 'entryCtrl'
      }
    }
  })

  .state('myAccount', {
    url: '/myaccount',
    templateUrl: 'templates/myAccount.html',
    controller: 'myAccountCtrl'
  })

  .state('tabsController.newVisitor', {
    url: '/newVisitor',
    views: {
      'tab3': {
        templateUrl: 'templates/newVisitor.html',
        controller: 'newVisitorCtrl'
      }
    }
  })

  .state('login', {
    url: '/login',
    templateUrl: 'templates/login.html',
    controller: 'loginCtrl'
  })

$urlRouterProvider.otherwise('/login')

  

});