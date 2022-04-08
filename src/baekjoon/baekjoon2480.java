package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Collections;
public class baekjoon2480 {
    public void answer() throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        br.close();

        List<Integer> list = new ArrayList<>();

        for(int i=0;i<3;i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);

        int count=0;

        int num=0;

        int answer=0;

        if(list.get(0)==list.get(1)){
            count+=1;
            num=list.get(0);
        }

        if(list.get(1)==list.get(2)){
            count+=1;
            num=list.get(1);
        }

        if(count==0){
            answer=list.get(2)*100;
        }

        if(count==1){
            answer=num*100+1000;
        }

        if(count==2){
            answer=num*1000+10000;
        }

        wr.write(String.valueOf(answer));
        wr.close();
    }
}
