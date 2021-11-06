package project;
/**
 * This SeatPosition class has information which contains the row and 
 * column of a seat in a floor grid (rows as integers and columns as 
 * characters - e.g. 1A, 5D, 8F).
 * 
 * @author rherkt, 
 * @author 18022861
 */
public class SeatPosition 
{
	private int row;
	private char column;
	
	/**
	 * This SeatPosition constructor has two inputs: the seat's row as 
	 * an integer and the column as a character, and sets the values 
	 * accordingly.
	 * 
	 * @param seat's row as an integer and the column as a character.
	 */
	public SeatPosition(int row, char column)
	{
		this.row = row;
		this.column = column;
	}
	
	/**
	 * This data encapsulation method returns the seat's row 
	 * as an integer.
	 * 
	 * @return seat's row as integer.
	 */
	public int getRow()
	{
		return this.row;
	}
	
	/**
	 * This data encapsulation method returns the seat's column 
	 * as a character.
	 * 
	 * @return seat's column as character.
	 */
	public char getColumn()
	{
		return this.column;
	}
}
