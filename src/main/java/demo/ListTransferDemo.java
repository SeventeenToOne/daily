package demo;

import edu.princeton.cs.algs4.In;
import org.apache.commons.collections.CollectionUtils;

import java.util.*;

public class ListTransferDemo {

    public void demo(List<Persion> list) {
        System.out.println(list);
        deal1(list);
        deal2(list);
        System.out.println(list);
    }

    public void deal1(List<Persion> list) {
        Persion persion = list.get(0);
        persion.setAge(10);
    }

    public void deal2(List<Persion> list) {
        Iterator<Persion> iterator =  list.iterator();
        while (iterator.hasNext()) {
            Persion persion = iterator.next();
            if (persion.getName().equals("xiaoming")) {
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2);

        List<Integer> list2 = null;
        System.out.println(CollectionUtils.retainAll(list1, list2));

        list2 = new LinkedList<>();
        list2.add(123);
        System.out.println(CollectionUtils.retainAll(list1, list2));
    }

}

class Persion {
    private String name;
    private Integer age;

    public Persion(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Persion{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
