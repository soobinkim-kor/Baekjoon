package baekjoon.gold3;

import java.io.*;

public class baek1005 {
    static int houses;
    static int rules;
    static int[] prices;
    static int[][] rule;
    static int target;
    public static void answer() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        int testcase= Integer.parseInt(br.readLine());      //테스트 케이스
        for(int i=0;i<testcase;i++){
            String[] info = br.readLine().split(" ");
            houses = Integer.parseInt(info[0]);         // 건물 갯수
            rules = Integer.parseInt(info[1]);          // 규칙 갯수
            prices = new int[houses+1];                 // 건물 건설 비용 ( 0은 제외. 인덱스 1 = 1번 건물 )
            String[] pricesinfo = br.readLine().split(" ");
            for(int j=0;j<houses;j++){
                prices[j+1]=Integer.parseInt(pricesinfo[j]);
            }

            rule = new int[rules][2];


            for(int k=0;k<rules;k++){
                String ruleinfo[] = br.readLine().split(" ");
                rule[k]=new int[]{Integer.parseInt(ruleinfo[0]),Integer.parseInt(ruleinfo[1])};
            }

            target=Integer.parseInt(br.readLine());

            System.out.println(houses+" "+rules);

            for(int data:prices){
                System.out.print(data+" ");
            }
            System.out.println(" ");
            for(int[] data:rule){
                System.out.println(data[0]+" "+data[1]);
            }

            System.out.println(target);
        }
    }
}
