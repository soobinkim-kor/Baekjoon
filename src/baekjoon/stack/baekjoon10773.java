package baekjoon.stack;

import java.io.*;
import java.util.Stack;

public class baekjoon10773 {

    public void answer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        int k = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<k;i++){
            int called=Integer.parseInt(br.readLine());
            if(called==0){
                stack.pop();
            }
            else{
                stack.push(called);
            }
        }
        int sum=0;
        for(Integer data:stack){
            sum+=data;
        }

        wr.write(String.valueOf(sum));
        wr.close();
    }

}
