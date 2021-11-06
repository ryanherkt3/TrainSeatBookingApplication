package project;
/**
 * This Seat class has information which stores a seat's reservation 
 * and first class status, the type of seat (enumerated type), a 
 * SeatPosition object to create a floor grid for the train operator, 
 * and two String methods which return a representation of a train seat 
 * as well as a longer description of a train seat.
 * 
 * The objects in this class are mainly for the train operator, as opposed 
 * to the user of the application. 
 * 
 * @author rherkt, 
 * @author 18022861
 */
public class Seat 
{
	private SeatType seatType;
	private boolean firstClass;
	private boolean reserved;
	private SeatPosition seatPosition;
	
	/**
	 * This Seat constructor has three parameters: seatPosition of type 
	 * SeatPosition, seatType (enumeration) of type SeatType and boolean 
	 * firstClass; the reserved attribute is set to whatever is returned 
	 * from the isReserved method. The inputs come from the abstract 
	 * initialiseFloorGrid method, which is overridden in the 
	 * GrandeFloorGrid and PetiteFloorGrid subclasses.
	 * 
	 * @param train seat's overall seatPosition as a SeatPosition, train 
	 * seat's seatType (window, middle or aisle) as a SeatType enum, and
	 * firstClass as a boolean type.
	 */
	public Seat(SeatPosition seatPosition, SeatType seatType, boolean firstClass)
	{
		this.seatType = seatType;
		this.seatPosition = seatPosition;
		this.firstClass = firstClass;
		this.reserved = isReserved();	//returns true or false to variable
	}
	
	/**
	 * This data encapsulation method returns the type of seat as 
	 * a Seat object / gets the seatType when asked for it.
	 * 
	 * @return enumerated type of seat (Window, Middle or Aisle) as 
	 * SeatType.
	 */
	public SeatType getSeatType()
	{
		return seatType;
	}
	
	/**
	 * This method returns a train seat's status as either first class 
	 * or economy, depending on its location in the train.
	 * 
	 * @return boolean true/false for first class parameter.
	 */
	public boolean isFirstClass()
	{
		if (this.firstClass)	//triggered if the seat is first class
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * This method returns a train seat's status as either reserved 
	 * or unreserved, depending on whether it has been booked or not.
	 * 
	 * @return boolean true/false for reserved parameter.
	 */
	public boolean isReserved()
	{
		if (this.reserved)	//triggered if the seat is reserved
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * This data encapsulation method sets a train seat's status as 
	 * either reserved or unreserved, depending on whether the 
	 * parameter passed in is true (reserved) or false (unreserved).
	 * 
	 * @param reserved status as boolean type.
	 */
	public void setReserved(boolean reserved)
	{
		this.reserved = reserved;
	}
	
	/**
	 * This data encapsulation method gets a train seat's position 
	 * in the array [row, column] and returns it to the caller.
	 * 
	 * @return seatPosition as SeatPosition (int row, char column).
	 */
	public SeatPosition getSeatPosition()
	{
		return seatPosition;
	}
	
	/**
	 * This method returns a longer text description of a Seat from the 
	 * corresponding FloorGrid. What is returned depends on whether the 
	 * seat is first class or economy and whether it is reserved or not.
	 * 
	 * @return String description of the seat.
	 */
	public String toDescription()
	{
		//Longer descriptions of individual seats
		if (this.reserved)	//... equals true
		{
			if (this.firstClass) //... equals true
			{
				return "First class " + seatType + " seat at: " + seatPosition.getRow() + seatPosition.getColumn() + " is booked.";
			}
			else
			{
				return "Economy class " + seatType + " seat at: " + seatPosition.getRow() + seatPosition.getColumn() + " is booked.";
			}
		}
		else
		{
			if (this.firstClass)
			{
				return "First class " + seatType + " seat at: " + seatPosition.getRow() + seatPosition.getColumn() + " is not booked.";
			}
			else
			{
				return "Economy class " + seatType + " seat at: " + seatPosition.getRow() + seatPosition.getColumn() + " is not booked.";
			}
		}
	}
	
	/**
	 * This method returns a text representation of a Seat from the 
	 * corresponding FloorGrid. What is returned depends on whether the 
	 * seat is first class or economy and whether it is reserved or not. 
	 * This method is used by the train operator to see each seat's type, 
	 * reservation status and first class status.
	 * 
	 * @return small String representation of a seat.
	 */
	public String toString()
	{
		if (this.seatType == SeatType.WINDOW)	//triggered if the seat type matches the static WINDOW seat type
		{
			if (this.reserved)
			{
				if (this.firstClass)
				{
					return "[W X ]";	//string representation of a booked window seat in first class
				}
				else
				{
					return "[w X ]";	//string representation of a booked window seat in economy class
				}			
			}
			else
			{
				if (this.firstClass)
				{
					return "[W _ ]";	//string representation of an empty window seat in first class
				}
				else
				{
					return "[w _ ]";	//string representation of an empty window seat in economy class
				}
			}
		}
		
		else if (this.seatType == SeatType.AISLE)	//triggered if the seat type matches the static AISLE seat type
		{
			if (this.reserved)
			{
				if (this.firstClass)
				{
					return "[A X ]";
				}
				else
				{
					return "[a X ]";
				}			
			}
			else
			{
				if (this.firstClass)
				{
					return "[A _ ]";
				}
				else
				{
					return "[a _ ]";
				}
			}
		}
		
		else if (this.seatType == SeatType.MIDDLE)	//triggered if the seat type matches the static MIDDLE seat type
		{
			if (this.reserved)
			{
				if (this.firstClass)
				{
					return "[M X ]";
				}
				else
				{
					return "[m X ]";
				}			
			}
			else
			{
				if (this.firstClass)
				{
					return "[M _ ]";
				}
				else
				{
					return "[m _ ]";
				}
			}
		}
		return null;
	}
}