import java.util.*;

/**
 * @Author: yangbo
 * @Description:
 * @Date: Create in 2020/6/23 16:08
 */
public class Main {

    public static void main(String[] args) {
        /*
        *   void reverse(List list)//反转
            void shuffle(List list)//随机排序
            void sort(List list)//按自然排序的升序排序
            void sort(List list, Comparator c)//定制排序，由Comparator控制排序逻辑
            void swap(List list, int i , int j)//交换两个索引位置的元素
            void rotate(List list, int distance)//旋转。当distance为正数时，将list后distance个元素整体移到前面。当distance为负数时，将 list的前distance个元素整体移到后面。

            int binarySearch(List list, Object key)//对List进行二分查找，返回索引，注意List必须是有序（元素有序）的
            int max(Collection coll)//根据元素的自然顺序，返回最大的元素。 类比int min(Collection coll)
            int max(Collection coll, Comparator c)//根据定制排序，返回最大元素，排序规则由Comparatator类控制。类比int min(Collection coll, Comparator c)
            void fill(List list, Object obj)//用指定的元素代替指定list中的所有元素。
            int frequency(Collection c, Object o)//统计元素出现次数
            int indexOfSubList(List list, List target)//统计target在list中第一次出现的索引，找不到则返回-1，类比int lastIndexOfSubList(List source, list target).
            boolean replaceAll(List list, Object oldVal, Object newVal), 用新元素替换旧元素
        * */
        String[] arr = {"a","c","b","d"};
        List<String> list = Arrays.asList(arr);
        Collections.reverse(list);
        System.out.println("reverse : " + list);
        Collections.shuffle(list);
        System.out.println("shuffle : " + list);
        Collections.swap(list,1,3);
        System.out.println("swap 1,3: " + list);
        Collections.rotate(list,2);
        System.out.println("rotate 2: " + list);

        Collections.sort(list);
        System.out.println("sort : " + list);
        System.out.println("binarySearch 'c' : " + Collections.binarySearch(list, "c"));
        System.out.println("max : " + Collections.max(list));
        System.out.println("frequency 'a': " + Collections.frequency(list, "a"));
        System.out.println("indexOfSublist 'b' : " + Collections.indexOfSubList(list, new ArrayList(){{add("b");}}));
        Collections.fill(list,"c");
        System.out.println("fill 'c': " + list);
        Collections.replaceAll(list, "c" ,"a");
        System.out.println("replaceAll 'c' 'a': " + list);


        Map<String,String> map = Collections.emptyMap();
        System.out.println("emptyMap : " + map);
        List<String> list1 = Collections.singletonList("a");
        System.out.println("singletonList : " + list1);
        List<String> list2 = Collections.unmodifiableList(list);
        System.out.println("unmodifiableList : " + list2);

        String[] arr1 = {"b","d","c","a"};
        /*Arrays.sort(arr1);
        System.out.println("sort arr : " + Arrays.asList(arr1));*/
        Arrays.sort(arr1,1,3);
        System.out.println(Arrays.asList(arr1));
        Arrays.parallelSort(arr1,2,4);
        System.out.println(Arrays.asList(arr1));


        String[] arr2 = Arrays.copyOfRange(arr1,1,3);
        System.out.println(Arrays.asList(arr2));

        list.subList(1,3);
    }


}
