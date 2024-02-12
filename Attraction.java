import java.util.*;
public abstract class Attraction {
	private int id;
	private String name;
	private int typeID;
	private String descirbe = "";
	private static int numberofobject =0;
	private int uniquid;
	
	public Attraction(){
		numberofobject++;
		uniquid = numberofobject;
	}
	public Attraction(int id,  int typeID,String name ){
		this.id = id;
		this.name = name;
		this.typeID = typeID;
		numberofobject++;
		uniquid = numberofobject;
	}
	public Attraction(String name){
		this.name = name;
		numberofobject++;
		uniquid = numberofobject;
	}
	public int getuniquid(){
		return uniquid;
		
	}
	public String getname1(){
		return name;
	}
	public int getid1(){
		return id;
	}
	public int gettypeID(){
		return typeID;
	}
	public void setdescribe(String descirbe){
		this.descirbe = descirbe;
	}
	public String getdescribe(){
		return descirbe;
	}
	public void display(Attraction a){
		System.out.println(getdescribe());
		if(a instanceof Sport)
	System.out.println("agaLimit: "+((Sport)a).getageLimit() + "+");
	if(a instanceof Culture)
		System.out.println("entrance fee: "+((Culture)a).getentrancefee() +"00");
	if(a instanceof Shopping)
	{
		System.out.println();
		System.out.println("list of shops ");
		for(int i = 0; i < ((Shopping)a).getnumberofshops() ; i++)
			System.out.println(i+1 + ". " +((Shopping)a).getshops(i));
	}
		
	
	
}
}