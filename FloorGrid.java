package project;
/**
 * This FloorGrid class is an abstract class with one abstract method 
 * for the floor grid initialization, which is taken care of by the 
 * PetiteFloorGrid and GrandeFloorGrid sub classes. This class also 
 * stores a 2D array of Seat objects, which are initialized later by 
 * other classes, and contains instance (integer) variables which store 
 * the number of rows and columns (of the 2D array for each floor grid 
 * type), and first class rows.
 * 
 * In this class are methods which return the instance variable values, 
 * the seats in the array to the left and right of a specific seat, a 
 * toString representation of a floor grid (grande or petite) and methods 
 * which query whether an economy or first class seat is available.
 * 
 * @author rherkt, 
 * @author 18022861
 */
public abstract class FloorGrid 
{
	protected Seat[][] seats;
	protected int nRows;
	protected int nColumns;
	protected int nFirstClassRows;
	
	/**
	 * This abstract method initializes the floor grid. As it is an 
	 * abstract method, it is overridden by the PetiteFloorGrid and 
	 * GrandeFloorGrid subclasses, which have their own algorithms 
	 * for initializing the floor grid since they have a different 
	 * number of rows, columns and first class rows.
	 */
	abstract protected void initialiseFloorGrid();
	
	/**
	 * This method returns the final (end) column of a floor grid 
	 * as a single character, by adding the nColumns value by 64 
	 * and casting it to a capital letter character.
	 * 
	 * @return final (end) column of a floor grid as a single 
	 * character.
	 */
	public char lastSeatPosition()
	{
		return (char)(nColumns + 64);	//type cast to represent a capital letter character
	}
	
	/**
	 * This method returns the bottom row of a floor grid 
	 * as an integer.
	 * 
	 * @return bottom row of a floor grid as an integer.
	 */
	public int lastSeatRow()
	{
		return nRows;
	}
	
	/**
	 * This method returns the seat to the left of the one 
	 * that is passed through as a parameter, if the seat 
	 * passed through is not in column A.
	 * 
	 * @param aSeat of type Seat
	 * @return the array indices of the seat to the left of 
	 * aSeat (e.g if aSeat[2][4], then seats[2][3] will be 
	 * returned), or nothing if the preconditions aren't met.
	 */
	public Seat getLeft(Seat aSeat)
	{
		//can't return a seat to the left of column A (0 in array)
		if ((aSeat.getSeatPosition().getColumn() > 'A') && (aSeat.getSeatPosition().getColumn() <= lastSeatPosition()))
		{
			SeatPosition position = new SeatPosition(aSeat.getSeatPosition().getRow(), aSeat.getSeatPosition().getColumn());
			//subtract 1 from row to get actual position, 'B'/66 from column to get column matrix number to left of aSeat column number
			Seat leftSeat = this.seats[position.getRow()-1][position.getColumn()-'B'];
			
			return leftSeat;		
		}
		else
		{
			return null;	//no seat returned if one cannot be found		
		}
	}
	
	/**
	 * This method returns the seat to the right of the one 
	 * that is passed through as a parameter, if the seat 
	 * passed through is not in the last column.
	 * 
	 * @param aSeat of type Seat
	 * @return the array indices of the seat to the right of 
	 * aSeat (e.g if aSeat[2][4], then seats[2][5] will be 
	 * returned), or nothing if the preconditions aren't met.
	 */
	public Seat getRight(Seat aSeat)
	{
		//can't return a seat to the right of the last column
		if ((aSeat.getSeatPosition().getColumn() >= 'A') && (aSeat.getSeatPosition().getColumn() < lastSeatPosition()))
		{
			SeatPosition position = new SeatPosition(aSeat.getSeatPosition().getRow(), aSeat.getSeatPosition().getColumn());
			//subtract 1 from row to get actual position, 64 from column to get column matrix number to right of aSeat column number
			Seat rightSeat = this.seats[position.getRow()-1][position.getColumn()-64];	
			
			return rightSeat;		
		}
		else
		{
			return null;	//no seat returned if one cannot be found		
		}
	}
	
	/**
	 * This method returns a toString representation of a floor 
	 * grid, with if/else statements and for loops determining 
	 * how the floor grid is printed, which is dependent on 
	 * certain conditions being met. To achieve this, an empty 
	 * string variable is created and the appropriate string 
	 * values are appended to the current string. Then, the 
	 * final result of the string is returned
	 *
	 * @return string representation of a floor grid.
	 */
	public String toString()
	{
		String grid = "";	//empty string created
		
		if (nRows == 10)	//the string appended depends on whether the grid is petite or grande
			grid += "    A      B      C      D      E      F      G";		
		else
			grid += "    A      B      C      D      E      F      G      H      I";
		
		grid += "\n";	//newline appended
		for (int j = 0; j < nRows; ++j)
		{
			//If the row number is less, then 9 a space is added to 
			//make the string representation look like the one 
			//given in the instructions			
			if (j < 9)	
				grid += " " + (j+1) + " ";
			else
				grid += (j+1) + " ";
			
			for (int k = 0; k < nColumns; ++k)
			{
				grid += seats[j][k] + " ";
			}
			grid += "\n";
		}
		return grid;	//string returned
	}
	
	/**
	 * This method queries whether a seat in economy class 
	 * is available (via looping) and returns one if it is 
	 * not reserved.
	 * 
	 * @param seatType enumerated value (type SeatType)
	 * @return a seat variable with array indices, or nothing 
	 * if a seat cannot be found.
	 */
	public Seat queryAvailableEconomySeat(SeatType aType)
	{
		for (int j = nFirstClassRows; j < nRows; ++j) //queries economy rows only
		{
			for (int k = 0; k < nColumns; ++k)
			{
				if (seats[j][k].getSeatType() == aType && seats[j][k].isReserved() == false) //if seat type matches & is not reserved
				{
					return seats[j][k];
				}
			}
		}
		return null;	//no seat returned if one cannot be found
	}
	
	/**
	 * This method queries whether a seat in first class 
	 * is available (via looping) and returns one if it is 
	 * not reserved.
	 * 
	 * @param seatType enumerated value (type SeatType)
	 * @return a seat variable with array indices, or nothing 
	 * if a seat cannot be found.
	 */
	public Seat queryAvailableFirstClassSeat(SeatType aType)
	{
		for (int j = 0; j < nFirstClassRows; ++j)	//queries first class rows only
		{
			for (int k = 0; k < nColumns; ++k)
			{
				if (seats[j][k].getSeatType() == aType && seats[j][k].isReserved() == false)	//if seat type matches & is not reserved
				{
					return seats[j][k];
				}
			}
		}
		return null;	//no seat returned if one cannot be found
	}
	
	/**
	 * This data encapsulation method gets a seat variable with 
	 * appropriate array indices (int row and char column) and 
	 * returns it to the caller.
	 * 
	 * @param row of type integer, column of type char
	 * @return a seat variable with array indices based on the 
	 * parameters given.
	 */
	public Seat getSeat(int seatRow, char seatPosition)
	{
		return seats[seatRow][seatPosition];
	}
}