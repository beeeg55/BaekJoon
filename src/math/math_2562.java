package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class math_2562 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int index = 0;
		int max = 0;
		int max_index = 0;
		for(int i=0;i<9;i++){
			index++;
			int n = Integer.parseInt(br.readLine());
			if(n>max){
				max = n;
				max_index = index;
			}
		}
		System.out.println(max);
		System.out.println(max_index);
	}

}
