package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class greedy_5585 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int p = Integer.parseInt(br.readLine());
		int ans = 0;
		int n = 1000-p;
		while(n>=500){
			n -= 500;
			ans++;
		}
		while(n>=100){
			n -= 100;
			ans++;
		}
		while(n>=50){
			n -= 50;
			ans++;
		}
		while(n>=10){
			n -= 10;
			ans++;
		}
		while(n>=5){
			n -= 5;
			ans++;
		}
		while(n>0){
			n -= 1;
			ans++;
		}
		System.out.println(ans);
	}

}
