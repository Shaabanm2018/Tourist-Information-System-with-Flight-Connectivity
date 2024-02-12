import java.util.*;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
public class Main2 {
	public static void main(String [] args){
		char c;
		int chose;
		int num;
		int x = 0;
		c = 'a';
		System.out.println();
		Scanner input = new Scanner(System.in);
		char q = 'a';
	
		ArrayList <Cities> city = new ArrayList<>();
		
		

		java.io.File file = new java.io.File("city.txt");
		try{
			
			Scanner input1 = new Scanner (file);
			while(input1.hasNext())
			{
				int num2 = input1.nextInt();
				String num1 = input1.nextLine();
				
				city.add(new Cities(num2, num1));
			}
		
		}
		catch(FileNotFoundException e)
		{
			System.out.println(e);
		}
		
			Collections.sort(city);
		
		java.io.File file2 = new java.io.File("attraction.txt");
		try{
			Scanner input2 = new Scanner (file2);
			while(input2.hasNext())
			{
				
			int citynumber = input2.nextInt();
			
				int age = 0;
				double fee = 0;
				int attractiontype = input2.nextInt();
				if(attractiontype == 2)
					age = input2.nextInt();
				if(attractiontype == 1)
					fee = input2.nextDouble();
				int attid;
				String type = "d";
				String attractionname = input2.next();
				String des = input2.nextLine();
				
				
				
				if (attractiontype == 1)
					type = "c";
				else if (attractiontype == 2)
				 type = "s";
				else if (attractiontype == 3)
					type = "o";

					else if (attractiontype == 4)
				     type = "h";
					else if (attractiontype == 5)
				type = "n";
				
			if(type == "c"){
				
				Attraction first = new Culture(citynumber, attractiontype , attractionname, fee);
				first.setdescribe(des);
				city.get(citynumber).addAttraction(first);
			}
			else if(type == "s"){
				
				Attraction second = new Sport(citynumber, attractiontype, attractionname, age);
				second.setdescribe(des);
				city.get(citynumber).addAttraction(second);
			
			}
			else if(type == "o"){
				
				
				Attraction third = new Shopping(citynumber, attractiontype, attractionname);
				third.setdescribe(des);
				city.get(citynumber).addAttraction(third);
				
			}
			else if(type == "h"){
				
				
				Attraction fourth = new History(citynumber, attractiontype, attractionname);
				fourth.setdescribe(des);
				city.get(citynumber).addAttraction(fourth);
			}
			else if(type == "n"){

				
				Attraction fifth = new Nature(citynumber, attractiontype, attractionname);
				fifth.setdescribe(des);
				city.get(citynumber).addAttraction(fifth);
			
			}
				
			
			}
		}
		catch(FileNotFoundException e)
		{
			System.out.println(e);
		}
		
		
		
		
		
		
		
		
		
		
		
		ArrayList <Directflights> line1 = new ArrayList<>();
		java.io.File file3 = new java.io.File("directflight.txt");
			Stack1 stack = new Stack1();
			try{
			
			Scanner input4 = new Scanner (file3);
			while(input4.hasNext())
			{
				int firstcity = input4.nextInt();
				int secondcity = input4.nextInt();
			   double price = input4.nextDouble();
				String time1 = input4.next();
				String time2 = input4.next();
			line1.add(new Directflights(city.get(firstcity), city.get(secondcity), price, time1, time2));
				
			}
		
		}
		catch(FileNotFoundException e)
		{
			System.out.println(e);
		}
		catch(InputMismatchException e){
			System.out.println("data wrong");
		}
		for(int i = 0 ; i< line1.size(); i++)
			stack.push(line1.get(i));		
					
					
					
				for(int j = 0; j < city.size() ; j++){
			for(int i = 0; i < city.get(j).getnumberofAttraction(); i++)
				if(city.get(j).gettypeid(i) == 3 )
				{
					String name22 = city.get(j).getAttractionname(i)+".txt";
						java.io.File file33 = new java.io.File(name22);
					try{
						Scanner input44 = new Scanner (file33);
			
				
				while(input44.hasNext())
			{
			  String shop = input44.next();
			  city.get(j).addshops1(i , shop);
			  
				
			}
					}
			catch(FileNotFoundException e)
		{
			System.out.println(e);
		}
		catch(InputMismatchException e){
			System.out.println("data wrong");
		}	
			
				}
			}		
				
			
	
			while(x != 4)
		{
			System.out.println();
		System.out.println("-----------------------------------------");
		System.out.println("  Welcome To tourist information system  ");
		System.out.println("-----------------------------------------");
		System.out.println("[1]About_us, [2]Cities, [3]Comment, [4]Quit, \n[5]Adman, [6]View_Directflight, [7]Inquiry, [8]Reading_from_file ");
		System.out.print("--> ");
		x = 0;
		while ((x != 2)&&(x != 1)&&(x != 3)&&(x != 4)&&(x != 5)&&(x!=6)&&(x!=7)&&(x != 8))
		{
		try{
		x = input.nextInt();
		}
		 catch(InputMismatchException ex){
		  
		   input.nextLine();
	  }
	  if((x != 2)&&(x != 1)&&(x != 3)&&(x != 4) && (x != 5)&&(x != 6)&&(x!=7) && (x != 8))
	   System.out.print("Input Error: 2 numbers are required. ");
		}
	if(x == 4)
		 System.exit(1);
	System.out.println();
		
		
		while(x == 5)
		{
			int admin = 0;
			int entry = 0;
			System.out.println("-----------------");
			System.out.println("Admin department ");
			System.out.println("-----------------");
			System.out.println("[1]Cities_Adminstration, [2]Attraction_Adminstration, [3]DirectFlight_Adminstration, [0]GoBack ");
			System.out.print("--> ");
			while(admin != 1 && admin != 2 && admin != 3)
			{
				try{
					admin = input.nextInt();
					if(admin == 0)
						break;
				}
				catch (InputMismatchException e){
					input.nextLine();
				}
				if(admin != 1 && admin != 2 && admin != 3)
					System.out.print("Input error try again --> ");
			}
			
			if(admin == 1)
			{
				
				System.out.println();
				System.out.println("Cities Administration");
				System.out.println("----------------------");
				System.out.println("[1]Insert new city, [2]Delete a city ");
				System.out.print("--> ");
				while(entry != 1 && entry != 2){
				
				try{
				entry = input.nextInt();
				}
						catch (InputMismatchException e){
					input.nextLine();
				}
				if(entry != 1 && entry != 2)
					System.out.print("Input error try again --> ");
				}
				if(entry == 1)
				{
					String name;
				

					System.out.println();
					System.out.println("Enter new city name ");
					String name1 = " ";
					name = input.next();
					int y = city.size() + 1;
					name1 = name1 + name;
					city.add(new Cities (y, name1));
					
				}
				
				else if(entry == 2)
				{
					int delete = 0;
					System.out.println("Cities list");
		System.out.println(" ---------------------------------");
		for(int i = 0; i < city.size(); i++)
			System.out.println(i+ 1 + ". " + city.get(i).getname());
		System.out.println(" ---------------------------------");
					System.out.print("Select your number of city to be deleted -->");
					while(delete > city.size() || delete <= 0)
					{
						try{
					delete = input.nextInt();
						}
						catch(InputMismatchException e)
						{
							input.nextLine();
						}
						if(delete > city.size() || delete <= 0)
							System.out.print("Error input please try again --> ");
					}
					city.remove(delete - 1);
					
					Collections.sort(city);
				}
				
			}
			
			else if(admin == 2)
			{
				int intry2 = 0;
				System.out.println("Attraction Administration");
				System.out.println("--------------------------");
				System.out.println("[1]Insert new Attraction, [2]Delete an Attraction ");
				System.out.print("-->");
				while (intry2 != 1 && intry2 != 2)
				{
					try {
				intry2 = input.nextInt();
					}
					catch (InputMismatchException e)
					{
						input.nextLine();
					}
					if(intry2 != 1 && intry2 != 2)
						System.out.print("Input error please try again --> ");
			}
				if(intry2 == 1)
				{
					int temp = 0;
					String nametemp;
					int typetemp = 0;
						System.out.println("Cities list");
		System.out.println(" ---------------------------------");
		for(int i = 0; i < city.size(); i++)
			System.out.println(i+ 1 + ". " + city.get(i).getname());
		System.out.println(" ---------------------------------");
		String descirbe4 = " ";
					System.out.print("Select your number of city to add new Attraction -->");
					while(temp > city.size() || temp <= 0)
					{
						try{
					temp = input.nextInt();
						}
						catch(InputMismatchException e)
						{
							input.nextLine();
						}
						if(temp > city.size() || temp <= 0)
							System.out.print("Error input please try again --> ");
					}
					System.out.println();
					System.out.println("Select your Attraction Type ");
					System.out.println("[1]Culture ,[2]Sport ,[3]Shopping , [4]History ,[5]Nature ");
					while(typetemp > 5 || typetemp <= 0)
					{
						try {
					typetemp = input.nextInt();
						}
						catch(InputMismatchException e)
						{
						input.nextLine();
					}
					if(typetemp > 5 || typetemp <= 0)
						System.out.print("Error input please try again --> ");
				}
				int age1 = 0;
				double fee1 = 0.00;
				String shop1 ;
				
				if(typetemp == 2){
					System.out.println("Enter age limit ");
					age1 = input.nextInt();
				}
				if(typetemp == 1)
				{
					System.out.println("Enter the entrance fee ");
					fee1 = input.nextDouble();
				}
					Scanner input11 = new Scanner (System.in);
					System.out.println("Enter your Attraction Name ");
					nametemp = input11.nextLine();
					StringBuilder p = new StringBuilder (nametemp);
					for(int i = 0 ; i < nametemp.length(); i++)
						if(nametemp.charAt(i) == ' ')
						{
								p.setCharAt(i , '_');
						}
					temp = temp -1;
					System.out.println("Enter description for a new Attraction ");
					String descirbe3 = input11.nextLine();
					descirbe4 = descirbe4 + descirbe3;
						if(typetemp == 1){
				city.get(temp).addAttraction(new Culture(temp, typetemp, p.toString(), fee1));
			
						}
			else if(typetemp == 2){
				city.get(temp).addAttraction(new Sport(temp, typetemp, p.toString(), age1));
				
			}
			else if(typetemp == 3){
				city.get(temp).addAttraction(new Shopping(temp, typetemp, p.toString()));
		
			
					
					int i = city.get(temp).getnumberofAttraction() - 1;
					int yy = 3;
					while(yy != 0)
					{
						yy = 5;
						Scanner input5 = new Scanner(System.in);
						System.out.println("Enter shops, 0 to go_back ");
						shop1 = input5.nextLine();
						
						city.get(temp).addshops1(i, shop1);
						
						System.out.println("Enter 1 to add more , 0 togoback -- >");
						
						while(yy != 0 && yy != 1){
						try{
						yy = input.nextInt();
						}
						catch(InputMismatchException e){
							input.nextLine();
/////////////////////
						}
						if(yy != 0 && yy != 1)
					System.out.println("Enter 1 to add more , 0 togoback -- >");
					}
					}
				}
				
			
			else if(typetemp == 4){
				city.get(temp).addAttraction(new History(temp, typetemp, p.toString()));
			
			}
			
			else if(typetemp == 5){
				city.get(temp).addAttraction(new Nature(temp,typetemp, p.toString()));		
			}
			int num3 = city.get(temp).getnumberofAttraction();
			city.get(temp).setdescribe1(num3-1, descirbe4);
				}
				
				else if(intry2 == 2)
				{
					int delete2 = 0;
					int delete1 = 0;
					System.out.println("Cities list");
		System.out.println(" ---------------------------------");
		for(int i = 0; i < city.size(); i++)
			System.out.println(i+ 1 + ". " + city.get(i).getname());
		System.out.println(" ---------------------------------");
					System.out.print("Select your number of city to delete Attraction from -->");
					while(delete2 > city.size() || delete2 <= 0)
					{
					try
					{
						delete2 = input.nextInt();
					}
					catch(InputMismatchException e)
					{
						input.nextLine();
					}
					if(delete2 > city.size() || delete2 <= 0)
						System.out.print("Input error please try again --> ");
					}
					delete2 = delete2 -1;
					//city.get(delete2).attractionlist();
					
					
					city.get(delete2).attractionlist();
					System.out.println("Select your number of Attraction do delete ");
					System.out.println("--> ");
					while(delete1 > city.get(delete2).getnumberofAttraction() || delete1 <= 0)
					{
						try {
					delete1 = input.nextInt();
						}
						catch(InputMismatchException e)
						{
							input.nextLine();
						}
						if(delete1 > city.get(delete2).getnumberofAttraction() || delete1 <= 0)
							System.out.print("Input error please try again --> ");
					}
					delete1 = delete1 -1;
					
					city.get(delete2).removeAttraction(delete1);
				}
				
			}
			
			else if(admin == 3)
			{
				int direct1 = 0;
				int direct4 = 0;
				System.out.println();
				System.out.println("DirectFlight Administration");
				System.out.println("----------------------------");
				System.out.println("[1]insert new direct line, [2]delete a line ");
				System.out.print("--> ");
				while(direct1 != 1 && direct1 != 2)
				{
					try {
				direct1 = input.nextInt();
					}
					catch(InputMismatchException e)
					{
						input.nextLine();
					}
					if(direct1 != 1 && direct1 != 2)
						System.out.print("Input error please try again --> ");
				}
				if(direct1 == 1)
				{
					int firstone = 0; 
					int secondone = 0;
					double price1 = 0.00;
					String timeone;
					String timetwo;
					
						System.out.println("Cities list");
		System.out.println(" ---------------------------------");
		for(int i = 0; i < city.size(); i++)
			System.out.println(i+ 1 + ". " + city.get(i).getname());
		System.out.println(" ---------------------------------");
					System.out.print("Select 2 cities number to Enter a direct line flight -->");
					while(firstone > city.size() || firstone <= 0)
					{
						try {
					firstone = input.nextInt();
						}
						catch(InputMismatchException e)
						{
							input.nextLine();
						}
						if(firstone > city.size() || firstone <= 0)
							System.out.print("Input error please try again -->");
					}
					
						while(secondone > city.size() || secondone <= 0)
					{
						try {
					secondone = input.nextInt();
						}
						catch(InputMismatchException e)
						{
							input.nextLine();
						}
						if(secondone > city.size() || secondone <= 0)
							System.out.print("Input error please try again --> ");
					}
						System.out.println("Enter a price of a ticket ");
					while(price1 <= 0){
				try {
					price1 = input.nextDouble();
				}
				catch(InputMismatchException e){
					input.nextLine();
				}
				if(price1 <= 0)
					System.out.print("Invalid entry please try again --> ");
					}
					System.out.println("Enter a time depart");
					timeone = input.next();
					System.out.println("Enter a time arrival ");
					timetwo = input.next();
					
					line1.add(new Directflights(city.get(firstone-1), city.get(secondone-1), price1, timeone, timetwo));
					
				}
				
				else if(direct1 == 2)
				{
					for(int i = 0 ; i < line1.size(); i++)
							line1.get(i).displaydirect(i+1);
						System.out.println("please select your line number to delete ");
						while(direct4 > line1.size() || direct4 <= 0)
						{
							try {
						direct4 = input.nextInt();
							}
							catch(InputMismatchException e)
							{
								input.nextLine();
							}
							if(direct4 > line1.size() || direct4 <= 0)
								System.out.print("Input error please try again --> ");
						}
						direct4 = direct4 - 1;
						line1.remove(direct4);
				}
				
				
				
				
				
				
				
				
				
				
			}
			if(admin == 0)
				break;
			x = 2;
			System.out.println();
		System.out.print("Enter 0 for [Home_bage] or 5 to continue -->");
			while(x != 5 && x != 0){
				try {
						x = input.nextInt();
				}
				catch (InputMismatchException e)
				{
					input.nextLine();
				}
				if(x != 5 && x != 0)
					System.out.print("Enter 0 for[Home_bage] or 5 to continue -->");
			}
		
		}
		
		while(x == 6)
		{
			
	
			System.out.println();
			for(int i =0;i < line1.size(); i++)
			line1.get(i).displaydirect(i+1);
		
		
		
		
		
		
		
		
		
		
		char save13 = 'w';
			while(save13 != 'n' && save13 != 'N')
			{
				System.out.println("Do you want to save [Y]es ,[N]o ? ");
					System.out.print("--> ");
				while( save13 != 'N' && save13 != 'n' &&  save13 != 'y' && save13 != 'Y'){
					try{
				save13 = input.next().charAt(0);
					}
					catch(InputMismatchException e){
						System.out.println(e);
					}
					if( save13 != 'N' && save13 != 'n' && save13 != 'y' && save13 != 'Y'){
						System.out.println("Do you want to save [Y]es ,[N]o ? ");
					    System.out.print("--> ");
					}
				}
				if(save13 == 'y' || save13 == 'Y')
				{
					
						try{
						System.out.print("Enter the file name to save in --> ");
						String tempname13 = input.next();
			BufferedWriter ww13 = new BufferedWriter(new FileWriter(tempname13));
			for (int i =0 ; i < line1.size(); i ++){
				 int k = i + 1;
				 ww13.write("\n");
			ww13.write("direct_flight number " + k);
			ww13.write("\n");
				ww13.write("------------------------------------------------------------------------------");
				ww13.write("\n");
				ww13.write("From              Depart               TO");
				ww13.write("\n");
						ww13.write(line1.get(i).geta() + "           " +  line1.get(i).gettimedepart() + "--->         "+line1.get(i).getb());
						ww13.write("\n");
						ww13.write("EI Part lntl.Apt." + "             " +  line1.get(i).getdepartdate() + "                 " + line1.get(i).gettimearrival());
						ww13.write("\n");
						ww13.write("Price: " + line1.get(i).getprice()+"$");
						ww13.write("\n");
						ww13.write("------------------------------------------------------------------------------");
		ww13.write("\n");
			}
			ww13.close();
			
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
					
				}	
				System.out.println();
				
					break;
					
					
				
			}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
			System.out.print("Enter 0 to go back or 4 to close the program -->");
			int d = 1;
			while(d != 0 && d != 4){
				try {
					d = input.nextInt();
					x = d;
					if(d == 4)
						System.exit(1);
					
				}
				catch(InputMismatchException ex){
					input.nextLine();
				}
				if( d != 0 && d != 4)
					System.out.print("Enter 0 to go back or 4 to close the program -->");
		
				
		}
		}
		
		while(x == 8){
			int lineNumber = 0;
		try {
			Scanner input8 = new Scanner (System.in);
			System.out.print("Enter File Name --> ");
			String filename = input8.next();
			BufferedReader in = new BufferedReader(new FileReader(filename));
			
			String line = null;
			while((line = in.readLine()) != null){
				lineNumber++;
				System.out.println(line);
				
			}
			
		}
		catch(IOException e)
		{
			System.out.println();
			System.out.println(" The File Does Not Exist ! ");
		}
		System.out.println();
		
			System.out.print(" Enter 8 to ask again or 0 to go bake --> ");
			x = 111;
			while(x != 8&& x != 0){
			try{
			x = input.nextInt();
			}
			catch (InputMismatchException e){
			input.nextLine();
			}
			if(x != 8&& x != 0)
				System.out.print(" Enter 8 to ask again or 0 to go bake --> ");
			}
		}
		
		
		
		
		
		
		
		
			
			while(x == 7)
			{
				
				int s = 1;
			
		
			int a = 0;
			int b = 0;
			System.out.println();
			System.out.println();
			
			System.out.println("welcome to department of inquiry about direct line");
			
			System.out.println("---------------------------------------------------");
		
			while(s == 1){
				System.out.println("Cities list");
		System.out.println(" ---------------------------------");
		for(int i = 0; i < city.size(); i++)
			System.out.println(i+ 1 + ". " + city.get(i).getname());
		System.out.println(" ---------------------------------");
			System.out.println("Enter two number of cities to search about flight direct line ");
			System.out.print("-->");
			int z = 9;
			while (z > city.size() || z <= 0)
			{
				try{
			a = input.nextInt();
			z = a;
				}
				catch(InputMismatchException ex){
					input.nextLine();
				}
			if (z > city.size() || z <= 0){
			System.out.println("Enter two number of cities to search about flight direct line ");
			System.out.print("-->");
			}
			
			}
			
			
			
			 z = 9;
			while(z > city.size() || z<= 0)
			{
				try{
			b = input.nextInt();
			z = b;
				}
				catch(InputMismatchException ex){
					input.nextLine();
				}
			if(z > city.size() || z <= 0){
		System.out.println("Enter two number of cities to search about flight direct line ");
			System.out.print("-->");
			}
			
			}
			System.out.println();
			a = a -1;
			b = b - 1;
		int si=	stack.serch(a,b);
		if(si != 9)
			line1.get(si).displaydirect(si);
			System.out.println();
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			char save12 = 'w';
			while(save12 != 'n' && save12 != 'N'&& si != 9)
			{
				System.out.println("Do you want to save [Y]es ,[N]o ? ");
					System.out.print("--> ");
				while( save12 != 'N' && save12 != 'n' &&  save12 != 'y' && save12 != 'Y'){
					try{
				save12 = input.next().charAt(0);
					}
					catch(InputMismatchException e){
						System.out.println(e);
					}
					if( save12 != 'N' && save12 != 'n' && save12 != 'y' && save12 != 'Y'){
						System.out.println("Do you want to save [Y]es ,[N]o ? ");
					    System.out.print("--> ");
					}
				}
				if(save12 == 'y' || save12 == 'Y')
				{
					
						try{
						System.out.print("Enter the file name to save in --> ");
						String tempname12 = input.next();
			BufferedWriter ww12 = new BufferedWriter(new FileWriter(tempname12));
			for (int i =1 ; i <= 1; i ++){
			ww12.write("direct_flight");
			ww12.write("\n");
				ww12.write("------------------------------------------------------------------------------");
				ww12.write("\n");
				ww12.write("From              Depart               TO");
				ww12.write("\n");
						ww12.write(line1.get(si).geta() + "           " +  line1.get(si).gettimedepart() + "--->         "+line1.get(si).getb());
						ww12.write("\n");
						ww12.write("EI Part lntl.Apt." + "             " +  line1.get(si).getdepartdate() + "                 " + line1.get(si).gettimearrival());
						ww12.write("\n");
						ww12.write("Price: " + line1.get(si).getprice()+"$");
						ww12.write("\n");
						ww12.write("------------------------------------------------------------------------------");
		ww12.write("\n");
			}
			ww12.close();
			
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
					
				}	
				System.out.println();
				
					break;
					
					
				
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			System.out.print("Enter 1 to ask again , or 0 to goback -->");
			s = 9;
			while((s != 0)&&(s != 4)&&(s != 1))
		{
		try{
		s = input.nextInt();
		if(s == 4)
			System.exit(1);
		}
		catch(InputMismatchException ex){
			input.nextLine();
		}
		if((s != 0)&&(s != 4)&&(s != 1)){
			System.out.print("Enter 0 to geback or to close the program-->");
	
		}
		}
		x = s;
		System.out.println();
	}
		
			
			
			}
			
		
		
		
	while(x ==2){
		
		System.out.println("Cities list");
		System.out.println(" ---------------------------------");
		for(int i = 0; i < city.size(); i++)
			System.out.println(i+ 1 + ". " + city.get(i).getname());
		System.out.println(" ---------------------------------");
		chose = 0;
		System.out.print("Select a city number, 0 to goback --> ");
		
		while (chose > city.size() || chose <= 0)
		{
		try{
	chose = input.nextInt();
	if(chose == 0)
		break;
		}
		 catch(InputMismatchException ex){
		  
		   input.nextLine();
	  }
	if (chose >= city.size() || chose <= 0)
	  System.out.print("Error input please try again --> ");
  
  
		}
	
			
			
			
		
		
		
		
		if(chose == 0)
		break;
		
		num = 1;
		
		while( num != 0) { 
		
		
		city.get(chose-1).print();
		int t = 5;
		System.out.print("select 1 to view the Attraction list or 2 to view the Type list of attration , 0 to goback --> ");
		while(t != 1 && t != 2 && t != 0){
		
		try{
		t = input.nextInt();
		num = t;
		}
		 catch(InputMismatchException ex){
		  
		   input.nextLine();
	  }
	  if(t != 1 && t != 2 && t != 0)
	  {
		 // System.out.println();
	  System.out.print("select 1 to view the Attraction list or 2 to view the Type list of attration , 0 to goback --> ");
	  }
		}
		
		int s = 1;
		if(num == 1)
			while(s != 0){
			System.out.println();
			city.get(chose-1).attractionlist();
			System.out.println();
			char save = 'w';
			while(save != 'n' && save != 'N')
			{
				System.out.println("Do you want to save [Y]es ,[N]o ? ");
					System.out.print("--> ");
				while( save != 'N' && save != 'n' &&  save != 'y' && save != 'Y'){
					try{
				save = input.next().charAt(0);
					}
					catch(InputMismatchException e){
						System.out.println(e);
					}
					if( save != 'N' && save != 'n' && save != 'y' && save != 'Y'){
						System.out.println("Do you want to save [Y]es ,[N]o ? ");
					    System.out.print("--> ");
					}
				}
				if(save == 'y' || save == 'Y')
				{
					
						try{
						System.out.print("Enter the file name to save in --> ");
						String tempname = input.next();
			BufferedWriter ww3 = new BufferedWriter(new FileWriter(tempname));
			ww3.write("Attraction list \n");
			
				for(int i = 0; i < city.get(chose-1).getnumberofAttraction(); i++){
					ww3.write(city.get(chose-1).getAttractionname(i) + " ");
		ww3.write("\n");
				}
			ww3.close();
			
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
					
				}	
				System.out.println();
				
					break;
					
					
				
			}
			System.out.print("choose your Attraction number to view, 0 to go back -->");
			t = 8;
			while (t > city.get(chose-1).getnumberofAttraction() || t < 0)
			{
			try {
			t = input.nextInt();
			if(t == 0)
				s = t;
			
			}
			 catch(InputMismatchException ex){
		 input.nextLine();
	  }
	  if(t > city.get(chose-1).getnumberofAttraction() || t < 0)
	   System.out.print("Error input please try again --> ");
	   
			}
			System.out.println();
	 
			if(t != 0){
						System.out.println("_______________________________________");
				System.out.println();
			city.get(chose-1).getattration(t-1);
					System.out.println("_______________________________________");
			System.out.println();
			
			
			
			
			
				char save1 = 'w';
			while(save1 != 'n' && save1 != 'N')
			{
				System.out.println("Do you want to save [Y]es ,[N]o ? ");
				System.out.print("--> ");
				while( save1 != 'N' && save1 != 'n' &&  save1 != 'y' && save1 != 'Y'){
					try{
				save1 = input.next().charAt(0);
					}
					catch(InputMismatchException e){
						System.out.println(e);
					}
					if( save1 != 'N' && save1 != 'n' && save1 != 'y' && save1 != 'Y'){
						System.out.println("Do you want to save [Y]es ,[N]o ? ");
					System.out.print("--> ");
					}
				}
				if(save1 == 'y' || save1 == 'Y')
				{
					
						try{
						System.out.print("Enter the file name to save in --> ");
						String tempname1 = input.next();
			BufferedWriter ww4 = new BufferedWriter(new FileWriter(tempname1));
			ww4.write(city.get(chose-1).getAttractionname(t-1));
			ww4.write("\n");
			
					ww4.write(city.get(chose-1).getdescribe1(t-1) + " ");
		ww4.write("\n");
		if(city.get(chose-1).gettypeid(t-1) == 3 ){
			ww4.write("\n");
			ww4.write("Shops list ");
		ww4.write("\n");
			for(int q2 = 0; q2 < city.get(chose-1).getnumberofshops1(t-1); q2++){
			ww4.write(city.get(chose-1).getshops1(t-1,q2));
			ww4.write("\n");
			}
		}
		
		if(city.get(chose-1).gettypeid(t-1) == 2 ){
			ww4.write("\n");
			ww4.write("age Limit ");
			ww4.write(city.get(chose-1).getageLimit1(t-1) + "+");
		}
		
		if(city.get(chose-1).gettypeid(t-1) == 1 ){
			ww4.write("\n");
			ww4.write("Entrance fee ");
			ww4.write(city.get(chose-1).getentrancefee1(t-1) + "00");
		}
		
		
		//////////////////////////////////////////////////
		/////////////////////////////////////////////////
			
			ww4.close();
			
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
					
				}	
				System.out.println();
				
					break;
					
					
				
			}
			
			
			
			
			
			
			
			
			
			
			
			
			System.out.print("Type 1 to continue or 0 to goback --> ");
			s = 2;
			
			while(s != 1 && s != 0){
				try {
			s = input.nextInt();
				}
					 catch(InputMismatchException ex){
		 input.nextLine();
	  }
	  if (s != 1 && s != 0)
	  System.out.print("Type 1 to continue or 0 to goback --> ");
	  
			}
			}
			
			}
			
			
			
			else if(num == 2){
			s = 1;
			int t1 = 50;
				while(s != 0){
				city.get(chose-1).typelist();
			System.out.print("Enter your type number to view ,0 to go back -->");
			while(t1 > city.get(chose-1).getnumberofAttraction() || t1 < 0) {
			try{
			t1 = input.nextInt();
			if(t1 == 0){
				s = t1;
				break;
			}
			}
			   	 catch(InputMismatchException ex){
		 input.nextLine();
	  }
	  if(t1 > city.get(chose-1).getnumberofAttraction() || t1 < 0)
	  System.out.print("Error input please try again --> ");
			}
			 
		   input.nextLine();
		   if (t1 != 0){
			   System.out.println();
			   System.out.println("___________________________________________________");
			   System.out.println();
			city.get(chose-1).getattration(t1-1);
			  System.out.println("___________________________________________________");
		   }
			System.out.println();
			
			
			
			
			
			
			
			
			
			
			
			char save2= 'w';
			while(save2 != 'n' && save2!= 'N')
			{
				System.out.println("Do you want to save [Y]es ,[N]o ? ");
					System.out.print("--> ");
				while( save2 != 'N' && save2 != 'n' &&  save2 != 'y' && save2 != 'Y'){
					try{
				save2 = input.next().charAt(0);
					}
					catch(InputMismatchException e){
						System.out.println(e);
					}
					if( save2 != 'N' && save2 != 'n' && save2 != 'y' && save2 != 'Y'){
					System.out.println("Do you want to save [Y]es ,[N]o ? ");
					System.out.print("--> ");
					}
				}
				if(save2== 'y' || save2== 'Y')
				{
					
						try{
						System.out.print("Enter the file name to save in --> ");
						String tempname2= input.next();
			BufferedWriter ww5= new BufferedWriter(new FileWriter(tempname2));
			ww5.write(city.get(chose-1).getAttractionname(t1-1));
			ww5.write("\n");
			
					ww5.write(city.get(chose-1).getdescribe1(t1-1) + " ");
		ww5.write("\n");
		if(city.get(chose-1).gettypeid(t1-1) == 3 ){
			ww5.write("\n");
			ww5.write("Shops list ");
		ww5.write("\n");
			for(int q3 = 0; q3 < city.get(chose-1).getnumberofshops1(t1-1); q3++){
			ww5.write(city.get(chose-1).getshops1(t1-1,q3));
			ww5.write("\n");
			}
		}
		
		if(city.get(chose-1).gettypeid(t1-1) == 2 ){
			ww5.write("\n");
			ww5.write("age Limit ");
			ww5.write(city.get(chose-1).getageLimit1(t1-1) + "+");
		}
		
		if(city.get(chose-1).gettypeid(t1-1) == 1 ){
			ww5.write("\n");
			ww5.write("Entrance fee ");
			ww5.write(city.get(chose-1).getentrancefee1(t1-1) + "00");
		}
						
			
			ww5.close();
			
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
					
				}	
				System.out.println();
				
					break;
					
					
				
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			if (t1 == 0)
				break;
			System.out.print("Type 1 to continue or 0 to goback --> ");
			s = 2;
			while(s != 1 && s != 0){
				try{
			s = input.nextInt();
			if(s == 0)
				break;
				}
				   	 catch(InputMismatchException ex){
		 input.nextLine();
	  }
	  if(s != 1 && s != 0)
	  System.out.print("Type 1 to continue or 0 to goback --> ");
				}
				}
			}
		
		//else{
		//System.out.println();
		//	city[chose-1].getattration(num-1);
	//	}
		}
			
		
	
	}
	
	if(x == 1)
	while(x != 0){
		System.out.println("____________________________________");
		System.out.println();
		System.out.println("MULTIMEDIA University");
		System.out.println("Faculty of Computing And Informatics");
		System.out.println("TCP1201 Object Oriented Programming And Data Structures");
		System.out.println("Assignment , Trimester 2, 2017/1018");
		System.out.println("Lecturer Name: Dr. Chai Ian");
		System.out.println("Student Name: Shaaban Mohammed Najib");
		System.out.println("ID: 1151304220");
		System.out.println("____________________________________");
		System.out.println();
		System.out.print("Enter 0 to geback or 4 to close the program-->");
		while((x != 0)&&(x != 4))
		{
		try{
		x = input.nextInt();
		if(x == 4)
			System.exit(1);
		}
		catch(InputMismatchException ex){
			input.nextLine();
		}
		if((x != 0)&&(x != 4)){
			System.out.print("Enter 0 to geback or 4 to close the program-->");
		}
		
	}
	}
	
	if(x == 3)
		while(x != 0){
			//String comment = new String();
			System.out.println("____________________________________");
			System.out.println();
			System.out.println("Enter your comment to us");
			Scanner in = new Scanner(System.in);
			String comment = in.nextLine();
			System.out.println();
			
			
			
			try{
			BufferedWriter com = new BufferedWriter(new FileWriter("Comments.txt"));
				com.write(comment);
		com.write("\n");
			
			com.close();
			
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
			
			
			System.out.println("your comment has been saved in file Comments.txt");
			System.out.println("Thank you ");
			System.out.println("____________________________________");
			System.out.print("Enter 0 to goback or 4 to close the program --> ");
			while((x != 0)&&(x != 4))
		{
		try{
		x = input.nextInt();
		if(x == 4)
			System.exit(1);
		}
		catch(InputMismatchException ex){
			input.nextLine();
		}
		if((x != 0)&&(x != 4)){
			System.out.println();
			System.out.println("input error please try again");
			System.out.print("Enter 0 to geback or 4 to close the program-->");
		}
		
	}
			
		}
		
		
		
		
			
			
			
			
			
			
		try{
			BufferedWriter r = new BufferedWriter(new FileWriter("city.txt"));
			for(int i = 0; i < city.size(); i++){
				city.get(i).setid(i);
				r.write(city.get(i).getid() + city.get(i).getname());
		r.write("\n");
			}
			r.close();
			
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		
		
		try{
			int f = 0;
			BufferedWriter w = new BufferedWriter(new FileWriter("attraction.txt"));
			
			for(int j = 0; j < city.size() ; j++){
				city.get(j).setid(j);
			for(int i = 0; i < city.get(j).getnumberofAttraction(); i++){
				if(city.get(j).gettypeid(i) != 2 && city.get(j).gettypeid(i) != 1 )
				w.write(city.get(j).getid()+ " " +city.get(j).gettypeid(i) +" " + city.get(j).getAttractionname(i) + city.get(j).getdescribe1(i) );
				if(city.get(j).gettypeid(i) == 2 )
					w.write(city.get(j).getid()+ " " +city.get(j).gettypeid(i) +" " +city.get(j).getageLimit1(i) + " " + city.get(j).getAttractionname(i) + city.get(j).getdescribe1(i) );
				if(city.get(j).gettypeid(i) == 1 )
					w.write(city.get(j).getid()+ " " +city.get(j).gettypeid(i) +" " +city.get(j).getentrancefee1(i)+ " " + city.get(j).getAttractionname(i) + city.get(j).getdescribe1(i) );
		w.write("\n");
		
			}
			}
			w.close();
			
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		
	try{
			
			BufferedWriter w2 = new BufferedWriter(new FileWriter("directflight.txt"));
			//for(int i = 0; i < city.size(); i++)
			for(int j = 0; j < line1.size() ; j++){
			
				w2.write(line1.get(j).getida() +" " +line1.get(j).getidb() +" " + line1.get(j).getprice() +" " +  line1.get(j).gettimedepart() +" " +
				line1.get(j).gettimearrival());
				
		w2.write("\n");
			
			}
			w2.close();
			
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	
	
	
	
	
	
	
		for(int j = 0; j < city.size() ; j++){
			for(int i = 0; i < city.get(j).getnumberofAttraction(); i++)
				if(city.get(j).gettypeid(i) == 3 )
				{
					String newname = city.get(j).getAttractionname(i)+".txt";
	try{
		BufferedWriter ww2 = new BufferedWriter(new FileWriter(newname));
		for(int q1 = 0; q1 < city.get(j).getnumberofshops1(i); q1++){
			ww2.write(city.get(j).getshops1(i,q1));
		ww2.write("\n");
		
		}
	
	ww2.close();
	
	}		
				catch(IOException e)
		{
			System.out.println(e);
		}
				}
		}
	
	
	
	
	
	
	}
	
			
	
	}
}







