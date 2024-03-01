package springbasic.basic.study.baekjoon.silver.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 쇠막대기 - 자료구조
 */
public class _10799 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*
            ()(((()())(())()))(()) -> 17
            레이저가 발생한 경우 여태까지 나온 그리고 닫히지 않은 '(' 문자의 개수 + 1 - 보류
            레이저가 나오면 스택에 있는 '(' 개수 3 * 2
            - 연속된 레이저의 경우 + 3
            - 레이저가 나왔는데 스택 사이즈가 1이면 + 2
         */
        // TODO 아이디어 다시 생각해보자
        Stack<Character> openStack = new Stack<>();
        String s = br.readLine();
        int answer = 0;

        // 연속적인 레이저 개수
        int continuousRazer = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                // 연속적으로 레이저가 발생하지 않은 경우
                if (s.charAt(i + 1) != ')') {
                    continuousRazer = 0;
                }
                openStack.push(ch);
            }
            else {
                // 연속적으로 레이저가 발생한 경우
                if (continuousRazer > 1) {
                    openStack.pop();
                    answer = answer + openStack.size() * 2;
                    continue;
                }

                // 레이저가 발생한 경우
                if (openStack.peek() == '(') {
                    openStack.pop();

                    // ( 1개만 남은 경우
//                    if (openStack.size() == 1) {
//
//                    }

                    continuousRazer++;

                    if (!openStack.isEmpty()) {
                        answer += openStack.size();
                    }
                } else {
                    // 닫힌 괄호 2번 이상 나온 상태
                    continuousRazer = 0;
                }
            }
        }

        System.out.println(answer);
        br.close();
    }
}
