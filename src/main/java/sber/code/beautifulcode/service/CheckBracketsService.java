package sber.code.beautifulcode.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CheckBracketsService {

    public boolean checkBrackets(String input) {
        return checkOpenCloseBrackets(input);
    }

    /**
     * Метод проверки текста между скобок
     *
     * @param text строка из запроса
     * @return возвращает валидности скобок в тексте
     */
    public boolean checkOpenCloseBrackets(String text) {
        Stack<Character> stack = new Stack<>();
        boolean result = true;
        for (int i = 0; i < text.length(); i++) {

            char bracket = text.charAt(i);
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

                    int q = i;
                    var next = 'a';
                    do {
                        q++;
                        next = text.charAt(q);
                    }
                    while (next == ' ');
                    if (next == ')' || next == ']' || next == '}') {
                        result = false;
                        break;
                    }

                    stack.push(bracket);
                }
            }
        }
        if (!stack.empty()) {
            result = false;
        }
        return result;
    }

    boolean checkTextBetweenBrackets(String text, int iterator) {
        var next = 'i';
        do {
            iterator++;
            next = text.charAt(iterator);
        }
        while (next == ' ');
        return next != ')' && next != ']' && next != '}';
    }
}

