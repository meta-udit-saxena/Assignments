'use strict';

/**
 * Helps to add two numbers when the sum method of any of the 
 * following syntax is invoked.
 * 
 * @param {*} firstOperand 
 */
function sum(firstOperand) {
  // When sum(firstOperand, secondOperand) is invoked.
  if (arguments.length === 2) {
    console.log(arguments[0] + arguments[1]);
  }
  // When sum(firstOperand)(secondOperand) is invoked.
  else if (arguments.length === 1) {
    return (function (secondOperand) {
      console.log(firstOperand + secondOperand);
    });
  }
  // For other cases. 
  else {
    console.log("Please enter only 2 numbers to add");
  }
}