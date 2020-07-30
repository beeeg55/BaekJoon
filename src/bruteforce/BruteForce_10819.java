package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BruteForce_10819 {
	static int answer = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s," ");
		
		for(int i=0;i<N;i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		perm(arr,0,arr.length);
		System.out.println(answer);
	}
	public static void perm(int[] arr, int depth, int k) {
		if (depth == k) {
			// �ѹ� depth �� k�� �����ϸ� ����Ŭ�� ������. �����. 
			sum(arr,k);
			return;
		}
		for (int i = depth; i < k; i++) {
			swap(arr, i, depth); 
			perm(arr, depth + 1,k);
			swap(arr, i, depth);
			}
		}
	// �ڹٿ����� �����Ͱ� ���� ������ �Ʒ��� ����, �ε��� i�� j�� ���� �ٲ���.
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static void sum(int[] arr, int k) {
		int result = 0;
		for(int i=0;i<k-1;i++){
			result += Math.abs(arr[i]-arr[i+1]); 
		}
		if(answer<result){
			answer = result;
		}
	}
	
}
