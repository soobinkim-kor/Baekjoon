package baekjoon.bruteforce;

import java.io.*;

public class baekjoon1436 {
    public void answer()throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        int target = Integer.parseInt(br.readLine());

        int start=665;
        int count=0;

        while(count!=target){
            start+=1;
            if(contains666(start)){
                count+=1;
            }
        }
        wr.write(String.valueOf(start));
        wr.close();
    }
    public static boolean contains666(int k){
        String kToString = String.valueOf(k);
        return kToString.contains("666");
    }

}
