package baekjoon.silver4;

import java.io.*;

public class baek1676 {

    public static void answer() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(
                br.readLine());

        int count5=0;

        for(int i=1;i<=N;i++){
            int num=i;
            while(num%5==0){
                count5++;
                num=num/5;
            }
        }
        wr.write(count5+"");
        wr.close();
    }
}
