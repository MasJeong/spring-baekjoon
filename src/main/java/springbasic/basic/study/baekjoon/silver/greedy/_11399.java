package springbasic.basic.study.baekjoon.silver.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * ATM
 * 그리디 알고리즘이란
 * - 선택의 순간마다 당장 눈 앞에 보이는 최적의 상황을 쫓아 최적해를 구하는 알고리즘
 * - 순간마다 최선을 선택했다고 하나 최종적인 해답에서 최적이라고 보장은 없다.
 * 그리디 알고리즘 적용 조건
 * 1) 앞의 선택이 이후의 선택에 영향을 주면 안된다.
 * 2) 문제에 대한 최종 해결 방법은 부분 문제에 대한 최적 문제 해결 방법으로 구성된다.
 */
public class _11399 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] p = new int[n];
        int time = 0;
        int min = 0;

        // 입력
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < p.length; i++)
            p[i] = Integer.parseInt(st.nextToken());

        // TODO 수의 범위가 1000밖에 되지 않으니 카운팅정렬 사용해보자
        Arrays.sort(p);

        for(int i = 0; i < p.length; i++) {
            time += p[i];
            min += time;
        }

        br.close();
        bw.write(Integer.toString(min));
        bw.flush();
        bw.close();
    }
}
