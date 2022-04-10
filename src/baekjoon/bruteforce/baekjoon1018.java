package baekjoon.bruteforce;

import java.io.*;
import java.util.Arrays;

public class baekjoon1018 {
    public void answer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] sp = br.readLine().split(" ");
        int n=Integer.parseInt(sp[0]);
        int m=Integer.parseInt(sp[1]);
        String[][] chess = new String[n][m];

        for(int i=0;i<n;i++){
            String info = br.readLine();
            for(int j=0;j<m;j++){
                chess[i][j]=String.valueOf(info.charAt(j));
            }
        }

        System.out.println(Arrays.deepToString(chess));

        wr.close();
    }
}
