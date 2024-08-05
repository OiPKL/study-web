package practice;

import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int valExt, String sortBy) {
                
        // 조건 충족 code idx 추출
        List<int[]> filteredIdxArr = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            if (ext.equals("code")      && data[i][0] < valExt)
                filteredIdxArr.add(data[i]);
            else if (ext.equals("date")      && data[i][1] < valExt)
                filteredIdxArr.add(data[i]);
            else if (ext.equals("maximum")   && data[i][2] < valExt)
                filteredIdxArr.add(data[i]);
            else if (ext.equals("remain")    && data[i][3] < valExt)
                filteredIdxArr.add(data[i]);
        }
        
        // 정렬 기준 idx
        int sortIdx = 0;
        if (sortBy.equals("code"))
            sortIdx = 0;
        else if (sortBy.equals("date"))
            sortIdx = 1;
        else if (sortBy.equals("maximum"))
            sortIdx = 2;
        else if (sortBy.equals("remain"))
            sortIdx = 3;
        
        // 조건 충족 code idx -> 조건 충족 data[][]
        int n = filteredIdxArr.size();
        int[][] filteredData = new int[n][4];
        for (int i = 0; i < n; i++){
            filteredData[i] = filteredIdxArr.get(i);
        }

        // 정렬
        int[][] orderedData = Sort.selectionSort(filteredData, sortIdx);
        
        return orderedData;            
    }
}

class Sort {    // sortNum : 0 = code, 1 = date, 2 = maximum, 3 = remain
    public static int[][] selectionSort(int[][] data, int sortIdx){
        
        int n = data.length;
        for (int i = 0; i < n; i++){
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (data[minIdx][sortIdx] > data[j][sortIdx])
                    minIdx = j;
            }
            // Swap data[i] and data[minIdx]
            int[] tmp = data[i];
            data[i] = data[minIdx];
            data[minIdx] = tmp;
        }
        
        return data;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] data = {{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}};
        int[][] result = solution.solution(data, "date", 20300501, "remain");
        
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}
