var webWorker = {}; // Global variable declaration.

/**
 * Checks if web worker is compatible with the browser.
 * If the webWorker is of object type it calls the web_worker.js file.
 */
function startWorker() {
    var result = document.getElementById('result');
    if ('undefined' !== typeof(Worker)) {
        if ('object' === typeof(webWorker)) {
            webWorker = new Worker('js/web_worker.js');
        }
        // Gets the value of date and time from web_worker.js file.
        webWorker.onmessage = function(event) {
            result.innerHTML = event.data;
        }
    } else {
        result.innerHTML = 'NOT SUPPORTED';
    }
}

/**
 * Stops the running web worker.
 */
function stopWorker() {
    webWorker.terminate();
    document.getElementById('result').innerHTML = 'Web Worker is stopped.';
};

/**
 * Resets the web worker to use it again.
 */
function checkAgain() {
    document.getElementById('result').innerHTML = 'Your Result Will Appear Here...';
    webWorker = {};
}

/**
 * Display the current date and time.
 * Set up eventListeners when window is loaded.
 */
window.onload = function() {
    document.getElementById('start').addEventListener('click',startWorker);
    document.getElementById('stop').addEventListener('click',stopWorker);
    document.getElementById('checkAgain').addEventListener('click',checkAgain);
    var date = new Date();
    alert(date);
};