//Yuening Huang

import java.util.ArrayList;

public class BoundedGrid implements Grid
{
	private String[][] board;

	public BoundedGrid(int size)
	{
		board= new String [size][size];
	}
	
	public int getNumRows()
	{
		return board.length;
	}

	public int getNumCols()
	{
		return board[0].length;
	}

	//----------------------------------------------------------------------------
	//Precondition:  loc is not null
	//Postcondition: Returns true if loc is valid in this grid, false otherwise
	public boolean isValid(Location loc)
	{
		if( (loc.getRow()>=0 && loc.getRow()<getNumRows() )&&( loc.getCol()>=0 && loc.getCol()<getNumCols()) )
		{
			return true;
		}
		else 
			return false;
	}
	//----------------------------------------------------------------------------
	//Precondition:  (1) loc is valid in this grid
	//				 (2) theColor is not null
	//Postcondition:  Puts the String object at loc.
	//				  Returns the object previously at that location.
	public String put(Location loc, String theColor)
	{
		String rtn= board[loc.getRow()][loc.getCol()];
		board[loc.getRow()][loc.getCol()]= theColor;
		return rtn;
	}
	//----------------------------------------------------------------------------
	//Precondition:  (1) loc is valid in this grid
  //Postcondition: Removes the object at loc.
  //				 returns the object that was removed or null if the location is unoccupied
  public String remove(Location loc)
  {
  	String rtn= board[loc.getRow()][loc.getCol()];
		board[loc.getRow()][loc.getCol()]= null;
		return rtn;
  }

	//----------------------------------------------------------------------------
	//Precondition:  loc is valid in this grid
	//Postcondition: Returns the String at loc or null if the location is unoccupied.
	public String get(Location loc)
	{
		return board[loc.getRow()][loc.getCol()];
	}
	//----------------------------------------------------------------------------
	//Precondition:
	//Postcondition:  returns an ArrayList of all occupied locations in this grid
  public ArrayList<Location> getOccupiedLocs()
	{
  	ArrayList<Location> al= new ArrayList<Location>();
  	for(int i=0; i<board.length; i++)
  	{
  	   	for(int j=0; j<board[0].length; j++)
  	   	{	
  	   		if(board[i][j]!=null)
  	   			al.add(new Location(i,j));
  	   	}
  	}

  	return al;
	}

	//----------------------------------------------------------------------------
	//Precondition:  loc is valid in this grid
	//Postcondition: returns an ArrayList of valid locations adjacent to loc in
	//				 all eight compass directions (north, northeast, east, southeast,
	//				 south, southwest,west, and northwest).
	public ArrayList<Location> getValidAdjacentLocations(Location loc)
  {
  	ArrayList<Location> al= new ArrayList<Location>();	
  	
  	al.add(loc.getAdjacentLoc(Location.NORTH));
  	al.add(loc.getAdjacentLoc(Location.SOUTH));
  	al.add(loc.getAdjacentLoc(Location.WEST));
  	al.add(loc.getAdjacentLoc(Location.EAST));
  	al.add(loc.getAdjacentLoc(Location.NORTHWEST));
  	al.add(loc.getAdjacentLoc(Location.NORTHEAST));
  	al.add(loc.getAdjacentLoc(Location.SOUTHWEST));
  	al.add(loc.getAdjacentLoc(Location.SOUTHEAST));
  	
  	for (int i=al.size()-1; i>=0; i--)
		{
  		if(isValid(al.get(i)) ==false)
  			al.remove(i);
		}
  	return al;
  }

	//----------------------------------------------------------------------------

  //Precondition:  loc is valid in this grid
	//Postcondition: returns an ArrayList of valid empty locations adjacent to loc
	//				 in all eight compass directions (north, northeast, east,
	//				 southeast, south, southwest, west, and northwest).
  public ArrayList<Location> getEmptyAdjacentLocations(Location loc)
  {
  	ArrayList<Location> al= new ArrayList<Location>();	
  	ArrayList<Location> occupied= new ArrayList<Location>();	

  	al=getValidAdjacentLocations(loc);
  	occupied= getOccupiedLocs();
  	
  	for (int i=al.size()-1; i>=0; i--)
	{
  		for(int j=0; j<occupied.size(); j++)
  	   	{
  			if(al.get(i).equals(occupied.get(j)))
  				al.remove(i);
  	   	}
	}

  	return al;
  }


	//----------------------------------------------------------------------------
	//Precondition:	  loc is valid in this grid
	//Postcondition:  returns an ArrayList of valid occupied locations adjacent to
	//				  loc in all eight compass directions (north, northeast, east,
	//				  southeast, south, southwest, west, and northwest).
 	public ArrayList<Location> getOccupiedAdjacentLocs(Location loc)
	{
  	ArrayList<Location> al= getValidAdjacentLocations(loc);
  	ArrayList<Location> occupied= getOccupiedLocs(); 
  	ArrayList<Location> rtn= new ArrayList<Location>();	
  	
  	for (int i=al.size()-1; i>=0; i--)
	{
  		for(int j=0; j<occupied.size(); j++)
  	   	{
  			if(al.get(i).equals(occupied.get(j)))
  				rtn.add(al.get(i));
  	   	}
	}    	
  	
  	return rtn;
	}

	//----------------------------------------------------------------------------
	//Postcondition: displays the board and its values onto the screen.
	public void display()
	{
		System.out.println();
		System.out.print(String.format("%4s", " "));
		for (int i = 0; i < board[0].length; i++)
			System.out.print(String.format("%4d", i));

		System.out.println("\n");

		for (int i = 0; i < board.length; i++)
		{
			System.out.print(String.format("%4d", i));
			for (int j = 0; j < board[0].length; j++)
			{
				if (board[i][j] != null)
					System.out.print(String.format("%4s", board[i][j]));
				else
					System.out.print(String.format("%4s", "."));
			}
			System.out.println("\n");
		}

		System.out.println();
	}

	//----------------------------------------------------------------------------
}