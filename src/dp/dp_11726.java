package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class dp_11726 {
	static int[] t;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		t = new int[n+1];
		if(n>=1) t[1]=1;
		if(n>=2) t[2]=2;
		for(int i=3;i<n+1;i++){
			t[i]=(t[i-1]+t[i-2])%10007;
		}
		System.out.println(t[n]);
	}

}
