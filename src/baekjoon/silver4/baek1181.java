package baekjoon.silver4;

import java.io.*;
import java.util.*;

public class baek1181 {
    public void answer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        String[] words = new String[n];
        for(int i=0;i<n;i++){
            words[i]=br.readLine();
        }

        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()){
                    return o1.compareTo(o2);
                }
                else{
                    return o1.length()-o2.length();
                }
            }
        });

        for(int i=0;i<n;i++){
            if(i==n-1){
                wr.write(words[i]);
                break;
            }

            else if(words[i].equals(words[i+1])){
                continue;
            }

            else{
                wr.write(words[i]+"\n");
            }

        }
        wr.close();
    }
}
