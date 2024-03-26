package kr.co.quiz;

public class Ex8_Constructor {

	public static void main(String[] args) {

		// Ex8_1_Product
		Ex8_1_Product product = new Ex8_1_Product();
		
		System.out.println(product.name);
		System.out.println(product.price);
		System.out.println(product.count);
		
		System.out.println();
		
		Ex8_1_Product product2 = new Ex8_1_Product("칸쵸", 2000, 6);
		
		System.out.println();
		
		Ex8_1_Product product3 = new Ex8_1_Product("다이제", 4000);
		
		System.out.println("---------------------------------------");
		
		// Ex8_2_Buy
		Ex8_2_Buy buy = new Ex8_2_Buy(200000, 130000, 50000, 150000);
		
		buy.buyMonitor();
		
		buy.buyMouse();
		
		buy.buyComputer();
		
		
		
	}

}
