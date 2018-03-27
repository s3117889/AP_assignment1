# AP_assignment1
Instructions:

Create folder AP_assignment1

Extract all to folder AP_assignment1

Run the following commands:
javac AP_assignment1/*.java
java AP_assignment1/MiniNet

Select any option from the menu; where applicable, sub-menus/further input will be required

The following scenarios are tested and results indicated with comments if applicable

- user enters invalid menu option (int): passed
- user enters invalid menu option (string): passed

- addPerson
	- test add : passed
	- test add same person : passed, prevented
	
- findPerson
	- test person does not exist: passed
	- test person exist: passed
	
- displayProfile
	- test person does not exist: passed
	- test person exist: passed
	
- displayAllProfile
	
- updateProfile
	- test person does not exist: passed
	- test person exist: passed
	- test adult with friends/spouse/children change age
	- test child with parents change age
	- test child change age who has friends within age-gap
	
- deletePerson
	- test person does not exist
	- test person exist
	- test delete person with spouse
	- test delete person with friends
	- test delete child
	
- connectPerson
	- test both person exist/not exists combination: passed
	- test both person exist: passed
	- test connect friends (no connections yet) : passed
	- test connect child
	- test connect spouse (no spouse yet)
	- test connect spouse (spouse already exists)
	- test connect friend already exists
	- test connect child-father-adult
	- test child connect friend (adult)
	- test child connect friend (child inside family)
	- test child connect friend (child outside family)
	- test child connect friend (child not within age-range)
	- test child connect friend (child within age-range)
	- test child below 2 connect friend
	
- findFriends (input person A, input person B)
	- test both person exist/not exists combination : passed
	- test both person exist: passed
	- test both persons are friends : passed
	- test both persons are not friends : passed
	
- findFamily	
	- test person does not exist: passed
	- test person exist: passed
	
- return to menu once any option selected: passed




