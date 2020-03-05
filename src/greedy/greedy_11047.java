package greedy;

import java.util.Scanner;

public class greedy_11047 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int k = in.nextInt();
		int[] coin = new int[10];
		int count=0;
		
		for(int i=0;i<n;i++){
			coin[i] = in.nextInt();
		}
		
		for(int i=n-1;i>=0;i--){
			while(k >= coin[i]){
				k = k-coin[i];
				count++;
			}
			if(k==0) break;
		}
		System.out.println(count);
		in.close();
	}

}
