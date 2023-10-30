package zuochengyun_new.class06;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Code01_ShowComparator {

    public static class Student {
        public String name;
        public int id;
        public int age;

        public Student(String name, int id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "b";
        System.out.println(str1.compareTo(str2));
        //大根堆
        PriorityQueue<Student> heap = new PriorityQueue<>((o1, o2) -> o2.id - o1.id);
        Student s1 = new Student("张三", 5, 27);
        Student s2 = new Student("李四", 1, 17);
        Student s3 = new Student("王五", 4, 29);
        Student s4 = new Student("赵六", 3, 9);
        Student s5 = new Student("左七", 2, 34);
        heap.add(s1);
        heap.add(s2);
        heap.add(s3);
        heap.add(s4);
        heap.add(s5);
        System.out.println("=========");
        while (!heap.isEmpty()) {
            Student s = heap.poll();
            System.out.println(s.name + ", " + s.id + ", " + s.age);
        }
    }

}
