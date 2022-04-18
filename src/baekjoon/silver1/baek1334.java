package baekjoon.silver1;

import java.io.*;
import java.util.ArrayList;

public class baek1334 {
    /*
    * 알고리즘
    * 인풋 값 +1 부터 탐색
    * 10의 자리 이하일 경우 바로 리턴
    * 정수를 반으로 쪼개서
    * 홀수 일 경우:
    *       가운데 수를 제외한 앞, 뒤 숫자를 비교
    *       앞 숫자를 뒤집은 수 보다 뒤 숫자가 클 경우
    *           가운데 수 +1
    *           뒤 숫자를 앞 숫자를 뒤집은 수로 교체
    *
    *       뒤 숫자가 앞 숫자를 뒤집은 수 보다 작거나 같을 경우
    *           뒤 숫자를 뒤집음
    * 짝수 일 경우:
    *       앞 숫자를 뒤집은 수가 뒤 숫자보다 크거나 같을 경우
    *           뒤 숫자를 앞 숫자를 뒤집은 수로 변경
    *       9876
    *       9890
    *       앞 숫자를 뒤집은 수가 뒤 숫자보다 작은 경우
    *           앞 숫자의 마지막 자리 수+1
    *           앞 숫자를 뒤집은 수를 뒤 숫자로 변경
    * */
    static ArrayList<Integer> front;
    static ArrayList<Integer> back;
    static int middle;
    public static void answer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            numbers.add(Integer.parseInt(String.valueOf(input.charAt(i))));
        }

        if(numbers.size()==1){
            if(numbers.get(0)<9){
                wr.write(String.valueOf(numbers.get(0)+1));
            }
            else{
                wr.write(String.valueOf(11));
            }
        }

        else{
            numbers=plus1(numbers);



            /* 짝수 일 경우:
             *       앞 숫자를 뒤집은 수가 뒤 숫자보다 크거나 같을 경우
             *           뒤 숫자를 앞 숫자를 뒤집은 수로 변경
             *       9876
             *       9890
             *       앞 숫자를 뒤집은 수가 뒤 숫자보다 작은 경우
             *           앞 숫자의 마지막 자리 수+1
             *           앞 숫자를 뒤집은 수를 뒤 숫자로 변경
             * */

            if(numbers.size()%2==0) {
                front = new ArrayList<>(numbers.subList(0, numbers.size() / 2));
                back = new ArrayList<>(numbers.subList(numbers.size() / 2, numbers.size()));

                if (compare(swap(front), back)==1) {
                    back = swap(front);
                } else if(compare(swap(front),back)==-1) {
                    front = plus1(front);
                    back = swap(front);
                }

            }

            /*
             * 홀수 일 경우:
             *       가운데 수를 제외한 앞, 뒤 숫자를 비교
             *       앞 숫자를 뒤집은 수 보다 뒤 숫자가 클 경우
             *           가운데 수 +1
             *           뒤 숫자를 앞 숫자를 뒤집은 수로 교체
             *
             *       뒤 숫자가 앞 숫자를 뒤집은 수 보다 작거나 같을 경우
             *           뒤 숫자를 뒤집음
             */


            else{
                front = new ArrayList<>(numbers.subList(0,numbers.size()/2));
                middle = numbers.get(numbers.size()/2);
                back = new ArrayList<>(numbers.subList(numbers.size()/2+1,numbers.size()));
                if(compare(back,swap(front))==1){
                    middle+=1;
                    if(middle==10){
                        front=plus1(front);
                        middle=0;
                    }
                    back=swap(front);
                }
                else if(compare(back,swap(front))==-1){
                    back=swap(front);
                }


            }
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<front.size();i++){
                sb.append(front.get(i));
            }
            if(numbers.size()%2!=0){
                sb.append(middle);
            }
            for(int i=0;i<back.size();i++){
                sb.append(back.get(i));
            }

            wr.write(String.valueOf(sb));
        }

        wr.close();
    }

    public static ArrayList<Integer> swap(ArrayList<Integer> a){
        ArrayList<Integer> b = new ArrayList<>();
        for(int i=0;i<a.size();i++){
            b.add(a.get(a.size()-i-1));
        }
        return b;
    }

    public static ArrayList<Integer> plus1(ArrayList<Integer> a){

        a=swap(a);

        a.set(0,a.get(0)+1);
        for(int i=0;i<a.size()-1;i++){
            if(a.get(i)==10){
                a.set(i,0);
                a.set(i+1,a.get(i+1)+1);
            }
        }
        if(a.get(a.size()-1)==10){
            a.set(a.size()-1,0);
            a.add(1);
        }

        return swap(a);
    }

    public static int compare(ArrayList<Integer> a, ArrayList<Integer> b){

        if(a.size()!=b.size()){
            System.out.print("size does not match");
        }

        // if a>b return 1
        // if a<b return -1;
        // if a==b return 0
        for(int i=0;i<a.size();i++){
            if(a.get(i)>b.get(i)){
                return 1;
            }
            else if(a.get(i)<b.get(i)){
                return -1;
            }
        }
        return 0;
    }
}
