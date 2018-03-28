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
	- test adult with spouse change age : passed
	- test adult with spouse change age : passed
	- test child with parents change age : passed
	- test child change age who has friends within age-gap : passed
	- test child change age to baby (with friends): passed
	- test child change age to baby (without friends): passed
	
- deletePerson
	- test person does not exist: passed
	- test person exist: passed
	- test delete person with spouse: passed
	- test delete person with friends: passed
	- test delete child: passed
	
- connectPerson
	- test both person exist/not exists combination: passed
	- test both person exist: passed
	- test connect friends (no connections yet) : passed
	- test connect spouse (no spouse yet) : not_done_yet
	- test connect spouse (spouse already exists) : not_done_yet
	- test connect friend already exists : not_done_yet
	- test child connect friend (adult) : not_done_yet
	- test child connect friend (child inside family) : not_done_yet
	- test child connect friend (child outside family) : not_done_yet
	- test child connect friend (child not within age-range) : not_done_yet
	- test child connect friend (child within age-range) : not_done_yet
	- test child below 2 connect friend : not_done_yet
	
- findFriends (input person A, input person B)
	- test both person exist/not exists combination : passed
	- test both person exist: passed
	- test both persons are friends : passed
	- test both persons are not friends : passed
	
- findFamily	
	- test person does not exist: passed
	- test person exist: passed
	
- return to menu once any option selected: passed




