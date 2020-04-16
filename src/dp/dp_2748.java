package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class dp_2748 {
	
	static long[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new long[n+1];
		System.out.println(fib(n));
	}
	public static long fib(int n){
		if(n==0){
			return 0;
		}
		if(n==1){
			return 1;
		}
		if(arr[n]==0){
			return arr[n]=fib(n-2)+fib(n-1);
		}else{
			return arr[n];
		}
	}
}
