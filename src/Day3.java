import java.util.*;

public class Day3 {

}

class Solution {

    public static void main(String[] args) {
        System.out.println("asdas");
    }
    public static void main(String[] args) {
        System.out.println("qweqwe");
        }

    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {

            if (rev < -Math.pow(2, 31) / 10 || rev > (Math.pow(2, 31) - 1) / 10) {
                return 0;
            }

            int yu = x % 10;
            x /= 10;

            rev = rev * 10 + yu;
        }
        return rev;
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        if (x == rever(x)) {
            return true;
        }


        return false;
    }

    public int rever(int x) {
        int res = 0;

        while (x != 0) {
            int yu = x % 10;
            x = x / 10;
            res = res * 10 + yu;
        }

        return res;
    }

//    3
//    面积取决于短板。①因此即使长板往内移动时遇到更长的板，矩形的面积也不会改变；遇到更短的板时，面积会变小。②因此想要面积变大，
//
//    只能让短板往内移动(因为移动方向固定了)，当然也有可能让面积变得更小，但只有这样才存在让面积变大的可能性

    public int maxArea(int[] height) {
        int s = 0;
        int i = 0;
        int j = height.length - 1;

        while (i < j) {

            if (height[i] < height[j]) {
                s = Math.max(s, (j - i) * height[i++]);
            } else {
                s = Math.max(s, (j - i) * height[j--]);
            }


        }

        return s;
    }

    //    4
    public String longestCommonPrefix(String[] strs) {
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != c || i == strs[j].length()) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];
    }

    //    5
    public List<List<Integer>> threeSum(int[] nums) {


        List<List<Integer>> rs = new ArrayList<>();

        if (nums == null || nums.length < 3)
            return rs;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > 0) {
                break;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];

                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    rs.add(list);

                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }

                    l++;
                    r--;

                } else if (sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }


        }

        return rs;

    }

    //    6
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3)
            return 0;

        int res = nums[0] + nums[1] + nums[2];

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];

                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }

                if (sum == target)
                    return res;
                else if (sum < target)
                    l++;
                else
                    r--;

            }

        }

        return res;

    }

    //    7
    public List<String> letterCombinations(String digits) {

        List<String> res = new ArrayList<>();
        if (digits.length() == 0)
            return res;
        Map<Character, String> map = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        StringBuffer s = new StringBuffer();

        back(res, map, 0, s, digits);

        return res;

    }

    public static void back(List<String> res, Map<Character, String> map, int index, StringBuffer s, String digits) {
        if (index == digits.length()) {
            res.add(s.toString());
        } else {
            char number = digits.charAt(index);
            String letter = map.get(number);
            for (int i = 0; i < letter.length(); i++) {
                s.append(letter.charAt(i));
                back(res, map, index + 1, s, digits);
                s.deleteCharAt(s.length() - 1);
            }
        }
    }

    //   8
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode fast = newHead;
        ListNode low = newHead;

        while (n != 0) {
            fast = fast.next;
            n--;
        }

        while (fast.next != null) {
            fast = fast.next;
            low = low.next;
        }

        low.next = low.next.next;

        return newHead.next;

    }

    //9
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        StringBuffer s = new StringBuffer();

        backGen(list, n, 0, 0, 0, s);

        return list;
    }

    public void backGen(List<String> list, int n, int index, int zuo, int you, StringBuffer s) {
        if (index == n * 2) {
            list.add(s.toString());
        } else {
            if (zuo < n) {
                s.append('(');
                zuo++;
                backGen(list, n, index + 1, zuo, you, s);
                s.deleteCharAt(s.length() - 1);
                zuo--;
            }
            if (you < n && zuo > you) {
                s.append(')');
                you++;
                backGen(list, n, index + 1, zuo, you, s);
                s.deleteCharAt(s.length() - 1);
                you--;
            }
        }
    }

//    10

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0) {
            return null;
        }
        return mergre(lists, 0, lists.length - 1);
    }

    public ListNode mergre(ListNode[] lists, int l, int r) {

        if (l >= r) {
            return lists[l];
        }

        int mid = (l + r) / 2;

        return mergreTwo(mergre(lists, l, mid), mergre(lists, mid + 1, r));
    }

    public ListNode mergreTwo(ListNode lists1, ListNode lists2) {

        ListNode head = new ListNode(-1);
        ListNode r = head;


        while (lists1 != null && lists2 != null) {
            if (lists1.val < lists2.val) {
                r.next = lists1;
                lists1 = lists1.next;
            } else {
                r.next = lists2;
                lists2 = lists2.next;
            }
            r = r.next;
        }

        if (lists1 != null) {
            r.next = lists1;
        }
        if (lists2 != null) {
            r.next = lists2;
        }

        return head.next;
    }

    //    11
    public static int removeDuplicates1(int[] nums) {

        if (nums.length < 2)
            return nums.length;

        int de = 0;
        for (int i = 1; i < nums.length; i++) {
            if (i == nums.length - de)
                break;

            if (nums[i] == nums[i - 1]) {
                de++;
                for (int j = i; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                i--;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);

        }
        return nums.length - de;
    }

    public static int removeDuplicates(int[] nums) {

        if (nums == null && nums.length < 2)
            return 0;

        int l = 0;
        int r = 1;

        while (r < nums.length) {
            if (nums[r] == nums[l]) {
                r++;
            } else {
                nums[l + 1] = nums[r];
                l++;
                r++;
            }
        }
        return l + 1;
    }

    //    12
    public int removeElement(int[] nums, int val) {
        if (nums == null)
            return 0;

        int l = 0;
        int r = 0;

        while (r < nums.length) {
            if (nums[r] == val) {
                r++;
            } else {
                nums[l] = nums[r];
                l++;
                r++;
            }
        }
        return l;
    }

    //    13
    public int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            for (int j = 0; j < needle.length(); j++) {
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    break;
                }
                if (j == needle.length() - 1)
                    return i;
            }
        }

        return -1;
    }

    //    14
    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode pre = newHead;
        ListNode p = newHead.next;

        while (pre != null && p != null) {
            if(p.next ==null)
                break;
            ListNode temp = p.next;
            p.next = temp.next;
            temp.next = p;
            pre.next = temp;


            pre = pre.next.next;
            p = p.next;
        }

        return newHead.next;
    }

//    15

    public ListNode mergeTwoLists(ListNode lists1, ListNode lists2) {

        ListNode head = new ListNode(-1);
        ListNode r = head;

        while (lists1 != null && lists2 != null) {
            if (lists1.val < lists2.val) {
                r.next = lists1;
                lists1 = lists1.next;
            } else {
                r.next = lists2;
                lists2 = lists2.next;
            }
            r = r.next;
        }

        if (lists1 != null) {
            r.next = lists1;
        }
        if (lists2 != null) {
            r.next = lists2;
        }

        return head.next;
    }
    public static void main(String[] args) {

    }
}


