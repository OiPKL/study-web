package swea;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static List<Long> note = new ArrayList<>();
    static long sum = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();

        for (int tc = 1; tc <= TC; tc++) {
            int N = sc.nextInt();
            long A = sc.nextLong();

            // 초기화
            note.clear();
            note.add(0L); // 0번 인덱스는 사용하지 않음
            note.add(A);
            sum = A;

            for (int n = 0; n < N; n++) {
                long b = sc.nextLong();
                long c = sc.nextLong();

                // 두 숫자를 추가
                note.add(b);
                note.add(c);

                // 중간값 찾기
                findMiddle(1);

                // 중간값을 sum에 추가
                sum += note.get(1);
            }

            System.out.println("#" + tc + " " + sum % 20171109);
        }
        sc.close();
    }

    static void findMiddle(int idx) {
        if (idx * 2 >= note.size()) return;

        // 왼쪽 자식과 오른쪽 자식의 인덱스
        int leftIdx = idx * 2;
        int rightIdx = idx * 2 + 1;

        // 현재 부모 노드와 자식 노드들의 값을 가져옴
        long parent = note.get(idx);
        long leftChild = note.get(leftIdx);
        long rightChild = (rightIdx < note.size()) ? note.get(rightIdx) : Long.MAX_VALUE;

        // 정렬: leftChild <= parent <= rightChild
        if (parent > rightChild && rightIdx < note.size()) {
            note.set(idx, rightChild);
            note.set(rightIdx, parent);
            findMiddle(rightIdx);
        }
        if (parent < leftChild) {
            note.set(idx, leftChild);
            note.set(leftIdx, parent);
            findMiddle(leftIdx);
        }
    }
}
