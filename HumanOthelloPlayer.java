import java.util.ArrayList;
import java.util.Scanner;

//Yuening Huang

public class HumanOthelloPlayer extends OthelloPlayer
{
	public HumanOthelloPlayer(String inName, String inColor)
	{
		super(inName, inColor);
		
	}
	public Location getMove( ArrayList<Location> list)
	{
		Scanner input = new Scanner(System.in);
		int row,col;
		boolean check=false;
		Location rtn;
		do
		{
			System.out.print("Enter row: ");
			row = input.nextInt();
			System.out.print("Enter col: ");
			col = input.nextInt();
			rtn= new Location(row,col);

			for(int i=0; i<list.size(); i++)
			{
				if(rtn.equals(list.get(i)))
					check=true;			
			}
			if(check!=true)
				System.out.println("Invalid move. please re-enter");
			
			
		}while(check!=true);
		
		return rtn;
	}
	
}
