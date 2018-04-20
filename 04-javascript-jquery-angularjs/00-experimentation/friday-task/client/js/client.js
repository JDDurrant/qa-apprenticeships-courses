// import * as controller from './modules/controller.js';

const app = angular.module('app', []);

app.controller('main', ['$scope', '$root', ($scope, $root) => {
    $scope.title = 'London';

    // $scope.current = {
    //     name: 'Tower Bridge',
    //     image: '/images/tower-bridge.jpg',
    //     description: 'A bridge that rises to allow the passage of large ships'
    // };
}]);

export function generate(name, slug) {
    return ['$scope', '$root', ($scope, $root, $http) => {
        $http.get(`/${slug}`).then($response => $scope.data = $response.data);

        $scope.title = name;
        $scope.controller = slug;

        $scope.displayDetails = ($item, $event) => {
            $event.preventDefault();
            $root.current = $item;
        }
    }]
}

app.controller('attractions', generate('Attractions', 'attractions'));
app.controller('buildings', generate('Buildings', 'buildings'));
app.controller('cultural-events', generate('Cultural Events', 'cultural-events'));
app.controller('sporting-facilities', generate('Sporting Facilities', 'sporting-facilities'));