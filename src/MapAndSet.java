import java.util.HashMap;
import java.util.Map;

class Employee{
    private int id;
    private String ename;
    private double salary;
    public Employee(int id,String ename,Double salary){
        super();
        this.id=id;
        this.ename=ename;
        this.salary=salary;
    }

    @Override
    public String toString() {
        return "id："+id+"ename："+ename+"salary："+salary;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getEname(){
        return ename;
    }
    public void setEname(String ename){
        this.ename=ename;
    }
    public double getSalary(){
        return salary;
    }
    public void setSalary(double salary){
        this.salary=salary;
    }
}



//Map 就是用来存储 键值对 的  Map类中存储的键值对通过键来标识 所以键对象不能重复
//测试 HashMap 的使用
public class MapAndSet {
    public static void main(String[] args) {
        Map<Integer,String> m1=new HashMap<>();
        m1.put(1,"one");
        m1.put(2,"two");
        m1.put(3,"three");
            //put存放键值对 get通过键值对查找对象 remove删除键对象对对应的值
        m1.get(1);
        System.out.println(m1.get(1));
        System.out.println(m1.size());
        System.out.println(m1.isEmpty());
        System.out.println(m1.containsKey(2));
        System.out.println(m1.containsValue("one"));
        Map<Integer,String> m2=new HashMap<>();
        m2.put(4,"si");
        m2.put(5,"wu");
        m2.put(6,"liu");
        m1.putAll(m2);
        //键是不能重复的 如果重复则新的会覆盖旧的 判断是否重复是使用equals方法来判断
        System.out.println(m1);

        Employee e1=new Employee(1001,"小人",2000.0);
        Employee e2=new Employee(1002,"大人",3000.0);
        Employee e3=new Employee(1003,"人",4000.0);

        System.out.println(e1.hashCode());//哈希码 利用哈希码计算(计算余数)出哈希值根据哈希值 把Entry对象存到数组索引位置
        //若计算的哈希值相同 则以链表的方式在后面加  （最好使用散列算法而不是计算余数）
        //如果哈希值每次都是相同的数字，键值对象都会存到数组索引相同的位置，这样的话会形成一个非常长的链表，相当于会发生哈希冲突
        //此时 HashMap会退化成为一个链表 这是一个极端的情况

        Map<Integer,Employee> map=new HashMap<>();
        map.put(1001,e1);
        map.put(1002,e2);
        map.put(1003,e3);
        Employee emp=map.get(1001);
        System.out.println(emp.getEname());
        System.out.println(map);
    }

}
