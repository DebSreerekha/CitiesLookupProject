This project is used to fetch the city names pertaining to a state .
The main class is CityDataManager class
It uses the India_Cities .csv data file( It will work for any comma separated file );
CSVDataParser class  parses the data file and internally stores it in the ds.hashtable.MyHashtable  data structure.

The benchmarking package has classes for performing a benchmark test 
The  PerformanceBenchmarking.java encapsulates the logic for comparing the time taken to fetch the cities of a particular state.
Different flavours of the parsers are implemented based on the internal data structure used to hold the parsed data from the csv file.
