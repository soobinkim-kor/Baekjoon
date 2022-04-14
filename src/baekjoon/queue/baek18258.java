package baekjoon.queue;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class baek18258 {

    public static void answer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<String> queue = new LinkedList<>();

        int commands = Integer.parseInt(br.readLine());
        for(int i=0;i<commands;i++){

            String[] command=br.readLine().split(" ");
            if(command[0].equals("push")){
                queue.add(command[1]);
            }

            else if (command[0].equals("pop")){
                if(queue.isEmpty()){
                    wr.write("-1"+"\n");
                }
                else{
                    wr.write(queue.poll()+"\n");
                }
            }

            else if (command[0].equals("size")){
                wr.write(String.valueOf(queue.size())+"\n");
            }

            else if (command[0].equals("empty")){
                if(queue.isEmpty()){
                    wr.write("1"+"\n");
                }
                else{
                    wr.write("0"+"\n");
                }
            }

            else if (command[0].equals("front")){
                if(queue.isEmpty()){
                    wr.write("-1"+"\n");
                }
                else{
                    wr.write(queue.peek()+"\n");
                }

            }

            else if (command[0].equals("back")){
                if(queue.isEmpty()){
                    wr.write("-1"+"\n");
                }
                else{
                    wr.write(queue.getLast()+"\n");
                }

            }
        }

        wr.close();
    }
}
