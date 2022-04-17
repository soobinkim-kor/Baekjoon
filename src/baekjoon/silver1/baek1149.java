package baekjoon.silver1;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

import static java.lang.Math.min;

public class baek1149 {
    static House[] houseList;
    static String[] colors={"Red","Green","Blue"};
    static int price=0;
    public void answer()throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        int houses= Integer.parseInt(br.readLine());
        houseList = new House[houses];

        for(int i=0;i<houses;i++){
            String[] info = br.readLine().split(" ");
            House house= new House();
            house.setToRed(Integer.parseInt(info[0]));
            house.setToGreen(Integer.parseInt(info[1]));
            house.setToBlue(Integer.parseInt(info[2]));
            houseList[i]=house;
        }

        for(House data:houseList){
            System.out.println("집의 색: "+data.getColor()+" 빨강비용: "+data.getToRed()+" 초록비용: "+data.getToGreen()+" 파랑비용: "+data.getToBlue());
        }

        for(int i=0;i<3;i++){
            price=min(price,bfs(colors[i]));
        }

        System.out.println(price);
    }

    public static int bfs(String firstHouseColor){
        Deque<House> deque=new LinkedList<>();
        House house = houseList[0];
        house.setColor(firstHouseColor);

        deque.add(house);
        while(!deque.isEmpty()){
            House polledHouse=deque.poll();

        }
        return 0;
    }

    public class House{

        int toRed;
        int toBlue;
        int toGreen;
        String color;


        public String getColor(){
            return this.color;
        }

        public void setColor(String color){
            this.color=color;
        }

        public int getToRed(){
            return this.toRed;
        }

        private void setToRed(Integer price){
            this.toRed=price;
        }

        public int getToBlue(){
            return this.toBlue;
        }

        private void setToBlue(Integer price){
            this.toBlue=price;
        }

        public int getToGreen(){
            return this.toGreen;
        }
        private void setToGreen(Integer price){
            this.toGreen=price;
        }
    }
}
