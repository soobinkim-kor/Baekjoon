package baekjoon.silver1;

import java.io.*;
import java.util.Arrays;

public class baek11660 {
    static int[] start = new int[2];
    static int[] end = new int[2];
    public static void answer()throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] info = br.readLine().split(" ");
        int size = Integer.parseInt(info[0]);
        int answers = Integer.parseInt(info[1]);

        int[][] matrix = new int[size][size];
        for(int i=0;i<size;i++){
            String[] info2 = br.readLine().split(" ");
            for(int j=0;j<size;j++){
                matrix[i][j]=Integer.parseInt(info2[j]);
            }
        }

        for(int i=0;i<answers;i++){
            String[] info3 = br.readLine().split(" ");
            start[0]=Integer.parseInt(info3[0]);
            start[1]=Integer.parseInt(info3[1]);
            end[0]=Integer.parseInt(info3[2]);
            end[1]=Integer.parseInt(info3[3]);
            wr.write(calSum(matrix,start,end)+"\n");
        }

        wr.close();
    }

    static int calSum(int[][] matrix, int[] start, int[] end){
        int sum=0;
        for(int i=start[0]-1;i<end[0];i++){
            for(int j=start[1]-1;j<end[1];j++){
                sum+=matrix[i][j];
            }
        }
        return sum;
    }
}

/*
*
4 3
1 2 3 4
2 3 4 5
3 4 5 6
4 5 6 7
2 2 3 4
3 4 3 4
1 1 4 4
*
*
* */