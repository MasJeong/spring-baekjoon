package springbasic.basic.study.baekjoon.silver.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 큐 - 자료구조
 * 원형큐 구현 - 용량을 동적 할당하는 메소드까지 구현한다.
 */
public class _10845_circularQueue {

    private static int[] queue;

    // 큐 첫 번째 인덱스(빈 공간)
    private static int front = 0;
    // 큐 마지막 인덱스
    private static int rear = 0;
    // 큐 요소 개수
    private static int size = 0;

    /**
     * queue 용량을 재설정한다(up, down).
     * @param newCapacity 새로운 용량크기
     */
    private static void resize(int newCapacity) {
        int[] newQueue = new int[newCapacity];

        /*
            기존 큐에 존재하던 데이터를 복사한다.
            새로운 큐에는 front가 0이고 첫 번째 인덱스부터 값을 세팅한다.
         */
        for (int i = 1, j = front + 1; i <= size; i++, j++) {
            newQueue[i] = queue[j % size];
        }

        queue = newQueue;

        front = 0;

        // 용량이 더 커졌기 때문에 1자로 데이터가 나열되었기 때문에 rear = size
        rear = size;
    }

    /**
     * offer: 큐 마지막에 요소를 추가한다.
     * @param val 추가할 요소 값
     */
    private static void offer(int val) {
        // 용량이 가득찬 경우 용량을 2배로 동적 할당한다.
        if (front == (rear + 1) % queue.length) {
            resize(queue.length * 2);
        }

        rear = (rear + 1) % queue.length;

        queue[rear] = val;
        size++;
    }

    /**
     * poll: 큐의 첫 번째 요소를 삭제하고 삭제 된 요소를 반환한다.
     * @return 큐의 첫 번째 요소
     */
    private static int poll() {
        if (size <= 0) {
            return -1;
        }

        // 공백(front) 다음 값을 가져온 후 0(or 빈값)으로 초기 세팅한다.
        front = (front + 1) % queue.length;
        int element = queue[front];

        queue[front] = 0;


        // 요소 개수가 1/4 미만일 경우 용량(사이즈)를 1/2로 줄인다.
        if(size < (queue.length / 4)) {
            resize(queue.length / 2);
        }

        return element;

//        if(front > rear) {
//            return -1;
//        }
//
//        size--;
//        return queue[front++];
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
     * @return 큐의 첫 번째 요소
     */
    private static int peek() {
        if(size <= 0) {
            return -1;
        }

        return queue[front];
    }

    private static int front() {
        if(size <= 0) {
            return -1;
        }

        return queue[front];
    }

    private static int back() {
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
        queue = new int[cmd];

        for(int i = 0; i < cmd; i++) {
            st = new StringTokenizer(br.readLine());

            String str = st.nextToken();
            switch (str) {
                case "push":
                    offer(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(poll()).append("\n");
                    break;
                case "size":
                    sb.append(size()).append("\n");
                    break;
                case "empty":
                    sb.append(empty()).append("\n");
                    break;
                case "front":
                    sb.append(front()).append("\n");
                    break;
                case "back":
                    sb.append(back()).append("\n");
                    break;
            }
        }

        System.out.println(sb);
        br.close();
    }
}
