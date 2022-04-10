package baekjoon.bruteforce;

import java.io.*;

public class baekjoon7568 {
    public void answer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        int n= Integer.parseInt(br.readLine());
        int[][] array=new int[n][2];
        String[] info;
        for(int i=0;i<n;i++){
            info = br.readLine().split(" ");
            array[i][0]=Integer.parseInt(info[0]);
            array[i][1]=Integer.parseInt(info[1]);
        }

        for(int i=0;i<n;i++){
            int rank=0;
            for(int j=0;j<n;j++){
                if(array[i][0]<array[j][0] && array[i][1]<array[j][1]){
                    rank+=1;
                }
            }
            wr.write(String.valueOf(rank+1)+" ");
        }
        wr.close();
    }
}
