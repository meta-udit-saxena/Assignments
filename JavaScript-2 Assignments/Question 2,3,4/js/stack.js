//Stack object declare
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
 * Satck function containing top node
 */
function Stack() {
    this.top = null;
    this.length = 0;
}

/**
 * Push function insert the element into the Satck
 * @param {*} data - input data
 */
Stack.prototype.push = function (data) {
    var newNode = new Node(data);
    if (!this.top) {
        this.top = newNode;
    } else {
        newNode.next = this.top;
        this.top = newNode;
    }
}

/**
 * Pop function pop the data from the top of the stack
 * @return msg - message
 */
Stack.prototype.pop = function () {
    var msg;
    if (!this.top) {
        msg = "Empty Stack ";
    } else {
        msg = "Data poped --> " + this.top.data;
        this.top = this.top.next;
    }
    return msg;
}

/**
 * Display the stack
 */
Stack.prototype.display = function () {
    var start = this.top;
    var msg = "Top<br>";
    if (!start) {
        msg = "Empty";
    } else {
        while (start != null) {
            msg += start.data + "<br>";
            start = start.next;
        }
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
function displaySatck() {
    document.getElementById("displayStack").innerHTML = obj.display();
}

/**
 * Clear the input field
 * @param {*} input 
 */
function clearInputField(input) {
    input.value = "";
}

/**
 * Push the element to the stack
 */
function pushElement() {
    var inputObj = document.getElementById("inputValue");
    var value = inputObj.value.trim();
    var flag = checkInput(value);
    if (flag === true) {
        obj.push(value);
        document.getElementById("message").innerHTML = "";
        displaySatck();
    } else {
        displayMessage("Enter Value");
    }
    clearInputField(inputObj);
}

/**
 * Pop the element from the stack
 */
function popElement() {
    displayMessage(obj.pop());
    displaySatck();
    clearInputField();
}

window.onload = function () {
    document.getElementById("push").addEventListener("click", pushElement);
    document.getElementById("pop").addEventListener("click", popElement);
    obj = new Stack();
}
