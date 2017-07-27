package ShoppingStore;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Contains All promotion and discounts for final order
 * 
 * @author Udit Saxena
 * 
 */
public class OrderPromo implements Promotion {
	private List<String> orderPromoList;
	// HashMap<ThresoldValue,Discount>
	private HashMap<Double, Double> discountList = new HashMap<Double, Double>();
	// HashMap<ThresoldValue,DiscountType>
	// PromotionType is an enum
	private HashMap<Double, PromotionType> discountType = new HashMap<Double, PromotionType>();

	public OrderPromo() {
		initOrderPromoList();
	}

	/**
	 * Read from orderpromo file and save into hashmaps
	 */
	public void initOrderPromoList() {
		orderPromoList = new FileHandling()
				.read(Constants.ORDER_PROMO_LIST_PATH);
		for (String str : orderPromoList) {
			String[] details = str.split(",");
			discountList.put(Double.parseDouble(details[2]),
					Double.parseDouble(details[1]));
			discountType.put(Double.parseDouble(details[2]),
					PromotionType.valueOf(details[0]));
		}
	}

	/**
	 * @return discountList hashMap
	 */
	public HashMap<Double, Double> getDiscountList() {
		return discountList;
	}

	/**
	 * @return discountType hashMap
	 */
	public HashMap<Double, PromotionType> getDiscountType() {
		return discountType;
	}

	/**
	 * @param totalAmount
	 *            - Complete order amount after applying product level discount
	 * @return true if totalAmount is apllicable for discount else false
	 */
	public boolean isApplicable(double totalAmount) {
		double[] thresoldArray = new double[discountList.size()];
		int index = 0;
		for (double amount : discountList.keySet()) {
			thresoldArray[index] = amount;
			index++;
		}
		Arrays.sort(thresoldArray);
		if (totalAmount >= thresoldArray[0]) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Responsible for finding discount according to amount and set to the order
	 * level discount
	 * 
	 * @param cart
	 *            - Cart class object
	 */
	public void setDiscount(Cart cart) {
		double totalAmount = cart.getSubTotal()
				- cart.getTotalProductLevelDiscount();

		if (isApplicable(totalAmount)) {
			double[] thresoldArray = new double[discountList.size()];
			int index = 0;
			for (double amount : discountList.keySet()) {
				thresoldArray[index] = amount;
				index++;
			}
			Arrays.sort(thresoldArray);
			double maxDiscount = 0;
			int count = 0;
			while (count < thresoldArray.length) {
				if (totalAmount < thresoldArray[count]) {
					break;
				} else {
					if (PromotionType.OrderFixedAmountPromotion
							.equals(discountType.get(thresoldArray[count]))) {
						if (maxDiscount < discountList
								.get(thresoldArray[count])) {
							maxDiscount = discountList
									.get(thresoldArray[count]);
						}
					} else {
						if (maxDiscount < discountList
								.get(thresoldArray[count]) * totalAmount / 100) {
							maxDiscount = discountList
									.get(thresoldArray[count])
									* totalAmount
									/ 100;
						}
					}
					count++;
				}
			}
			cart.setOrderLevelDiscount(Double.parseDouble(String.format("%2f",maxDiscount)));
		} else {
			cart.setOrderLevelDiscount(0);
		}
	}

	/**
	 * Overriding toString method of String class
	 * 
	 * @return String containing details of all order Level discount available
	 */
	@Override
	public String toString() {
		String result = "";
		for (String str : orderPromoList) {
			String[] s = str.split(",");
			if (PromotionType.OrderFixedAmountPromotion.toString().equals(s[0])) {
				result += "get Rs" + s[1] + "  discount on order above - Rs"
						+ s[2] + "\n";
			} else {
				result += "get " + s[1] + "%  discount on order above - Rs"
						+ s[2] + "\n";
			}
		}

		return result;
	}

}
