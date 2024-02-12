
public class Sport extends Attraction{
	private int ageLimit;
	public Sport(){
	}
	public Sport(String name){
		super(name);
	}
	public Sport(int id, String name, int typeID, int ageLimit){
		super(id, typeID, name);
		this.ageLimit = ageLimit;
	}
	public Sport(int cityid ,int type, String name, int ageLimit){
		super(cityid,type, name);
		this.ageLimit = ageLimit;
	}
	public int getageLimit(){
	return ageLimit;
	}
	
	public void setageLimit(int ageLimit){
	this.ageLimit = ageLimit;
}
	
}