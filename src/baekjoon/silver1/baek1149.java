package baekjoon.silver1;

import java.io.*;

public class baek1149 {
    static int houses;
    static int[][] dp;
    public void answer()throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        houses= Integer.parseInt(br.readLine());

        dp=new int[houses+1][3];

        for(int i=1;i<=houses;i++){
            String[] info = br.readLine().split(" ");
            int toRed = Integer.parseInt(info[0]);
            int toGreen = Integer.parseInt(info[1]);
            int toBlue = Integer.parseInt(info[2]);

            dp[i][0]=Math.min(dp[i-1][1],dp[i-1][2])+toRed;
            dp[i][1]=Math.min(dp[i-1][0],dp[i-1][2])+toGreen;
            dp[i][2]=Math.min(dp[i-1][0],dp[i-1][1])+toBlue;
        }
        wr.write(Math.min(dp[houses][0],Math.min(dp[houses][1],dp[houses][2]))+"");
        wr.close();
    }

}
