package baekjoon.gold3;

import java.io.*;

public class baek1005 {
    /*
    * 알고리즘
    * 타겟이 되는 집 을 찾고,
    * 그 집을 가르키고 있는 모든 다른 집들을 찾는다
    * 정답을 리턴할 answer 변수에 위에서 구한 다른 집들의 건설 시간 중 가장 큰 수를 더한다
    *
    * 연결된 집 찾는 알고리즘:
    *   rule[1]이 자신과 같으면 연결 됨
    *   지었으면 해당 집이 지어졌다는 내용을 담을 boolean[] 을 업데이트
    * */

    static int houses;
    static int rules;
    static int[] prices;
    static int[][] rule;
    static int target;

    static boolean[] constructed;

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
                rule[k]=new int[]{Integer.parseInt(ruleinfo[0]),Integer.parseInt(ruleinfo[1])};                         // x,y => x가 있으면 y 를 지을 수 있다.
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
