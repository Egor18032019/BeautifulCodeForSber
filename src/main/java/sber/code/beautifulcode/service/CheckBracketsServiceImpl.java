package sber.code.beautifulcode.service;

import org.springframework.stereotype.Service;

import java.util.Stack;

/**
 * Сервис реализующий логику проверки скобок
 */
@Service
public class CheckBracketsServiceImpl implements CheckBracketsService {
    /**
     * @param input строка из запроса
     * @return возвращает валидности скобок в тексте
     */
    @Override
    public boolean checkTextOnBrackets(String input) {
        return checkOpenCloseBrackets(input);
    }

    /**
     * Метод проверки соответствия открытости и закрытости скобок и проверки текста между скобок
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
                    boolean isHaveText = checkTextBetweenBrackets(text, i);
                    if (!isHaveText) {
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

    /**
     * Метод проверки наличия текста между скобок
     *
     * @param text строка из запроса
     * @return возвращает валидности скобок в тексте
     */
    boolean checkTextBetweenBrackets(String text, int iterator) {
        var next = 'i';
        do {
            iterator++;
            next = text.charAt(iterator);
        }
        while (text.charAt(iterator) == ' ');
        return next != ')' && next != ']' && next != '}';
    }
}

