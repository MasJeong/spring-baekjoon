package springbasic.basic.study.baekjoon.bronze;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arrCard = new int[n];

        int idx = 0;
        while(st.hasMoreTokens()) {
            arrCard[idx++] = Integer.parseInt(st.nextToken());
        }

        br.close();
//        bw.write(Integer.toString(max));
        bw.flush();
        bw.close();
    }
}
