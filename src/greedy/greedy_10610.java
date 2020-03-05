package greedy;
//런타임에러
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class greedy_10610 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		long num = Integer.parseInt(s);
		int[] arr=new int[10];
		long total = 0;
		Arrays.fill(arr, 0);
		for(int i=0;i<s.length();i++){
			int temp = Character.getNumericValue(s.charAt(i));
			arr[temp] += 1;
			total += temp;
		}
		if(arr[0]==0||total%3!=0){
			System.out.println("-1");
			return;
		}
		else{
			for(int i=9;i>=0;i--){
				if(arr[i]==0){
					continue;
				}
				for(int j=0;j<arr[i];j++){			
					System.out.print(i);
				}
			}
		}
		
		
	}
}
