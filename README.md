# CIT300 Data Structure & Graph Performance Analyzer

## Project Description
This is a Java console-based application developed for the CIT300 Data Structures and Algorithms Graded Practical Assignment 2.

The system demonstrates:
- Array operations
- Stack operations
- Queue operations
- Linked List operations
- Linear Search
- Binary Search
- Graph representation
- BFS traversal
- DFS traversal
- Performance / complexity comparison
- Input validation
- Integrated console menu

## Team Members and Responsibilities

### Member 1
**Student ID:** 23DA2-0546  
**Name:** A.B.M Suhair  

**Assigned Responsibility:**  
Array, Searching, Performance Comparison, Main Menu Integration and Testing

**Individual Contribution:**
- Implemented ArrayManager
- Implemented Linear Search
- Implemented Binary Search
- Implemented search step and execution-time measurement
- Implemented PerformanceAnalyzer
- Implemented the main console menu
- Integrated all members' components
- Performed final system testing

### Member 2
**Student ID:** 23DA2-0557  
**Name:** M.M Manaseer  

**Assigned Responsibility:**  
Stack and Queue

**Individual Contribution:**
- Implemented StackManager
- Implemented push, pop, peek and display
- Implemented QueueManager
- Implemented enqueue, dequeue, peek/front and display
- Added empty stack/queue validation
- Tested stack and queue operations

### Member 3
**Student ID:** 23DA2-0845  
**Name:** A.P Sabras  

**Assigned Responsibility:**  
Linked List

**Individual Contribution:**
- Implemented LinkedListManager
- Implemented linked list insertion
- Implemented deletion
- Implemented searching
- Implemented display
- Tested linked list functionality

### Member 4
**Student ID:** 23DA2-0581  
**Name:** T. Apna  

**Assigned Responsibility:**  
Graph and Graph Traversal

**Individual Contribution:**
- Implemented GraphManager
- Implemented adjacency-list graph representation
- Implemented add vertex
- Implemented add edge
- Implemented graph display
- Implemented BFS traversal
- Implemented DFS traversal
- Tested graph functionality

## Technologies Used
- Java
- VS Code
- Git
- GitHub

## Requirements
- JDK 17 or later recommended
- VS Code with Extension Pack for Java

## How to Run
Open the project folder in VS Code.

From the terminal:

```bash
cd src
javac *.java
java Main
```

Or open `Main.java` and click **Run**.

## Main Menu
1. Array Operations
2. Stack Operations
3. Queue Operations
4. Linked List Operations
5. Searching Operations
6. Graph Operations
7. Performance Comparison
8. Display All Results
9. Exit

## Complexity Notes
- Array search: O(n)
- Stack push/pop: O(1) amortized for normal operations
- Queue enqueue: O(1) amortized; this simple array implementation shifts items on dequeue, so dequeue is O(n)
- Linked List insertion at end: O(n) in this implementation
- Linked List search: O(n)
- Linear Search: O(n)
- Binary Search: O(log n) on sorted data
- BFS: O(V + E)
- DFS: O(V + E)

## Collaboration
Each member should work on an individual Git branch and create meaningful commits. Pull requests should be used to merge completed work into `main`.
