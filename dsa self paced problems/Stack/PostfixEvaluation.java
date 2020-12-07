import java.util.ArrayList;
import java.util.Stack;

import AkPackage.InputOutput;

public class PostfixEvaluation {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new PostfixEvaluation());
        while (!lines.isEmpty()) {
            String line = lines.remove(0);
            System.out.println("For input:" + line);
            System.out.println("value is: " + getResult(line));
        }
    }

    public static int getResult(String postfix) {
        Stack<Integer> operandStack = new Stack<Integer>();
        for (int i = 0; i < postfix.length(); i++) {
            Character ch = postfix.charAt(i);
            if (!isOperator(ch))
                operandStack.push(Integer.parseInt(ch.toString()));
            else {
                char operator = ch;
                int a = operandStack.pop(), b = operandStack.pop();
                operandStack.push(evaluate(a, b, operator));
            }
        }
        return operandStack.pop();
    }

    public static int evaluate(int a, int b, char ch) {
        switch (ch) {
            case '+':
                return b + a;
            case '-':
                return b - a;
            case '*':
                return a * b;
            case '/':
                return b / a;
        }
        return -1;
    }

    public static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '%' || ch == '^' || ch == '(' || ch == ')';
    }
}
