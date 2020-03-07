package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class stack_9012 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		/* 방법1
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		for(int i=0;i<num;i++){
			int ch = 0;
			boolean che = true;
			String s = br.readLine();
			for(int j=0;j<s.length();j++){
				if(s.charAt(j)=='('){
					ch++;
				}
				else{
					ch--;
				}
				if(ch<0){
					che = false;
				}
			}
			if(ch==0&&che==true){
				System.out.println("YES");
			}
			else{
				System.out.println("NO");
			}
		}
		*/
		//스택을 이용한 방법
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		for(int i=0;i<num;i++){
			Stack<Character> stack = new Stack<Character>();
			String s = br.readLine();
			boolean che = true;
			for(int j=0;j<s.length();j++){
				if(s.charAt(j)=='('){
					stack.push(s.charAt(j));
				}
				else{
					if(stack.empty()==true){
						che=false;
					}
					else stack.pop();
				}
			}
			if(stack.empty()==true&&che==true){
				System.out.println("YES");
			}
			else{
				System.out.println("NO");
			}
		}
		
	}

}
