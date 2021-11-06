package project;
import java.util.*;
/**
 * This TrainSeatBookingApplication class serves as the main class 
 * for this program, with four methods. Five variables are created: 
 * a Scanner for the user inputs, a constant integer for the number of 
 * journeys (5), an an array of type TrainJourney with a size of 5, and 
 * two new instances of floor grids (Petite and Grande) created through 
 * the use of polymorphism.
 * 
 * The first method is the main method, which initializes both the floor 
 * grids instantiated in the class and instantiates the array of train 
 * journeys by injecting each element in the array with the appropriate 
 * parameters.
 *
 * The bookJourney method creates a null TrainOperator object (again, by
 * polymorphism) and a null Seat object, then displays the available 
 * train journeys the user can book and asks them which journey they'd 
 * like to book and what type of seat (out of window, aisle or middle) 
 * they would like. The train operator is then chosen at random before 
 * the chooseASeat method is called, passing in the user's chosen journey, 
 * seat type, the train operator and the null Seat object as parameters.
 * 
 * For the chooseASeat method, a null SeatType object is created, which 
 * is populated with the appropriate enumerated type based on the user's 
 * earlier input (if/else) before the train operator attempts to book a 
 * first class or economy (if no seats are available based on the 
 * operator's first class booking policy) seat. The printTicket method 
 * is then called, passing in the seat as a parameter.
 *
 * Finally, the printTicket method sets the user's seat to booked (if one 
 * is found from the chooseASeat method), prints out their seat and a message.
 * If no seat can be found, an error message is printed to the console. Otherwise, 
 * the customer is presented with their seat details. After both instances, 
 * the customer is asked if they'd like to book another journey, where they respond 
 * with either Y or N; a N response terminates the program, while a Y response 
 * sees the program loop with a new call to the bookJourney method.
 * 
 * @author rherkt, 
 * @author 18022861
 */
public class TrainSeatBookingApplication 
{
	private static Scanner keyboard = new Scanner(System.in);
	private static final int NUMBER_OF_JOURNEYS = 5;
	private static TrainJourney[] arrayOfJourneys = new TrainJourney[NUMBER_OF_JOURNEYS];	
	private static FloorGrid petiteGrid = new PetiteFloorGrid();
	private static FloorGrid grandeGrid = new GrandeFloorGrid();

	/**
	 * The main method instantiates the array of five journeys with their 
	 * journey numbers, source city, destination city, departure time and 
	 * floor grids. This method also calls the bookJourney method.
	 * 
	 * @param String args[].
	 */
	public static void main(String args[])
	{
		//initialization of floor grids
		petiteGrid.initialiseFloorGrid();
		grandeGrid.initialiseFloorGrid();

		//instantiation of the TrainJourney array
		arrayOfJourneys[0] = new TrainJourney("1", "Wellington", "Auckland", "1100", grandeGrid);
		arrayOfJourneys[1] = new TrainJourney("2", "Nelson", "Dunedin", "1215", grandeGrid);
		arrayOfJourneys[2] = new TrainJourney("3", "Auckland", "Hamilton", "0830", grandeGrid);
		arrayOfJourneys[3] = new TrainJourney("4", "Tauranga", "New Plymouth", "1430", petiteGrid);
		arrayOfJourneys[4] = new TrainJourney("5", "Christchurch", "Queenstown", "1730", petiteGrid);
				
		//call to issueTicket method
		bookJourney();
	}
	
	/**
	 * This method creates a null TrainOperator object, a null Seat object and a 
	 * Random object, which determines the train operator for the journey. The 
	 * user is then shown the journeys they can book and their details, and asked 
	 * to enter the journey number (1-5) and their preferred seat location (1-3). 
	 * The random object then chooses a random number (out of 0 or 1) to determine 
	 * the train operator for the user's journey. Finally, the method initializes 
	 * the null TrainOperator object with either a new TrainWay or TrainSmart 
	 * constructor, then prints a greeting from the train operator before calling 
	 * the chooseASeat method, passing in the train operator, journey number, 
	 * seat location and null Seat object as parameters.
	 * 
	 * N.B. This method assumes the user will enter the inputs correctly
	 */
	public static void bookJourney()
	{
		TrainOperator operator = null;	//creation of null train operator object
		Seat seatOne = null;	//creation of null Seat object

		System.out.println("Welcome to the Train Seat Booking Application. Here is a list of journeys you can choose from:");
		for (int k = 0; k < NUMBER_OF_JOURNEYS; ++k)	//loop to print the toString representations of each train journey object
		{
			System.out.println(arrayOfJourneys[k]);
		}
		System.out.println();
		
		System.out.println("Please enter the journey number:");
		int journeyNumber = keyboard.nextInt();
		System.out.println("Please enter the type of seat you want (1 - window, 2 - aisle, 3 - middle):");
		int seatLocation = keyboard.nextInt();
		
		System.out.println();
		
		Random randNum = new Random();
		int randOperator = randNum.nextInt(2);	//to randomize the choosing of the two train operators
		
		if (randOperator == 0)	//TrainWay operator
		{
			operator = new TrainWay("Peter");	//initialize TrainWay object by polymorphism
			System.out.println(operator + ", from TrainWay.");
		}
		else	//TrainSmart operator
		{
			operator = new TrainSmart("Steven");	//initialize TrainSmart object by polymorphism
			System.out.println(operator + ", from TrainSmart.");
		}

		//call to method with passed in parameters
		chooseASeat(journeyNumber, seatLocation, seatOne, operator);	
	}
	
