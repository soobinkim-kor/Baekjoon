package baekjoon.silver4;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class baek10866 {
    static Deque<Integer> deque;
    /*
    * 문제
    정수를 저장하는 덱(Deque)를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

    명령은 총 여덟 가지이다.

    push_front X: 정수 X를 덱의 앞에 넣는다.
    push_back X: 정수 X를 덱의 뒤에 넣는다.
    pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    size: 덱에 들어있는 정수의 개수를 출력한다.
    empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
    front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    입력
    첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다. 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다. 주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다. 문제에 나와있지 않은 명령이 주어지는 경우는 없다.

    출력
    출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.
    *
    *
    * */
    public static void answer() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        int commands = Integer.parseInt(br.readLine());

        deque = new LinkedList<>();

        for(int i=0;i<commands;i++){
            String[] command = br.readLine().split(" ");

            if(command[0].equals("push_front")){
                deque.addFirst(Integer.parseInt(command[1]));
            }

            else if(command[0].equals("push_back")){
                deque.addLast(Integer.parseInt(command[1]));
            }

            else if(command[0].equals("pop_front")){
                if(deque.isEmpty()){
                    wr.write("-1\n");
                }
                else{
                    wr.write(deque.pollFirst() +"\n");
                }

            }

            else if(command[0].equals("pop_back")){
                if(deque.isEmpty()){
                    wr.write("-1\n");
                }
                else{
                    wr.write(deque.pollLast() +"\n");
                }

            }

            else if(command[0].equals("size")){
                wr.write(deque.size()+"\n");
            }

            else if(command[0].equals("empty")){
                if(deque.isEmpty()){
                    wr.write("1\n");
                }
                else{
                    wr.write("0\n");
                }
            }

            else if(command[0].equals("front")){
                if(deque.isEmpty()){
                    wr.write("-1\n");
                }
                else{
                    wr.write(deque.peekFirst() +"\n");
                }

            }

            else if(command[0].equals("back")){
                if(deque.isEmpty()){
                    wr.write("-1\n");
                }
                else{
                    wr.write(deque.peekLast() +"\n");
                }

            }

        }

        wr.close();
    }
}
