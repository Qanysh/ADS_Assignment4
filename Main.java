public class Main {
    public static void main(String[] args) {
        MyBST<Integer, String> tree = new MyBST<>();
        tree.put(5, "Apple");
        tree.put(3, "Banana");
        tree.put(7, "Cherry");

        for (MyBST.MyNode<Integer, String> node : tree) {
            System.out.println("Key: " + node.getKey() + ", Value: " + node.getValue());
        }
    }
}
