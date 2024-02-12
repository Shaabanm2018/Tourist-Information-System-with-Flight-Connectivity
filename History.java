
public class History extends Attraction{
	private double entrancefee;
	public History(){}
	public History(int cityid, int type, String name )
	{
		super(cityid, type, name);
	}
	public History(String name){
		super(name);
	}
}
