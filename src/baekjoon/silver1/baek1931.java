package baekjoon.silver1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class baek1931 {

    static int N;
    static ArrayList<int[]> rooms;

    public static void answer() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt( //회의의 수
                br.readLine());

        rooms=new ArrayList<int[]>();
        int answer=0;

        for(int i=0;i<N;i++){
            String[] info = br.readLine().
                    split(" ");

            if(info[0].equals(info[1])){
                answer++;
            }

            else{
                rooms.add(new int[]{Integer.parseInt(info[0]), Integer.parseInt(info[1])});
            }

        }



        Collections.sort(rooms, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]==o2[1]){
                    return o1[0]-o2[0];
                }
                return o1[1]-o2[1];
            }
        });

        for(int[] data:rooms){
            System.out.println("시작 시간: "+data[0]+" 종료 시간: "+data[1]);
        }

        for(int i=0;i<rooms.size();i++){

        }

        wr.close();
    }
}
