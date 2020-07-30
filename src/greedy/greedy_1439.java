package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class greedy_1439 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		//��� 0���� ��ȯ
		int answer0 = 0;
		for(int i=0;i<s.length()-1;i++){
			if(s.substring(i, i+2).equals("10")){
				answer0++;
			}
		}
		if(s.charAt(s.length()-1)=='1'){
			answer0++;
		}
		//��� 1�� ��ȯ
		int answer1 = 0;
		for(int i=0;i<s.length()-1;i++){
			if(s.substring(i, i+2).equals("01")){
				answer1++;
			}
		}
		if(s.charAt(s.length()-1)=='0'){
			answer1++;
		}
		
		if(answer0<=answer1){
			System.out.println(answer0);
		}else{
			System.out.println(answer1);
		}
		
		
	}

}
