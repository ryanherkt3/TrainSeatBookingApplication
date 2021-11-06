package project;
/**
 * This TrainWay subclass (an extension of the TrainJourney class) 
 * has a default constructor which calls the super keyword with the 
 * string as a parameter, and two methods which contain algorithms for 
 * booking first class and economy seats based on the TrainWay booking 
 * policy.
 * 
 * @author rherkt, 
 * @author 18022861
 */
public class TrainWay extends TrainOperator
{
	/**
	 * This TrainWay constructor contains one parameter - the train 
	 * operator's name as a String, and uses the super keyword to invoke 
	 * the TrainJourney constructor.
	 * 
	 * @param train operator's name (aString) as a string.
	 */
	public TrainWay(String aString)
	{
		super(aString);
	}
	
	/**
	 * This overridden reserveFirstClass method contains an 
	 * algorithm for booking a first class seat based on the TrainWay 
	 * booking policy. This method returns a seat and has two parameters - 
	 * the train journey and the user's requested seat type. Booking policy:
	 * 
	 * 1) book a first class seat of matching type; if this isn't possible:
	 * 2) book any first class seat; if this isn't possible:
	 * 3) book a window seat in economy; if this isn't possible: 
	 * the method returns null/no seat, meaning a booking couldn't be made.
	 * 
	 * @param train journey as TrainJourney, seat type (enum) as SeatType.
	 */
	@Override
	public Seat reserveFirstClass(TrainJourney aJourney, SeatType aType) 
	{
		//search for an available FC seat of requested type
		Seat aSeat = aJourney.getSeating().queryAvailableFirstClassSeat(aType);
		
		if (aSeat != null)
		{
			return aSeat;	//return seat if one is found
		}
		else		
		{
			//Nested for loop to search for an available FC seat of any type,
			//since calling the FloorGrid method requires a parameter to be 
			//passed through. I found it easier to write this loop rather than 
			//create independent switch cases for the seat type (aType)
			for (int j = 0; j < aJourney.getSeating().nFirstClassRows; ++j)
			{
				for (int k = 0; k < aJourney.getSeating().nColumns; ++k)
				{
					if (aJourney.getSeating().seats[j][k].isReserved() == false)
					{
						return aJourney.getSeating().seats[j][k];	//return seat if one is unbooked
					}
				}
			}
			
			//search for an available window seat in economy
			aSeat = aJourney.getSeating().queryAvailableEconomySeat(SeatType.WINDOW);
			if (aSeat != null)
			{
				return aSeat;
			}
			else
			{
				return null;	//return nothing if a booking cannot be made
			}
		}
	}

	/**
	 * This overridden reserveEconomy method contains an algorithm for 
	 * booking an economy class seat based on the TrainWay
	 * booking policy. This method returns a seat and has two parameters - 
	 * the train journey and the user's requested seat type. Booking policy:
	 * 
	 * 1) book an economy seat of matching type; if this isn't possible:
	 * 2) book a window seat in first class; if this isn't possible:
	 * the method returns null/no seat, meaning a booking couldn't be made.
	 * 
	 * @param train journey as TrainJourney, seat type (enum) as SeatType.
	 */
	@Override
	public Seat reserveEconomy(TrainJourney aJourney, SeatType aType) 
	{
		//search for an available economy seat of requested type
		Seat aSeat = aJourney.getSeating().queryAvailableEconomySeat(aType);

		if (aSeat != null)
		{
			return aSeat;	//return a seat if one is found
		}
		else
		{
			//search for an available window seat in first class
			aSeat = aJourney.getSeating().queryAvailableFirstClassSeat(SeatType.WINDOW);
			if (aSeat != null)
			{
				return aSeat;
			}
			else
			{
				return null;	//return nothing if a booking cannot be made
			}
		}
		
	}
}
