package project;
/**
 * This TrainJourney class stores information relating to a TrainJourney, 
 * which is the journey number, source and destination cities, departure time 
 * and a floor grid. The floor grid is stored as a FloorGrid object, while the 
 * other variables/attributes are stored as Strings. In this method is data 
 * encapsulation methods to prevent unauthorized modification of the values and 
 * a toString representation of a TrainJourney object.
 * 
 * @author rherkt, 
 * @author 18022861
 */
public class TrainJourney 
{
	private String journeyNumber;
	private String sourceCity;
	private String destCity;
	private String departureTime;
	private FloorGrid seating;
	
	/**
	 * This TrainJourney constructor has five parameters: journeyNumber, 
	 * destCity, sourceCity and departureTime all of type String and seating
	 * of type FloorGrid. The inputs come from the initialization of the 
	 * individual TrainJourney objects in the main method, where default 
	 * values are preset.
	 * 
	 * @param a journey's number, destination city, source city and departure 
	 * time as Strings and the seating matrix as a FloorGrid.
	 */
	public TrainJourney(String journeyNumber, String destCity, String sourceCity, String departureTime, FloorGrid seating)
	{
		this.journeyNumber = journeyNumber;
		this.sourceCity = sourceCity;
		this.destCity = destCity;
		this.departureTime = departureTime;
		this.seating = seating;
	}
	
	/**
	 * This toString method sets returns a String representation of a 
	 * TrainJourney object, proving a comprehensive description of a 
	 * train journey a user can book. What is returned depends on 
	 * whether the train for the journey is small (i.e. PetiteGrid) 
	 * or large (i.e. GrandeGrid).
	 * 
	 * @return String representation of TrainJourney object.
	 */
	public String toString()
	{		
		if (seating.nRows == 10)	//condition triggers if the grid is small/petite
		{
			return "Train journey #" + journeyNumber + " from " + destCity + " to " + sourceCity + " departing at: " + departureTime + " (small train)";	//small train refers to the PetiteFloorGrid
		}
		else
		{
			return "Train journey #" + journeyNumber + " from " + destCity + " to " + sourceCity + " departing at: " + departureTime  + " (deluxe train)";	//deluxe train refers to the GrandeFloorGrid		
		}
	}
	
	/**
	 * This data encapsulation method gets a train journey's number 
	 * (note: a journey number can start with a zero, making it a 
	 * string), and returns it as a string to the caller.
	 * 
	 * @return journeyNumber as a string.
	 */
	public String getJourneyNumber()
	{
		return this.journeyNumber;
	}
	
	/**
	 * This data encapsulation method gets a train journey's source 
	 * city and returns it as a string to the caller.
	 * 
	 * @return sourceCity as a string.
	 */
	public String getSourceCity()
	{
		return this.sourceCity;
	}
	
	/**
	 * This data encapsulation method sets a train journey's source 
	 * city.
	 * 
	 * @param sourceCity as a string.
	 */
	public void setSourceCity(String sourceCity)
	{
		this.sourceCity = sourceCity;
	}

	/**
	 * This data encapsulation method gets a train journey's 
	 * destination city and returns it as a string to the caller.
	 * 
	 * @return destCity as a string.
	 */
	public String getDestCity() 
	{
		return destCity;
	}

	/**
	 * This data encapsulation method sets a train journey's 
 	 * destination city.
	 * 
	 * @param destCity as a string.
	 */
	public void setDestCity(String destCity) 
	{
		this.destCity = destCity;
	}

	/**
	 * This data encapsulation method gets a train journey's 
	 * floor grid seating matrix and returns it as a FloorGrid 
	 * to the caller.
	 * 
	 * @return seating as a FloorGrid.
	 */
	public FloorGrid getSeating() 
	{
		return seating;
	}

	/**
	 * This data encapsulation method sets a train journey's 
	 * floor grid seating matrix.
	 * 
	 * @param seating as a FloorGrid.
	 */
	public void setSeating(FloorGrid seating) 
	{
		this.seating = seating;
	}

	/**
	 * This data encapsulation method gets a train journey's 
	 * departure time (note: 12:40 must be represented as a 
	 * string due to the semicolon) and returns it as a string 
	 * to the caller.
	 * 
	 * @return departureTime as a string.
	 */
	public String getTime() 
	{
		return departureTime;
	}

	/**
	 * This data encapsulation method sets a train journey's 
	 * departure time.
	 * 
	 * @param departureTime as a string.
	 */
	public void setTime(String departureTime) 
	{
		this.departureTime = departureTime;
	}
}
