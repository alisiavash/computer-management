
//Assignment-2
//Student Name: Ali Khoonsiavash
//Student ID: 2212351
//Date: 20-10-2022

package Main;

//import java.util.ArrayList;
//import java.util.Iterator;
import java.util.Scanner;
import Basic.Computer;

public class Program {	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int cpuIndex = 0;
		
			Scanner sc = new Scanner(System.in);
			System.out.println("\n");
			System.out.println("*********** Welcome to the computer store ***********\n");
			System.out.println("Please Indicate the capacity of the inventory: \n");
			
			int InventorySpace = sc.nextInt();
			Computer c[] = new Computer [InventorySpace];
			
			do {
				
				displayMainMenu();
				int choice = sc.nextInt();
				switch (choice) {
				case 1: {
					
					if(Login()) {
						Computer.ComputerInventory(c);
					}
			        break;
				    }
				case 2: {
					
					if(Login()) {
						Computer.updateMenu(c);
					}
					break;
				}
				case 3: {
					Computer.findComputersBy(c);
					break;
				}
				case 4: {
					Computer.findCheaperThan(c);
					break;
				}
				case 5: {
					System.out.println("Thank you, we wish you will back soon.");
					System.exit(0);
					break;
				}
				default:
					System.out.println("Invalide choice");
			}
					
		} while (true);
			
	}
	
	public static void displayMainMenu() {

		System.out.println("Plesae select your choice: ");
		System.out.println("	1. Enter new computers");
		System.out.println("	2. Change information of a computer");
		System.out.println("	3. Display all computers by a specific brand.");
		System.out.println("	4. Display all computers under a certain a price.");
		System.out.println("	5. Quit");

	}

	public static Boolean Login() {
		boolean flag = false;
		String PASSWORD = "password";
        String inputPass;
        Scanner  input = new Scanner(System.in);
        System.out.println("Enter Your Password:");
        inputPass = input.nextLine();
        if(!(inputPass.equals(PASSWORD))){
        	System.out.println("The password is incorrect, Please try again.");
        	inputPass = input.nextLine();
        	 if(!(inputPass.equals(PASSWORD))){
        		 System.out.println("The password is incorrect, This is the last attampt Please try again.");
        		 inputPass = input.nextLine();
        		  	if(!(inputPass.equals(PASSWORD))){
        			 flag = false;
        		  	}else{
        		   flag= true;
        		  	}
        	  }else		        
        		 flag = true;
        }else {
        	 flag = true;
        }
        return flag;	
	}
}
