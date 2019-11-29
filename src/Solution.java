import java.beans.IntrospectionException;
import java.util.*;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode (int val,TreeNode left,TreeNode right)
    {
        this.val=val;
        this.left=left;
        this.right=right;
    }
}
class Element{
    TreeNode node;
    int level;
    Element (TreeNode node,int level){
        this.node=node;
        this.level=level;
    }
}
public class Solution {
    public static List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> retList=new ArrayList<>();
        if(root==null){
            return retList;
        }
        Queue<Element> queue=new LinkedList<>();
        Element e=new Element(root,0);
        e.node=root;
        e.level=0;
        queue.add(e);
        while(!queue.isEmpty()){
        Element front=queue.poll();
            if(front.level==retList.size()){
                retList.add(new ArrayList<>());
            }
            retList.get(front.level).add(front.node .val);
            if(front.node.left!=null) {
            Element l = new Element(root,0);
            l.node = front.node.left;
            l.level = front.level + 1;
            queue.add(l);
            }
            if(front.node.right!=null) {
                Element d = new Element(root,0);
                d.node = front.node.right;
                d.level = front.level + 1;
                queue.add(d);
            }
        }
        return  retList;
    }
     public static void preOrderTraversal(TreeNode root){
        if(root==null){
            return;
        }
        System.out.println(root.val);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
     }
      public static boolean isEmpty(TreeNode root){

        return root==null;
      }
      public static  void inOrderTraversal(TreeNode root){
        if(root==null){
            return ;
        }
        inOrderTraversal(root.left);
        System.out.println(root.val);
        inOrderTraversal(root.right);

}
      public static void postOrderTraversal(TreeNode root){
        if(root==null){
            return;
        }
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
        System.out.println(root.val);
}
      public static List<Integer> preOrder(TreeNode root){
        if(root==null){
            return new ArrayList<>();
        }
        List<Integer> list=new ArrayList<>();
        List<Integer> leftPreOrder=preOrder(root.left);
        List<Integer> rightPreOrder=preOrder(root.right);
        list.add(root.val);
        list.addAll(leftPreOrder);
        list.addAll(rightPreOrder);
        return list;
}
      public static int getHeight(TreeNode root){
        if(root==null){
            return 0;
        }
        int nl=getHeight(root.left);
        int nr=getHeight(root.right);
        return nl>nr?nl+1:nr+1;

      }
      public static int size(TreeNode root){
        if(root==null){
            return 0;
        }
        int sLeft=size(root.left);
        int sRight=size(root.right);
        return sLeft+sRight+1;

      }
      public static boolean findKey(TreeNode root,int val){
       if(root==null){
           return false;
       }else if(root.val==val){
           return true;
          }else{
           if( findKey(root.left,val)){
               return true;
           }
           return  findKey(root.right,val);
       }
      }
    public static void main(String[] args) {
        TreeNode node5=new TreeNode(5,null,null);
        TreeNode node4=new TreeNode(4,null,node5);
        TreeNode node3=new TreeNode(3,null,null);
        TreeNode node7=new TreeNode(7,null,null);
        TreeNode node6=new TreeNode(6,null,node7);
        TreeNode node2=new TreeNode(2,node3,node6);
        TreeNode node1=new TreeNode(1,node4,node2);
        System.out.println(isEmpty(node1));
        preOrderTraversal(node1);
        System.out.println("====================");
        inOrderTraversal(node1);
        System.out.println("====================");
        postOrderTraversal(node1);
        System.out.println("====================");
        System.out.println(preOrder(node1));
        System.out.println("====================");
        System.out.println(levelOrder(node1));
        System.out.println("二叉树的高度");
        System.out.println(getHeight(node1));
        System.out.println("二叉树的结点数量");
        System.out.println(size(node1));
        System.out.println("查找二叉树中是否有7");
        System.out.println(findKey(node1,7));
    }
}