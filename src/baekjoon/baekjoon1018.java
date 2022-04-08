package baekjoon;

import java.io.*;

public class baekjoon1018 {
    public void answer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        System.out.println("ss");
        String[] sp = br.readLine().split(" ");
        int n=Integer.parseInt(sp[0]);
        int m=Integer.parseInt(sp[1]);
        String[][] chess = new String[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                String info = br.readLine();
                chess[i][j]=String.valueOf(info.charAt(j));
            }
        }

        for(String[] data: chess){
            System.out.println(data);
        }

        wr.close();
    }
}
