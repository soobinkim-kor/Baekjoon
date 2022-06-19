package baekjoon.silver1;

import java.io.*;

public class baek1080 {
    /*
    * Algorithm
    * 1. 두개의 매트릭스 (뒤집기 전, 목표 매트릭스)
    * 2. 뒤집기 전 매트릭스의 값들을 0,0 부터 비교.
    * 2-1) 값이 다르면 뒤집음
    * 2-2) 값이 같으면 다음 값 비교
    * 3.만약 남아있는 오른쪽 컬럼, 아래쪽 로우 가 2개 이하일 경우 (뒤집을 공간이 없는 경우) 는 패스
    * 4.마지막까지 뒤집기 실행
    * 4-1) 맨 오른쪽 두 열, 맨 아래쪽 두 행의 값이 같다면 성공한 것
    * 4-2) 값이 다르다면, 그 부분은 뒤집을 수 없음. (그 부분을 기준으로 오른쪽만 뒤집기가 가능하기 때문)
    * */

    public static void main(String[] args) throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] info = br.readLine().split(" ");
        int rows=Integer.parseInt(info[0]);
        int columns=Integer.parseInt(info[1]);
        int[][] matrixA=new int[rows][columns];
        int[][] matrixB=new int[rows][columns];

        // Matrix A 만들기
        for(int i=0;i<rows;i++){

            String[] ele = br.readLine().split("");
            for(int j=0;j<columns;j++){
                matrixA[i][j]=Integer.parseInt(ele[j]);
            }

        }

        // Matrix B 만들기
        for(int i=0;i<rows;i++){

            String[] ele = br.readLine().split("");
            for(int j=0;j<columns;j++){
                matrixB[i][j]=Integer.parseInt(ele[j]);
            }

        }

        // 3 by 3 보다 작은 매트릭스는 뒤집기가 불가능. 따라서 바로 비교
        if(rows<3 || columns <3){

            for(int i=0;i<rows;i++){
                for(int j=0;j<columns;j++){
                    if(matrixA[i][j]!=matrixB[i][j]){
                        System.out.println(-1); // 비교부터 틀림
                        return;
                    }
                }
            }
            System.out.println(0);
            return;
        }

        int count=0;
        for(int i = 0; i < rows - 2 ; i++){
            for( int j = 0 ; j < columns - 2 ; j++ ){
                if(matrixA[i][j]!=matrixB[i][j]){
                    swap3by3(i,j,matrixA);
                    count++;
                }
            }
        }

        for(int i = rows - 2; i < rows ; i ++){
            for( int j= columns - 2 ; j < columns ; j ++ ){
                if (matrixA[i][j]!=matrixB[i][j]){
                    System.out.println("-1");
                    return;
                }
            }
        }
        System.out.println(count);

    }


    public static void swap3by3(int row, int column, int[][] matrixA){
        for(int i=row ; i<row+3 ; i++){
            for( int j=column ; j<column+3 ; j++){
                if(matrixA[i][j]==1){
                    matrixA[i][j]=0;
                }
                else{
                    matrixA[i][j]=1;
                }
            }
        }
    }

    public static void printMatrix(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println("");
        }
    }



}
