package project;
import java.util.Random;
/**
 * This GrandeFloorGrid subclass (an extension of the FloorGrid class) 
 * has a default constructor that initializes the variables inherited from the 
 * superclass and a method which contains an algorithm for initializing 
 * the floor grid. This method contains the values initialized in the 
 * constructor as well as random numbers to determine a seat's 
 * availability.
 * 
 * @author rherkt, 
 * @author 18022861
 */
public class GrandeFloorGrid extends FloorGrid
{
	/**
	 * This default GrandeFloorGrid constructor initializes the values 
	 * inherited from the superclass accordingly, where nRows = 12, 
	 * nColumns = 9, nFirstClassRows = 6 and the seats array is set to 
	 * a size of [12][(char)74] or [12][J], in accordance with the char columns 
	 * variable in the SeatPosition class.
	 */
	public GrandeFloorGrid()
	{
		this.nRows = 12;
		this.nColumns = 9;
		this.nFirstClassRows = 6;
		//The columns figure in the array has been typecast and added by 'A'...
		//since the columns variable in the SeatPosition class is also a char
		this.seats = new Seat[nRows][(char)nColumns+'A'];	
	}
	
	/**
	 * This method uses random numbers, if/else conditions and nested for looping 
	 * to initialize the floor grid accordingly, ensuring seats of all types (window, 
	 * aisle and middle) and both classes have unique data values for their 
	 * position, first class status and reservation status.
	 * 
	 * For more information on how (and/or) why the algorithm works, please see 
	 * the programmer's (i.e. my) comments below:
	 */
	public void initialiseFloorGrid()
	{
		Random randNum = new Random();	//new Random object to randomly determine if seats are reserved or not
				
		for (int j = 0; j < nColumns; ++j)
		{
			if (j == 0 || j == 8)	//in words: if j row is a WINDOW row
			{
				for (int k = 0; k < nRows; ++k) //nested looping to iterate through the array to initialize individual seats
				{
					int reserved = randNum.nextInt(50);	//50 chosen, range of 0-49
					
					SeatPosition position = new SeatPosition((k+1), (char)(j+'A'));
					if (k < nFirstClassRows)	//if k is less than the number of FC rows then the seat is in FC
					{
						this.seats[k][j] = new Seat(position, SeatType.WINDOW, true);	//setting data values for a new seat
						//42 chosen due to 43/50 being a high probability (of seats being reserved)...
						//and showing the implementation of the different booking policies of the two...
						//train operators.
						if (reserved < 42) 
							this.seats[k][j].setReserved(true);	//reserves the seat (status: booked)
						else
							this.seats[k][j].setReserved(false);		
					}
					else
					{
						this.seats[k][j] = new Seat(position, SeatType.WINDOW, false);
						if (reserved < 42)
							this.seats[k][j].setReserved(true);
						else
							this.seats[k][j].setReserved(false);		
					}
				}
			}
			else if (j == 2 || j == 3 || j == 5 || j == 6)	//in words: if j row is an AISLE row
			{
				for (int k = 0; k < nRows; ++k)
				{
					int reserved = randNum.nextInt(50);
					
					SeatPosition position = new SeatPosition((k+1), (char)(j+'A'));
					if (k < nFirstClassRows)
					{
						this.seats[k][j] = new Seat(position, SeatType.AISLE, true);
						if (reserved < 42)
							this.seats[k][j].setReserved(true);
						else
							this.seats[k][j].setReserved(false);		
					}
					else
					{
						this.seats[k][j] = new Seat(position, SeatType.AISLE, false);
						if (reserved < 42)
							this.seats[k][j].setReserved(true);
						else
							this.seats[k][j].setReserved(false);		
					}
				}
			}
			else	//if j/Columns is equal to 1 or 4 or 7. In words: if j row is a MIDDLE row
			{
				for (int k = 0; k < nRows; ++k)
				{
					int reserved = randNum.nextInt(50);
					
					SeatPosition position = new SeatPosition((k+1), (char)(j+'A'));
					if (k < nFirstClassRows)
					{
						this.seats[k][j] = new Seat(position, SeatType.MIDDLE, true);
						if (reserved < 42)
							this.seats[k][j].setReserved(true);
						else
							this.seats[k][j].setReserved(false);		
					}
					else
					{
						this.seats[k][j] = new Seat(position, SeatType.MIDDLE, false);
						if (reserved < 42)
							this.seats[k][j].setReserved(true);
						else
							this.seats[k][j].setReserved(false);		
					}
				}
			}
		}
	}
}