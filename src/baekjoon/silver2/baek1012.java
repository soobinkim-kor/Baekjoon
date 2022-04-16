package baekjoon.silver2;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Deque;
public class baek1012 {
    /*
    * ***알고리즘***
    * 연결되어있는 배추 그룹을 찾고, 그 갯수만큼 리턴 하면 됨
    * visited 를 통해 갯수 세기 가능
    */

    static int testcase;
    static int[][] field;
    static boolean[][] visited;
    static StringTokenizer st;
    static Deque<Integer[]> deque;

    public static void answer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        testcase=Integer.parseInt(br.readLine());
        for(int i=0;i<testcase;i++){
            System.out.println(i+1+" 번째 field");
            String location = br.readLine();
            st = new StringTokenizer(location);
            System.out.println(location);
            int height=Integer.parseInt(st.nextToken());
            int width=Integer.parseInt(st.nextToken());
            int cabbage = Integer.parseInt(st.nextToken());

            field=new int[height][width];
            visited= new boolean[height][width];

            for(int j=0;j<cabbage;j++){
                String[] info = br.readLine().split(" ");

                field[Integer.parseInt(info[0])][Integer.parseInt(info[1])]=1;
            }

            for(int x=0;x<field.length;i++){
                for(int y=0;y<field[0].length;y++){
                    if(!visited[x][y]&&field[x][y]==1){
                        Integer[] loc = {x,y};
                        deque.add(loc);
                        while(!deque.isEmpty()){
                            Integer[] space = deque.poll();
                            // 아래 배추가 1인 경우

                            if(field[space[0]+1][space[1]]==1&&!visited[space[0]+1][space[1]]){
                                if(space[0]+1>=height){
                                    break;
                                }

                                visited[space[0]+1][space[1]]=true;
                                Integer[] newLoc = {space[0]+1,space[1]};
                                deque.add(newLoc);
                            }
                            // 오른쪽 배추가 1인 경우

                            if(field[space[0]][space[1]+1]==1&&!visited[space[0]][space[1]+1]){
                                if(space[1]+1>=width){
                                    break;
                                }

                                visited[space[0]][space[1]+1]=true;
                                Integer[] newLoc = {space[0],space[1]+1};
                                deque.add(newLoc);
                            }

                            // 위 배추가 1인 경우
                            if(field[space[0]-1][space[1]]==1&&!visited[space[0]-1][space[1]]){
                                if(space[0]-1<0){
                                    break;
                                }

                                visited[space[0]-1][space[1]]=true;
                                Integer[] newLoc = {space[0]-1,space[1]};
                                deque.add(newLoc);
                            }

                            // 왼쪽 배추가 1인 경우
                            if(field[space[0]][space[1]-1]==1&&!visited[space[0]][space[1]-1]){
                                if(space[1]-1<0){
                                    break;
                                }

                                visited[space[0]][space[1]-1]=true;
                                Integer[] newLoc = {space[0],space[1]-1};
                                deque.add(newLoc);
                            }
                        }
                    }
                }
            }
        }
    }
    public static void printField(int[][] field){
        for(int i=0;i<field.length;i++){
            System.out.print("[");
            for(int j=0;j<field[0].length;j++){
                System.out.print(field[i][j]+", ");
            }
            System.out.print("]\n");
        }
    }

    public static void printVisited(boolean[][] visited){
        for(int i=0;i<visited.length;i++){
            System.out.print("[");
            for(int j=0;j<visited[0].length;j++){
                System.out.print(visited[i][j]+", ");
            }
            System.out.print("]\n");
        }
    }
}
