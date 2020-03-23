package error;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class stack_2504 {
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		Stack<Character> st1 = new Stack<Character>();
		int result = 0;
		int temp = 0;
		int temp2 = 0;
		boolean op = false;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=='('||s.charAt(i)=='['){ // 열린괄호 일때 
				op = true;
				st1.push(s.charAt(i));
			}else if(s.charAt(i)==')'){//)일때
				op=false;
				if(st1.size()==0){ // error
					result = 0;
					break;
				}else{
					if(st1.peek()=='('){ // error 확인
						st1.pop();
						if(temp==0){ 
							if(s.charAt(i+1)=='('||s.charAt(i+1)=='['){
								temp *= 2;
								result += temp;
								temp = 0;
							}else{
								temp += 2;
							}
						}else{
							if(i==s.length()-1){
								temp *= 2;
							}else{
								if(s.charAt(i+1)=='('||s.charAt(i+1)=='['){
									temp *= 2;
									result += temp;
									temp = 0;
								}else{
									temp *= 2;
								}
							}
						}
						if(st1.size()==0){
							result += temp;
							temp = 0;
						}
					}else{ // error이면 0
						result = 0;
						break;
					}
				}	
			}
			else{// ]일때
				op=false;
				if(st1.size()==0){
					result = 0;
					break;
				}
				else{
					if(st1.peek()=='['){
						st1.pop();
						if(temp==0){
							if(s.charAt(i+1)=='('||s.charAt(i+1)=='['){
								temp *= 3;
								result += temp;
								temp = 0;
							}else{
								temp += 3;
							}
						}else{
							if(i==s.length()-1){
								temp *= 3;
							}else{
								if(s.charAt(i+1)=='('||s.charAt(i+1)=='['){
									temp *= 3;
									result += temp;
									temp = 0;
								}else{
									temp *= 3;
								}
							}
						}
						if(st1.size()==0){
							result += temp;
							temp = 0;
						}
					}else{
						result = 0;
						break;
					}
				}
			}
		}
		if(st1.size()!=0){
			System.out.println(28);
		}else{
			System.out.println(result);
		}
	}
}
