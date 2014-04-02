package marcUtil;

import java.util.Arrays;

import java.util.Collection;

import java.util.Date;

import java.util.HashMap;

import java.util.Iterator;

import java.util.Map;

import java.util.Set;

import java.util.Vector;

public class GenericTest {

    public static void main(String[] args) {

       //Map接口并没有去实现Iterable接口，所以不能迭代，要交给Set集合完成

       HashMap<String, Integer> maps = new HashMap<String, Integer>();

       maps.put("张三", 29);

       maps.put("李四", 32);

       maps.put("王五", 33);

       Set<Map.Entry<String, Integer>> entrySet = maps.entrySet();

       for (Map.Entry<String, Integer> entry: entrySet) {

           System.out.println(entry.getKey() + ":" + entry.getValue());

       }

       add(3, 5); //->Integer

       add(3.5, 3); //->Number

       add(3, "abc"); //->Object

       String[] s = new String[]{"abc","xyz","itcast"};

       swap(s,1,2);

       System.out.println(Arrays.asList(s));

       

//     swap(new int[]{1,3,5,4,5},3,4); 这样做不行，泛型接受的必须是引用类型，下面的可行

       Integer[] integer = new Integer[]{1,2,3};

       swap(integer, 1, 2);

       System.out.println(Arrays.asList(integer));   

       Object obj = "abc";

       String x3 = autoConvert(obj);   

//     copyArrayToArray(new Date[10], s); 会报错？

//     copyArrayToArray(new Vector<Date>(), new String[10]); 限定了只能传Date

       Vector<String> vs = new Vector<String>();

       copyCollectionToArray(vs, s); //将S数组中的数据复制到了可变数组中

       /*

       for (int i = 0; i < vs.size(); i++) {

           System.out.println(vs.get(i));

       }

       */

       Iterator<String> it =  vs.iterator();

       while(it.hasNext()) {

           System.out.println(it.next());

       }

    }

    private static <T> T add(T x, T y) {

       return x;

    }

    private static <T> void swap(T[] a,int i, int j) {

       T tmp = a[i];

       a[i] = a[j];

       a[j] = tmp;

    }

    /*

    private static <T extends Exception> sayHello() throws T {

       try {

           

       }catch (Exception e) {

           thorw (T)e;

       }

    }*/

    /**

     * 编写一个泛型方法，自动将Object类型的对象转换成其它类型

     */

    private static <T> T autoConvert(Object obj) {

       return (T) obj;

    }   

    /**

     * 定义一个方法，可以将任意类型的数组中的所有元素填充为想方相应类型的某个对象

     */

    private static <T> void fillArray(T[] a, T obj) {

       for (int i = 0; i < a.length; i++) {

           a[i] = obj;

       }

    }

    public static void printCollection(Collection<?> collection) {

       System.out.println(collection.size());

       for(Object obj: collection) {

           System.out.println(obj);

       }

    }

    public static <T> void printCollection2(Collection<T> collection, T obj2) {

       System.out.println(collection.size());

       for(Object obj: collection) {

           System.out.println(obj);

       }

       collection.add(obj2);

    }

    /**

     * 把任意参数类型的一个数组中的数据安全地复制到相应类型的别一个数组中

     * @param <T>

     * @param desc

     * @param src

     */

    public static <T> void copyArrayToArray(T[] desc, T[] src) {

       for (int i = 0; i < src.length; i++) {

           desc[i] = src[i];

       }

    }

    /**

     * 把任意参数类型的一个数组中的数据安全地复制到相应类型的集合中

     * @param <T>

     * @param desc

     * @param src

     */

    public static <T> void copyCollectionToArray(Collection<T> desc, T[] src) {

       for(int i = 0; i < src.length; i++) {

           desc.add(src[i]);

       }

    }

}

