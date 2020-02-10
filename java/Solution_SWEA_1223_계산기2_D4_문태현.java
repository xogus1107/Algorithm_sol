import java.util.Scanner;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			StringBuilder sb = new StringBuilder();

			int len = Integer.parseInt(sc.nextLine());
			String st = sc.nextLine();

			char[] stack = new char[len];
			int top = -1;

			for (int i = 0; i < st.length(); i++) {
				char c = st.charAt(i);

				switch (c) { 
				case '(': 
					stack[++top] = c;
					break;

				case '*':
				case '/':
					while (top >= 0 && (stack[top] == '*' || stack[top] == '/')) {
						sb.append(stack[top--]);
					}
					stack[++top] = c;
					break;

				case '+':
				case '-':
					while (top >= 0 && (stack[top] == '*' || stack[top] == '/' || stack[top] == '+'
							|| stack[top] == '-')) {
						sb.append(stack[top--]);

					}

					stack[++top] = c;
					break;

				case ')':
					while (top >= 0 && stack[top] != '(') {
						sb.append(stack[top--]);
					}
					if (top >= 0 && stack[top] == '(') { 
						top--;
					}
					break;

				default:
					sb.append(st.charAt(i));
					break;
				}
			}
			while (top > -1) {
				sb.append(stack[top--]);
			}

			Stack<Integer> stack = new Stack<Integer>();

			for (int i = 0; i < sb.length(); i++) {

				if (sb.charAt(i) == '*' || sb.charAt(i) == '/' || sb.charAt(i) == '+' || sb.charAt(i) == '-') {
					int b = stack.pop();
					int a = stack.pop();
					int c = 0;

					if (sb.charAt(i) == '*') {
						c = a * b;
					} else if (sb.charAt(i) == '/') {
						c = a / b;
					} else if (sb.charAt(i) == '+') {
						c = a + b;
					} else if (sb.charAt(i) == '-') {
						c = a - b;
					}

					stack.push(c);

				} else {
					stack.push(sb.charAt(i) - 48);
				}
			}

			System.out.println("#" + tc + " " + stack.pop());
		}

	}
}
