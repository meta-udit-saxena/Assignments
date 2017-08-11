/**
 * .Call SingleLnkedList.html
 */
function callSingly() {
    document.getElementById("containerDiv").innerHTML = '<object type="text/html" data="SingleLinkedList.html" width="100%" height="100%" ></object>';
}

/**
 * .Call DoublyLnkedList.html
 */
function callDoubly() {
    document.getElementById("containerDiv").innerHTML = '<object type="text/html" data="DoublyLinkedList.html" width="100%" height="100%"></object>';
}

/**
 * .Call stack.html
 */
function callStack() {
    document.getElementById("containerDiv").innerHTML = '<object type="text/html" data="stack.html" width="100%" height="100%"></object>';
}

/**
 * .Call queue.html
 */
function callQueue() {
    document.getElementById("containerDiv").innerHTML = '<object type="text/html" data="queue.html" width="100%" height="100%"></object>';
}

window.onload = function () {
    document.getElementById("stack").addEventListener("click", callStack);
    document.getElementById("queue").addEventListener("click", callQueue);
    document.getElementById("singly").addEventListener("click", callSingly);
    document.getElementById("doubly").addEventListener("click", callDoubly);
    callSingly();
}