//Yuening Huang

import java.util.ArrayList;
import java.util.Scanner;

public class OthelloGame
{
	private OthelloPlayer humanPlayer;		//human Othello player
	private OthelloPlayer compPlayer;		//computer Othello player
	private Grid board;						//board

	//----------------------------------------------------------------------------------
	public OthelloGame()
	{

		//testing entire game with an 8 x8
		//board = new BoundedGrid(8);

		Scanner input = new Scanner(System.in);
		System.out.print("Enter board size: ");
		int boardSize = input.nextInt();
		board = new BoundedGrid(boardSize);

		//initialize the humanPlayer object
		//initialize the compPlayer object
		
		humanPlayer= new HumanOthelloPlayer("human", "B"); 
		compPlayer= new StupidComputerPlayer("computer", "W");
		//humanPlayer= new StupidComputerPlayer("comp2", "B");

		initializeBoard();
	}
	//----------------------------------------------------------------------------------
	//Description:  This method places the "B"'s and "W"'s in the appropriate 
	// 				place on the game board. Pretend you don't know the size of 
	// 				the board - i.e. write generically.

	//Postcondition: "B"'s and "W"'s are placed in the appropriate place on the
	//				 board.

	private void initializeBoard()
	{
		int h= board.getNumRows()/2;
		int w= board.getNumCols()/2;
		
		 board.put(new Location(h-1, w), "W");
		 board.put(new Location(h-1, w-1), "B");
		 board.put(new Location(h, w-1), "W");
		 board.put(new Location(h, w), "B");
	}
	//----------------------------------------------------------------------------------
	/*
	The playGame method (below) has the players alternate moves until the board is filled or both
	players have no legal moves.  A winner is then declared.

	When it's the human's turn, all legal moves are displayed on the screen.  If there are legal
	moves, the human is asked for a move (in another method).  The move is made and the board is
	reconfigured according to the rules of the game.  If there are no legal moves, display a message
	stating there are no legal moves. Switch the player.

	When it's the computer's turn, all legal moves are displayed on the screen.  If there are legal
	moves, a random move is selected (not in this method).   The move is made and the board is
	reconfigured according to the rules of the game.  If there are no legal moves display a message
	stating there are no legal moves. Switch the player.

	This method calls other methods to help do its job.
	*/

	public void playGame()
	{
		boolean end= false, p=true;
		String hName= humanPlayer.getName();
		String cName= compPlayer.getName();
		String hCol= humanPlayer.getColor();
		String cCol= compPlayer.getColor();
		boolean c=false, h=false;

		while (end== false)	//keep playing while the game is not over
		{
			
			board.display();
			if(p==true)
			{
				System.out.print(cName );
			}
			else 
				System.out.print(hName );
			System.out.println(" - your turn." );
					
			
			if(p==false)
			{
				h=move(humanPlayer);		
			}
			else
			{
				c= move(compPlayer);
			}
			
			if(c== true && h==true)
			{
				end=true;
			}
			//Check for a winner and provide code if a winner exists.
			//switch the current player
			
			p=!p;
		}
		//Announce winner or tie
		
		int hcount= getCount(humanPlayer);
		int ccount= getCount(compPlayer);
		System.out.println(hcount +" V " + ccount);

		if(hcount>ccount)
		{
			System.out.print(hName +" wins!");

		}
		else if((hcount<ccount))
		{
			System.out.print(cName +" wins!");
		}
		else
		{
			System.out.print("It's a tie!");
		}
		
	}

	public int getCount(OthelloPlayer obj)
	{
		int count=0;
		Location loc;
		
		for(int i=0; i<board.getNumRows(); i++)
		{
			for(int j=0; j<board.getNumCols(); j++)
			{
				loc= new Location (i,j);
				if(board.get(loc)!= null && board.get(loc) .equals(obj.getColor()))
				{
					count++;
				}
			}
		}
		
		return count;
	}
	
	public boolean move(OthelloPlayer obj)
	{
		System.out.println("legal moves: "+ getLegalMoves(obj.getColor()) );
		if(getLegalMoves(obj.getColor()).size()>=1)
		{
			Location m=obj.getMove(getLegalMoves(obj.getColor()));
		
		System.out.print("\nMOVING TO: " +m );
		
		updateBoard(m,obj.getColor());
		return false;
		}
		else
		{
			System.out.println("No moves possible");
			return true;
		}
		
	}
	
	//----------------------------------------------------------------------------------
	public ArrayList<Location> getLegalMoves(String curColor)
	{
		 ArrayList<Location> al= new ArrayList<Location>();  
	     ArrayList<Location> occupied= board.getOccupiedLocs(); 
	     Location loc,dir;
	     ArrayList<Location> valid;
	                
	     for(int i=0; i<occupied.size(); i++)
	    {
	         loc= occupied.get(i);
	         valid= board.getOccupiedAdjacentLocs(loc);
	   
	         if(board.get(loc).equals(curColor) )
	         {
	         for(int j=0; j<valid.size();j++)
	         {
	             if(board.get(valid.get(j)) .equals(curColor) ==false) 
	             {
	                 if( !(board.get(valid.get(j)) .equals(curColor) )&& board.get(valid.get(j)) !=null)
	                 {
	                     int n= loc.getDirectionToward(valid.get(j)); 
	                     dir= valid.get(j);
	 
	                     do
	                     {                            
	                         dir= dir.getAdjacentLoc(n);                                                 
	                     }
	                     while(board.isValid(dir) && board.get(dir)!=null && !(board.get(dir).equals(curColor)) );
	 
	                     if(board.isValid(dir) && board.get(dir)==null )
	                     {
	                         al.add(dir);
	                     }
	                         
	                 }   
	                                    
	             }                                 
	         }
	               
	         }
	    }
	 
	     for (int i=0; i<al.size() ; i++)
	     {
	          for (int y=i+1; y<al.size() ; y++)
	          {
	              if(al.get(y).equals(al.get(i)) && i!=y)
	              {
	                  al.remove(i);
	                  y--;
	              }
	          }
	     }
	           
	    return al;
	}
	//----------------------------------------------------------------------------------

	public void updateBoard(Location nextMove, String targetString)
	{
	     ArrayList<Location> occupied= board.getOccupiedAdjacentLocs(nextMove); 	     
	     Location temp;
	    
	     for(int i=0; i<occupied.size(); i++)
	     {
	    	 boolean d=true;
	    	 if(!board.get(occupied.get(i)).equals(targetString) )
	         {
	    		 int n=nextMove.getDirectionToward(occupied.get(i));
	    		 temp= occupied.get(i);	    		 
	    		 
	   		 for(int q=0; q<board.getOccupiedLocs().size() &&d==true;q++)
	    		 { 
	   			 	if(board.isValid(temp) && board.get(temp)!=null && board.get(temp).equals(targetString)  )				
	   			 		d=false;
	   			 	temp= temp.getAdjacentLoc(n);          
	    		 }
    		 temp= occupied.get(i);	    		 

	   		while(d==false)            
	   			{                                   
                if(board.isValid(temp) && board.get(temp)!=null && !board.get(temp).equals(targetString))
                	board.put(temp, targetString);                               
                else
                	d=true;
                temp= temp.getAdjacentLoc(n); 
	   			}
	         }
	    	 
	     }
	     board.put(nextMove, targetString);	     
	}
	
}