CS542 Design Patterns
Fall 2016
ASSIGNMENT 4 README FILE

Due Date: Wednesday, Novermber 23, 2016
Submission Date: Wednesday, Novermber 23, 2016
Grace Period Used This Project: 0 Days
Grace Period Remaining: 0 Days
Author(s): Omkar Nibandhe
e-mail(s): oniband1@binghamton.edu


PURPOSE:

[
  "wc" command with Visitor, Prototype, and Observer 
]

PERCENT COMPLETE:

[
  -I assume that the code is 100% complete and running.
  -The performance may be boosted using memory mapped IO for reading/writing using 
	IO operations to avoid cache miss and extert all the IO operations in 1 shot.
  -used diff command in java runtime to check that the backup works.
]


DATASTRUCTURE CHOICE:
[

	Binary Search Tree
 	
	Access Θ(log(n)) (Average case)
	Insertion Θ(log(n)) (Average case)
	Space Complexity O(n)
]

SAMPLE OUTPUT:

[
  
     [java] totalWords : 13
     [java] distinctWords : 11
     [java] characters : 56
     [java] Total Time: 23 milliseconds

]

TO COMPILE:

[
 ant -buildfile src/build.xml all
 ant -buildfile src/build.xml -Darg0=../input.txt -Darg0=../output.txt

]

TO RUN:

[
  ant -buildfile src/build.xml run -Darg0=<input_file_name> -Darg1=<UPDATE_VALUE>
  Example:
  ant run -Darg0=input.txt -Darg1=output.txt

]

TO CLEAN:

[
  ant -buildfile src/build.xml clean
]
