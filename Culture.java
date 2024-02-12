
public class Culture extends Attraction{
	
	private double entrancefee;
	public Culture(){
	}
	public Culture(int cityid, String name, int type, double entrancefee){
		super(cityid, type, name);
		this.entrancefee = entrancefee;
	}
	public Culture(int cityid ,int type, String name, double entrancefee){
		super(cityid, type, name);
		this.entrancefee = entrancefee;
		
	}
	public Culture(String name){
		super(name);
		
	}
	public double getentrancefee(){
		return entrancefee;
	}
	public void setentrancefee(double entrancefee){
		this.entrancefee = entrancefee;
	}
}