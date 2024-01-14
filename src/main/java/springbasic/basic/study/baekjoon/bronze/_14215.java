package springbasic.basic.study.baekjoon.bronze;

import java.io.*;
import java.util.StringTokenizer;

public class _14215 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nMax = -1;
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        nMax = nMax < a ? a : nMax;
        nMax = nMax < b ? b : nMax;
        nMax = nMax < c ? c : nMax;

        // 가장 긴 변의 길이가 다른 변의 길이의 합보다 작아야 한다
        if((a + b + c - nMax) > nMax)
            System.out.println(a + b + c);
        else
            System.out.println((a + b + c - nMax) * 2 - 1);

        br.close();
    }

}
