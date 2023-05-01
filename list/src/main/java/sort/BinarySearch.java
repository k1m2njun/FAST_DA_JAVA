package sort;
public class BinarySearch {

    public int search(int[] arr, int target) {
        // 1. 데이터 중간 인덱스 값을 찾는다.
        // 2. 중간 인덱스 위치를 기준으로 arr를 절반으로 나눈다.
        // 3. 나눈 리스트에서 target 값을 찾는다.

        int left = 0;
        int right = arr.length - 1;

        int middle;

        while(left <= right) {
            middle = (left + (right - left) / 2);

            if (arr[middle] == target) {
                return middle;
            }

            if (arr[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }
}
