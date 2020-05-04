package bf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bf_1417 {
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n-1];
		int t = Integer.parseInt(br.readLine());
		for(int i=0;i<n-1;i++){
			arr[i] = Integer.parseInt(br.readLine());
		}
		if(n==1){
			System.out.println(0);
		}else{
			int count = 0;
			while(true){
				Arrays.sort(arr);
				if(arr[n-2]>=t){
					arr[n-2]--;
					t++;
					count++;
				}else{
					break;
				}
				
			}
			System.out.println(count);
		}
		
	}
}
