package baekjoon.bruteforce;

import java.io.*;

public class baekjoon2231 {
    public void answer() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        br.close();
        for(int i=0; i<n; i++){
            if(returnSum(i)==n){
                System.out.println(i);
                break;
            }
            if (i==n-1){
                System.out.println(0);
            }

        }

    }

    public int returnSum(int k){
        int sum=k;

        while(k>=1){
            sum+=k%10;
            k=k/10;
        }

        return sum;
    }

}
