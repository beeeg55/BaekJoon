package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class stack_10828 {
	
	static Stack<Integer> st = new Stack<Integer>();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n = br.readLine();
		int num = Integer.parseInt(n);
		
		for(int i=0;i<num;i++){
			String s = br.readLine();
			stackcal(s);
		}
	}

	private static void stackcal(String s) {
		switch(s){
			case "top":
				if(st.empty()==true){
					System.out.println(-1);
				}
				else System.out.println(st.peek());
				break;
			case "size":
				System.out.println(st.size());
				break;
			case "pop":
				if(st.empty()==true){
					System.out.println(-1);
				}
				else{ 
					System.out.println(st.peek());
					st.pop();
				}
				break;
			case "empty":
				if(st.empty()==true){
					System.out.println(1);
				}
				else System.out.println(0);
				break;
			default :
				StringTokenizer stk = new StringTokenizer(s," ");
				String a = stk.nextToken();
				int b = Integer.parseInt(stk.nextToken());
				st.push(b);
				break;
		}
	}
}
