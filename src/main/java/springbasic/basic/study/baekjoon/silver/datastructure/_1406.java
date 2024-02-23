package springbasic.basic.study.baekjoon.silver.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 에디터 - 자료구조
 */
public class _1406 {

    private static char[] stack;
    private static int pointer = -1;
    private static int size = 0;

    private static void push(char val) {
        // L 겁나 눌러서 pointer 음수이면 맨 앞에 1개 데이터세팅
        if (pointer < 0) {
            char[] newStack = new char[stack.length];

            for (int i = 0; i < size; i++) {
                newStack[i + 1] = stack[i];
            }

            stack = newStack;

            pointer = -1;
        }

        stack[++pointer] = val;
        size++;
    }

    private static int pop() {
        if(pointer < 0) {
            return -1;
        }

        size--;
        stack[pointer] = '\0';
        return stack[pointer--];
    }

    private static int size() {
        return size;
    }

    private static int top() {
        if(size <= 0) {
            return -1;
        }

        return stack[size - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        /*
            L	커서를 왼쪽으로 한 칸 옮김 (커서가 문장의 맨 앞이면 무시됨)
            D	커서를 오른쪽으로 한 칸 옮김 (커서가 문장의 맨 뒤이면 무시됨)
            B	커서 왼쪽에 있는 문자를 삭제함 (커서가 문장의 맨 앞이면 무시됨) - 이부분 유의하자.
            삭제로 인해 커서는 한 칸 왼쪽으로 이동한 것처럼 나타나지만, 실제로 커서의 오른쪽에 있던 문자는 그대로임
            P $	$라는 문자를 커서 왼쪽에 추가함
         */
        String n = br.readLine();
        int m = Integer.parseInt(br.readLine());
        stack = new char[n.length() + m];
        StringTokenizer st;

        // 처음 입력받은 문자열 push
        for (int i = 0; i < n.length(); i++) {
            char ch = n.charAt(i);
            push(ch);
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            char cmd = st.nextToken().charAt(0);

            switch (cmd) {
                case 'L':
                    if (pointer < 0) break;

                    // Todo L: 왼쪽 공백푸쉬, R: 오른쪽 공백푸쉬로 진행해보자 
                    // 요솟수가 존재한다면 우측으로 1칸씩 옮겨준다.
//                    if(stack[pointer] != '\0') {
//                        for (int i = pointer; i < size; i++) {
//                            char temp = stack[i + 1];
//                            stack[i + 1] = stack[i];
//                            stack[i] = temp;
//                        }
//                    }

                    pointer--;
                    break;
                case 'D':
                    pointer++;
                    break;
                case 'B':
                    if (pointer < 0) break;

                    pop();
                    break;
                case 'P':
                    push(st.nextToken().charAt(0));
                    break;
            }
        }

        for (int i = 0; i < size(); i++) {
            sb.append(stack[i]);
        }
        System.out.println(sb);
        br.close();
    }
}