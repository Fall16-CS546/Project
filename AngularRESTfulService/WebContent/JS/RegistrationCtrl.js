app.controller("RegistrationCtrl",['$scope', '$http', function($scope, $http) {
	
	$scope.newuserReg = function() {
		
		var newUserObj = {
				name : $scope.rName,
				email : $scope.rEmail,
				phone : $scope.rPhone,
				password : $scope.rPassword
		};	
		console.log(JSON.stringify(newUserObj));

		
		//var res = $http.get('http://localhost:8080/AngularRESTfulService/backend/user/service');
		//var res = $http.post('e');
		var config = {
                headers : {
                    'Content-Type': 'application/json;charset=utf-8;'
                }
            }
		var res = $http.post('http://localhost:8080/AngularRESTfulService/backend/user/service', JSON.stringify(newUserObj));
		res.success(function(data, status, headers, config) {
			console.log("Success");
			console.log(JSON.stringify({data: data}));
			//console.log(data);
		});
		res.error(function(data, status, headers, config) {
			alert( "failure message: " + JSON.stringify({data: data}));
			console.log(JSON.stringify({data: data}));
		});
		/*
		$http({
	        method : "POST",
	        url : "/user/service"
	    }).then(function mySucces(response) {
	    	console.log("Success");
	    }, function myError(response) {
	    	console.log("Failed!");
	    });
	    */
	};
	
}]);
