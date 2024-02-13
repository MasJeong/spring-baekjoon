package springbasic.basic.study.baekjoon.silver.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 스택 수열 - 자료구조
 */
public class _1874 {

    private static int pointer = -1;
    private static int size = 0;

    private static void push(int[] stack, int val) {
        stack[++pointer] = val;
        size++;
    }

    private static int pop(int[] stack) {
        if(pointer < 0) {
            return -1;
        }

        size--;
        return stack[pointer--];
    }

    private static int size() {
        return size;
    }

    private static int empty() {
        if(size <= 0) {
            return 1;
        }

        return 0;
    }

    private static int top(int[] stack) {
        if(size <= 0) {
            return -1;
        }

        return stack[size - 1];
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        /*
            push, push, push, push, pop, pop, push, push, pop, push, push, pop, pop, pop, pop, pop
            [4, 3, 6, 8, 7, 5, 2, 1]
         */

        int n = Integer.parseInt(br.readLine());
        int[] stack = new int[n];
        int num = 1;

        for(int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());

            // TODO 위 주석처리된 예제를 해당하게 소스 작성해보자 
            if (top(stack) == num) {
                pop(stack);
                sb.append("-").append("\n");
            } else {
                push(stack, num++);
                sb.append("+").append("\n");
            }
        }

        System.out.println(sb);
        br.close();
    }
}
