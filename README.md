# Binary Search Tree (MyBST) Implementation
This is a Java implementation of a binary search tree (BST) called MyBST. The MyBST class provides methods for inserting, retrieving, and deleting key-value pairs in the tree. It also supports in-order traversal and iteration over the nodes of the tree.

# Features

Put: Inserts a key-value pair into the binary search tree.

Get: Retrieves the value associated with a given key from the binary search tree.

Delete: Removes a key-value pair from the binary search tree.

Size: Returns the number of nodes in the binary search tree.

In-order Traversal: Supports in-order traversal of the binary search tree.

Iterable: Implements the Iterable interface, allowing iteration over the nodes of the tree.


# Usage

To use the MyBST class, follow these steps:

Instantiate an object of the MyBST class:

MyBST<Integer, String> tree = new MyBST<>();

Insert key-value pairs into the tree using the put method:

tree.put(5, "Apple");

tree.put(3, "Banana");

tree.put(7, "Cherry");

Retrieve values by providing the key using the get method:

String value = tree.get(5); // Returns "Apple"

Delete key-value pairs from the tree using the delete method:

tree.delete(3);

Access the number of nodes in the tree using the size method:

int size = tree.size(); // Returns the current size of the tree

Iterate over the nodes of the tree using a foreach loop:

for (MyBST.Node<Integer, String> node : tree) {

    // Access key and value of each node
    
    int key = node.getKey();
    
    String value = node.getValue();
    
    // Perform desired operations with key and value
    
}

# Contributing

Contributions are welcome! If you find any issues or have suggestions for improvements, please feel free to open an issue or submit a pull request.
