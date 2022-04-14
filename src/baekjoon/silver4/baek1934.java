package baekjoon.silver4;

import java.io.*;
import java.util.StringTokenizer;

public class baek1934 {

    public void answer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            wr.write(String.valueOf(a*b/get_gcd(a,b)));
            wr.write("\n");
        }

        wr.close();
    }

    public int get_gcd(int a, int b){
        if (a<b){
            int temp=a;
            a=b;
            b=temp;
        }

        if(b==0){
            return a;
        }

        if(a%b==0){
            return b;
        }

        else{
            return get_gcd(b,a%b);
        }
    }
}
