import java.util.ArrayList;
import java.util.Stack;

import AkPackage.InputOutput;

public class InfixToPostfix {
    public static void main(String[] args) {
        ArrayList<String> lines = InputOutput.takeCompleteInput(new InfixToPostfix());
        while (!lines.isEmpty()) {
            String infix = lines.remove(0);
            System.out.println("For input: " + infix);
            System.out.println("Output is: " + getResult(infix));
        }
    }

    public static String getResult(String infix) {
        Stack<Character> operatorStack = new Stack<Character>();
        StringBuilder postfix = new StringBuilder();
        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);
            if (!checkOperator(ch))
                postfix.append(ch);
            else {
                if (operatorStack.empty()) {
                    operatorStack.push(ch);
                } else {
                    if (operatorStack.peek() == '(') {
                        operatorStack.push(ch);
                        continue;
                    }
                    if (ch == ')') {
                        while (operatorStack.peek() != '(') {
                            char x = operatorStack.pop();
                            postfix.append(x == '(' || x == ')' ? '\0' : x);
                        }
                        operatorStack.pop();
                        continue;
                    }
                    while (!operatorStack.empty() && getPresedence(operatorStack.peek()) >= getPresedence(ch)
                            && operatorStack.peek() != '(') {
                        char x = operatorStack.pop();
                        postfix.append(x == '(' || x == ')' ? '\0' : x);
                    }
                    operatorStack.push(ch);
                }
            }
        }
        while (!operatorStack.empty()) {
            char x = operatorStack.pop();
            postfix.append(x == '(' || x == ')' ? '\0' : x);
        }
        System.out.println("Null character is:"+ Character.MIN_VALUE + "A");
        return postfix.toString();
    }

    public static int getPresedence(char ch) {
        switch (ch) {
            case '+':
                return 1;
            case '-':
                return 1;
            case '^':
                return 3;
            case '/':
                return 2;
            case '*':
                return 2;
            case '(':
                return 4;
            case ')':
                return -1;
            default:
                break;
        }
        return 0;
    }

    public static boolean checkOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '%' || ch == '^' || ch == '(' || ch == ')';
    }
}
