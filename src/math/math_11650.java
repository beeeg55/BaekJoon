package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//¹Ì¿Ï·á
public class math_11650 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		int arr[][] = new int[5][2];
		
		for(int i=0;i<num;i++){
			String xy = br.readLine();
			StringTokenizer st = new StringTokenizer(xy," ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		for(int i=0;i<num;i++){
			System.out.println(arr[i][0]+" "+ arr[i][1] );
		}
	}

}
