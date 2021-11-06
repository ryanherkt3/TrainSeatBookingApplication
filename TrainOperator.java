package project;
/**
 * This TrainOperator class is an abstract class with two abstract methods
 * for first class and economy class seat reservations, which are taken care 
 * of by the TrainSmart and TrainWay subclasses. This class also contains 
 * data encapsulation for the operator name (get & set methods), a toString 
 * representation of a train operator and a constructor
 * 
 * @author rherkt, 
 * @author 18022861
 */
public abstract class TrainOperator 
{
	private String operatorName;
	
	/**
	 * This Seat constructor has one parameter: the operatorName, which is 
	 * a string. This parameter comes from the initialization of a new 
	 * TrainOperator object in the TrainSeatBookingApplication class as 
	 * a constructor.
	 * 
	 * @param train operator's name as a string.
	 */
	public TrainOperator(String operatorName)
	{
		this.setOperatorName(operatorName);
	}
	
	/**
	 * This abstract method reserves a first class seat. As it is an 
	 * abstract method, it is overridden by the TrainSmart and 
	 * TrainWay subclasses, which have their own algorithms 
	 * for reserving the first class seat as they both have different 
	 * booking policies.
	 * 
	 * @param aJourney as a TrainJourney, aSeat as a SeatType enum
	 * @return Seat of type aSeat, but only in the subclasses mentioned 
	 * which override this method
	 */
	abstract public Seat reserveFirstClass(TrainJourney aJourney, SeatType aSeat);
	
	/**
	 * This abstract method reserves an economy seat. As it is an 
	 * abstract method, it is overridden by the TrainSmart and 
	 * TrainWay subclasses, which have their own algorithms 
	 * for reserving the economy seat as they both have different 
	 * booking policies.
	 * 
	 * @param aJourney as a TrainJourney, aSeat as a SeatType enum
	 * @return Seat of type aSeat, but only in the subclasses mentioned 
	 * which override this method
	 */
	abstract public Seat reserveEconomy(TrainJourney aJourney, SeatType aSeat);

	/**
	 * This data encapsulation method gets a train operator's name as a 
	 * string and returns it to the caller.
	 * 
	 * @return operatorName as a string.
	 */
	public String getOperatorName() 
	{
		return operatorName;
	}

	/**
	 * This data encapsulation method sets a train operator's name as a 
	 * string, ensuring no unauthorized modification of the name.
	 * 
	 * @param operatorName as a String.
	 */
	public void setOperatorName(String operatorName) 
	{
		this.operatorName = operatorName;
	}
	
	/**
	 * This toString method sets returns a String representation of a 
	 * TrainOperator object, proving a succinct yet clear description 
	 * of the train operator and the company they work for (TrainSmart 
	 * or TrainWay).
	 * 
	 * @return String representation of TrainJourney object.
	 */
	public String toString()
	{
		return "Your train conductor today is " + operatorName;
	}
}
