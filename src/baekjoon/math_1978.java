package baekjoon;

import java.util.Scanner;

public class math_1978 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int arr[] = new int[n];
		int count =0;
		for(int i=0;i<n;i++){
			arr[i]=in.nextInt();
		}
		for(int i=0;i<n;i++){
			if(arr[i]==2||arr[i]==3){
				count++;
			}
			for(int j=2;j<=(int)arr[i]/2;j++){
				if(arr[i]%j==0){
					break;
				}
				if(j==(int)arr[i]/2){
					count++;
				}
			}
		}
		System.out.println(count);
	}

}
