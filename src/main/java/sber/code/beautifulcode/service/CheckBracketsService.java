package sber.code.beautifulcode.service;

import org.springframework.stereotype.Component;

import java.util.Stack;

@Component
public class CheckBracketsService {
    public boolean checkBrackets(String input) {
        Stack<Character> stack = new Stack<>();
        boolean result = true;
        for (int i = 0; i < input.length(); i++) {
            char bracket = input.charAt(i);
            if (bracket == ')' || bracket == ']' || bracket == '}') {
                if (stack.empty()) {
                    result = false;
                    break;
                }
                if (bracket == ')' && stack.peek() == '(') {
                    stack.pop();
                    continue;
                }
                if (bracket == ']' && stack.peek() == '[') {
                    stack.pop();
                    continue;
                }
                if (bracket == '}' && stack.peek() == '{') {
                    stack.pop();
                    continue;
                }
                result = false;
                break;
            } else {
                if (bracket == '(' || bracket == '[' || bracket == '{') {
                    stack.push(bracket);
                }
            }
        }
        if (!stack.empty()) {
            result = false;
        }
        return result;
    }
}

