package baekjoon.silver1;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class baek1189 {
    // 0,0 시작 -> r,c 도착
    static boolean[][] visited;
    static int[][] road;
    static int r;
    static int c;
    static int k;
    static int[] dx ={-1,1,0,0};
    static int[] dy ={0,0,1,-1};
    static int answer=0;
    public static void answer() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] info = br.readLine().split(" ");

        r=Integer.parseInt(info[0]);
        c=Integer.parseInt(info[1]);
        k=Integer.parseInt(info[2]);

        road = new int[r][c];
        visited = new boolean[r][c];

        for(int i=0;i<r;i++){
            String rows = br.readLine();

            for(int j=0;j<c;j++){
                if(rows.charAt(j)==('.')){
                    road[i][j]=1;
                }
                else{
                    road[i][j]=-1;
                }
            }
        }


        dfs(0,0);
        print(road);
        System.out.println(answer);
    }

    public static void dfs(int x, int y){
        Stack<Integer[]> stack = new Stack<>();
        stack.push(new Integer[]{x,y});
        int steps=0;

        while(!stack.isEmpty()){




            Integer[] current = stack.pop();
            if(current[0]==r-1&& current[1]==c-1){
                System.out.println("도착");

                if(steps==k){
                    answer+=1;
                }
            }
            visited[current[0]][current[1]]=true;
            System.out.println(current[0]+" "+current[1]+" 방문 "+ steps);
            for(int i=0;i<4;i++){
                int newX = current[0]+dx[i];
                int newY = current[1]+dy[i];

                if(newX>=0 && newY>=0 && newX<r && newY<c){
                    if(!visited[newX][newY] && road[newX][newY]!=-1){
                        visited[newX][newY]=true;
                        stack.push(new Integer[]{newX,newY});
                        steps+=1;
                    }
                }
            }
        }

    }

    public static void print(int[][] a){
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
}
