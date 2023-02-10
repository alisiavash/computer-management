
//Assignment-2
//Student Name: Ali Khoonsiavash
//Student ID: 2212351
//Date: 20-10-2022

package Basic;

//import java.lang.reflect.Array;
import java.util.Scanner;

public class Computer {
		protected String brand;
		protected String model;
		protected long SN;
		protected double price;
		private static int counter = 0;

	public Computer(String br,String mo,long sn,double pr) {		
		brand = br;
		model = mo;
		SN = sn;
		price = pr;
		counter++;
	}
	public String getBrand() {
		return brand;
	}	
	public void setBrand(String brand) {	
		this.brand = brand;
	}
	public String getModel() {		
		return model;
	}	
	public void setModel(String model) {	
		this.model = model;
	}
	public long getSN() {	
		return SN;
	}
	public void setSN(long sn) {	
		this.SN = sn;
	}
	public double getPrice() {	
		return price;
	}
	public void setPrice(double price) {	
		this.price = price;
	}
	@Override
	public String toString() {
		
		return "The computer information is: "
				+ "\nbrand: " + brand + "\nmodel: " + model + "\nSN: " + SN + "\nprice: $" + price + "\n";
	}
	
	public static int findNumberOfCreatedComputers() {
		return counter;
	}
	public static void ComputerInventory(Computer[] c) {
		int counter = 0;
		Scanner  sc = new Scanner(System.in);
		System.out.println("\nYou have successfully logged in, Please indicate the number of computers you wish to enter the inventory :");
		int enteredComputer = sc.nextInt();
			while (enteredComputer > (c.length - Computer.findNumberOfCreatedComputers())) {
				System.out.println("Sorry! There is no enough space, the available space is ( " + (c.length - Computer.findNumberOfCreatedComputers()) + " ) please enter a new number:");
				if ((c.length - Computer.findNumberOfCreatedComputers()) == 0) {
					return;
				}
				enteredComputer = sc.nextInt();
			 }			
				System.out.println("Please fill out the following information");
					for(int i = 0; i < enteredComputer; i++) {
							System.out.println("Enter your brand name: ");
							String brand = sc.next();
							System.out.println("Enter your model: ");
							String model = sc.next();
							System.out.println("Enter your SN:");
							Long SN = sc.nextLong();
							System.out.println("Enter your price: ");
							Double price = sc.nextDouble();	
							c[i] = new Computer(brand, model, SN, price);							
						}
					counter++;
			System.out.println(enteredComputer + " Computer(s) has/have been successfully added to the Inventory.\n");
			for(int i = 0; i < Computer.findNumberOfCreatedComputers(); i++) {
				System.out.println("********* Computer # " + i + " *********\n");
				System.out.println(c[i] + "\n");
			}
			
			return;
	}
	

	public static void updateMenu(Computer[] c) {
		Scanner  sc = new Scanner(System.in);
		char countinue = 'y';
		do {
				System.out.println("Which computer you wish to update?");
				int ComouterNumber = sc.nextInt();
				if (ComouterNumber >= 0 && ComouterNumber < Computer.findNumberOfCreatedComputers()) {

						System.out.println("******** Computer " + ComouterNumber + " *********");
						System.out.println(c[ComouterNumber]);
						System.out.println("\n");
						System.out.println("======== What information would you like to be modified? ======");
						System.out.println("1. Brand");
						System.out.println("2. Model");
						System.out.println("3. SN");
						System.out.println("4. Price");
						System.out.println("5. Quit");
						System.out.println();
						System.out.println("Enter your choice: ");
						
						int choic = sc.nextInt();
						switch (choic) {
						case 1: {			
							System.out.println("Please enter the new brand: ");
							String brand = sc.next();
							c[ComouterNumber].setBrand(brand);
							System.out.println("******** The Computer " + ComouterNumber + " has been modified *********\n");
							System.out.println(c[ComouterNumber]);
							System.out.println("The brand has been successfully changed, for continuing , enter any key or for back to the main menu, please enter(y).");
							countinue = sc.next().toLowerCase().charAt(0);
							System.out.println("\n");
							break;
						}
						case 2: {
							System.out.println("Please enter the new model: ");
							String model = sc.next();
							c[ComouterNumber].setModel(model);
							System.out.println("******** The Computer " + ComouterNumber + " has been modified *********\n");
							System.out.println(c[ComouterNumber]);
							System.out.println("The model has been successfully changed, for continuing , enter any key or for back to the main menu, please enter(y).");
							countinue = sc.next().toLowerCase().charAt(0);
							System.out.println("\n");
							break;
						}
						case 3: {
							System.out.println("Please enter the new SN: ");
							Long sn = sc.nextLong();
							c[ComouterNumber].setSN(sn);
							System.out.println("******** The Computer " + ComouterNumber + " has been modified *********\n");
							System.out.println(c[ComouterNumber]);
							System.out.println("The SN has been successfully changed, for continuing , enter any key or for back to the main menu, please enter(y).");
							countinue = sc.next().toLowerCase().charAt(0);
							System.out.println("\n");
							break;
						}
						case 4: {	
							System.out.println("Please enter the new price: ");
							double price = sc.nextDouble();
							c[ComouterNumber].setPrice(price);
							System.out.println("******** The Computer " + ComouterNumber + " has been modified *********\n");
							System.out.println(c[ComouterNumber]);
							System.out.println("The price has been successfully changed, for continuing , enter any key or for back to the main menu, please enter(y).");
							countinue = sc.next().toLowerCase().charAt(0);
							System.out.println("\n");
							break;
						}
						case 5: {
							System.out.println("Are you sure you want to quit this menu? If yes enter(y) if not enter any key.");
							countinue = sc.next().toLowerCase().charAt(0);
							break;
						}
						default:
							System.out.println("Invalide choice");
						}
				}else {
					System.out.println("Error! Either the computer number is wrong or the inventory is empty.");
					System.out.println("If you would like to go back to the main menu, please enter(y), or to try another number please enter any key.");
					countinue = sc.next().toLowerCase().charAt(0);
				}
			} while (countinue != 'y');
	}

	public static void findComputersBy(Computer[] c) {
		Scanner  sc = new Scanner(System.in);
		if(Computer.findNumberOfCreatedComputers() != 0) {
			System.out.println("Please enter the brand name: ");
			String chosenBrand = sc.next();
			for (int i = 0; i < Computer.findNumberOfCreatedComputers(); i++) {
				if (c[i].getBrand().equals(chosenBrand)) {
					
					System.out.println(c[i]);
				}
			}
		}else {
			System.out.println("The inventory is empty.\n");
		}
	}
	
	public static void findCheaperThan(Computer[] c) {
		Scanner  sc = new Scanner(System.in);
		if(Computer.findNumberOfCreatedComputers() != 0) {
			System.out.println("Please enter the price: ");
			double chosenPrice = sc.nextDouble();
			for (int i = 0; i < Computer.findNumberOfCreatedComputers(); i++) {
				if (c[i].getPrice() < chosenPrice) {
					System.out.println(c[i]);
				}
			}
		}else {
			System.out.println("The inventory is empty.\n");
		}
	}

	public boolean equal(Computer c) {
		
		return this.brand == c.brand && this.model == c.model && this.price == c.price;
	}

}
