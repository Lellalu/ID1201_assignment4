# ID1201_assignment4
This is an assignemnt for the course ID1201, Algorithms and Data Structures, at KTH Royal Institute of Techonology. 
This assignment is about implementing and exploring the linked list.

## How run

This is an example of how to compile and test this project.

```bash
mvn clean && mvn compile && mvn test
```

In main, we have implemented three benchmarks: benchmarkFixedB() is appending a fixed length list to a variable length list, benchmarkFixedA() is appending variable length list to a fixed length list, and benchmarkArrayVsList() compares allocating n items for linked list and array, see [Main.java](https://github.com/Lellalu/ID1201_assignment4/blob/main/src/main/java/se/kth/id1201/Main.java) 
for more details. To run this:

```bash
mvn exec:java 
```