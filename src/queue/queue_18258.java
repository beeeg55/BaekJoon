package queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class queue_18258 {

	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		LinkedList<Integer> q = new LinkedList<>();
		String n = br.readLine();
		int num1 = Integer.parseInt(n);
		
		for(int i=0; i<num1; i++) {
			String s = br.readLine();
			StringTokenizer stk = new StringTokenizer(s," ");
			String a = stk.nextToken();
			int num = 0;
			switch(a) {
			case "push":
				int b = Integer.parseInt(stk.nextToken());
				q.add(b);
				break;

			case "pop":
				num = q.isEmpty()?-1:q.pop();
				bw.write(String.valueOf(num));
				bw.newLine();
				bw.flush();
				break;

			case "size":
				num = q.size();
				bw.write(String.valueOf(num));
				bw.newLine();
				bw.flush();
				break;

			case "empty":
				num = q.isEmpty()?1:0;
				bw.write(String.valueOf(num));
				bw.newLine();
				bw.flush();
				break;

			case "front":
				num = q.isEmpty()?-1:q.peek();  
				bw.write(String.valueOf(num));
				bw.newLine();
				bw.flush();
				break;

			case "back":
				num = q.isEmpty()?-1:q.get(q.size()-1);
				bw.write(String.valueOf(num));
				bw.newLine();
				bw.flush();
				break;

			}
		}
		/*for(int i=0;i<num1;i++){
			String s = br.readLine();
			StringTokenizer stk = new StringTokenizer(s," ");
			String a = stk.nextToken();
			int num = 0;
			switch(a){
				case "push":
					int b = Integer.parseInt(stk.nextToken());
					qu.add(b);
					break;
				case "empty":
					if(qu.isEmpty() == false){
						bw.write(String.valueOf(0));
						bw.newLine();
						bw.flush();
					}
					else{
						bw.write(String.valueOf(1));
						bw.newLine();
						bw.flush();
					}
					break;
				case "size":
					bw.write(String.valueOf(qu.size()));
					bw.newLine();
					bw.flush();
					break;
				case "front":
					if(qu.isEmpty()==true){
						bw.write(String.valueOf(-1));
						bw.newLine();
						bw.flush();
					}
					else{ 
						bw.write(String.valueOf(qu.peek()));
						bw.newLine();
						bw.flush();
					}
					break;
				case "back":
					if(qu.isEmpty()==true){
						bw.write(String.valueOf(-1));
						bw.newLine();
						bw.flush();
					}
					else{ 
						bw.write(String.valueOf(qu.get(qu.size()-1)));
						bw.newLine();
						bw.flush();
					}
					break;
				case "pop":
					if(qu.isEmpty()==true){
						bw.write(String.valueOf(-1));
						bw.newLine();
						bw.flush();
					}
					else{ 
						bw.write(String.valueOf(qu.pop()));
						bw.newLine();
						bw.flush();
					}
					break;
			}
		}
		*/
		br.close();
		bw.close();
	}

}
