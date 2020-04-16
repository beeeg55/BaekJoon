package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class dp_1003 {

	static int[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++){
			int num = Integer.parseInt(br.readLine());
			arr = new int[num+1][2];
			  if(num==0) {
	                System.out.println("1 0");
	                continue;
	          }
	            // 1ÀÏ¶§
	          if(num==1){
	              System.out.println("0 1");
	              continue;
	          }
	          arr[0][0] = 1;
	          arr[1][1] = 1;
			for(int j=2; j<=num; j++){
	            arr[j][0] = arr[j-1][0]+arr[j-2][0];
	            arr[j][1] = arr[j-1][1]+arr[j-2][1];
	        	
			}
			System.out.println(arr[num][0]+" "+arr[num][1]);
		}
	}
	

}
