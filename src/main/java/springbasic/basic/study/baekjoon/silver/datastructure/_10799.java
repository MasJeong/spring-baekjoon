package springbasic.basic.study.baekjoon.silver.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 쇠막대기 - 자료구조 TODO 작업중
 */
public class _10799 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();
        String s = br.readLine();
        int length = s.length();

        while (length-- > 0) {
//            char ch = s.charAt(length);
//
//            if (ch == '(') {
//                // 막대기가 존재함.
//                while (!stack.isEmpty()) {
//                    
//                }
//
//                stack.push(ch);
//            }
//
//            if (ch == ')') {
//                if (stack.pop() == '(') {
//                    isRazer = true;
//                }
//            }
        }


        System.out.println(sb);
        br.close();
    }
}
