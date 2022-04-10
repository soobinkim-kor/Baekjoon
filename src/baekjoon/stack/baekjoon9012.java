package baekjoon.stack;

import java.io.*;
import java.util.Stack;

public class baekjoon9012 {

    public void answer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){

            Stack<String> stack = new Stack<>();
            String[] bracket = br.readLine().split("");

            if(bracket[0].equals(")")){
                wr.write("NO\n");
                continue;
            }

            for(int j=0;j< bracket.length;j++){

                if(bracket[j].equals("(")){
                    stack.push("(");
                }

                if(bracket[j].equals(")")){
                    if(stack.empty()){
                        stack.push(")");
                        break;
                    }
                    else{
                        stack.pop();
                    }
                }
            }
            if(stack.empty()){
                wr.write("YES\n");
            }
            else{
                wr.write("NO\n");
            }
        }
        wr.close();
    }

}
