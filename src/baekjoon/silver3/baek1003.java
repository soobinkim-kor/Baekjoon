package baekjoon.silver3;

import java.io.*;

public class baek1003 {
    static Integer[][] dp;
    public void answer() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        int testcase = Integer.parseInt(br.readLine());
        dp=new Integer[41][2];
        dp[0][0]=1;
        dp[0][1]=0;
        dp[1][0]=0;
        dp[1][1]=1;

        for(int i=0;i<testcase;i++){
            int n= Integer.parseInt(br.readLine());
            fibonacci(n);
            wr.write(String.valueOf(dp[n][0]+" "+String.valueOf(dp[n][1])));
            wr.write("\n");
        }
        wr.close();
    }

    public Integer[] fibonacci(int n){
        if(dp[n][0]==null || dp[n][1]==null){
            dp[n][0]=fibonacci(n-1)[0]+fibonacci(n-2)[0];
            dp[n][1]=fibonacci(n-1)[1]+fibonacci(n-2)[1];
        }
        return dp[n];
    }
}
