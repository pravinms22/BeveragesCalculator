package beverage.calculate.order.factory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import beverage.calculate.order.constant.BeveragesConstants;
import beverage.calculate.order.data.LoadBeveragesData;
import beverage.calculate.order.exception.InvalidOrderException;

public class CalculateBeveragesPrice {

	

	/**
	 * This method calculates the final price of all orders
	 * @param ordersList
	 * @return
	 * @throws InvalidOrderException
	 */
	public double calculateTotalOrdersPrice(List<String> ordersList) throws InvalidOrderException {

		double finalPrice = 0;
		//load data
		HashMap<String, Map<String, Double>> ordersIngredientDataMap = LoadBeveragesData.orderIngredientMap;
		//calculate total price of all orders
		for (String order : ordersList) {
			finalPrice = finalPrice
					+ getSingleCustomOrderPrice(order, ordersIngredientDataMap);
		}
		return finalPrice;
	}

	/**
	 * This mwthod calculates the price of single order after exclusion of ingredients 
	 * @param order
	 * @param ordersIngredientDataMap
	 * @return
	 * @throws InvalidOrderException
	 */
	public double getSingleCustomOrderPrice(String order, HashMap<String, Map<String, Double>> ordersIngredientDataMap
			) throws InvalidOrderException {

		String[] orderWithIngredientArray = order.split(BeveragesConstants.DELIMITER);
		String orderName = orderWithIngredientArray[0];
		//validate particular order 
		validateOrderName(orderName, ordersIngredientDataMap);
		double exclusion = 0;
		HashMap<String, Double> singleOrderIngredientsMap = (HashMap<String, Double>) ordersIngredientDataMap.get(orderName);
		Set<String> ingredientsSingleOrderSet = new HashSet<String>();
		//calculate total exclusions for order
		for (int i = 1; i < orderWithIngredientArray.length; i++) {
			//validate ingredients of order and check if ingredients are not repeated for exclusion
			validateOrderIngredient(orderWithIngredientArray[i], singleOrderIngredientsMap, ingredientsSingleOrderSet);
			exclusion = exclusion + singleOrderIngredientsMap.get(orderWithIngredientArray[i]);
			ingredientsSingleOrderSet.add(orderWithIngredientArray[i]);
		}

		double orderPriceWithAllIngredients = ordersIngredientDataMap.get(orderName).entrySet().stream().mapToDouble(e->e.getValue()).sum();
		double pricewithExclusion = orderPriceWithAllIngredients - exclusion;
		if (pricewithExclusion == 0) {
			throw new InvalidOrderException(" can not exclude all ingredients for" + orderName);
		}
		return pricewithExclusion;

	}

	/**
	 * Validates the single order ingredients for exclusions
	 * @param ingredient
	 * @param ingredientsMap
	 * @param ingredientsSingleOrderSet
	 * @throws InvalidOrderException
	 */
	private void validateOrderIngredient(String ingredient, HashMap<String, Double> ingredientsMap,
			Set<String> ingredientsSingleOrderSet) throws InvalidOrderException {
		if (!ingredientsMap.containsKey(ingredient)) {
			throw new InvalidOrderException(ingredient + " is Invalid order ingredient");
		}
		if (ingredientsSingleOrderSet.contains(ingredient)) {
			throw new InvalidOrderException(ingredient + " is repeated");
		}

	}

	/**
	 * Validates the the single order name 
	 * @param orderName
	 * @param orderIngredientMap
	 * @throws InvalidOrderException
	 */
	private void validateOrderName(String orderName, HashMap<String, Map<String, Double>> orderIngredientMap)
			throws InvalidOrderException {
		if (!orderIngredientMap.containsKey(orderName)) {
			throw new InvalidOrderException(orderName + " is Invalid order category");
		}

	}
}