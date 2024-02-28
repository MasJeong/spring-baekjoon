package springbasic.basic.study.baekjoon.silver.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 오큰수 - 자료구조
 */
public class _17298 {

    public static void main(String[] args) throws IOException{
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringBuilder sb = new StringBuilder();

        final Stack<Integer> firstStack = new Stack<>();
        final Stack<Integer> secondStack = new Stack<>();

        // TODO 2개의 스택을 사용해서 풀어보자
        int n = Integer.parseInt(br.readLine());
        final StringTokenizer st = new StringTokenizer(br.readLine());

        while (n-- > 0) {
            firstStack.push(Integer.parseInt(st.nextToken()));
        }


        System.out.println(sb);
        br.close();
    }
}
