import java.util.*;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
class Stack1 {
	
  private ArrayList<Directflights> list = new  ArrayList<>();
	public Stack1(){
	}
  public int getSize() {
    return list.size();
  }

  public Directflights peek() {
    return list.get(getSize() - 1);
  }

  public void push(Directflights o) {
    list.add(o);
  }

  public Directflights pop() {
    Directflights o = list.get(getSize() - 1);
    list.remove(getSize() - 1);
    return o;
  }

  public boolean isEmpty() {
    return list.isEmpty();
  }
  
  @Override
  public String toString() {
    return "stack: " + list.toString();
  }
  
  public int serch(int a, int b){
	  int  j =1;
	  for(int i = 0; i < list.size(); i++){
		if((a == list.get(i).getAcity().getid() && b == list.get(i).getBciy().getid())||
		(b == list.get(i).getAcity().getid() && a == list.get(i).getBciy().getid()))
		{
	  System.out.println("There are direct flight between " + list.get(i).getAcity().getname() + " city and " + 
	  list.get(i).getBciy().getname() + " city");
	  
	  j =2;
	  return i;
		}
	  }
	  if(j == 1)
		  System.out.println("Sorry There is not direct line ");
	  
		  return 9;
  }

  
}