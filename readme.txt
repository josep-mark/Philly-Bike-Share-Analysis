In the bikeshare data set problem I changed up my algorithm and crc a few times

Ultimately I had 6 classes:
A tester
a file reader
a data collection
a tripdata
a stationtable 
and a question set class

The file reader class is largely based off the one used in lecture
It takes in an argument as a file name,
reads the file and returns an array list of strings
Each string being a line

The StationTable class
This takes in a line from the station table
It splits the line by commas and stores each of those values as an instance variable
Those are: 
station id
Station Name
Go Live Date
and active
In order to massage the data I corrected for station names with commas in them
To do this I checked if the array was over 4, if so I concatenated index 1 and 2 and made a new array

The TripData class does much the same thing as the StationTable class
It however has 14 values including
trip id
bike id
duration
start station
start time
end station
end time
pass type
pass duration
trip type
start lat
start lon
end lat
end lon
and trip route

The collect data class uses the file reader to get ArrayLists of lines from the files
It then creates an arraylist of tripdata and an arraylist of stationtable
It has getters and setters for those arraylists

The last (besides the main) is the QuestionSet
This holds the methods for answering each of the questions
It takes in the tripData ArrayList and stationTable arraylist as arguments
Here I will explain my algortihms in detail

Count TripTypes
This method answer problem 1
It takes an input from the interface in the main and calculates the number of trips of that type
It does this by iterating through each trip and comparing the value given to the trip type in the TripData object

goLiveActive
This method takes in two arguments from the user
The first is the year they want to check 
Second the Active level
It then checks if these are equal to the values in each data
If so the count goes up by 1
The method returns the count

Start Percentage
This method answers question 3 by taking in the argument from the user
It does this by taking a name from the user
It iterates through the station table objects and finds the appropriate id #
Then it breaks
It then iterates through TripData and checks to see if that equals the start station
If so count + 1
After that iteration it calculates the percentage of count/ total trips

Pass Trip Type Percentage
This answers question 4 by taking in the user arguments for pass type and trip type
It then iterates through the trip data
if the pass type is the same as user given, pass type count + 1
if the trip type is also the same as user given, count for trip type goes up
I then divide passtypecount by triptypecount for the percentage

Bike with longest duration
This finds the bike by iterating through TripData
the local variable longestDuration records the record duration
The bikeId variable holds the winners value
I use Integer.parseInt to convert the duration to int
Then compare that value to the record
if it beats the record store that duration and bike id
Return the record holders

Bikes in use
This method answers question 6
It does so by taking in user input for date and time 
It turns time into a decimal number
Then it iterates through the trip info doing the following:
splits date and time for both start and end dates/times
turns time into decimal
Then it checks for 3 cases
1. when start and end date are the same day as the user given day
	If so if the start time < 7 and end time >7 count ++
2. when startdate is the only day that matches
	if so it counts it if start time < 7
3. when the end date is the only matching date
	if so it counts it if endtime > 7
This is all military time too

Longest trip info
This addresses question 7
It uses two methods 
1. a private method checkForNull
this checks to make sure the lat and lon values are not \N
If they are it ignores this case, the amount ignored should have no significant impact on results
If it does the program can move forward
2. LongestTripInfo
This method traps the longest trip by iterating through TripData
it converts lat and lon to decimal
Then calculates trip distance
It uses the formula
Distance = sqrt (a^2 + b^2)
where a is the difference in LAt and b is the difference in lon
It records record holders and record holder ids then prints out the info for the longest trip

Trips On Go Live Dates
This addresses question 8
It does so through two methods
The private method getUniqueStartDates uses the stationtable to find uniques start dates/times
It does so by creating an arraylist of startdates
Then it has nested for loops to identify ones that do not repeat
Those ones that do not repeat are added to the unique start date arraylist

The method tripsOnGoLiveDates()
It uses the uniqueGoLiveDates to get the station ids
Once it has the station IDs in an array list it iterates through the ids
in a nested for loop it iterates trhough all the trip data and checks if the start station or end station are the id
if so it adds the trip id to an arraylist of trip ids
If not it moves on
Then it returns the array list of trip IDs

My wildcard question was to find the percentage of people using a 0, 30, or 365 day pass
This may not be a hard question to solve but it could be important for Indego's marketing and pricing strategy
Since I'm not too bad
I did this by combining the techniques in questions one through 4








