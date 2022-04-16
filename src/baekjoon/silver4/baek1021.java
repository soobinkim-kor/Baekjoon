package baekjoon.silver4;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class baek1021 {
    static LinkedList<Integer> deque = new LinkedList<>();
    static int count=0;
    static int queueSize;
    public static void answer() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] info = br.readLine().split(" ");
        queueSize = Integer.parseInt(info[0]);
        int m = Integer.parseInt(info[1]);
        String[] targetList = br.readLine().split(" ");
        int[] targetToIntList = new int[targetList.length];

        for(int i=0; i<targetList.length;i++){
            targetToIntList[i]=Integer.parseInt(targetList[i]);
        }

        for(int data: targetToIntList){
            System.out.print(data+" ");
        }
        System.out.println(" ");

        for(int i=0; i<queueSize; i++){
            deque.add(i+1);
        }

        for(int i=0;i<targetToIntList.length;i++){
            int target=targetToIntList[i];
            while(true){
                if(deque.getFirst()==target){
                    int s=deque.poll();
                    System.out.println(s+ " 완료");
                    printQueue();
                    break;
                }
                else{
                    if(countRight(target)==1){
                        System.out.println("moved queue to Left ");
                        moveLeft();
                    }
                    else{
                        System.out.println("moved queue to Right ");
                        moveRight();
                    }
                }

                printQueue();
            }
        }
        wr.write(String.valueOf(count));
        wr.close();

//        Deque 출력
//        for(String data:deque){
//            System.out.print(data+" ");
//        }

    //if 2*(indexOf(target))+1 >= size -> moveLeft
    }
    public static void moveLeft(){ // 가장 왼쪽 원소를 빼고 오른쪽에 삽입
        count+=1;
        Integer last = deque.pollFirst();
        deque.offerLast(last);
    }

    public static void moveRight(){ // 가장 오른쪽 원소를 빼고 왼쪽에 삽입
        count+=1;
        Integer first = deque.pollLast();
        deque.offerFirst(first);
    }

    public static int countRight(int target){ //target 이 되는 수 보다 오른쪽 수가 많으면 1 (moveLeft) , 왼쪽 수가 많으면 -1 (moveRight)
        int queueSize = deque.size();
        System.out.println(queueSize);
        int index = deque.indexOf(target);
        System.out.println(target+"의 인덱스 : "+index);
        int leftCount=index;
        int rightCount=queueSize-index-1;

        if(leftCount<=rightCount){
            return 1;
        }
        else{
            return -1;
        }
    }

    public static void printQueue(){
        for(Integer data:deque){
            System.out.print(data+" ");
        }
        System.out.println(" ");
    }
}

/*
    target= 6
    size=10
    6의 index= 5
    6 왼쪽 갯수 = 5
    6 오른쪽 갯수 = 4
    왼쪽갯수<=오른쪽 갯수 -> moveleft

    target=3
    size=5
    3의 index =2
    3 왼쪽 갯수 = target의 index
    3 오른쪽 갯수 = size-target의 index -1

    if indexOf(target)>=size-indexOf(target)-1
    if 2*(indexOf(target))+1 >= size
    1 2 3 4 5 6 7 8 9 10
    1 2 3 4 5
    유리한 위치:

        짝수 개: 길이/2 인덱스부터 moveright
        10 -> 5번째부터!
        홀수 개: 길이/2 인덱스부터- > moveright
        5 -> 3이상부터 moveRight

        길이/2 <= 인덱스 -> moveRight
    2 3 4 5 6 7 8 9 10 1    (moveLeft)
    3 4 5 6 7 8 9 10 1      (pop)
    1 3 4 5 6 7 8 9 10      (moveRight)
    10 1 3 4 5 6 7 8 9      (moveRight)
    9 10 1 3 4 5 6 7 8      (moveRight)
    10 1 3 4 5 6 7 8        (pop)
    8 10 1 3 4 5 6 7        (moveRight)
    7 8 10 1 3 4 5 6        (moveRight)
    6 7 8 10 1 3 4 5        (moveRight)
    5 6 7 8 10 1 3 4        (moveRight)
    6 7 8 10 1 3 4          (pop)

인덱스=4, 길이 9 -> moveleft

*/