package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class greedy_1120 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s," ");
		
		String a = st.nextToken();
		String b = st.nextToken();
		
		int d = b.length() - a.length();
		int arr[] = new int[d+1];
		for(int i=0;i<=d;i++){
			for(int j=0;j<a.length();j++){
				if(a.charAt(j)==b.charAt(j+i)){
					arr[i] += 1;
				}
			}
		}
		Arrays.sort(arr);
		System.out.println(b.length()-arr[d]-d);
		
	}

}
