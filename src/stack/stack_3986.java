package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class stack_3986 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int sum = 0;
		for(int i=0;i<num;i++){
			Stack<Character> stack = new Stack<Character>();
			String word = br.readLine();
			for(int j=0;j<word.length();j++){
				if(stack.empty()){
					stack.push(word.charAt(j));
					continue;
				}
				if(stack.peek()==word.charAt(j)){
					stack.pop();
				}
				else{
					stack.push(word.charAt(j));
				}
			}
			if(stack.empty()){
				sum++;
			}
		}
		System.out.println(sum);
	}

}
