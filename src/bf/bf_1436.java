package bf;

import java.io.*;
 
 
class bf_1436{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int num = 0;
 
        while(N > 0) {
            num++;
            String str = Integer.toString(num);   // int to string ����ȯ
 
            if(str.contains("666")) 
                N--;
        }
 
        System.out.println(num);
    }
}
