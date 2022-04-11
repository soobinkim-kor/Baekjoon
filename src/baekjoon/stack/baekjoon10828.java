package baekjoon.stack;

import java.io.*;
import java.util.Stack;

public class baekjoon10828 {
    public void answer() throws  IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        int commands = Integer.parseInt(br.readLine());
        Stack<Integer> stack= new Stack<>();
        //조건 경우 잘 생각
        for(int i=0;i<commands;i++){
            String[] command= br.readLine().split(" ");
            if(command[0].contains("push")){
                stack.push(Integer.parseInt(command[1]));
            }

            else if(command[0].equals("pop")){
                if(stack.empty()){
                    wr.write("-1\n");
                }
                else{
                    wr.write(String.valueOf(stack.pop())+"\n");
                }

            }

            else if(command[0].equals("size")){
                wr.write(String.valueOf(stack.size())+"\n");
            }

            else if(command[0].equals("empty")){
                if(stack.empty()){
                    wr.write("1\n");
                }
                else{
                    wr.write("0\n");
                }
            }

            else if(command[0].equals("top")){
                if(stack.empty()){
                    wr.write("-1\n");
                }
                else{
                    wr.write(stack.peek()+"\n");
                }
            }

        }
        wr.close();

    }
}
