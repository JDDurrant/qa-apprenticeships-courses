$(document).ready(function() {

    const $sidebar = $('#sidebar');
    const $sidebarOffset = $sidebar.offset().top;

    function toggleSidebar() {
        if($(this).scrollTop() >= $sidebarOffset) {
            $sidebar.addClass('fixed');
        } else {
            $sidebar.removeClass('fixed');
        }
    }

    const $contactTextarea = $('.contact textarea');

    $('#enlarge').click(function() {
        $contactTextarea.toggleClass('enlarged');
        $(window).scrollTop($contactTextarea.offset().top);
    });

    $contactTextarea.keyup(function() {
        const length = $contactTextarea.val().length;
        
        if(length > 300) {
            $contactTextarea.addClass('enlarged');
            $(window).scrollTop($contactTextarea.offset().top);
        } else {
            $contactTextarea.removeClass('enlarged');
        }
    });

    $(window).scroll(toggleSidebar);
    toggleSidebar();
});