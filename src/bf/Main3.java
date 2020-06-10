package bf;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
class Main3 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		double[] arr = new double[n];
		for(int i=0;i<n;i++){
			arr[i]=Double.parseDouble(br.readLine());
		}
		int div = m/n;
		int d = m%n;
		
		Arrays.sort(arr);
		arr[n-1] = arr[n-1]/(div+1);
		Arrays.sort(arr);
		
		System.out.println(arr[0]);
	}
}