	/**
	 * This method creates a null SeatType object, which is populated with the 
	 * appropriate enumerated value (WINDOW, AISLE or MIDDLE), based on the user's 
	 * seatLocation chosen earlier, which is passed in. The null Seat object passed 
	 * in is then populated with a value (a seat array indices, or null) when the 
	 * train operator calls its reserveFirstClass and reserveEconomyClass methods, 
	 * passing in the arrayOfJourneys index number and the seatType value, populated 
	 * earlier. The printTicket method is then called, passing in the Seat object 
	 * previously populated.
	 * 
	 * @param journeyNumber and seatLocation as integers, seatOne as a null Seat 
	 * object and trainOperator as the randomly chosen TrainOperator.
	 * 
	 */
	public static void chooseASeat(int journeyNumber, int seatLocation, Seat seatOne, TrainOperator trainOperator)
	{
		SeatType aType = null;	//creation of null SeatType object
		
		//if else ladder to determine seat type
		if (seatLocation == 1)	//if seatLocation is equal to 1 (or window), this triggers
		{
			aType = SeatType.WINDOW;	//sets aType to static instance of WINDOW SeatType
		}
		else if (seatLocation == 2)	//if seatLocation is equal to 2 (or aisle), this triggers
		{
			aType = SeatType.AISLE;	//sets aType to static instance of AISLE SeatType
		}
		else if (seatLocation == 3)	//if seatLocation is equal to 3 (or middle), this triggers
		{
			aType = SeatType.MIDDLE;	//sets aType to static instance of MIDDLE SeatType
		}
		
		//seatOne equals whatever seat array indices is returned from the train operator's first class booking policy
		seatOne = trainOperator.reserveFirstClass(arrayOfJourneys[journeyNumber-1], aType);	
		if (seatOne == null)
		{
			//if nothing is returned from the first class booking policy, then 
			//seatOne equals whatever seat array indices is returned from the train operator's economy booking policy
			seatOne = trainOperator.reserveEconomy(arrayOfJourneys[journeyNumber-1], aType);
		}
		
		printTicket(seatOne);	//call to method with passed in parameters
	}
	
	/**
	 * This method prints out the user's train ticket, based on whether a seat 
	 * array indices was returned in the previous method. If one wasn't, the user 
	 * will receive a message saying a booking couldn't be made. If one was, the 
	 * seat will be set to reserved for them first, then the user will be given 
	 * a text description of their seat (first class/economy, the seat type and 
	 * its location).
	 * 
	 * In either case, the user is asked if they'd like to book another trip. If 
	 * they don't, the program terminates. If they do, the bookJourney method is 
	 * called again, restarting the process of booking a new train journey 
	 * recursively.
	 * 
	 * @param seatOne as a Seat object populated in chooseASeat method.
	 */
	public static void printTicket(Seat seatOne)
	{
		//if else ladder to determine whether a train seat was found for the user
		if (seatOne == null)	//i.e. no array indices was found, no matching seat was found
		{
			System.out.println("Sorry, but a booking couldn't be made as the train is full!");	//error message
		}
		else
		{
			seatOne.setReserved(true);	//books the user's seat for them beforehand
			System.out.println(seatOne.toDescription() + " Have a nice trip!");	//ticket description
		}
		
		//prompt for another trip/journey with local char variable storing the response
		System.out.println("Would you like to book another trip? (Y/N)");	
		char input = keyboard.next().charAt(0);
		
		if (input == 'Y' || input == 'y') //if response is 'Y', customer books again
		{
			System.out.println();
			bookJourney();
		}
		//a non 'Y' or 'y' response terminates the program
	}
}