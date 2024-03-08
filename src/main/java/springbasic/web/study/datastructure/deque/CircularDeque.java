package springbasic.web.study.datastructure.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 덱 - 자료구조
 */
public class CircularDeque {

    private static int[] queue;

    // 큐 첫 번째 인덱스(빈 공간)
    private static int front = 0;
    // 큐 마지막 인덱스
    private static int rear = 0;
    // 큐 요소 개수
    private static int size = 0;

    private static void offerFirst(int val) {
        // front위치 빈공간이기 때문에 값 추가 후 front 앞 공간 생성
        queue[front] = val;
        front = (front - 1 + queue.length) % queue.length;
        size++;
    }

    private static void offerLast(int val) {
        rear = (rear + 1) % queue.length;
        queue[rear] = val;
        size++;
    }

    private static int pollFirst() {
        if (size <= 0) {
            return -1;
        }

        front = (front + 1) % queue.length;
        int element = queue[front];

        queue[front] = 0;
        size--;

        return element;
    }

    private static int pollLast() {
        if (size <= 0) {
            return -1;
        }

        int element = queue[rear];
        queue[rear] = 0;

        rear = (rear - 1 + queue.length) % queue.length;

        size--;

        return element;
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

    private static int peekFirst() {
        if(size <= 0) {
            return -1;
        }

        return queue[(front + 1) % queue.length];
    }

    private static int peekLast() {
        if(size <= 0) {
            return -1;
        }

        return queue[(rear) % queue.length];
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int cmd = Integer.parseInt(br.readLine());
        queue = new int[cmd];

        for(int i = 0; i < cmd; i++) {
            st = new StringTokenizer(br.readLine());

            String str = st.nextToken();
            switch (str) {
                case "push_front":
                    offerFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    offerLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    sb.append(pollFirst()).append("\n");
                    break;
                case "pop_back":
                    sb.append(pollLast()).append("\n");
                    break;
                case "size":
                    sb.append(size()).append("\n");
                    break;
                case "empty":
                    sb.append(empty()).append("\n");
                    break;
                case "front":
                    sb.append(peekFirst()).append("\n");
                    break;
                case "back":
                    sb.append(peekLast()).append("\n");
                    break;
            }
        }

        System.out.println(sb);
        br.close();
    }
}
