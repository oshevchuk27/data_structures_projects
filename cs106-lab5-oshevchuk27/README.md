## CS 106 Lab 5 - Binary Trees

Name: Olga Shevchuk

Number of Late Days Using for this lab:

--0-

### Analysis Questions

1. In Lab 3 we used insertion sort with Linked Lists to gradually build up
a sorted list of names. If the total number of names is n, what was the big-O runtime
of this algorithm? Briefly explain your answer.

The runtime of that method was O(n^2) because we have to make n comparisons for each of the n elements we are adding to the list. In the worst case we might go all the way until the end to place a name. 

2. In this assignment (Lab 5) we used insertion sort with a Binary Tree, then
used a tree traversal to obtain a sorted list of candidates. If the total
number of candidates is n, what is the big-O runtime of this algorithm? Briefly 
explain your answer.

The runtime of the algorithm is O(nlog(n)). We have n candidates and each of them have to be inserted up to depth. The runtime of tree traversal is O(n) because we have to go through each of the elements in the tree. However, this does not add up much to the overall runtime because O(nlog(n)) + O(n) (approx) O(nlog(n)).

### Lab Questionnaire

(None of your answers below will affect your grade; this is to help refine lab
assignments in the future)

1. Approximately, how many hours did you take to complete this lab? (provide
  your answer as a single integer on the line below)
  10

2. How difficult did you find this lab? (1-5, with 5 being very difficult and 1
  being very easy)
  3

3. Describe the biggest challenge you faced on this lab:
The biggest challenge was implementing the remove method.

4. Was the **VerifyFormat** file useful to you during testing?
Yes
