package baekjoon.math;

import java.io.*;
import java.util.StringTokenizer;

public class baekjoon2740 {
    public void answer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stA = new StringTokenizer(br.readLine());

        int nA   =   Integer.parseInt(stA.nextToken()); //3
        int mA   =   Integer.parseInt(stA.nextToken()); //2

        int[][] matrixA = new int[nA][mA];

        for(int i=0; i<nA;i++){
            String[] numbers = br.readLine().split(" ");
            for ( int j=0; j<mA;j++) {
                matrixA[i][j] = Integer.parseInt(numbers[j]);
            }

        }


        StringTokenizer stB=new StringTokenizer(br.readLine());
        int mB   =   Integer.parseInt(stB.nextToken()); //2
        int kB   =   Integer.parseInt(stB.nextToken()); //3

        int[][] matrixB = new int[mB][kB];

        for(int i=0; i<mB;i++){
            String[] numbers = br.readLine().split(" ");
            for ( int j=0; j<kB;j++) {
                matrixB[i][j] = Integer.parseInt(numbers[j]);
            }
        }

        int[][] matrixC = new int[nA][kB];

        for(int i=0; i<nA;i++){

            for( int j=0;j<kB;j++){
                int sum=0;

                for(int k=0;k<mB;k++){

                    sum+=matrixA[i][k]*matrixB[k][j];
                }

                wr.write(String.valueOf(sum));
                wr.write(" ");
                //matrixC[i][j]=sum;

            }
            wr.write("\n");

        }
        wr.close();
    }
}
