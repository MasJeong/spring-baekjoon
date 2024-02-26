package springbasic.basic.study.baekjoon.silver.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 단어 뒤집기 2 - 자료구조 TODO 진행중
 */
public class _17413 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        Stack<Character> firstStack = new Stack<>();

        String s = br.readLine();

        // 괄호 없는 경우
        if (!s.contains("<")) {
            st = new StringTokenizer(s);
            while (st.hasMoreTokens()) {
                String token = st.nextToken();

                for (int i = 0; i < token.length(); i++) {
                    firstStack.push(token.charAt(i));
                }

                for (int i = 0; i < token.length(); i++) {
                    sb.append(firstStack.pop());
                }
                sb.append(" ");
            }

            System.out.println(sb);
            br.close();
            return;
        }


//        System.out.println(String.valueOf(arr));
        br.close();
    }
}
