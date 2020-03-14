package bf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bf_1065 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int s = Integer.parseInt(br.readLine());
		int N = 1;
		int count = 0;
		while(N<=s){
			String num = Integer.toString(N);
			if(num.length()==1){
				count++;
			}
			else{
				boolean han = true;
				int d = Character.getNumericValue(num.charAt(1))-Character.getNumericValue(num.charAt(0));
				for(int i=2;i<num.length();i++){
					if(Character.getNumericValue(num.charAt(i))-Character.getNumericValue(num.charAt(i-1))!=d){
						han = false;
						break;
					}
				}
				if(han==true){
					count++;
				}
			}
			
			N++;
		}
		System.out.println(count);
	}

}
