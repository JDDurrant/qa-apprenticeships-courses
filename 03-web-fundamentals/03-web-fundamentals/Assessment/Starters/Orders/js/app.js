const app = angular.module('app', []);

app.controller('Order', function OrderController($scope, $http) {

	// let selected;
	
	this.listOrders = $event => {
		const request = $http.get('/OrdersService.asmx/getOrders');
		request.then($response => $scope.orders = $response.data);
	}

	this.showOrderDetails = ($event, id) => {
		$event.preventDefault();
		const request = $http.get(`/OrdersService.asmx/getOrderDetails?orderId=${id}`);
		request.then($response => $scope.orderDetails = $response.data);

		const $orders = $scope.orders;

		this._deseletOrders($event);

		const $order = $scope.orders.find($order => $order.OrderID == id);
		$order.selected = true;
	}

	this.hideOrderDetails = $event => {
		this._deseletOrders($event);
		$scope.orderDetails = null;
	}

	this._deseletOrders = $event => {
		$scope.orders.forEach($order => $order.selected = false);
	}
});
