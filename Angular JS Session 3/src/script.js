
    $(document).ready(function () {
        $("[rel='tooltip']").tooltip();
        $('.thumbnail').click(
            function () {
                $(this).find('.caption').slideDown(250); //.fadeIn(250)
            },
            function () {
                $(this).find('.caption').slideUp(250); //.fadeOut(205)
            }
        );
    });