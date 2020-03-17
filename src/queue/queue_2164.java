package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class queue_2164 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		for(int i=1;i<=num;i++){
			q.add(i);
		}
		
		boolean th = true;
		while(q.size()!=1){
			if(th==true){
				q.poll();
				th = false;
			}
			else{
				q.add(q.poll());
				th = true;
			}
		}
		System.out.println(q.peek());
				
				
	}

}
