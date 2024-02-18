package springbasic.basic.study.baekjoon.silver.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 에디터 - 자료구조 // TODO 집에 가서 다시 풀자... 쉬운 것 같은데 집중이 안된다...
 */
public class _1406 {

    private static int pointer = -1;
    private static int size = 0;

    private static void push(char[] stack, char val) {
        stack[++pointer] = val;
        size++;
    }

    private static int pop(char[] stack) {
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

    private static int top(char[] stack) {
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
        char[] stack = new char[n.length() + m];
        StringTokenizer st;

        // 처음 입력받은 문자열 push
        for (int i = 0; i < n.length(); i++) {
            char ch = n.charAt(i);
            push(stack, ch);
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            char cmd = st.nextToken().charAt(0);

            switch (cmd) {
                case 'L':
                    if (pointer > 0) {
                        pointer--;
                    }
                    break;
                case 'D':
                    if(pointer + 1 != size()) {
                        pointer++;
                    }
                    break;
                case 'B':
                    pop(stack);
                    break;
                case 'P':
                    if(pointer + 1 != size()) {
                        // push 전에 1칸씩 뒤로 다 미뤄야 함
                        for (int i = pointer + 1; i < size(); i++) {
                            char temp = stack[i];
                            stack[i] = stack[i + 1];
                            stack[i + 1] = temp;
                        }

                        // TODO 이것도 생각해보자
                        // 위 포문에서 pointer + 1을 pointer로 변경하고 pointer를 1로 낮춘 후 push
                        // 즉, for문을 이용해 문자들 뒤로 밀고 앞 1자리 생긴 공간에 push를 하려고 해보자.
                        push(stack, st.nextToken().charAt(0));
                    } else {
                        push(stack, st.nextToken().charAt(0));
                    }
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