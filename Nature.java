
public class Nature extends Attraction {
	private double entrancefee;
	public Nature(){}
	public Nature(int cityid, int type, String name )
	{
		super(cityid,type, name);
	}
	public Nature(String name){
		super(name);
	}
}