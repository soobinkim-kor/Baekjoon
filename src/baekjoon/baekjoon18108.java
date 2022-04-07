package baekjoon;
import java.io.*;

public class baekjoon18108 {
    public void answer() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        String age = br.readLine();
        int answer = Integer.parseInt(age)-543;
        System.out.println(answer);
        wr.write(answer);

        br.close();
        wr.close();
    }

}
