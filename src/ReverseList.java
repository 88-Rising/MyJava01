import java.util.List;

class Listnode{
    int val;
    Listnode next=null;
    Listnode(int val,Listnode next){
       this.val=val;
       this.next=next;
   }
}
public class ReverseList {
    public static void display(Listnode head){
        for(Listnode cur=head;cur!=null;cur=cur.next){
            System.out.printf("(%d)->",cur.val);
        }
        System.out.println("null");

    }
    // prev 上一个结点
    // curr 当前节点
    // nextTemp 临时结点由于保存当前结点的指针域
      public static Listnode reverseList(Listnode head){
          Listnode prev=null;
          Listnode curr=head;
          while(curr!=null){
              Listnode nextTemp=curr.next;
              curr.next=prev;
              prev=curr;
              curr=nextTemp;
          }
          return prev;
      }
     public static void main(String[] args) {
         Listnode node3=new Listnode(3,null);
         Listnode node2=new Listnode(2,node3);
         Listnode node1= new Listnode(1,node2);
         display(node1);
         node1=reverseList(node1);
         display(node1);


    }

}
