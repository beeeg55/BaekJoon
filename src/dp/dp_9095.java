package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class dp_9095 {
	static int[] sumN;
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int c = Integer.parseInt(br.readLine());
		for(int i=0;i<c;i++){
			int n = Integer.parseInt(br.readLine());
			sumN = new int[n+1];
			if(n>=1)sumN[1]=1;
			if(n>=2)sumN[2]=2;
			if(n>=3)sumN[3]=4;
			for(int j=4;j<n+1;j++){
				sumN[j]=sumN[j-1]+sumN[j-2]+sumN[j-3];
			}
			System.out.println(sumN[n]);
		}
	}
}
