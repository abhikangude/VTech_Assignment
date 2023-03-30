package main;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import java.util.Scanner;
import java.util.Set;

import com.vtassignment.bean.PizzaMenu;
import com.vtassignment.bean.Sides;
import com.vtassignment.bean.Toppings;
import com.vtassignment.service.MenuService;
import com.vtassignment.service.MenuServiceImpl;

public class RocketPizza {

	//private static final Exception Exception = null;
	static Scanner sc= new Scanner(System.in);
	final static MenuService menu= new MenuServiceImpl();

	public static void main(String[] args) throws java.lang.Exception {
		int i;
		int crustType;
		System.out.println("\t***** Welcome to Rocket Pizza *****");
		System.out.print("\nChoose type of pizza crust before proceeding further: ");
		
		menu.displayPCrust();
		
		System.out.print("Select: ");
		
		crustType=sc.nextInt();
		
		System.out.println("You have selected \"" + menu.getCrusts().get(crustType-1)+"\" for your pizza. ");
		System.out.print("\nNow, press 1 to get the Pizza Menu\nEnter:  ");
		
		i=sc.nextInt();
		
		if(i==1) {
			menu.displayPizza();
		}
		switch (i) {
			case 1: {
				Map<PizzaMenu, List<Toppings>> order=orderPizza();
				List<Sides> sidesList=orderSides();
				int finalBill=calculateBill(order,sidesList);
				System.out.println("\nYour Total bill is : Rs."+ finalBill);
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + i);
			}
	}
	
	private static List<Sides> orderSides() {
		int sidesCost=0,s;
		String ch=null;
		List<Sides>sidesList=new ArrayList<>();
		System.out.print("\nDo you want to order any beverages or other from our menu(Y/N): ");
		ch=sc.next();
		if(ch.equalsIgnoreCase("Y")) {
			menu.displayPSides();
			do {
				System.out.print("Please, Enter the menu number to add it in your basket: ");
				s=sc.nextInt();
				sidesList.add(menu.getSides().get(s-1));
				System.out.print("Do you want to add more items in your basket(Y/N): ");
				ch=sc.next();
			}while(ch.equalsIgnoreCase("Y"));
		}
		
		//repeat
		for(int i = 0; i < sidesList.size(); i++)
		{
			sidesCost=sidesCost + sidesList.get(i).getCost();
		}
		return sidesList;
	}

	public static Map<PizzaMenu, List<Toppings>> orderPizza() {
		int i,j;
		String ch = null;
		Map<PizzaMenu, List<Toppings>> myOrder = new LinkedHashMap<>();
		do {
			
			
			List<Toppings> topList=new ArrayList<>();
			System.out.print("\nPlease, Enter the Pizza number from menu to add in the basket: ");
			j=sc.nextInt();
			//myOrder.p(menu.pizza().get(j-1));
			System.out.print("\nDo you want to add Extra Toppings(Y/N): ");
			ch=sc.next();
			if(ch.equalsIgnoreCase("Y")) {
				menu.displayPToppings();
				do {
					System.out.print("Select Topping number from list to add on this pizza: ");
					i=sc.nextInt();
					if(menu.getPizzas().get(j-1).isVegan()) {
						if(menu.getToppings().get(i-1).isVegan()) {
							topList.add(menu.getToppings().get(i-1));
						}
						else if (!menu.getToppings().get(i-1).isVegan()) {
							System.out.println("Veg Pizza can't have non-veg Toppings ");
						}
						//myOrder.putIfAbsent(menu.pizza().get(j-1), topList);
					}
					else if (!menu.getPizzas().get(j-1).isVegan()) {
						if(menu.getToppings().get(i-1).getToppingName().equals("Paneer")) {
							System.out.println("Non-Veg Pizza can't have Paneer Toppings");
						}
						else {
							int count=(int) topList.stream().filter(tp->!tp.isVegan()).count();
							if(count<1) {
								topList.add(menu.getToppings().get(i-1));
							}
							else if (menu.getToppings().get(i-1).isVegan()) {
								topList.add(menu.getToppings().get(i-1));
							}
							else {
								System.out.println("You can add only one of the non-veg toppings in non-vegetarian pizza");
							}
						}
						//myOrder.putIfAbsent(menu.pizza().get(j-1), topList);
					}
					System.out.print("Do you want to add more toppings(Y/N): ");
					ch=sc.next();
				}while(ch.equalsIgnoreCase("Y"));
				myOrder.putIfAbsent(menu.getPizzas().get(j-1), topList);
			}
			System.out.print("\nDo you want to add another Pizza in your basket(Y/N): ");
			ch=sc.next();
		}while(ch.equalsIgnoreCase("Y"));
		return myOrder;
	}
	
	public static int calculateBill(Map<PizzaMenu, List<Toppings>> order, List<Sides>sidesList){
		System.out.println("\n\t\t-------Your Basket-------");
		
		int totalBill=0,i=0,bill=0;
		List<Integer> bills=new ArrayList<>();
		Set<PizzaMenu> pMenuSet=order.keySet();
		for(Entry<PizzaMenu, List<Toppings>> entry : order.entrySet()) {
			int tBill=0;
			if(entry.getKey().getSize().equals("Large")) {
				int count=(int) entry.getValue().stream().count();
				if(count>2) {
					bill=entry.getKey().getCost() + entry.getValue().stream().skip(2).mapToInt(c->c.getCost()).sum();
					bills.add(bill);
					System.out.print("" + entry.getKey().getPizzaName() + " pizza with ");
					entry.getValue().stream().forEach(s->System.out.print(""+s.getToppingName()+", "));
					System.out.println("(" + entry.getKey().getSize() +")" + "-----------Rs."+bill);
				}
				else {
					bill=entry.getKey().getCost();
					bills.add(bill);
					System.out.print("" + entry.getKey().getPizzaName() + " pizza with ");
					entry.getValue().stream().forEach(s->System.out.print(""+s.getToppingName()+", "));
					System.out.println("(" + entry.getKey().getSize() +")" + "-----------Rs."+bill);
					//totalBill=totalBill+entry.getKey().getCost();
				}
			}
			else {
				//totalBill=totalBill+entry.getKey().getCost();
				bill=entry.getKey().getCost() + entry.getValue().stream().mapToInt(c->c.getCost()).sum();
				//.getCost());
				bills.add(bill);
				//System.out.println(""  +entry.getKey().getPName() + " pizza with " + entry.getValue().getToppingName()+" (" + entry.getKey().getPSize() +")"+ "-----------Rs."+bill);
				System.out.print("" + entry.getKey().getPizzaName() + " pizza with ");
				entry.getValue().stream().forEach(s->System.out.print(""+s.getToppingName()+" ,"));
				System.out.println(" (" + entry.getKey().getSize() +")" + "-----------Rs."+bill);
			}
		}
		int sideBill=0;
		sidesList.forEach(s->System.out.println(""+s.getSide()+"-----------Rs."+s.getCost()));
		for(i = 0; i < sidesList.size(); i++)
		{
			sideBill=sideBill+sidesList.get(i).getCost();
		}
		for(i = 0; i < bills.size(); i++)
		{
			totalBill=totalBill+bills.get(i);
		}
		totalBill=totalBill+sideBill;
		return totalBill;
	}
}
