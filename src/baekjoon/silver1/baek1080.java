package baekjoon.silver1;

import java.io.*;

public class baek1080 {

    static int rows;
    static int columns;

    static int[][] matrixA;
    static int[][] matrixB;

    public static void answer() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] info = br.readLine().split(" ");

        rows=Integer.parseInt(info[0]);
        columns=Integer.parseInt(info[1]);
        matrixA=new int[rows][columns];
        matrixB=new int[rows][columns];
        for(int i=0;i<rows;i++){
            String element = br.readLine();
            for(int j=0;j<columns;j++){
                matrixA[i][j]=Integer.parseInt(String.valueOf(element.charAt(j)));
            }
        }

        for(int i=0;i<rows;i++){
            String element = br.readLine();
            for(int j=0;j<columns;j++){
                matrixB[i][j]=Integer.parseInt(String.valueOf(element.charAt(j)));
            }
        }
        printMatrix(matrixA);
        printMatrix(matrixB);
    }

    public static void printMatrix(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println("");
        }
    }

    public static void swap3by3(int[][] matrix){
        for(int i=0;i<3;i++){
            
        }
    }

}
