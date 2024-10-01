package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Product> list = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int numberProducts = sc.nextInt();
		
		for(int i=1; i<=numberProducts; i++) {
			System.out.println("Product #" + i + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char response = sc.next().charAt(0);
			
			if(response == 'c') {
				System.out.print("Name: ");
				String name = sc.next();
				System.out.print("Price: ");
				double price = sc.nextDouble();
				
				Product p = new Product(name, price);
				list.add(p);
			}
			else if(response == 'u') {
				System.out.print("Name: ");
				String name = sc.next();
				System.out.print("Price: ");
				double price = sc.nextDouble();
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date manufactureDate = sdf.parse(sc.next());
				
				Product p = new UsedProduct(name, price, manufactureDate);
				list.add(p);
			}
			else if(response == 'i') {
				System.out.print("Name: ");
				String name = sc.next();
				System.out.print("Price: ");
				double price = sc.nextDouble();
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				
				Product p = new ImportedProduct(name, price, customsFee);
				list.add(p);
			}
		}
		
		System.out.println("\n");
		System.out.println("PRICE TAGS:\n");
		
		for(Product p : list) {
			System.out.println(p.priceTag());
		}
		
	sc.close();
	}
}
