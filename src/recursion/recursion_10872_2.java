package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class recursion_10872_2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = mul(N);
		
		System.out.println(answer);
	}
	static int mul(int n) {
		if(n>1) {
			return n*mul(n-1);
		}else {
			return 1;
		}
	}

}
