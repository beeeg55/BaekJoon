package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class dp_1463 {
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		arr[1]=0;
		for(int i=2;i<n+1;i++){
			int temp=arr[i-1]+1;
			if(i%2==0){
				if(temp>arr[i/2]+1){
					temp = arr[i/2]+1;
				}
			}
			if(i%3==0){
				if(temp>arr[i/3]+1){
					temp = arr[i/3]+1;
				}
			}
			arr[i]=temp;
		}
		System.out.println(arr[n]);
		
	}

}
