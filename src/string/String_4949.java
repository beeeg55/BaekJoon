package string;

import java.util.Scanner;
import java.util.Stack;

public class String_4949 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while(true) {
			Stack<Character> stack = new Stack<Character>();
			String s = in.nextLine();
			if(s.equals(".")) {
				break;
			}
			boolean balance = true;
			for (int i = 0; i < s.length(); i++) {
				if(s.charAt(i)=='('||s.charAt(i)=='[') {
					stack.push(s.charAt(i));
				}
				if(s.charAt(i)==')') {
					if(stack.size()==0||stack.peek()=='[') {
						balance = false;
						break;
					}else {
						stack.pop();
					}
				}
				if(s.charAt(i)==']') {
					if(stack.size()==0||stack.peek()=='(') {
						balance = false;
						break;
					}else {
						stack.pop();
					}
				}
			}
			if(balance&&stack.size()==0) {
				sb.append("yes\n");
			}else {
				sb.append("no\n");
			}
		}
		System.out.println(sb.toString());
		
	}

}
