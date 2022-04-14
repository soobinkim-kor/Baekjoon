package baekjoon.silver4;

import java.io.*;

public class baek1769 {

    public static void answer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        int y = Integer.parseInt(br.readLine());
        int count=0;

        while(y>=10 || getSum(y)>=10){
            count+=1;
            y=getSum(y);
        }

        wr.write(String.valueOf(count)+"\n");

        if(y%3==0){
            wr.write("YES");
        }
        else{
            wr.write("NO");
        }

        wr.close();
    }

    public static int getSum(int a){

        int sum=0;

        while (a>=1){
            sum+=a%10;
            a=a/10;
        }

        return sum;
    }
}
