package springbasic.basic.study.baekjoon.gold.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 오등큰수 - 자료구조
 */
public class _17299 {

    private static int[] stack;
    private static int pointer = -1;
    private static int size = 0;

    private static void push(int val) {
        stack[++pointer] = val;
        size++;
    }

    private static int pop() {
        if(pointer < 0) {
            return -1;
        }

        size--;
        return stack[pointer--];
    }

    public static void main(String[] args) throws IOException{
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringBuilder sb = new StringBuilder();

        final int COUNTING_MAX_SIZE = 1000001;

        int n = Integer.parseInt(br.readLine());
        stack = new int[n];

        int[] arrCounting = new int[COUNTING_MAX_SIZE];
        int[] arrOriginal = new int[n];
        int[] arrRealOrigin = new int[n];

        final StringTokenizer st = new StringTokenizer(br.readLine());

        // 카운팅 배열 생성
        for (int i = 1; i <= n; i++) {
            int input = Integer.parseInt(st.nextToken());

            arrCounting[input] += 1;
            arrOriginal[i - 1] = input;
            arrRealOrigin[i - 1] = input;
        }

        /*
         * 1 1 2 3 4 2 1
         * 3 3 2 1 1 2 3 - 만드는 과정
         * -1 -1 1 2 2 1 -1
         */
        for (int i = 0; i < n; i++) {
            arrOriginal[i] = arrCounting[arrOriginal[i]];
            push(arrOriginal[i]);
        }

        int[] arrResult = new int[n];
        arrResult[0] = -1;
        pop();

        int start = size;

        for (int i = start - 1; i >= 1; i--) {
            int num = pop();

            boolean isFind = false;
            for(int j = i + 1; j < n; j++) {
                if (arrOriginal[j] > num) {
                    isFind = true;
                    arrResult[i] = arrRealOrigin[j];
                    break;
                }
            }

            // 못찾은 경우
            if (!isFind) {
                arrResult[i] = -1;
            }
        }

        // 마지막인덱스도 -1
        arrResult[n - 1] = -1;

        for (int i = 0; i < arrResult.length - 1; i++) {
            sb.append(arrResult[i]).append(" ");
        }
        sb.append(arrResult[arrResult.length - 1]);

        System.out.println(sb);
        br.close();
    }
}
