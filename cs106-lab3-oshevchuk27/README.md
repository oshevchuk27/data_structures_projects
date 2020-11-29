## CS 106 Lab 3 - Linked Lists

Name: Olga Shevchuk

Number of Late Days Using for this lab:
0
---

### Writeup

1. Which instance variables do you have in your Name class?
In my Name class, I have a String representing the name of the baby, an ArrayList of all the years in which this name was present,
an ArrayList representing the number of babies with that name in each of those years, 
an ArrayList representing the rank of babies with that name in each of those years, 
an ArrayList representing the percentages for that baby in each of those years, an integer representing the total 
number of babies with a specific name among all of the years

2. How do you organize the storage of the yearly statistics per name versus the totals? 
We have the rank of the name and the number of names that year given from the file. To help compute some of the other statistics, I created ArrayLists in the Nameclass which would have information added to them as the files are read in. There is an ArrayList for years the entries of which correspond to the entries of ArrayList of number of names based on the same index. To get the number of names of that baby among all of the years, I sum up the information from the ArrayList of number of names for one name. Then to compute the grand total(the number of names of all babies among all of the years), I just go through each node, and add up this information between each one of the objects.To compute the percentage of babies given that name among all of the years, I divide the number of names of that baby among all of the years by the grand total. To compute the percentage of babies given that name that year, I access the number of names for that baby at a specific index in the ArrayList that matches the index of the the given year and divide it by the number of babies in the specific year (which I get from adding the information we get by traversing through the linked list, adding the number of names of each object at the index that matches that specific year).

3. Where are the overall totals stored and where are the yearly totals stored?
The percentage of babies given that name that year is stored in the ArrayList of percentages in the Name class and the total number of babies with that name among all of the years is stores as an instance variable in the name class. The total percentage, the total number of babies for a specific year and the total number of names for all babies among all of the years are calulated and stored in the Linked List class.

4. How do you keep the linked lists in alphabetically sorted order?
I traverse through the linked list, getting a name of the specific name object as an input, and compare the alphabetical position of that name with that of the current existing name using compareTo. Based on this, I decide whether to place it before or after the existing node. I do this in the while loop(if the position of the input name is after the current node, I keep going (putting it after each node updating the position of the current node). If the position of the input node is supposed to be before the updated current node, I put it between the current node and the node that precedes it. 

5. How is total rank computed?
To compute total rank, I compare the number of names among all of the years for specific name objects. I traverse the linked list, each time I go through the loop,  if the number of names of the existing node is bigger ot equals to that of the input name, I increase the rank by 1 because the rank of the input name would indicate how many babies come before the input name in the list plus one.
---

### Lab Questionnaire

(None of your answers below will affect your grade; this is to help refine lab
assignments in the future)

1. Approximately, how many hours did you take to complete this lab? (provide
  your answer as a single integer on the line below) 30

2. How difficult did you find this lab? (1-5, with 5 being very difficult and 1
  being very easy) 5

3. Describe the biggest challenge you faced on this lab: During this lab it was hard for me to figure out how to combine all the methods together so that they conctitute a structured program. Also, it was hard for me to figure out how to get my classes properly interact with the main method and how to store and use all the information in appropriate data structures.
