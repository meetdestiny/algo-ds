package a;

import java.util.Stack;

public class Postfix {

	public static void main(String[] args) {
		String postfix[] = {"1", "2" , "3" , "*" ,"+" , "4", "5", "/", "-"  };
		try {
			System.out.println(evalPostfix(postfix));
		} catch (Exception e) {
			System.err.println("Error:" + e.getMessage());
		}

	}

	public static Double evalPostfix(String postfix[]) throws Exception {
		Stack<Double> s = new Stack<Double>();


		for (int i = 0; i < postfix.length; i++) {
			String op = postfix[i];

			if (isOperator(op)) {
				switch (op) {
				case "+": s.push(s.pop() + s.pop());     break;
				case "*": s.push(s.pop() * s.pop());     break;
				case "-": s.push(-s.pop() + s.pop());    break;
				case "/": s.push(1 / s.pop() * s.pop()); break;
				}
			} else {
				s.push(Double.valueOf(postfix[i]));

			}
		}

		if (s.size() == 1) 
			return s.pop();
		else 
			throw new Exception("Invalid expression");

	}

	private static boolean isOperator(String op) {
		return op == "*" || op == "/" || op == "+" || op == "-";
	}
}

