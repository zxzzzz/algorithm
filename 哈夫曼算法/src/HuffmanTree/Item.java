package HuffmanTree;

/**
 * Created by zx on 16-11-6.
 */
public class Item{
    char name;
    int value;
    Item left;
    Item right;

    public char getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public Item getLeft() {
        return left;
    }

    public void setName(char name) {
        this.name = name;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setLeft(Item left) {
        this.left = left;
    }

    public void setRight(Item right) {
        this.right = right;
    }

    public Item getRight() {
        return right;
    }

}