package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class greedy_1946 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++){
			int t = Integer.parseInt(br.readLine());
			int arr[][]= new int[t][2];
			int count = 0;
			for(int j=0;j<t;j++){
				String s = br.readLine();
				StringTokenizer st = new StringTokenizer(s," ");
				arr[j][0] = Integer.parseInt(st.nextToken());
				arr[j][1] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr, (a, b)->Integer.compare(a[1], b[1]));
			Arrays.sort(arr, (a, b)->Integer.compare(a[0], b[0]));
			
			
			int min1 = arr[0][0];
			int min2 = arr[0][1];
			for(int j=0;j<t;j++){
				if(arr[j][0]>min1&&arr[j][1]>min2){
					continue;
				}else{
					if(arr[j][0]<min1){
						min1 = arr[j][0];
					}else{
						min2 = arr[j][1];
					}
					count++;
				}
			}
			System.out.println(count);
		}
		
	}

}
