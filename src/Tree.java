import java.util.*;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Tree {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param args TreeNode类
     * @return int整型一维数组
     *
     */
    public static void main(String[] args) {
        System.out.println("asd");
        System.out.println("asd2");
        System.out.println("asd4");
    }
    public int[] postorderTraversal(TreeNode root) {
        // write code here

        List<Integer> list = preorder(root);
        System.out.println(list);
        int a[] = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            a[i] = list.get(i);

        }

        return a;

    }

    public List<Integer> preorder(TreeNode root) {
        // write code here

        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        list.addAll(preorder(root.left));
        list.addAll(preorder(root.right));
        list.add(root.val);


        return list;

    }

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write code here


        ArrayList<ArrayList<Integer>> arrayListArrayList = new ArrayList<>();

        if (root == null) {
            return arrayListArrayList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode p = null;

        while (!queue.isEmpty()) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                p = queue.poll();

                arrayList.add(p.val);

                if (p.left != null) {
                    queue.add(p.left);
                }
                if (p.right != null) {
                    queue.add(p.right);
                }
            }

            arrayListArrayList.add(arrayList);

        }

        return arrayListArrayList;

    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        ArrayList<ArrayList<Integer>> rs = new ArrayList<>();

        if (pRoot == null) {
            return rs;
        }

        Queue<TreeNode> q = new LinkedList<>();

        q.add(pRoot);

        boolean flag = true;
        while (!q.isEmpty()) {

            int n = q.size();
            flag = !flag;

            ArrayList<Integer> row = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode p = q.poll();
                row.add(p.val);
                if (p.left != null) {
                    q.add(p.left);
                }
                if (p.right != null) {
                    q.add(p.right);
                }
            }


            if (flag == true) {
                Collections.reverse(row);
            }

            rs.add(row);

        }

        return rs;
    }

    public int maxDepth(TreeNode root) {
        // write code here
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return left > right ? left + 1 : right + 1;
    }

    public boolean hasPathSum (TreeNode root, int sum) {
        // write code here
        if (root == null ){
            return false;
        }

        if(sum - root.val == 0 && root.left==null&&root.right==null)
            return true;

        return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val);
    }
}