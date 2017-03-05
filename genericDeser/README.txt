CS542 Design Patterns
Fall 2016
ASSIGNMENT 5 README FILE

Due Date: Thursday, December 15, 2016
Submission Date: Tuesday, December 13, 2016
Grace Period Used This Project: 0 Days
Grace Period Remaining: 0 Days
Author(s): Omkar Nibandhe
e-mail(s): oniband1@binghamton.edu


PURPOSE:

[
  Comparing Objects in Java.
  Reflections.
]

PERCENT COMPLETE:

[
  -I assume that the code is 100% complete and running.
  -The performance may be boosted using memory mapped IO for reading/writing using 
	IO operations to avoid cache miss and extert all the IO operations in 1 shot.
  
]


DATASTRUCTURE CHOICE:
[

	HashMap to store the object and count in key/value pair.
 	
	Insertion O(1) (Average case)
	Search O(1) (Average case)
	Delete O(1) (Average case)
	Space Complexity O(n)
]

SAMPLE OUTPUT:

[
run:
     [java] Number of unique First objects: 4952
     [java] Total Number of First objects: 4952
     [java] Number of unique Second objects: 5018
     [java] Total Number of Second objects: 5048


]

TO COMPILE:

[
 ant -buildfile build.xml all

]

TO RUN:

[
  ant -buildfile src/build.xml run -Darg0=<input_file_name> -Darg1=<DEBUG_VALUE>
  Example:
  ant run -buildfile build.xml -Darg0=input.txt -Darg1=0


]

TO CLEAN:

[
  ant -buildfile src/build.xml clean
]
