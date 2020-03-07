package etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class array_3052 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean check[] = new boolean[42];
		Arrays.fill(check, false);
		int cnt = 0;
		for(int i=0;i<10;i++){
			int j = Integer.parseInt(br.readLine())%42;
			if(check[j]==false){
				check[j]=true;
				cnt++;
			}
		}
		System.out.println(cnt);
		
	}

}
