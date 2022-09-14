

import javax.management.StandardEmitterMBean;
import java.util.*;


public class Search {

    public boolean Find(int target, int[][] array) {

        int n = array.length;
        int m = array[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (array[i][j] == target)
                    return true;
            }

        }


        return false;
    }

    public static int findPeakElement(int[] nums) {
        // write code here
        if (nums.length == 1)
            return 0;

        for (int i = 0; i < nums.length; i++) {
            if (i == 0 && nums.length == 1)
                return 0;

            if (i == 0 && nums[i] > nums[i + 1])
                return 0;

            if (i == nums.length - 1 && nums[i] > nums[i - 1]) {
                return i;
            }
            if (i != 0 && i != nums.length - 1 && nums[i] > nums[i - 1] && nums[i] > nums[i + 1])
                return i;

        }

        return -1;
    }

    public int InversePairs(int[] array) {

        return merge(array, new int[array.length], 0, array.length - 1);
    }

    public int merge(int[] array, int[] temp, int left, int right) {

        if (left >= right) {
            return 0;
        }

        int mid = (left + right) / 2;

        int res = merge(array, temp, left, mid) + merge(array, temp, mid + 1, right);

        res = res % 1000000007;

        for (int i = left; i <= right; i++) {
            temp[i] = array[i];
        }

        int l = left;
        int r = mid+1;
        for (int i = left; i <= right; i++) {
            if (l == mid + 1) {
                array[i] = temp[r];
                r++;
            } else if (r == right + 1) {
                array[i] = temp[l];
                l++;
            } else if (temp[l] < temp[r]) {
                array[i] = temp[l];
                l++;
            } else {
                array[i] = temp[r];
                r++;
                res = res + mid + 1 - l;
            }
        }

        return res % 1000000007;

    }

    public int minNumberInRotateArray1(int [] array) {
        int min = array[0];
        for (int i = 0; i < array.length; i++) {

            if(array[i] < min){
                min = array[i];
            }
        }

        return min;
    }

    public int minNumberInRotateArray(int [] array) {
        int l = 0;
        int r = array.length-1;

        int min = 0;

        while (l<=r){
            int mid = (l + r)/2;
            min = array[mid];

            if(array[mid] > array[r]){
                l = mid+1;
            }

            else if(array[mid] == array[r]){
                r--;
            }
            else {
                r = mid-1;
            }

        }
        return min;
    }

    public int[] twoSum (int[] numbers, int target) {
        // write code here

        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {

            int temp = target - numbers[i];
            if (map.containsKey(temp)){


                return new int[]{map.get(temp)+1,i+1};
            }
            else {
                map.put(numbers[i], i);
            }

        }
        return null;

    }

    public int MoreThanHalfNum_Solution(int [] array) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                int value = map.get(array[i])+1;
                map.put(array[i], value);
            } else {
                map.put(array[i], 1);
            }

            if(map.get(array[i])> array.length/2){
                return array[i];
            }

        }

        return 0;

    }

    public int[] FindNumsAppearOnce (int[] array) {
        // write code here
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i])) {
                map.put(array[i], 1);
            } else {
                System.out.println("ad");
                map.put(array[i],map.get(array[i])+1);
            }

        }

        List<Integer> list = new ArrayList<>();
        for (Integer key : map.keySet()) {
            if(map.get(key)==1){
                System.out.println(key+" "+map.get(key));
                list.add(key);
            }
        }

        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    public int minNumberDisappeared (int[] nums) {
        // write code here
        Map<Integer, Integer> map  = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],1);
        }

        int rs = 1;
        while (map.containsKey(rs)) {
            rs++;
        }
        return rs;
    }


    public static void main(String[] args) {
        int a[] = {1, 2, 1, 3, 5, 6, 4};
        System.out.println(findPeakElement(a));
    }
}
