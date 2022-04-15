package baekjoon.silver2;


import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek1260 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void bfs  (int start, boolean[] visited, boolean[][] connected) throws IOException{
        Queue<Integer> queue= new LinkedList<>();
        queue.add(start);
        wr.write(String.valueOf(start+" "));
        while(!queue.isEmpty()){
            int temp=queue.poll();

            for(int i=0;i<connected.length;i++){
                if(visited[i]==false && connected[temp][i]==true){
                    queue.add(i);
                    visited[i]=true;
                    wr.write(String.valueOf(i)+" ");
                }
            }
        }
        wr.close();
    }


    public void answer() throws IOException {



        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int v = Integer.parseInt(st.nextToken());

        boolean[][] connected = new boolean[n][m];

        boolean[] visited = new boolean[n];

        System.out.println(n+" "+m+" "+v);
        for(int i = 0 ; i < m ; i ++){
            String[] info = br.readLine().split(" ");

            for(int j=0;j<2;j++){
                int start = Integer.parseInt(info[0]);
                int end = Integer.parseInt(info[1]);
                connected[start-1][end-1]=true;
                connected[end-1][start-1]=true;
            }
        }

        bfs(v,visited,connected);
    }
}
