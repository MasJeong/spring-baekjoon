package springbasic.basic.study.baekjoon.silver.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 균형잡힌세상 TODO 작업중
 */
public class _4949 {

    private static final char[] stack = new char[100];

    private static int pointer = -1;

    private static int size = 0;

    private static void push(char val) {
        stack[++pointer] = val;
        size++;
    }

    private static char pop() {
        if (size == 0) {
            return '\0';
        }

        size--;
        return stack[pointer--];
    }

    private static boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str;

        while ((str = br.readLine()) != null) {
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);

                if (ch == '(') {
                    push(ch);
                } else if (ch == ')') {
                    char data = pop();

                    // pop 실패 시
                    if(data == '\0') {
                        sb.append("no");
                        break;
                    }
                }
            }

            if (isEmpty()) {
                sb.append("yes");
            }
        }

        System.out.println(sb);
        br.close();
    }
}
