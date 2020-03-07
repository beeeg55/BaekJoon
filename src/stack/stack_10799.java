package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class stack_10799 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Stack<Character> stack = new Stack<Character>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		
		for(int i=0;i<s.length();i++){
			stack.push(s.charAt(i));
		}
		int cl= 0;
		int sum = 0;
		boolean r = false;
		while(!stack.empty()){
			if(stack.peek()=='('){
				cl--;
				if(r==false){
					sum = sum + cl;
				}else{
					sum++;
				}
				r=true;
			}
			else{
				cl++;
				r = false;
			}
			stack.pop();
		}
		System.out.println(sum);
	}

}
