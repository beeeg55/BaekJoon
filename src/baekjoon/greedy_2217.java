package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class greedy_2217 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		
		int l = Integer.parseInt(st.nextToken());
		int arr[] = new int[l];
		for(int i=0;i<l;i++){
			st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		int max = arr[l-1];
		for(int i=0;i<l-1;i++){
			if(arr[i]*(l-i)>=max){
				max=arr[i]*(l-i);
			}
		}
		System.out.println(max);
	}

}
