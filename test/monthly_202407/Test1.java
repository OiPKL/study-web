
public class Test1 {

	public static void main(String[] args) {
		
		// 배열 선언
		int[] intArr = new int[] {2, 19, 1, 90, 24, 51, 4, 77};
		int[] intArr2 = new int[intArr.length];		// 크기 순으로 정렬된 intArr
		int[] pair1 = new int[2];	// {1, 8} -> 1번째로 큰값, 8번째로 큰값
		int[] pair2 = new int[2];	// {2, 7}
		int[] pair3 = new int[2];	// {3, 6}
		int[] pair4 = new int[2];	// {4, 5}

		int idx2 = 0;
		for (int i = 0; i < intArr.length; i++) {
			
			int max = intArr[0];
			int idx = 0;
			for (int j = 0; j < intArr.length; j++) {
				
				// intArr 배열에서 가장 큰값을 max 에 저장하고
				// 해당하는 intArr 인덱스를 0으로 변경, intArr2 배열에 복사
				if (intArr[j] > max) {
					max = intArr[j];
					idx = j;
				}
				
			}
			
			intArr2[idx2++] = intArr[idx];
			intArr[idx] = 0;
			
		}
		
		// 페어 저장
		pair1[0] = intArr2[0];
		pair2[0] = intArr2[1];
		pair3[0] = intArr2[2];
		pair4[0] = intArr2[3];
		pair1[1] = intArr2[4];
		pair2[1] = intArr2[5];
		pair3[1] = intArr2[6];
		pair4[1] = intArr2[7];
		
		///
//		int max2 = 
		
	}
}
