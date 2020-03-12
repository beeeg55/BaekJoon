package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p4344 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++){
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s," ");
			int num = Integer.parseInt(st.nextToken());
			int sum = 0;
			int arr[] = new int[num];
			for(int j=0;j<num;j++){
				arr[j] = Integer.parseInt(st.nextToken());
				sum += arr[j];
			}
			Arrays.sort(arr);
			double count = num;
			int search = 0;
			while(arr[search]<=sum/num){
				count--;
				search++;
			}
			double result = 100*count/num;
			System.out.println(String.format("%.3f", result)+"%");
		}
	}
}
