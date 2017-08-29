//DoublyLinkedList object declare
var obj;

/**
 * Node function containing node data and node next
 * @param {*} data - input data
 */
function Node(data) {
    this.data = data;
    this.next = null;
    this.previous = null;
}

/**
 * DoublyLinkedList function containing head node and length of list
 */
function DoublyLinkedList() {
    this.head = null;
    this.length = 0;
}

/**
 * add function insert the element into the linked list at the end
 * @param {*} data - input data
 */
DoublyLinkedList.prototype.add = function (data) {
    var newNode = new Node(data);
    var start = this.head;
    if (!start) {
        newNode.next = this.head;
        this.head = newNode;
        this.length++;
    } else {
        while (start.next) {
            start = start.next;
        }
        start.next = newNode;
        newNode.previous = start;
        this.length++;
    }
}

/**
 * add the element into linked list according to the position given
 * @param {*} data - input data
 * @param {*} pos - positon at which data inserted
 * @return msg - message according to conditions
 */
DoublyLinkedList.prototype.addAtPosition = function (data, position) {
    var start = this.head;
    var newNode = new Node(data);
    var count = 1;
    var maxLength = this.length + 1;
    var msg = "";
    if (position > maxLength || position < 1) {
        msg = "Invalid Position";
    }
    else if (position == 1) {
        newNode.next = this.head;
        this.head = newNode;
        this.length++;
        msg = "Added Successfully at position 1";
    } else {
        while (count != position - 1) {
            start = start.next;
            count++;
        }
        newNode.next = start.next;
        newNode.previous = start;
        start.next = newNode;
        this.length++;
        msg = "Added at position " + (count + 1);
    }

    return msg;
}

/**
 * display the linked list
 * @return result - containing either empty or Linked List
 */
DoublyLinkedList.prototype.display = function () {
    var start = this.head;
    var result = "Start<-->";
    if (start === null) {
        result = "Empty";
    }
    else {
        while (start != null) {
            result += start.data + "<-->";
            start = start.next;
        }
        result+= "end";
    }

    return  result;
}

/**
 * Remove element from linked list by its value
 * @param {*} data - input data
 * @return msg - message 
 */
DoublyLinkedList.prototype.removeByValue = function (data) {
    var start = this.head;
    var msg;
    var flag = false;
    if (start === null) {
        msg = "Empty Linked List";
    }
    else if (start.data === data) {
        this.head = this.head.next;
        this.head.previous = null;
        this.length--;
        msg = data + " removed";
    }
    else {
        while (start != null) {
            if (start.data === data) {
                start.previous.next = start.next;
                if (start.next != null) {
                    start.next.previous = start.previous;
                }
                this.length--;
                msg = data + " removed";
                flag = true;
            }
            start = start.next;
        }
    }
    if (flag === false) {
        msg = "No such data exist";
    }

    return msg;
}

/**
 * Remove element from linked list by its position
 * @param {*} position - position of element
 * @return msg - message
 */
DoublyLinkedList.prototype.removeByPosition = function (position) {
    var start = this.head;
    var maxLength = this.length;
    var count = 1;
    var msg;
    if (position > maxLength || position < 1) {
        msg = "Invalid Position";
    }
    else if (start === null) {
        msg = "Empty Linked List";
    }
    else if (position == 1) {
        this.head = this.head.next;
        if (this.head != null) {
            this.head.previous = null;
        }
        this.length--;
        msg = start.data + " removed";
    }
    else {
        while (count != position) {
            start = start.next;
            count++;
        }
        start.previous.next = start.next;
        if (start.next != null) {
            start.next.previous = start.previous;
        }
        this.length--;
        msg = start.data + " Removed";
    }

    return msg;
}

/**
 * Search data in Linked List
 * @param {*} data - input data
 * @return msg - message
 */
DoublyLinkedList.prototype.searchData = function (data) {
    var start = this.head;
    var count = 1;
    if (start === null) {
        msg = "Empty Linked List";
    }
    while (start != null) {
        if (start.data === data) {
            break;
        }
        start = start.next;
        count++;
    }
    if (count <= length) {
        msg = data + " found at " + count;
    } else {
        msg = "No such data exist";
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

/*
 * Remove data from linked List by Position
 */
function removeDataByPosition() {
    var inputObj = document.getElementById("inputValue");
    var value = inputObj.value.trim();
    var msg = document.getElementById("messageDiv");
    var flag = checkInput(value);
    if (flag === true) {
        displayMessage(obj.removeByPosition(value));
        displayLinkedList();
    } else {
        displayMessage("Enter Value");
    }
    clearInputField(inputObj);
}

/**
 * Remove data by value
 */
function removeDataByValue() {
    var inputObj = document.getElementById("inputValue");
    var value = inputObj.value.trim();
    var flag = checkInput(value);
    if (flag === true) {
        displayMessage(obj.removeByPosition(value));
        displayLinkedList();
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
    obj = new DoublyLinkedList();
    document.getElementById("displayLinkedList").innerHTML = obj.display();
    displayMessage("Linked List Removed");
}

window.onload = function () {
    document.getElementById("add").addEventListener("click", addElement);
    document.getElementById("removeAll").addEventListener("click", deleteLinkedList);
    document.getElementById("search").addEventListener("click", search);
    document.getElementById("removeByPosition").addEventListener("click", removeDataByPosition);
    document.getElementById("removeByValue").addEventListener("click", removeDataByValue);
    document.getElementById("addAtPosition").addEventListener("click", addValueByPosition);
    obj = new DoublyLinkedList();
}
