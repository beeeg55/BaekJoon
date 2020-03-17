package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class queue_11866 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st =new StringTokenizer(s," ");
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		for(int i=1;i<=n;i++){
			q.add(i);
		}
		
		System.out.print("<");
		while(q.size()!=0){
			for(int i=0;i<k-1;i++){
				q.add(q.poll());
			}
			System.out.print(q.poll());
			if(q.size()!=0){
				System.out.print(", ");
			}
		}
		System.out.print(">");
				
	}

}
