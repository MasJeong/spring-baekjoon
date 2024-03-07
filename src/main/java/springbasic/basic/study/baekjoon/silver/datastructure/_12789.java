package springbasic.basic.study.baekjoon.silver.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 도키도키 간식드리미 - 스택 큐 덱 TODO 작업중
 */
public class _12789 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        final StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt = 1;
        final Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());

            if (input != cnt) {
                while (!stack.isEmpty() && stack.peek() == cnt) {
                    stack.pop();
                    cnt++;
                }

                stack.push(input);
            } else {
                cnt++;
            }
        }

        /*
        예시
        4
        4 2 1 3
         */
        
        int[] arrTemp = new int[n];
        int idx = 0;
        while (!stack.isEmpty()) {
            arrTemp[idx++] = stack.pop();
        }

        if (idx <= 1) {
            if (stack.pop() == cnt) {
                System.out.println("Nice");
            } else {
                System.out.println("Sad");
            }
        }

        for (int i = 0; i < idx - 1; i++) {
            if (arrTemp[i] >= arrTemp[i + 1]) {
                System.out.println("Sad");
                break;
            }
        }

        System.out.println("Nice");

        br.close();
    }
}
