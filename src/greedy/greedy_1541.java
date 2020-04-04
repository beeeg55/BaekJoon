package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class greedy_1541 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		boolean m = false;
		int sum = 0;
		int minus = 0;
		StringBuilder sb = new StringBuilder(); 
		for(int i = 0;i<s.length();i++){
			if(m==false){
				if(s.charAt(i)=='-'){
					m=true;
					sum += Integer.parseInt(sb.toString());
					sb = new StringBuilder(); 
				}else if(s.charAt(i)=='+'){
					sum += Integer.parseInt(sb.toString());
					sb = new StringBuilder(); 
				}else{
					sb.append(s.charAt(i));
					if(i==s.length()-1){
						sum += Integer.parseInt(sb.toString());
					}
				}
			}else{
				if(s.charAt(i)=='+'){
					minus += Integer.parseInt(sb.toString());
					sb = new StringBuilder(); 
				}else if(s.charAt(i)=='-'){
					minus += Integer.parseInt(sb.toString());
					sum -= minus;
					minus = 0;
					sb = new StringBuilder(); 
				}else{
					sb.append(s.charAt(i));
					if(i==s.length()-1){
						minus += Integer.parseInt(sb.toString());
						sum -= minus;
					}
				}
			}
		}
		System.out.println(sum);
	}

}
