package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class queue_1966 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCaseN = Integer.parseInt(br.readLine()); // �׽�Ʈ���̽� ����
		for(int i=0;i<testCaseN;i++){
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s," ");
			int n = Integer.parseInt(st.nextToken()); //���� ����
			int target = Integer.parseInt(st.nextToken()); // �ñ��� ���� �ε���
			int[] arr = new int[n]; // ���Ŀ� �迭
			LinkedList<Integer> qu = new LinkedList<>();
			s = br.readLine();
			st = new StringTokenizer(s," ");
			for(int j=0;j<n;j++){
				int num = Integer.parseInt(st.nextToken());
				arr[j] = num; 
				qu.add(num);
			}
			Arrays.sort(arr);
			int index = arr.length-1;
			int answer = 1; //���°�� �μ�
			while(true){
				//queue.peek()�� ���� ���� ū ���� �ɶ����� 
				while(qu.peek()!=arr[index]){
					qu.add(qu.poll());
					if(target==0){
						target = qu.size()-1;
					}else{
						target--;
					}
				}
				if(target==0){ // �ش� ���� �ε����� ���
					System.out.println(answer);
					break;
				}else{ // �ش� ������ �ƴ� ���
					qu.poll();
					answer++;
					index--;
					if(target==0){
						target = qu.size()-1;
					}else{
						target--;
					}
				}
			}
		}
		
	}

}
