import java.util.*;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
public class Cities implements Comparable<Cities> {
	private int id;
	private String name;
	private int numberofAttraction;
	private String country;
	private static int numberofcity = 1;
	private ArrayList<Attraction> attractions = new ArrayList<>();
	public Cities(){
	}
	
	public Cities(int id, String name,String country){
		this.id = id;
		this.name = name;
		this.country = country;
		
	}
	public Cities(int id, String name){
		this.id = id;
		this.name = name;
		numberofcity ++;
	}
	
	public void setid(int id){
		this.id = id;
	}
	public String getname(){
		return name;
	}
	public String getAttractionname( int i){
		return attractions.get(i).getname1();
		}
		
		public int getnumberofobject1(int i){
			return attractions.get(i).getuniquid();
		}
	
	public void addAttraction(Attraction s){
		
		attractions.add(s);
		numberofAttraction++;
		
	}
	public int gettypeid(int i){
		return attractions.get(i).gettypeID();
	}
	
	public int getAttrationid(int i){
		return attractions.get(i).getid1();
	}
	
	public void removeAttraction(int i){
		attractions.remove(i);
		numberofAttraction--;
	}
	public int getnumberofAttraction(){
		return numberofAttraction;
	}
	
	
	public void getattration(int num){
		
		System.out.println(attractions.get(num).getname1());
		System.out.println("--------------");
	 attractions.get(num).display(attractions.get(num));
	
	 
	}
	
	
	
	public int compareTo(Cities c){
		if(getname().charAt(0) > c.getname().charAt(0))
			return 1;
		else if (getname().charAt(0) < c.getname().charAt(0))
			return -1;
		else 
			return 0;
	}
	
	
	public int getid()
	{
		return id;
	}
	
	
	public String getcountry(){
		return country;
	}
	
	public void attractionlist(){
		System.out.println("Attraction list is ");
		System.out.println("----------------------");
		for(int i = 0; i< attractions.size(); i++)
			System.out.println(i+1+" - "+  attractions.get(i).getname1());
		
	}
	
	public String getdescribe1(int i){
		return attractions.get(i).getdescribe();
	}
	
	public void setdescribe1(int num, String descirbe1)
	{
		attractions.get(num).setdescribe(descirbe1);
	}
	
	public double getentrancefee1(int i){
		if(attractions.get(i) instanceof Culture)
			return ((Culture)attractions.get(i)).getentrancefee();
		else return 0;
	}
	
	public int getnumberofshops1(int i){
		if(attractions.get(i) instanceof Shopping)
			return ((Shopping)attractions.get(i)).getnumberofshops();
		else return 0;
	}
	
	public int getageLimit1(int i){
			if(attractions.get(i) instanceof Sport)
			return ((Sport)attractions.get(i)).getageLimit();
		else return 0;
	}
	
	public void addshops1(int i, String shop)
	{
		if(attractions.get(i) instanceof Shopping)
			((Shopping)attractions.get(i)).addshops(shop);
	
	}
	
	public String getshops1(int i, int j )
	{
		if(attractions.get(i) instanceof Shopping)
			return ((Shopping)attractions.get(i)).getshops(j);
	else return "something wrong";
	}
	
	public void print(){
		System.out.println();
		System.out.println("______________________________");
		System.out.println();
		System.out.println("Citiy name:" + getname() + "\n" + "City id: "
		+ getid());
		
		
			System.out.println();
		System.out.println("[1]Attration list");
		System.out.println("[2]Type list");
	
			System.out.println("________________________________");
			System.out.println();
		
	}
	public void typelist(){
		System.out.println();
		System.out.println(" Types of attractions provided is ");
		System.out.println("----------------------------------");
		for(int i = 0; i< attractions.size(); i++)
		{
			if(attractions.get(i) instanceof Sport)
				System.out.println(i+1+". Sport");
			else if (attractions.get(i) instanceof Culture)
				System.out.println(i+1+". Culture");
			else if (attractions.get(i) instanceof Shopping)
				System.out.println(i+1+ ". Shopping");
			else if (attractions.get(i) instanceof History)
				System.out.println(i+1+ ". History");
			else if (attractions.get(i) instanceof Nature)
				System.out.println(i+1+ ". Nature");
		}
		System.out.println();
		
	}
}

