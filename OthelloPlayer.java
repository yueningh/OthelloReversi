import java.util.ArrayList;

//Yuening Huang

public abstract class OthelloPlayer 
{
	private String name;
	private String color;
	
	public OthelloPlayer(String inName, String inColor)
	{
		name = inName;
		color = inColor;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getColor()
	{
		return color;
	}
	
	public abstract Location getMove( ArrayList<Location> list);

}
