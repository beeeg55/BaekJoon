package error;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class stack_2504_2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		Stack<Character> st = new Stack<Character>();
		int result = 0;
		int temp = 0;
		
		for(int i=0;i<s.length();i++){
			switch(s.charAt(i)){
				case '(':
					st.push('(');
					break;
				case '[':
					st.push('[');
					break;
				case ')':
					if(st.size()==0){
						result = 0;
						break;
					}
					if(st.pop()=='('){
						
					}else{
						result =0;
						break;
					}
				case ']':
					if(st.size()==0){
						result = 0;
						break;
					}
					if(st.pop()=='['){
						
					}else{
						result =0;
						break;
					}
			}
		}
		if(st.size()==0){
			result = 0;
		}
		System.out.println(result);
	}

}
