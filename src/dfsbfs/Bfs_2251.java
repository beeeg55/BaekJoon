package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Bfs_2251 {
 
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [] bottle = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<3; i++) {
            bottle[i] = Integer.parseInt(st.nextToken());
        }
 
        int [] b1 = {0, 0, 1, 1, 2, 2}; 
        int [] b2 = {1, 2, 0, 2, 0, 1};
        boolean [][]check = new boolean[201][201];
        boolean [] ans = new boolean[201];
        Queue<int[]> q = new LinkedList<>();
 
        q.add(new int[]{0, 0});
        check[0][0] = true;
        ans[bottle[2]] = true;
 
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int x = temp[0];
            int y = temp[1];
            int z = bottle[2]-x-y;
 
            for(int k=0; k<6; k++) {
                int [] next = {x, y, z};
                next[b2[k]] += next[b1[k]];
                next[b1[k]] = 0;
 
                if(next[b2[k]] > bottle[b2[k]]) { 
                    next[b1[k]] = next[b2[k]] - bottle[b2[k]]; 
                    next[b2[k]] = bottle[b2[k]]; 
                }
                if(!check[next[0]][next[1]]) {
                    check[next[0]][next[1]] = true;
                    q.add(new int[] {next[0], next[1]});
                    if(next[0] == 0) {
                        ans[next[2]] = true;
                    }
                }
            }
        }
        for(int i=0; i<=bottle[2]; i++) {
            if(ans[i])
                System.out.print(i+ " ");
        }
    }
 
}

 

