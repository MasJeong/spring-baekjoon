package springbasic.basic.study.sort.heap;

import java.util.PriorityQueue;

/**
 * 선택 정렬
 * 2. 선택 정렬 (Selection Sort)
 * 3. 삽입 정렬 (Insertion Sort)
 * 4. 거품 정렬 (Bubble Sort)
 * 5. 셸 정렬 (Shell Sort)
 * 6. 힙 정렬 (Heap Sort) - 최소힙 구현
 * 7. 합병(병합) 정렬 (Merge Sort)
 * 8. 퀵 정렬 (Quick Sort)
 *
 */
public class HeapSort {
	// 부모 인덱스를 얻는 함수
	private static int getParent(int child) {
		return (child - 1) / 2;
	}

	// 두 인덱스의 원소를 교환하는 함수
	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}


	// 힙을 만드는 함수
	private static void heapify(int[] a, int parentIdx, int lastIdx) {

		/*
		 * 현재 트리에서 부모 노드의 자식노드 인덱스를 각각 구해준다.
		 * 현재 부모 인덱스를 가장 큰 값을 갖고있다고 가정한다.
		 */
		int leftChildIdx = 2 * parentIdx + 1;
		int rightChildIdx = 2 * parentIdx + 2;
		int largestIdx = parentIdx;

		/*
		 *  left child node와 비교
		 *
		 *  자식노드 인덱스가 끝의 원소 인덱스를 넘어가지 않으면서
		 *  현재 가장 큰 인덱스보다 왼쪽 자식노드의 값이 더 클경우
		 *  가장 큰 인덱스를 가리키는 largestIdx를 왼쪽 자식노드인덱스로 바꿔준다.
		 *
		 */
		if(leftChildIdx <= lastIdx && a[largestIdx] < a[leftChildIdx]) {
			largestIdx = leftChildIdx;
		}

		/*
		 *  left right node와 비교
		 *
		 *  자식노드 인덱스가 끝의 원소 인덱스를 넘어가지 않으면서
		 *  현재 가장 큰 인덱스보다 오른쪽 자식노드의 값이 더 클경우
		 *  가장 큰 인덱스를 가리키는 largestIdx를 오른쪽 자식노드인덱스로 바꿔준다.
		 *
		 */
		if(rightChildIdx <= lastIdx && a[largestIdx] < a[rightChildIdx]) {
			largestIdx = rightChildIdx;
		}

		/*
		 * largestIdx 와 부모노드가 같지 않다는 것은
		 * 위 자식노드 비교 과정에서 현재 부모노드보다 큰 노드가 존재한다는 뜻이다.
		 * 그럴 경우 해당 자식 노드와 부모노드를 교환해주고,
		 * 교환 된 자식노드를 부모노드로 삼은 서브트리를 검사하도록 재귀 호출 한다.
		 */
		if(parentIdx != largestIdx) {
			swap(a, largestIdx, parentIdx);
			heapify(a, largestIdx, lastIdx);
		}
	}

	/**
	 * heap: 최솟값 또는 최댓값을 빠르게 찾아내기 위해 완전이진트리 형태로 만들어진 자료구조.
	 * heap 정렬을 알기 전 이진트리 개념이 필요하다.
	 * - 이진 트리: 모든 노드의 최대 차수를 2로 제한한 것
	 * - 완전이진트리: 마지막 레벨을 제외한 모든 노드가 채워져있어야 함.
	 * ㄴ 모든 노드들은 왼쪽부터 채워져있어야 함
	 * - 포화이진트리: 마지막 레벨을 제외한 모든 노드는 두 개의 자식노드를 갖는다.
	 *
	 * [성질]
	 * 1. 왼쪽 자식 노드 인덱스 = 부모 노드 인덱스 × 2 + 1
	 * 2. 오른쪽 자식 노드 인덱스 = 부모 노드 인덱스 × 2 + 2
	 * 3. 부모 노드 인덱스 = (자식 노드 인덱스 - 1) / 2
	 *
	 * [구현1] - 최대 힙 만들기(완전 정렬된 상태가 아니기 떄문에(형제노드).
	 * 1. 가장 작은 서브트리부터 최대 힙을 만족하도록 진행한다.
	 */
	public static void main(String[] args) {
		int[] arr = {3, 7, 5, 4, 2, 8};
		System.out.print(" 정렬 전 original 배열 : ");
		for(int val : arr) {
			System.out.print(val + " ");
		}

		PriorityQueue<Integer> heap = new PriorityQueue<Integer>();

		// 배열을 힙으로 만든다.
		for(int i = 0; i < arr.length; i++) {
			heap.add(arr[i]);
		}

		// 힙에서 우선순위가 가장 높은 원소(root노드)를 하나씩 뽑는다.
		for(int i = 0; i < arr.length; i++) {
			arr[i] = heap.poll();
		}

		System.out.print("\n 정렬 후 배열 : ");
		for(int val : arr) {
			System.out.print(val + " ");
		}
	}
}
