export default function controller($scope, $http) {

    this.submit = ($event, $form) => {
        $event.preventDefault();

        const post = $http.post('/contact', $form);

        post.then(response => {

            // console.log($event);
            console.log($form);

            if(response.data.valid) {
                $scope.$$childHead.$form = {};
                console.log($scope);
            }
        });
    };

    this.showMessage = $event => {
        //
    };

    this.hideMessage = $event => {
        //
    };
}

export function submit(event) {
    event.preventDefault();

    const $form = $(event.target);
    console.log($(this));
    console.log($form);

    $.post('/contact', $form.serialize(), response => {
        const $submitMessage = $('#contact-submit-message');
        $submitMessage.html(`<p>${response.message} Click to dismiss.</p>`);
        $submitMessage.slideDown();

        if(response.valid) {
            $form[0].reset();
        }
    });
}

export function dismissMessage(event) {
    $('#contact-submit-message').slideUp();
}
