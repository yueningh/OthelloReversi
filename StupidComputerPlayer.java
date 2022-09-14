import java.util.ArrayList;

//Yuening Huang

public class StupidComputerPlayer extends OthelloPlayer
{
	public StupidComputerPlayer(String inName, String inColor)
	{
		super(inName, inColor);
	}
	
	public Location getMove( ArrayList<Location> list)
	{
		int m= (int) (Math.random()*list.size());
		
		return list.get(m);
	}
}
