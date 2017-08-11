//SinglyLinkedList object declare
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
 * SinglyLinkedList function containing head node and length of list
 */
function SinglyLinkedList() {
    this.head = null;
    this.length = 0;
}

/**
 * add function insert the element into the linked list at the end
 * @param {*} data - input data
 */
SinglyLinkedList.prototype.add = function (data) {
    var newNode = new Node(data);
    var start = this.head;
    if (!start) {
        this.head = newNode;
        this.length++;
    } else {
        while (start.next != null) {
            start = start.next;
        }
        start.next = newNode;
        this.length++;
    }
}

/**
 * display the linked list
 * @return result - either containing Linked List or empty
 */
SinglyLinkedList.prototype.display = function () {
    var start = this.head;
    var result = "";
    if (start === null) {
        result = "Empty";
    } else {
        while (start != null) {
            result += start.data + "-->";
            start = start.next;
        }
        result += null;
    }

    return result;
}

/**
 * add the element into linked list according to the position given
 * @param {*} data - input data
 * @param {*} pos - positon at which data inserted
 * @return msg - message according to conditions
 */
SinglyLinkedList.prototype.addAtPosition = function (data, pos) {
    var start = this.head;
    var count = 1;
    var newNode = new Node(data);
    var maxLength = this.length + 1;
    var msg = "";
    if (pos > maxLength || pos < 1) {
        msg = "Invalid Position";
    }
    else if (pos == 1) {
        newNode.next = this.head;
        this.head = newNode;
        this.length++;
        msg = "Added Successfully at position 1";
    }
    else {
        while (count != pos - 1) {
            start = start.next;
            count++;
        }
        newNode.next = start.next;
        start.next = newNode;
        this.length++;
        msg = "Added at position " + (count + 1);
    }

    return msg;
}

/**
 * Return the value/data by its position
 * @param {*} position - position of data
 * @return msg - message 
 */
SinglyLinkedList.prototype.getValueByPosition = function (position) {
    var start = this.head;
    var msg;
    var maxLength = this.length;
    var count = 1;
    if (start === null) {
        msg = "Empty Linked List";
    }
    else if (position > maxLength || position < 1) {
        msg = "Invalid Position";
    }
    else {
        while (count != position) {
            start = start.next;
            count++;
        }
        msg = start.data;
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
function displayLinkedList() {
    document.getElementById("displayLinkedList").innerHTML = obj.display();
}

/**
 * Clear the input field
 * @param {*} input 
 */
function clearInputField(input) {
    input.value = "";
}

/**
 * Get value from prompt and check 
 * @return position - value fetch from prompt
 */
function getPromptData() {
    var position = prompt("Please enter position", "1").trim();
    while (!position.match("^[0-9]+$")) {
        position = prompt("Please enter Correct position", "1").trim();
    }

    return position;
}

/**
 * Add element to the linked list
 */
function addElement() {
    var inputObj = document.getElementById("inputValue");
    var value = inputObj.value.trim();
    var flag = checkInput(value);
    if (flag === true) {
        obj.add(value);
        document.getElementById("message").innerHTML = "";
        displayLinkedList();
    } else {
        displayMessage("Enter Value");
    }
    clearInputField(inputObj);
}

/**
 * Search element in Linked List
 */
function search() {
    var inputObj = document.getElementById("inputValue");
    var value = inputObj.value.trim();
    var flag = checkInput(value);
    if (flag === true) {
        displayMessage(obj.searchData(value));
    } else {
        displayMessage("Enter Value");
    }
    clearInputField(inputObj);

}

/**
 * Get Data by position from linked list
 */
function getDataByPosition() {
    var inputObj = document.getElementById("inputValue");
    var value = inputObj.value.trim();
    var flag = checkInput(value);
    if (flag === true) {
        displayMessage(obj.getValueByPosition(value));
    } else {
        displayMessage("Enter Value");
    }
    clearInputField(inputObj);
}

/**
 * Add data to linked List at given position
 */
function addValueByPosition() {
    var inputObj = document.getElementById("inputValue");
    var value = inputObj.value.trim();
    var flag = checkInput(value);
    if (flag === true) {
        var position = getPromptData();
        displayMessage(obj.addAtPosition(value, position));
        displayLinkedList();
    } else {
        displayMessage("Enter Value");
    }
    clearInputField(inputObj);
}

/**
 * Clear the linked List
 */
function deleteLinkedList() {
    obj = new SinglyLinkedList();
    document.getElementById("displayLinkedList").innerHTML = obj.display();
    displayMessage("Linked List Removed");
}

window.onload = function () {
    document.getElementById("add").addEventListener("click", addElement);
    document.getElementById("removeAll").addEventListener("click", deleteLinkedList);
    document.getElementById("getData").addEventListener("click", getDataByPosition);
    document.getElementById("addAtPosition").addEventListener("click", addValueByPosition);
    obj = new SinglyLinkedList();
}

