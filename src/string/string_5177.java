package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class string_5177 {

	static String Pattern = "().;:";
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int i = 1; i <= TC; i++) {
			String s1 = br.readLine();
			String s2 = br.readLine();
			
			// 1번 조건 해결 
			s1 = s1.toLowerCase();
			s2 = s2.toLowerCase();

			// 2번 조건 해결 
			s1 = s1.replaceAll("\\s+", " ");
			s2 = s2.replaceAll("\\s+", " ");
			
			// 3번 조건 해결 
			s1 = s1.trim();
			s2 = s2.trim();

			// 5번 조건 해결 
			s1 = s1.replace('[','(');
			s1 = s1.replace('{','(');
			s2 = s2.replace('[','(');
			s2 = s2.replace('{','(');
			
			// 6번 조건 해결 
			s1 = s1.replace(']',')');
			s1 = s1.replace('}',')');
			s2 = s2.replace(']',')');
			s2 = s2.replace('}',')');
			
			// 7번 조건 해결 
			s1 = s1.replace(',',';');
			s2 = s2.replace(',',';');
			
			// 특수문자 최소화 후 4번 조건 해결 
			s1 = removePattern(s1);
			s2 = removePattern(s2);
			
			String[] s1Arr = s1.split(" ");
			String[] s2Arr = s2.split(" ");
			
			if(Arrays.deepEquals(s1Arr, s2Arr)) {
				sb.append("Data Set "+i+": equal"+"\n\n");
			}else {
				sb.append("Data Set "+i+": not equal"+"\n\n");
			}
			
		}
		System.out.println(sb.toString());
	}
	public static String removePattern(String s) {
		int index = 0;
		while(index<s.length()) {
			String temp = "" + s.charAt(index);
			if(Pattern.contains(temp)) { //특수문자이면 
				if(index -1 >0 && s.charAt(index - 1 ) == ' ' ) { // 특수문자 왼쪽에 공백이 있을 때 
					s = s.substring(0,index - 1) + s.substring(index, s.length()); // 왼쪽 공백 없애기 
					index--; // 앞 빈칸이 사라지므로 index가 준다. 
				}
				if(index + 1 < s.length() && s.charAt(index+1) == ' ' ) { // 특수문자 오른쪽에 공백이 있을 때 
					s = s.substring(0,index+1) + s.substring(index+2,s.length()); // 오른쪽 공백 없애기 
				}
			}
			index++;
		}
		return s;
	}

}
