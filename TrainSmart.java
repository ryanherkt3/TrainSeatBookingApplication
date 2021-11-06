package project;
/**
 * This TrainSmart subclass (an extension of the TrainJourney class) 
 * has a default constructor which calls the super keyword with the 
 * string as a parameter, and two methods which contain algorithms for 
 * booking first class and economy seats based on the TrainSmart booking 
 * policy.
 * 
 * @author rherkt, 
 * @author 18022861
 */
public class TrainSmart extends TrainOperator
{
	/**
	 * This TrainSmart constructor contains one parameter - the train 
	 * operator's name as a String, and uses the super keyword to invoke 
	 * the TrainJourney constructor.
	 * 
	 * @param train operator's name (aString) as a string.
	 */
	public TrainSmart(String aString)
	{
		super(aString);
	}

	/**
	 * This overridden reserveFirstClass method contains an 
	 * algorithm for booking a first class seat based on the TrainSmart 
	 * booking policy. This method returns a seat and has two parameters - 
	 * the train journey and the user's requested seat type. Booking policy:
	 * 
	 * 1) book a first class seat of matching type; if this isn't possible:
	 * //2 and 3 are combined steps, per the assignment instructions...
	 * 2) book a window seat in economy class; if this isn't possible:
	 * 3) book an aisle seat in economy class. 
	 * 
	 * If neither 2 nor 3 return a seat, the method returns null/no seat, 
	 * meaning a booking couldn't be made.
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
			//search for an available window seat in economy
			aSeat = aJourney.getSeating().queryAvailableEconomySeat(SeatType.WINDOW);
			if (aSeat != null)
			{
				return aSeat;
			}
			else
			{
				//search for an available aisle seat in economy
				aSeat = aJourney.getSeating().queryAvailableEconomySeat(SeatType.AISLE);
				if (aSeat != null)
				{
					return aSeat;
				}
			}
			return null;
		}
	}

	/**
	 * This overridden reserveEconomy method contains an algorithm for 
	 * booking an economy class seat based on the TrainSmart 
	 * booking policy. This method returns a seat and has two parameters - 
	 * the train journey and the user's requested seat type. Booking policy:
	 * 
	 * 1) book an economy seat of matching type; if this isn't possible:
	 * the method returns null/no seat, meaning a booking couldn't be made.
	 * 
	 * @param train journey as TrainJourney, seat type (enum) as SeatType.
	 */
	@Override
	public Seat reserveEconomy(TrainJourney aJourney, SeatType aType) 
	{
		//search for an available economy seat of requested type
		Seat aSeat = aJourney.getSeating().queryAvailableEconomySeat(aType);
		
		if (aSeat != null)	//if aSeat is populated with a seat value
		{
			return aSeat;	//return seat if one is found
		}
		else
		{
			return null;
		}
	}
}