package error;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//³ªÁß¿¡...

public class queue_1966 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++){
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s," ");
			int doc = Integer.parseInt(st.nextToken());
			int find = Integer.parseInt(st.nextToken());
			Queue<Integer> q = new LinkedList<Integer>();
			String s2 = br.readLine();
			StringTokenizer st2 = new StringTokenizer(s2," ");
			for(int j=0;j<doc;j++){
				q.add(Integer.parseInt(st2.nextToken()));
			}
			int count = 0;
			while(true){
				int max = 0;
				int index = 0;
				int max_index =0;;
				Iterator it = q.iterator();
				while(it.hasNext()){
					if(((LinkedList<Integer>) q).get(index)>((LinkedList<Integer>) q).get(max)){
						max_index=index;
						max = ((LinkedList<Integer>) q).get(index);
					}
					index++;
				}
				if(max_index==find){
					System.out.println(find);
				}else if(max_index>find){
					for(int j=0;j<max_index;j++){
						q.add(q.poll());
						
						find--;
						
					}
					q.poll();
				}
				System.out.println();
			}
			
		}
	}

}
