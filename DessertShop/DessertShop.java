package DessertShop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import DessertShop.Payable.PayType;

public class DessertShop {
	static HashMap<String, Customer> customerDB = new HashMap<String, Customer>();

	public static void main(String[] args) {
		boolean closed = false;
		String cust = "";
		while (!closed) {
			String paymentMethod = "";

			// New instance
			Order o1 = new Order();

			Scanner sIn = new Scanner(System.in);
			String choice;
			DessertItem orderItem;

			boolean done = false;
			while (!done) {
				System.out.println("\n1: Candy");
				System.out.println("2: Cookie");
				System.out.println("3: Ice Cream");
				System.out.println("4: Sunday");
				System.out.println("5: Admin Module");

				System.out.print("\nWhat would you like to add to the order? (1-5, Enter for done): ");
				choice = sIn.nextLine();

				if (choice.equals("")) {
					done = true;
				} else {
					switch (choice) {
					case "1":
						orderItem = userPromptCandy(sIn);
						o1.add(orderItem);
						System.out.printf("%n%s has been added to your order.%n", orderItem.getName());
						break;
					case "2":
						orderItem = userPromptCookie(sIn);
						o1.add(orderItem);
						System.out.printf("%n%s has been added to your order.%n", orderItem.getName());
						break;
					case "3":
						orderItem = userPromptIceCream(sIn);
						o1.add(orderItem);
						System.out.printf("%n%s has been added to your order.%n", orderItem.getName());
						break;
					case "4":
						orderItem = userPromptSundae(sIn);
						o1.add(orderItem);
						System.out.printf("%n%s has been added to your order.%n", orderItem.getName());
						break;
					case "5":
						userPromptAdminModule(sIn, cust);
						break;
					default:
						System.out.println("Invalid response:  Please enter a choice from the menu (1-4)");
						break;
					}// end of switch (choice)
				} // end of if (choice.equals(""))

			} // end of while (!done)
			System.out.println();
			System.out.print("Enter the customer name: ");
			cust = sIn.nextLine();
			if (!customerDB.containsKey(cust)) {
				Customer p1 = new Customer(cust);
				customerDB.put(cust, p1);
			}

			customerDB.get(cust).addToHistory(o1);
			System.out.println();

			// Add to order
			o1.add(new Candy("Candy Corn", 1.5, .25));
			o1.add(new Candy("Gummy Bears", .25, .35));
			o1.add(new Cookie("Chocolate Chip", 6, 3.99));
			o1.add(new IceCream("Pistachio", 2, .79));
			o1.add(new Sundae("Vanilla", 3, .69, "Hot Fudge", 1.29));
			o1.add(new Cookie("Oatmeal Raisin", 2, 3.45));
			// Create an ArrayList with the order
			ArrayList<DessertItem> order = o1.getOrderList();
			// Print the name
			/*
			 * for (DessertItem item : order) {
			 * System.out.printf("%-25s$%-8.2f[Tax: $%.2f]\n", item.getName() + ":",
			 * item.calculateCost(), item.calculateTax()); }
			 * System.out.println("----------------------------------------------");
			 * System.out.printf("%-25s$%-8.2f[Tax: $%.2f]\n", "Order Subtotals:",
			 * p1.orderCost(), p1.orderTax()); System.out.printf("%-25s$%-8.2f",
			 * "Order Total:", p1.orderCost() + p1.orderTax()); // Print the item count
			 * System.out.printf("%n%s%d%n", "Total number of items in order: ",
			 * p1.itemCount());
			 */
			boolean valid = false;
			while (!valid) {
				System.out.print("What form of payment will be used? (CASH, CARD, PHONE): ");
				paymentMethod = sIn.nextLine();
				for (Payable.PayType type : Payable.PayType.values()) {
					if (paymentMethod.equalsIgnoreCase(type.name())) {
						paymentMethod = paymentMethod.toUpperCase();
						o1.setPayType(PayType.valueOf(paymentMethod));
					}
				}
				System.out.println();
				switch (paymentMethod) {
				case "CASH", "CARD", "PHONE" -> valid = true;

				default -> System.out.println("That's not a valid form of payment.");
				}
			}

			Collections.sort(order);

			System.out.println(o1);
			System.out.println("-------------------------------------------------------------------------------");
			System.out.printf("Customer Name: %-18sCustomer ID: %-18dTotal Orders: %-18d",
					customerDB.get(cust).getName(), customerDB.get(cust).getID(),
					customerDB.get(cust).getOrderHistory().size());
			System.out.println("\nHit enter to start a new order.");
			sIn.nextLine();
		}

	}

