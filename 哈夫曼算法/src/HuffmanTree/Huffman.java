package HuffmanTree;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Created by zx on 16-11-5.
 */
public class Huffman {
    //TreeSet:排序  //无重复元素
    //
    static TreeSet<Item> treeSet = new TreeSet<>(new Comparator<Item>() {
        @Override
        public int compare(Item o1, Item o2) {
            return o1.value - o2.value;
        }
    });

    public static void main(String[] args) {

        init();
        solution();
    }

    //添加元素到 treeSet
    public static void init() {
        Item item1 = new Item();
        item1.setName('f');
        item1.setValue(5);
        Item item2 = new Item();
        item2.setName('e');
        item2.setValue(9);
        Item item3 = new Item();
        item3.setName('c');
        item3.setValue(12);
        Item item4 = new Item();
        item4.setName('b');
        item4.setValue(13);
        Item item5 = new Item();
        item5.setName('d');
        item5.setValue(16);
        Item item6 = new Item();
        item6.setName('a');
        item6.setValue(45);
        treeSet.add(item1);
        treeSet.add(item2);
        treeSet.add(item3);
        treeSet.add(item4);
        treeSet.add(item5);
        treeSet.add(item6);
    }

    public static void solution() {
        //treeSet.pollFirst()

        while (treeSet.size() != 1) {
            for (Item item : treeSet) {
                System.out.print(item.value);

            }
            System.out.println("");
            Item itemZ = new Item();
            itemZ.left = treeSet.pollFirst();
            System.out.println("left:" + itemZ.left.name);
            int left = itemZ.left.getValue();//left.value
            itemZ.right = treeSet.pollFirst();//right
            System.out.println("right:" + itemZ.right.name);
            int right = itemZ.right.getValue();//right.value
            itemZ.value = left + right;//
            itemZ.name=(char)itemZ.value;
            treeSet.add(itemZ);
        }
    }
}



