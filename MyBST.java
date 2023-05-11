import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class MyBST<K extends Comparable<K>, V> implements Iterable<MyBST.MyNode<K, V>> {
    private MyNode<K, V> root;
    private int size;
    public static class MyNode<K, V> {
        private K key;
        private V value;
        private MyNode<K, V> left, right;

        public MyNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }


    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("Null key not allowed");
        }
        if (value == null) {
            delete(key);
            return;
        }
        root = put(root, key, value);
    }

    private MyNode<K, V> put(MyNode<K, V> node, K key, V value) {
        if (node == null) {
            size++;
            return new MyNode<>(key, value);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }
        return node;
    }

    public V get(K key) {
        MyNode<K, V> node = get(root, key);
        return node == null ? null : node.value;
    }

    private MyNode<K, V> get(MyNode<K, V> node, K key) {
        while (node != null) {
            int cmp = key.compareTo(node.key);
            if (cmp < 0) {
                node = node.left;
            } else if (cmp > 0) {
                node = node.right;
            } else {
                return node;
            }
        }
        return null;
    }

    public void delete(K key) {
        root = delete(root, key);
    }

    private MyNode<K, V> delete(MyNode<K, V> node, K key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = delete(node.left, key);
        } else if (cmp > 0) {
            node.right = delete(node.right, key);
        } else {
            size--;
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            MyNode<K, V> temp = node;
            node = min(temp.right);
            node.right = deleteMin(temp.right);
            node.left = temp.left;
        }
        return node;
    }

    public int size() {
        return size;
    }

    public Iterator<MyNode<K, V>> iterator() {
        return new InOrderIterator<>(root);
    }

    private MyNode<K, V> min(MyNode<K, V> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private MyNode<K, V> deleteMin(MyNode<K, V> node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        return node;
    }

    private static class InOrderIterator<K, V> implements Iterator<MyNode<K, V>> {
        private final Stack<MyNode<K, V>> stack;

        public InOrderIterator(MyNode<K, V> root) {
            stack = new Stack<>();
            pushLeft(root);
        }

        private void pushLeft(MyNode<K, V> node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        public MyNode<K, V> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            MyNode<K, V> node = stack.pop();
            pushLeft(node.right);
            return node;
        }
    }
}
