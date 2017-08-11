/**
 * Holds execution for 2 minutes and then send the date and time
 * to the calling object.
 */
setTimeout(function () {
        var newDate = new Date();
        postMessage(newDate);
    }, 120000);