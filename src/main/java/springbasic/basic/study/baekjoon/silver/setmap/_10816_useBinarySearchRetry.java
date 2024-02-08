package springbasic.basic.study.baekjoon.silver.setmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 숫자카드2 - 집합과 맵
 */
public class _10816_useBinarySearchRetry {

    // TODO upperBound, lowerBound 구현
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] target = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        while(n-- > 0) {
            target[n] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(target);

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        while(m-- > 0) {

        }

        System.out.println(sb);

        br.close();
    }

}
