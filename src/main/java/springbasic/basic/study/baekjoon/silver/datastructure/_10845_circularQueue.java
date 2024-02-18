package springbasic.basic.study.baekjoon.silver.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 큐 - 자료구조
 * 원형큐 구현 TODO 작업중
 */
public class _10845_circularQueue {

    // 큐 첫 번째 인덱스(빈 공간)
    private static int front = 0;
    // 큐 마지막 인덱스
    private static int rear = -1;
    // 큐 요소 개수
    private static int size = 0;

    /**
     * offer: 큐 마지막에 요소를 추가한다.
     * @param queue 큐 배열
     * @param val 추가할 요소 값
     */
    private static void push(int[] queue, int val) {
        queue[++rear] = val;
        size++;
    }

    /**
     * poll: 큐의 첫 번째 요소를 삭제하고 삭제 된 요소를 반환한다.
     * @param queue 큐 배열
     * @return 큐의 첫 번째 요소
     */
    private static int pop(int[] queue) {
        if(front > rear) {
            return -1;
        }

        size--;
        return queue[front++];
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

    /**
     * peek: 큐의 첫 번째 요소를 반환한다.
     * @param queue 큐 배열
     * @return 큐의 첫 번째 요소
     */
    private static int front(int[] queue) {
        if(size <= 0) {
            return -1;
        }

        return queue[front];
    }

    private static int back(int[] queue) {
        if(size <= 0) {
            return -1;
        }

        return queue[rear];
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int cmd = Integer.parseInt(br.readLine());
        int[] queue = new int[cmd];

        for(int i = 0; i < cmd; i++) {
            st = new StringTokenizer(br.readLine());

            String str = st.nextToken();
            switch (str) {
                case "push":
                    push(queue, Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(pop(queue)).append("\n");
                    break;
                case "size":
                    sb.append(size()).append("\n");
                    break;
                case "empty":
                    sb.append(empty()).append("\n");
                    break;
                case "front":
                    sb.append(front(queue)).append("\n");
                    break;
                case "back":
                    sb.append(back(queue)).append("\n");
                    break;
            }
        }

        System.out.println(sb);
        br.close();
    }
}
