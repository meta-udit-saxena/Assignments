package ShoppingStore;

import java.util.ArrayList;

/**
 * Display bill on console and write on text file
 * 
 * @author Udit Saxena
 * 
 */
public class Bill {
	private String userName;
	private Cart cart;
	private ProductPromo productPromo;
	

	/**
	 * parameterized constructor initializing private variables
	 * 
	 * @param userName
	 *            - User Name
	 * @param cart
	 *            - Cart class object
	 * @param productPromo
	 *            - ProductPromo class object
	 */
	public Bill(String userName, Cart cart, ProductPromo productPromo) {
		this.userName = userName;
		this.cart = cart;
		this.productPromo = productPromo;
		
	}

	/**
	 * 
	 * @return String containing purchase details
	 */
	private String purchaseProductDetails() {
		String output = "";
		for (CartProducts product : cart.getCartItems()) {
			output += "\nProduct : " + product.getProductId() + " - "
					+ product.getProductName() + "\n";
			output += "Cost : Rs"
					+ (product.getProductPrice() * product.getQuantity()) + "("
					+ product.getQuantity() + " X " + product.getProductPrice()
					+ ")\n";
		}
	
		return output;
	}

	/**
	 * 
	 * @return String containing Promotion/Discount details
	 */
	private String appliedPromotionsOrDiscount() {
		String output = "";
		for (CartProducts product : cart.getCartItems()) {
			if (productPromo.getDiscountType().containsKey(
					product.getProductId())) {
				if (PromotionType.ProductFixedAmountPromotion
						.equals(productPromo.getDiscountType().get(
								product.getProductId()))) {
					output += "Promotion : Rs" + product.getDiscount()
							+ " off on " + product.getProductName() + " [Code:"
							+ product.getProductId() + "]\n";
					output += "Discount : "
							+ (product.getDiscount() * product.getQuantity())
							+ "\n\n";
				} else {
					output += "Promotion : "
							+ productPromo.getDiscountAmount().get(
									product.getProductId()) + "% off on "
							+ product.getProductName() + " [Code:"
							+ product.getProductId() + "]\n";
					output += "Discount : "
							+ (product.getDiscount() * product.getQuantity())
							+ "\n\n";
				}

			}
		}
		output += "Promotion : Rs" + cart.getOrderLevelDiscount()
				+ " off on order \n";
		output += "Discount : Rs" + cart.getOrderLevelDiscount() + "\n\n\n";
		return output;
	}

	/**
	 * 
	 * @return String containing final bill
	 */
	private String finalBill() {
		String output = "";
		output += "Subtotal : " + cart.getSubTotal() + "\n";
		output += "Product Level Discounts : Rs" + cart.getTotalProductLevelDiscount()
				+ "\n";
		output += "Order Level Discounts : Rs" + cart.getOrderLevelDiscount() + "\n";
		output += "Total Discount : Rs"
				+ (cart.getOrderLevelDiscount() + cart.getTotalProductLevelDiscount()) + "\n";
		output += "Total : Rs"
				+ (cart.getSubTotal() - cart.getTotalProductLevelDiscount() - cart.getOrderLevelDiscount() + "\n");
		
		return output;
	}

	/**
	 * Overriding toString method and return bill in string format
	 * @return String containing details of bill
	 */
	@Override
	public String toString() {
		String display = "";
		String hashtag = "\n##########################################################################################\n";
		display += hashtag + "\nYour Order : " + userName + " \n" + hashtag;
		display += "\nPURCHASE PRODUCTS :\n";
		display += purchaseProductDetails();
		display += "\n\nAPPLIED PROMOTION/DISCOUNTS : \n\n";
		display += appliedPromotionsOrDiscount();
		display += finalBill();
		display += hashtag + "  THANK YOU " + hashtag;
		cart.setCartItems(new ArrayList<CartProducts>());
		FileHandling file = new FileHandling();
		file.write(display, userName);
		
		return display;
	}
}