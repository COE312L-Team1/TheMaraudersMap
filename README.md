# COE 312 Software Design Homework 1
![](https://p1.hiclipart.com/preview/693/926/322/harry-potter-hogwarts-logo.jpg)
## *Hogwarts School of Witchcraft and Wizardry - The Marauder's Map*
### The assignment was as follows:

The Marauder's Map is a magical document that reveals all of Hogwarts School of
Witchcraft and Wizardry. The map was created by Remus Lupin (Moony), Peter
Pettigrew (Wormtail), Sirius Black (Padfoot), and James Potter (Prongs) while they
were attending Hogwarts.

![](https://images-na.ssl-images-amazon.com/images/I/81hXyIewnxL._AC_SY550_.jpg)

Your task is to create in Java a Zork-like text adventure game simulating the use of
the marauder’s map. The player inputs commands in the console to navigate around
Hogwarts and to interact with characters or objects in each location.
The map shows 3 locations that the player can go to. In each location, the player can talk with 1 character
and use 2 objects. The locations’ details are as follows:

1. Dining hall: The dining hall is the biggest open area inside Hogwarts. In the dining hall, the player
finds Professor Dumbledore. The player can use the sorting hat to get sorted randomly into one
of the houses (Gryffindor, Hufflepuff, Ravenclaw and Slytherin), and hold food to eat.
2. Library: Once the academic year starts, students spend a lot of their time in the school library.
Amongst those students that the player can talk to is Hermione. In the library, the player finds a
book they can read, and a quill they can write with.
3. Potions Classroom: Potions is one of the core subjects that first year students are required to
study. In the potions class there is Professor Snape who teaches the subject. The Potions Classroom
is full of equipment and material that the player can use including a cauldron to make potions, and
a potion to drink that casts a magical spell.

Based on the description above:
- Create appropriate Java classes to model the different locations Dining Hall, Library, Potions
Classroom with appropriate attributes, methods and constructors. You should also consider the
relationships between these classes and make use of interfaces and abstract classes.
- Each location has a description, set of characters and set of objects. Each object has use()
method that prints what the object does as described above. Each character has talk() method
that prints what the character says, i.e. the objects that are in the current location. These methods
are executed upon interacting with the objects/characters.
- The player can use the look command to know the location’s description and character present
and walk command to move to another location (see sample output below).
- Create a Main class with the main method. Running the program prints the opening statement
(see sample output below) then waits for user input. The next move depends on the input.
- The game starts when the player types “I solemnly swear that I am up for no good” and ends
when s/he types “mischief managed”.
- If the player enters a non-existent object or character or command in a particular location, it
should prompt the player that it is invalid.
