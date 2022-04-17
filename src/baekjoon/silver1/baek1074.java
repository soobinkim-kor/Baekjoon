package baekjoon.silver1;

import java.io.*;

public class baek1074 {
    static int N;
    static int row;
    static int column;

    static int size;
    static int answer;
    public static void answer()throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] info = br.readLine().split(" ");
        N=Integer.parseInt(info[0]);
        row=Integer.parseInt(info[1]);
        column=Integer.parseInt(info[2]);

        size=(int)Math.pow(2,N);
        find(row,column,size);
        wr.write(answer+"");
        wr.close();
    }

    static void find(int r, int c, int size){
        if(size==1){
            return;
        }

        // r,c 가 4사분면 일 때

        if( r < size/2 && c < size/2){
            find(r,c,size/2);
        }


        // r,c 가 1사분면 일 때

        else if( r > size/2 && c <= size/2){
            find(r,c-size/2,size/2);
            answer+=size*size/4;
        }


        // r,c 가 2사분면 일 때

        else if ( r >= size/2 && c > size/2){
            find(r-size/2,c,size/2);
            answer+=size*size/4
        }


        // r,c 가 3사분면 일 때

        else{
            find(r-size/2,c-size/2,size/2);
        }

        return 0;
    }

}
