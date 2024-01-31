package springbasic.basic.study.baekjoon.bronze.bruteforce;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// TODO x=(c*e-b*f)/(a*e-b*d)
// y= (c*d -a*f)/(db-ae)
public class _19532 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());

        Loop1:
        for(int i = -999; i <= 999; i++)
            Loop2:
            for(int j = -999; j <= 999; j++)
                if((a * i + b * j == c) && (d * i + e * j == f)) {
                    bw.write(i + " " + j);
                    break Loop1;
                }

        br.close();
        bw.flush();
        bw.close();
    }

}
