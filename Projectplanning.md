# AirlineTracker
WebApplication to track the airplane

###Task Description
------------------------------------------------------------------------------------------------------------------------------------------------------------------------
User Story : As a Pilot of Lufthansa Airlines , I would like to know when a particular aircraft arrives to the Frankfurt airport.

Use case 1: 
Pilot enters the flight number or “callsign” of the aircraft. The application will show the callsign, current location of the aircraft, the departure and arrival airport, the scheduled departure, actual departure, the Scheduled time of arrival and Estimated time of arrival.   

Database used : Mongo DB, API Opensky, Openmaps
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
####
Planning phase
####
1. Because the course is all about DB, more concentration on DB part, as well as real time data streaming into DB through API
2. Frontend - Interface with Flight number and search button
After clicking the search button, these  results should be displayed
1. Callsign
2. ICAO24
3. Current location ( in air, or ground (airport name/ country name))
4. Departure Airport
5. Arrival Airport
6. Scheduled departure
7. Actual Departure
8. Scheduled time of Arrival
9. Estimated time of arrival
####
General information about airplane tracking
####
Assumptions and observations
####
1. Airplane mainly have 3 properties to be dealt with while mapping
2. a.Flight number
3. b.Callsign
4. c.icao2424
5. Evêry plane has unique flightnumber and callsign
6. pilot only knows flight number and not call sign
7. They both are more are less same, for eg,  D is added
8. ----------------------------------------------------------------------------
9. particular route for eg Frankfurt to mumbai and mumbai to frankfurt  has the data
10. ----------------------------------------------------------------------------
11. Flightno     callsign     icao2424                       Departure   Arrival
12. ----------------------------------------------------------------------------
13. LH756        DLH756       3c4ad8                         Frankfurt   Mumbai
   LH757        DLH757       3c4ad8                         Mumbai      Frankfurt 
   --------------------------------------------------------------------------------
9. openskynetwork gives status or "state" of plane by entering icao2424, which is unique for an airplane at that point of time
10. icao2424 changes for a particular plane on a paricular route,in different days, and  also can be same or different for to and fro flight
11. But at a point of time in sky, every flight have unique icao2424
12. -----------------------------------------------------------------------------------------------------------------------------------------------
13. *****Can the data of a flight be recieved from Openskynetwork API by entering callsign*** it seems possible******
14. its not tested by entering callsign and tested for icao2424, but seems possible..just test it
15. -------------------------------------------------------------------------
16. -----------------------------------------------------------------------------------------------------------------------------------------------
17. https://openskynetwork.github.io/opensky-api/rest.html
18. eg: LH456 is currently in the air, Frankfurt to losangeles
---------------------------------------------------------------------------------------
i entered icao24 value and not call sign
I entered https://opensky-network.org/api/states/all?icao24=3c4b34 in postman GET request

Following is response in json format
{
    "time": 1651396192,
    "states": [
        [
            "3c4b34",
            "DLH456  ",
            "Germany",
            1651396192,
            1651396192,
            8.7051,
            50.0728,
            655.32,
            false,
            116.75,
            57.78,
            11.7,
            null,
            777.24,
            "2505",
            false,
            0,
            6
        ]
    ]
}

...............................
below are the descriptions for the above data
...............................

Index    

-----------------------------------------------------
But trying to get data after entering callsign is not possible or i may be using it wrong way
---------------------------------------
https://opensky-network.org/api/states/all?callsign=DLH456

I get different data, ie of all the airplanes state
so this needs to be solved

-------------------------------------------------------------------------------------
What data we can get from openskynetwork api
---------------------------------------------
https://openskynetwork.github.io/opensky-api/rest.html

Also, for the above project, if we know how to use API correctly, all the data we can get it seems from 
https://openskynetwork.github.io/opensky-api/rest.html#flights-in-time-interval   scrolling below

---------------------------------------------------------------------------------
Very important finding --note it down
.....................................................................................................................
Flights by Aircraft and flights in time interval seems promising query but need to know how to use it 
...............................................................................
$ curl -u "USERNAME:PASSWORD" -s "https://opensky-network.org/api/flights/aircraft?icao24=3c675a&begin=1517184000&end=1517270400" | python -m json.tool

link
https://openskynetwork.github.io/opensky-api/rest.html#flights-in-time-interval


But using import and pasting curl command, im getting error

20. For java, to get unix time, we use 
21. long unixTime = System.currentTimeMillis() / 1000L;
22. 
23. -------------------------------------------------------------------------------------------
24. 1. DB planning and modelling (MongoDB)
25. 2. data -Static collection and Dynamic collection differentiation
26. 3. Testing data insertion through Java
27. 4. Using Java API provided by open sky network and dumping it to database, updatation should happen frenequently
28. 5.Performing queries manually
29. 6. Developing front end and framework and integrating APIs and DB
30. ...............................................................................................
31. 
32. 2. 
