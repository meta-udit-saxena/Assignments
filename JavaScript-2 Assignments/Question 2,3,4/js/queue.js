//Queue object declare
var obj;

/**
 * Node function containing node data and node next
 * @param {*} data - input data
 */
function Node(data) {
    this.data = data;
    this.next = null;
}

/**
 * Queue function containing front node and rear node
 */
function Queue() {
    this.front = null;
    this.rear = null;
}

/**
 * enqueue function insert the element into the Queue
 * @param {*} data - input data
 */
Queue.prototype.enqueue = function (data) {
    var newNode = new Node(data);
    if (this.front === null) {
        this.front = newNode;
        this.rear = newNode;
    } else {
        this.rear.next = newNode;
        this.rear = newNode;
    }
}

/**
 * dequeue function dequeue the first element from Queue
 * @return msg - message
 */
Queue.prototype.dequeue = function () {
    var msg;
    if (this.front === null) {
        msg = "Empty Queue";
    } else {
        msg = "Dequeue data --> " + this.front.data;
        this.front = this.front.next;
    }

    return msg;
}

/**
 * Display the queue
 * return msg - either containig Queue or empty
 */
Queue.prototype.display = function () {
    var start = this.front;
    var msg = "Front";
    if (start === null) {
        msg = "Empty";
    } else {
        while (start != null) {
            msg += "-->" + start.data;
            start = start.next;
        }
        msg += "<--Rear";
    }

    return msg;
}

/**
 * This function check input value is empty or Not
 * @param {*} value - input value
 * @return boolean - true if valid else false
 */
function checkInput(value) {
    var flag = true;
    if (value === "") {
        flag = false
    }

    return flag;
}

/**
 * Display Message
 * @param {*} message - message to display
 */
function displayMessage(message) {
    document.getElementById("message").innerHTML = message;
}

/**
 * Display the Linked List
 */
function displayQueue() {
    document.getElementById("displayQueue").innerHTML = obj.display();
}

/**
 * Clear the input field
 * @param {*} input 
 */
function clearInputField(input) {
    input.value = "";
}

/**
 * Enqueue the data to queue 
 */
function enqueueElement() {
    var inputObj = document.getElementById("inputValue");
    var value = inputObj.value.trim();
    var flag = checkInput(value);
    if (flag === true) {
        obj.enqueue(value);
        document.getElementById("message").innerHTML = "";
        displayQueue();
    } else {
        displayMessage("Enter Value");
    }
    clearInputField(inputObj);
}

/**
 * Dequeue the data from queue
 */
function dequeueElement() {
    displayMessage(obj.dequeue());
    displayQueue();
    clearInputField();
}

window.onload = function () {
    document.getElementById("enqueue").addEventListener("click", enqueueElement);
    document.getElementById("dequeue").addEventListener("click", dequeueElement);
    obj = new Queue();
}

