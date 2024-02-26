package springbasic.basic.study.baekjoon.silver.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 단어 뒤집기 2 - 자료구조 TODO 진행중~
 */
public class _17413 {

    private static char[] stack;
    private static int pointer = -1;
    private static int size = 0;

    private static void push(char val) {
        stack[++pointer] = val;
        size++;
    }

    private static char pop() {
        if(pointer < 0) {
            return '\0';
        }

        size--;
        return stack[pointer--];
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();

        stack = new char[s.length()];

        // 조건 if 안에 for문 안에 StringTokenizer
        for (int i = 0; i < s.length(); i++) {

        }


        System.out.println(sb);
        br.close();
    }
}
