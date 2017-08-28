package com.metacube.infixtopostfixnotaion;

import com.metacube.stackimplementation.MyStack;

/**
 * The Class InfixToPostFix covert the infix string to post fix.
 */
public class InfixToPostFix {

	/**
	 * Convert Infix to post fix.
	 *
	 * @param infix
	 *            the infix string
	 * @return the post fix string
	 */
	public String covertInfixToPostFix(String infix) {
		String postFix = null;
		// if input string is not null
		if (infix != null) {
			MyStack<Character> stack = new MyStack<Character>();
			postFix = "";
			for (int index = 0; index < infix.length(); index++) {
				char character = infix.charAt(index);
				// if character is equal to '(' then push to stack
				if (character == '(') {
					stack.push(character);
				}
				// if character is operator (+,-,/,*/^)
				else if (isOperator(character)) {
					// if operator is of same or lower precedence the pop from
					// stack and append with post fix string
					while (stack.getTop() != null
							&& getPrecedence(character) <= getPrecedence(stack
									.peek()) && stack.peek() != '(') {
						postFix += stack.pop();
					}
					// if operator is of higher precedence than stack top
					// operator
					stack.push(character);
				}
				// if character is ')' then pop the element up to next ')'
				// character not found and append to post fix string
				else if (character == ')') {
					while (stack.getTop() != null && stack.peek() != '(') {
						postFix += stack.pop();
					}
					// for '(' character
					stack.pop();
				}
				// if alphabets and integers encounters append with post fix
				else if(character!=' ') {
					postFix += character;
				}
			}
			while (stack.getTop() != null) {
				postFix += stack.pop();
			}
		}

		return postFix;
	}

	/**
	 * Gets the precedence.
	 *
	 * @param ch
	 *            the character
	 * @return the precedence
	 */
	public static int getPrecedence(Character ch) {
		int precedence = 0;
		switch (ch) {
		case '+':
		case '-':
			precedence = 1;
			break;
		case '*':
		case '/':
			precedence = 2;
			break;
		case '^':
			precedence = 3;
			break;
		}
		return precedence;
	}

	/**
	 * Checks if character is operator.
	 *
	 * @param ch
	 *            the character
	 * @return true, if character is operator else false
	 */
	public static boolean isOperator(Character ch) {
		boolean flag = false;
		if (ch == '*' || ch == '/' || ch == '+' || ch == '-' || ch == '^') {
			flag = true;
		}

		return flag;
	}
}
