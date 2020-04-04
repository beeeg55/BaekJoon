package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class greedy_1931 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[][]= new int[n][2];
		for(int i=0;i<n;i++){
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s," ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr, (a, b)->Integer.compare(a[0], b[0]));
		Arrays.sort(arr, (a, b)->Integer.compare(a[1], b[1]));
		
		int start = arr[0][0];
		int end = arr[0][1];
		int index = 0;
		int num = 1;
		boolean f = false;
		while(true){
			while(arr[index][0]<end){
				index++;
				if(index==arr.length){
					f = true;
					break;
				}
			}
			if(f==true){
				break;
			}
			start=arr[index][0];
			end=arr[index][1];
			if(start==end){
				if(index==0){
					index++;
					continue;
				}else{
					index++;
					num++;
				}
			}else{
				num++;
			}
			if(index==arr.length) break;
		}
		System.out.println(num);
	}

}
