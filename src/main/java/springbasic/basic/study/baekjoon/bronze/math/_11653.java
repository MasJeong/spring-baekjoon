package springbasic.basic.study.baekjoon.bronze.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 소인수분해 - 수학
 */
public class _11653 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if(n == 1) return;

        StringBuilder sb = new StringBuilder();
        for(int i = 2; i <= Math.sqrt(n); i++) {
            while(n % i == 0) {
                sb.append(i).append('\n');
                n /= i;
            }
        }

        // for 종료 후 n이 1이 아니면 소수임
        if(n != 1) {
            sb.append(n);
        }

        System.out.println(sb);

        br.close();
    }

}
