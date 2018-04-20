export function generate(name, slug) {
    return ($scope, $http) => {
        $http.get(`/${slug}`).then($response => $scope.data = $response.data);

        $scope.title = name;
        $scope.controller = slug;

        $scope.displayDetails = $event => {
            $event.preventDefault();
            console.log('Clicked');
        }
    }
}