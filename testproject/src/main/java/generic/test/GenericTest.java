package generic.test;

import com.test.pakcage.A;

public class GenericTest {
    public static void main(String[] args) {
//        AbstractList<String> stringAbstractList = new AbstractList<>();
//        stringAbstractList.add("hello");
//        System.out.println(stringAbstractList.getList());

//        AbstractList abstractList = new AbstractList();
//        abstractList.add("hello");
//        abstractList.add(1);
//        System.out.println(abstractList.getList());

        AbstractList abstractList = new AbstractList<Integer>();
        System.out.println(new AbstractList<Integer>());
        abstractList.add("add");
        abstractList.add(3.14D);
        System.out.println(abstractList.getList());



    }
}
