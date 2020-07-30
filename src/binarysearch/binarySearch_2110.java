package binarysearch;
// ���� : https://mygumi.tistory.com/301
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class binarySearch_2110 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s," ");
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int[] house = new int[N];
		for(int i=0;i<N;i++){
			house[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(house);
		
		int first = 1; // �ּҰŸ� 
	    int last = house[N-1]-house[0]; //�ִ�Ÿ� 
	    int answer = 0;
	    int d = 0;
	    
	    
	    // ������ ���ؼ� ������ �� + ���� ����
	    while(first<=last){
	    	int mid = (first+last)/2;
	    	int count = 1;
	    	int start = house[0];
	    	for (int i = 1; i < N; i++) {
	            d = house[i] - start;
	            if (mid <= d) {
	                ++count;
	                start = house[i];
	            }
	        }
	 
	        if (count >= C) {
	            // �������� ���� ������ => ���� ������
	        	answer = mid;
	            first = mid + 1;
	        } else {
	            // �����Ⱑ �� ��ġ�Ǿ���Ѵ�. => ���� ������
	            last = mid - 1;
	        }
	    }
	    System.out.println(answer);
	}

}
