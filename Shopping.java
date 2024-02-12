import java.util.*;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
public class Shopping extends Attraction{
	
	ArrayList<String> shops = new ArrayList<>();
	public Shopping(){
	}
	public Shopping(int cityid ,int type, String name){
		super(cityid, type , name);
		
	}
	
	public Shopping(String name){
		super(name);
	}
	
	public void addshops(String shop){
		shops.add(shop);
	}
	public void removeshos(int i){
		shops.remove(i);
	}
	public String getshops(int i){
		return shops.get(i);
	}
	public int getnumberofshops(){
		return shops.size();
	}
}
