package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class string_1152 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		int num=0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)==' '&& i!=0){
				num++;
			}
		}
		if(s.charAt(s.length()-1)!=' '){
			num++;
		}
		System.out.println(num);
	}

}
