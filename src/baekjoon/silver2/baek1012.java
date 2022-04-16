package baekjoon.silver2;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.Stack;
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
    static Stack<int[]> stack;

    static int height;
    static int width;
    // 상 하 좌 우
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    public static void answer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        testcase=Integer.parseInt(br.readLine());

        for(int i=0;i<testcase;i++){
            int answer=0;
            String location = br.readLine();
            st = new StringTokenizer(location);
            height=Integer.parseInt(st.nextToken());
            width=Integer.parseInt(st.nextToken());
            int cabbage = Integer.parseInt(st.nextToken());

            field=new int[height][width];
            visited= new boolean[height][width];

            for(int j=0;j<cabbage;j++){
                String[] info = br.readLine().split(" ");
                field[Integer.parseInt(info[0])][Integer.parseInt(info[1])]=1;
            }

            for(int x=0;x<field.length;x++){
                for(int y=0;y<field[0].length;y++){
                    if(field[x][y]==1 && !visited[x][y]){
                        //dfs(x,y);
                        bfs(x,y);
                        answer+=1;
                        System.out.println("**");
                    }
                }
            }
            wr.write(answer+"\n");
        }
        wr.close();
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

    public static void dfs(int x, int y){
        visited[x][y] = true;
        for(int i=0; i<4; i++){
            int newx=x+dx[i];
            int newy=y+dy[i];

            if(newx>=0 && newy>=0 && newx<height && newy<width){
                if(!visited[newx][newy] && field[newx][newy]==1){
                    dfs(newx,newy);
                }
            }
        }
    }

    public static void bfs(int x, int y){
        Deque<Integer[]> deque = new LinkedList<>();
        deque.add(new Integer[]{x,y});

        while(!deque.isEmpty()){
            // 1.
//            x=deque.peek()[0];
//            y=deque.peek()[1];
//            System.out.println(x+" "+y);
//            visited[x][y]=true;
//            deque.poll();

            // 2.
            Integer[] current = deque.poll();
            System.out.println(current[0]+" "+current[1]);
            visited[current[0]][current[1]]=true;

            for(int i=0;i<4;i++){
                int newx = x+dx[i];
                int newy = y+dy[i];

                if(newx>=0 && newy>=0 && newx<height && newy<width){
                    if(!visited[newx][newy] && field[newx][newy]==1){

                        deque.add(new Integer[]{newx,newy});
                        visited[newx][newy]=true;
                    }
                }
            }
        }
    }
}
