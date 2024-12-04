[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/ymuo-0J4)

[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/4TIv-oW9)

<center><h1>PROGRAMMING ASSIGNMENT 11
<br/><br/>HASHING</h1>

**Due: Wednesday, December 11th, 2024, 2:30 PM**

</center>
<br/>

<br/>

In this assignment, you are to implement two classes: `HashSet` and `HashMap` that internally use hashing to store String data. 

In Java, you can convert any String to an integer using sum of ASCII values. To get the ASCII value of a character, you can use the `char` data type and cast it to an `int`. For example, the following code snippet converts a character to its ASCII value:

```java
char ch = 'a';
int ascii = (int) ch;
```

The hash function should be the remainder of the division of the hash code of the element by the size of the array. Initialize the size of an array to a prime number to reduce the number of collisions. 

## Q1. HashSet

Implement a **HashSet** class that internally uses hashing to store elements in an array of linked lists. The `HashSet` class should have the following methods:

- `size()`: Returns the number of elements in the set.

- `isEmpty()`: Returns a boolean indicating whether the set is empty.

- `add(String s)`: Adds the element `e` to the set if it is not already present.

- `remove(String s)`: Removes the element `e` from the set if it is present.

- `contains(String s)`: Returns a boolean indicating whether the set contains the element `e`.

- `clear()`: Removes all elements from the set.

- `toArray()`: Returns an array containing all the elements in the set.

- `intersection(HashSet other)`: Returns a new `HashSet` containing the intersection of the current set and the `other` set.

- `union(HashSet other)`: Returns a new `HashSet` containing the union of the current set and the `other` set.

- `difference(HashSet other)`: Returns a new `HashSet` containing the difference of the current set and the `other` set.

- `subset(HashSet other)`: Returns a boolean indicating whether the current set is a subset of the `other` set.

## Q2. HashMap

Implement a **HashMap** class that internally uses hashing to store key-value pairs in an array of linked lists. The `HashMap` class should have the following public methods:

- `size()`: Returns the number of entries in the map.

- `isEmpty()`: Returns a boolean indicating whether the map is empty.

- `get(String key)`: Returns the value associated with the key `key`, if such an entry exists; otherwise, returns `null`.

- `put(String key, String value)`: If the map does not have an entry with key equal to `key`, then adds entry `(key, value)` to the map and returns `null`; else, replaces with `value` the existing value of the entry with key equal to `key` and returns the old value.

- `remove(String key)`: Removes from the map the entry with key equal to `key`, and returns its value; if the map has no such entry, then returns `null`.

- `keySet()`: Returns all the keys stored in the map.

- `values()`: Returns all the values stored in the map.

--- 

Feel free to define any additional <u>private</u> helper methods or classes as needed. 

You are to write JUnit test cases in corresponding test classes for each of the four classes above. Make sure to test all the methods keeping in mind any <u>edge cases</u> that may arise.

---

## **Instructions**

1. Click on `Accept Assignment` at the link posted on Moodle. This is equivalent to forking the repository.</font>
2. Navigate to the repository you just forked. It should be named `pa11-<your-github-username>`
3. Click on the green `Code` button. Click on SSH tab and copy the SSH link (it is important to use SSH and not HTTPS).
4. Open the terminal on your computer and navigate to the folder where you want to clone the repository.
5. Run `git clone <copied-ssh-link>`. Replace `<copied-ssh-link>` with the link you copied in step 3.
6. In Visual Studio Code, click on File -> Open and open the folder of the repository. 

## Evaluation

Your submission will be evaluated based on the correctness **_and completeness_** of your implementation and test cases. If your implementation is correct but your test cases are incomplete, you will lose points. If your implementation is incorrect, you will lose even more points.

---