package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class stack_2504 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		Stack<String> st = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			String temp = s.substring(i,i+1);
			if(temp.equals("(")||temp.equals("[")) {
				st.push(temp);
			}else {
				if(st.size()==0) {
					System.out.println(0);
					System.exit(0);
				}
				if(st.peek().equals("(")) {
					if(temp.equals("]")){
						System.out.println(0);
						System.exit(0);
					}
					st.pop();
					st.push("2");
				}else if(st.peek().equals("[")) {
					if(temp.equals(")")){
						System.out.println(0);
						System.exit(0);
					}
					st.pop();
					st.push("3");
				}else {
					int sum = 0;
					while(true) {
						if(st.size()==0) {
							System.out.println(0);
							System.exit(0);
						}
						if(st.peek().equals("(")) {
							if(temp.equals("]")){
								System.out.println(0);
								System.exit(0);
							}
							st.pop();
							st.push(""+(sum*2));
							break;
						}else if(st.peek().equals("[")) {
							if(temp.equals(")")){
								System.out.println(0);
								System.exit(0);
							}
							st.pop();
							st.push(""+(sum*3));
							break;
						}
						sum += Integer.parseInt(st.pop());
					}
				}
			}
		}
		int answer = 0;
		while(!st.empty()) {
			if(st.peek().equals("(")||st.peek().equals("[")) {
				System.out.println(0);
				System.exit(0);
			}
			answer += Integer.parseInt(st.pop());
		}
		System.out.println(answer);
		
	}

}
