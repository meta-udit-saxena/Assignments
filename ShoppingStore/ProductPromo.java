import java.util.HashMap;
import java.util.List;

/**
 * Contains All promotion and discounts on each products
 * 
 * @author Udit Saxena
 * 
 */
public class ProductPromo implements Promotion {
	private List<String> productPromo;
	// HashMap<ProductId,Discount>
	private HashMap<Integer, Double> discountAmount = new HashMap<Integer, Double>();
	// HashMap<ProductId,DiscountType> here PromotionType is an enum
	private HashMap<Integer, PromotionType> discountType = new HashMap<Integer, PromotionType>();

	public ProductPromo() {
		initProductPromo();
	}

	/**
	 * Read from Productpromo file and save into hashmaps
	 */
	protected void initProductPromo() {
		productPromo = new FileHandling()
				.read(Constants.PRODUCT_PROMO_LIST_PATH);
		for (String str : productPromo) {
			String[] details = str.split(",");
			PromotionType promotionType = PromotionType.valueOf(details[0]);
			Double discount = Double.parseDouble(details[1]);
			String discountProductId[] = details[2].split(";");
			for (int index = 0; index < discountProductId.length; index++) {
				discountAmount.put(Integer.parseInt(discountProductId[index]),
						discount);
				discountType.put(Integer.parseInt(discountProductId[index]),
						promotionType);
			}
		}
	}

	/**
	 * @return discountAmount hashMap contains productId and discounts
	 */
	public HashMap<Integer, Double> getDiscountAmount() {
		return discountAmount;
	}

	/**
	 * @return discountType hashMap contains productId and discountType
	 */
	public HashMap<Integer, PromotionType> getDiscountType() {
		return discountType;
	}

	/**
	 * @param id
	 *            - Product Id
	 * @return true if product is applicable for discount else false
	 */
	public boolean isApplicable(double id) {

		return discountAmount.containsKey((int) id);
	}

	/**
	 * Responsible for finding discount according to product and set to the
	 * product discount in CartProducts
	 * 
	 * @param cart
	 *            - Cart class object
	 */
	public void setDiscount(Cart cart) {
		double discountPercentage = 0;
		double discountOffer = 0;
		for (CartProducts product : cart.getCartItems()) {
			int productId = product.getProductId();
			if (isApplicable(productId)) {
				if (PromotionType.ProductFixedAmountPromotion
						.equals(discountType.get(productId))) {
					product.setDiscount(discountAmount.get(productId));
				} else {
					discountPercentage = discountAmount.get(productId);
					discountOffer = product.getProductPrice()
							* (discountPercentage) / 100;
					product.setDiscount(discountOffer);
				}
			} else {
				product.setDiscount(0);
			}
			product.setTotalAmount();
		}
	}
	/**
	 * Overriding toString method of String class
	 * 
	 * @return String containing details of all product Level discount available
	 */
	@Override
	public String toString() {
		String result = "";
		for (String str : productPromo) {
			String[] s = str.split(",");
			if (PromotionType.ProductFixedAmountPromotion.equals(s[0])) {
				result += "get Rs " + s[1] + " discount on these Products : "
						+ s[2] + "\n";
			} else {
				result += "get " + s[1] + "% discount on these Product : "
						+ s[2] + "\n";
			}
		}
		return result;
	}
}
