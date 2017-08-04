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
	private double subTotal;
	private double totalProductLevelDiscount;
	private double orderLevelDiscount;

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
		this.subTotal = cart.getSubTotal();
		this.totalProductLevelDiscount = cart.getTotalProductLevelDiscount();
		this.orderLevelDiscount = cart.getOrderLevelDiscount();
	}

	/**
	 * 
	 * @return String containing purchase details
	 */
	protected String purchaseProductDetails() {
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
	protected String appliedPromotionsOrDiscount() {
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
	protected String finalBill() {
		String output = "";
		output += "Subtotal : " + subTotal + "\n";
		output += "Product Level Discounts : Rs" + totalProductLevelDiscount
				+ "\n";
		output += "Order Level Discounts : Rs" + orderLevelDiscount + "\n";
		output += "Total Discount : Rs"
				+ (orderLevelDiscount + totalProductLevelDiscount) + "\n";
		output += "Total : Rs"
				+ (subTotal - totalProductLevelDiscount - orderLevelDiscount + "\n");
		
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
		FileHandling file = new FileHandling();
		file.write(display, userName);
		
		return display;
	}
}