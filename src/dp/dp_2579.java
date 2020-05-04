package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class dp_2579 {
	static int[] arr;
	static boolean[] cont;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		int[] st = new int[n+1];
		for(int i=1;i<n+1;i++){
			st[i]=Integer.parseInt(br.readLine());
		}
		
	}
	public static int stPoint(int n){
		
		return 1;
	}

}
