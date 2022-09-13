package demo;

import java.util.*;
import java.util.stream.Collectors;

import edu.princeton.cs.algs4.In;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import sun.jvm.hotspot.jdi.ArrayReferenceImpl;
import sun.tools.jconsole.ProxyClient;


public class DataOrderDemo {
    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();
        l1.add(70001);
        List<Integer> test = new ArrayList<>();

        List<Integer> l2 = new ArrayList<>();
        l2.add(1003);
        l2.add(10002);
        System.out.println(l1.addAll(l2));
        test.addAll(l2);
        new ArrayList<>().add(7001);

        List<Integer> single = Collections.singletonList(123);
        List<Integer> list = new ArrayList<>();
        list.addAll(single);
        list.addAll(l2);
        System.out.println(list);

        List<Integer> virParam = new ArrayList<>();
        List<Integer> isVirtualList = Optional.ofNullable(virParam).orElse(new ArrayList<>());
        System.out.println(CollectionUtils.isEmpty(isVirtualList));
        System.out.println(isVirtualList == null);
        CollectionUtils.addIgnoreNull(isVirtualList, 1);
        System.out.println(isVirtualList);


        List<Integer> virNull = null;
        List<Integer> virtualNullList = Optional.ofNullable(virNull).orElse(new ArrayList<>());
        System.out.println(CollectionUtils.isEmpty(virtualNullList));
        System.out.println(isVirtualList == null);
        CollectionUtils.addIgnoreNull(virtualNullList, null);
        System.out.println(virtualNullList);

        String[] actualSoldNumKdtIds = "123,1,1,1,3,4,5".split(",");
        if (0 == actualSoldNumKdtIds.length) {
            System.out.println("0 == actualSoldNumKdtIds.length");
        }
        System.out.println(Arrays.stream(actualSoldNumKdtIds).mapToLong(Long::parseLong).boxed().collect(Collectors.toSet()));
        Set<Long> testSet = Collections.emptySet();
        System.out.println(testSet.contains(123));


        List<Integer> testList = Arrays.asList(1, 2, 3, 4, 5);
        List<String> wordList = testList.stream()
                .map(String::valueOf)
                .limit(1)
                .collect(Collectors.toList());
        System.out.println(wordList);

        String str = " 9787535394255002 ";
        System.out.println(str);
        System.out.println(StringUtils.trim(str));

        Integer val = null;
        //System.out.println(Optional.of(val).orElse(1));

        User user = new User(null, null);
        User nullUser = null;
        //System.out.println(Optional.ofNullable(nullUser.getName()).orElse("123"));
        //System.out.println(Optional.ofNullable(nullUser.getName()).equals("123"));

        User user1 = new User("n1", "bir");
        Student stu = new Student();
        stu.setAge(1);
        stu.setName("23");
        print(user1, stu);
    }

    public static void print(Object o1, Object o2) {
        System.out.println(o1.toString());
        System.out.println(o2.toString());
    }

    public static void sort(List<User> list) {
        list.sort(Comparator.comparing(User::getBirthday).thenComparing(User::getName));
        //System.out.println(list);
    }
}

class Student {

    private String name;

    private Integer age;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
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

    public void setAge(Integer age) {
        this.age = age;
    }

}

class User {

    private String name;
    private String birthday;

    public User(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                '}' + "\n";
    }
}

