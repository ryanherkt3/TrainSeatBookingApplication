package project;
/**
 * SeatType is an enumerated class which has enumerated values for 
 * the three seat types (window, aisle and middle).
 * 
 * @author rherkt, 
 * @author 18022861
 */
public enum SeatType 
{
	WINDOW,	AISLE, MIDDLE;
	
	/**
	 * This method returns a text representation of the seat's location 
	 * in the floor grid (window, aisle or middle). What is returned depends 
	 * on whether the if/else condition matches the user's choice.
	 * 
	 * @return small String representation of a seat (e.g. if the seat type 
	 * is window, then "WINDOW" is returned.
	 */
	public String toString()
	{
		if (this.equals(WINDOW))	//if the seatType matches the WINDOW enumerated type
		{
			return "WINDOW";
		}
		else if (this.equals(AISLE))	//if the seatType matches the AISLE enumerated type
		{
			return "AISLE";
		}
		else	//if the seatType matches neither of the above enumerated types
		{
			return "MIDDLE";
		}
	}
}