	private static void userPromptAdminModule(Scanner sIn, String cust) {
		boolean valid = false;
		String choice2 = "";
		while (!valid) {
			System.out.println();
			System.out.println("1: Shop Customer List\r\n" + "2: Customer Order History\r\n" + "3: Best Customer\r\n"
					+ "4: Exit Admin Module");
			System.out.println();
			System.out.print("What would you like to do? (1-4): ");
			choice2 = sIn.nextLine();
			switch (choice2) {

			case "1":
				System.out.println();
				for (String key : customerDB.keySet()) {
					System.out.printf("Customer Name: %-20s Customer ID: %-20d\n", customerDB.get(key).getName(),
							customerDB.get(key).getID());
				}

				break;
			case "2":
				System.out.print("\nEnter the name of the customer: ");
				String someCust = sIn.nextLine();
				System.out.printf("\nCustomer Name: %-20s Customer ID: %-20d\n", customerDB.get(someCust).getName(),
						customerDB.get(someCust).getID());
				System.out.println("-------------------------------------------------------------------------------");
				for (int i = 0; i < customerDB.get(someCust).getOrderHistory().size(); i++) {
					System.out.printf("Order#: %d\n", i + 1);
					System.out.println(customerDB.get(someCust).getOrderHistory().get(i));
					System.out.println();
				}
				break;
			case "3":
				int bestCust = 0;
				String bestCustName = "";
				for (String key : customerDB.keySet()) {
					if (customerDB.get(key).getOrderHistory().size() > bestCust) {
						bestCust = customerDB.get(key).getOrderHistory().size();
						bestCustName = customerDB.get(key).getName();
					}
				}
				System.out.println("-----------------------------------------------------");
				System.out.printf("The Dessert Shop's most valued customer is: %s\n", bestCustName);
				System.out.println("-----------------------------------------------------");
				break;
			case "4":
				return;
			default:
				System.out.println("Invalid response:  Please enter a choice from the menu (1-4)");
				break;
			}
		}

	}

	// Candy Prompt
	private static DessertItem userPromptCandy(Scanner sIn) {
		System.out.println("Enter the name of the candy: ");
		String name = sIn.nextLine();
		double cw = getValidDouble(sIn, "Enter the Weight of the Candy: ", "Please enter a valid number.");
		double pp = getValidDouble(sIn, "Enter the price per pound: ", "Please enter a valid number.");
		Candy c = new Candy(name, cw, pp);
		return c;
	}

	// Cookie Prompt
	private static DessertItem userPromptCookie(Scanner sIn) {
		System.out.println("Enter the type of cookie: ");
		String name = sIn.nextLine();
		int cw = getValidInt(sIn, "Enter the quantity purchased: ", "Please enter a valid number.");
		double pp = getValidDouble(sIn, "Enter the price per dozen: ", "Please enter a valid number.");
		Cookie c = new Cookie(name, cw, pp);
		return c;
	}

	// IceCream Prompt
	private static DessertItem userPromptIceCream(Scanner sIn) {
		System.out.println("Enter the type of Ice Cream used: ");
		String name = sIn.nextLine();
		int cw = getValidInt(sIn, "Enter the number of scoops: ", "Please enter a valid number.");
		double pp = getValidDouble(sIn, "Enter the price per scoop: ", "Please enter a valid number.");
		IceCream c = new IceCream(name, cw, pp);
		return c;

	}

	// Sundae Prompt
	private static DessertItem userPromptSundae(Scanner sIn) {
		System.out.println("Enter the type of Ice Cream: ");
		String name = sIn.nextLine();
		int cw = getValidInt(sIn, "Enter the number of scoops: ", "Please enter a valid number.");
		double pp = getValidDouble(sIn, "Enter the price per scoop: ", "Please enter a valid number.");
		System.out.println("Enter the kind of topping used: ");
		String nameT = sIn.nextLine();
		double pt = getValidDouble(sIn, "Enter the price for the topping: ", "Please enter a valid number.");
		Sundae c = new Sundae(name, cw, pp, nameT, pt);
		return c;
	}

	// Validation
	public static double getValidDouble(Scanner sIn, String question, String warning) {
		double num = 0;
		boolean valid = false;
		while (!valid) {
			System.out.print(question);
			String input = sIn.nextLine();
			try {
				num = Double.parseDouble(input);
				valid = true;
			} catch (Exception e) {
				System.out.println(warning);
				valid = false;
			}
		}
		return num;

	}

	public static int getValidInt(Scanner sIn, String question, String warning) {
		int num = 0;
		boolean valid = false;
		while (!valid) {
			System.out.print(question);
			String input = sIn.nextLine();
			try {
				num = Integer.parseInt(input);
				valid = true;
			} catch (Exception e) {
				System.out.println(warning);
				valid = false;
			}
		}
		return num;
	}

}
