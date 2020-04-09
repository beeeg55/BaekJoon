package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class string_2908 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s," ");
		String str1 = st.nextToken();
		StringBuilder sb1 = new StringBuilder(str1); // 타입 변환
		sb1.reverse();
		int n1 = Integer.parseInt(sb1.toString());
		
		String str2 = st.nextToken();
		StringBuilder sb2 = new StringBuilder(str2); // 타입 변환
		sb2.reverse();
		int n2 = Integer.parseInt(sb2.toString());
		
		if(n1>n2){
			System.out.println(sb1.toString());
		}else{
			System.out.println(sb2.toString());
		}
	}

}
