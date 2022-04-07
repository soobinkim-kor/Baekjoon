package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class baekjoon2525 {
    public void answer() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter((new OutputStreamWriter(System.out)));

        String firstrow = br.readLine();
        StringTokenizer st = new StringTokenizer(firstrow);

        int hour    =   Integer.parseInt(st.nextToken());
        int min     =   Integer.parseInt(st.nextToken());

        int add = Integer.parseInt(br.readLine());
        min=min+add;

        while(min>=60){
            min=min-60;
            hour=hour+1;
        }

        if (hour>=24){
            hour=hour-24;
        }
        String answer=hour+" "+min;

        wr.write(answer);
        wr.close();
    }
}
