package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class array_2953 {

	public static void main(String[] args) throws IOException {
		int arr[] = new int[5];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int best = 0;
		for(int i=0;i<5;i++){
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s," ");
			for(int j=0;j<4;j++){
				arr[i] += Integer.parseInt(st.nextToken());
			}
			if(arr[i]>arr[best]){
				best = i;
			}
		}
		System.out.println(best+1+" "+arr[best]);
		
	}

}
