package baekjoon;

import java.util.Scanner;
//실패(런타임에러)
public class array_2798 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int N = input.nextInt();
		int M = input.nextInt();
		int sum = 0;
		int diff = M;
		int result = 0;
		
		int arr[] = new int[N];
		
		for(int i=0; i<N; i++){
			arr[i]= input.nextInt();
		}
		
		for(int i=0;i<N-2;i++){
			for(int j=i+1;j<N-1;j++){
				for(int k=j+1;k<N;k++){
					sum = arr[i]+arr[j]+arr[k];
					diff = M - sum;
					if(diff>=0 && sum> result){
						result = sum;
					}
				}
			}
		}
		System.out.println(result);
		
	}

}
