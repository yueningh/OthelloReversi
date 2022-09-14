//Yuening Huang

public class Location
{
	private int row;
	private int col;

	public static final int NORTH = 0;
	public static final int EAST = 90;
	public static final int SOUTH = 180;
	public static final int WEST = 270;
	public static final int NORTHEAST = 45;
	public static final int SOUTHEAST = 135;
	public static final int SOUTHWEST = 225;
	public static final int NORTHWEST = 315;

	public Location(int inRow, int inCol)
	{
		row= inRow;
		col= inCol;
	}

	public int getRow()
	{
		return row;
	}

	public int getCol()
	{
		return col;
	}

	//----------------------------------------------------------------------
	//Description:  Gets the adjacent location in any one of the eight
	//			    compass directions.
	//			    It is possible to return a Location that is out of bounds.
	//Precondition:  dir is one of the 8 compass directions.
	//Postcondition: returns the adjacent location in the direction that is closest to dir
	public Location getAdjacentLoc(int dir)
	{
		if(dir==NORTH)
		{
			return new Location (row-1, col);
		}
		else if (dir==EAST)
		{
			return new Location(row, col+1);
		}
		else if (dir==SOUTH)
		{
			return new Location(row+1, col);
		}
		else if (dir==WEST)
		{
			return new Location(row, col-1);
		}
		else if (dir==NORTHEAST)
		{
			return new Location(row-1, col+1);
		}
		else if (dir==SOUTHEAST)
		{
			return new Location(row+1, col+1);
		}
		else if (dir==NORTHWEST)
		{
			return new Location(row-1, col-1);
		}
		else
		{
			return new Location(row+1, col-1);
		}

	}

	//----------------------------------------------------------------------
	//Description: Returns the direction from this location toward another
	//             location. The direction is one of the eight compass
	//             directions.
	//Precondition:  target - a location that is different from this location.
	//			 	 target is an adjacent Location.
	//				 target is valid in the matrix
	//Postcondition: returns the closest compass direction from this location
	//				 toward target
	public int getDirectionToward(Location target)
	{		 
		 if(target.getCol()==col)
		 {
			if(target.getRow()<row)
				return NORTH;
			else if (target.getRow()>row)
				return SOUTH;
		 }	
		 
		 if(target.getRow()==row)
		 {
			 if (target.getCol()<col)
				 return WEST;
			 else if (target.getCol()>col)
				 return EAST;
		 }
		 
		 if(target.getCol()<col)
		 {
			 if(target.getRow()<row)
				 return NORTHWEST;		 
			 else if (target.getRow()>row)
				 return SOUTHWEST;
		 }

		if (target.getCol()>col)
		 {
			 if(target.getRow()<row)
				  return NORTHEAST;		 
			 else if(target.getRow()>row)
				 return SOUTHEAST;
		 }
		return NORTH;
	}

	//----------------------------------------------------------------------
	//override .equals method
	//Description: Determines if this Location is equal to otherLoc
	//Precondition: otherLoc is a Location object and is valid in the matrix
	//Postcondition: return true if otherLoc is a Location with the same row
	//               and column as this location; false otherwise.
	public boolean equals(Object otherLoc)
	{
		if(row== ((Location)otherLoc).getRow() && col== ((Location)otherLoc).getCol())
			return true;
		else 
			return false;
	}

	//----------------------------------------------------------------------
	//Postcondition: returns a String with the row and col of this location
	//				 in the format: (row, col)
	public String toString()
	{
		return "("+row +", "+col +")";
	}

}