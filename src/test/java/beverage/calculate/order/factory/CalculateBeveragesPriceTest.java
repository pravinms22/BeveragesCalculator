package beverage.calculate.order.factory;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import beverage.calculate.order.exception.InvalidOrderException;


public class CalculateBeveragesPriceTest {
	CalculateBeveragesPrice calculateBeveragesPrice=new CalculateBeveragesPrice();
	/**
	 * orders with exclusions
	 * @throws InvalidOrderException
	 */
	@Test
	public void calculateTotalOrdersPriceTest() throws InvalidOrderException {
		List<String> orders=new ArrayList<>();
		orders.add("Chai");
		orders.add("Chai,-sugar");	
		assertEquals(7.5, calculateBeveragesPrice.calculateTotalOrdersPrice(orders));	
	}
	
	/**
	 * Orders without exclusions
	 * @throws InvalidOrderException
	 */
	@Test
	public void calculateTotalOrdersPriceWithoutExclusionsTest() throws InvalidOrderException {
		List<String> orders=new ArrayList<>();
		orders.add("Chai");
		orders.add("Coffee");	
		assertEquals(9.0, calculateBeveragesPrice.calculateTotalOrdersPrice(orders));	
	}
	
	/**
	 * Invalid Order
	 * @throws InvalidOrderException
	 */
	@Test(expected = InvalidOrderException.class)
	public void invalidOrderTest() throws InvalidOrderException {
		List<String> orders=new ArrayList<>();
		orders.add("Lassi");
		calculateBeveragesPrice.calculateTotalOrdersPrice(orders);	
	}
	
	/**
	 * Excluding invalid ingredients
	 * @throws InvalidOrderException
	 */
	@Test(expected = InvalidOrderException.class)
	public void invalidOrderIngredientsTest() throws InvalidOrderException {
		List<String> orders=new ArrayList<>();
		orders.add("Chai,-coconut");
		calculateBeveragesPrice.calculateTotalOrdersPrice(orders);	
	}
	
	/**
	 * Excluding all ingredients of order
	 * @throws InvalidOrderException
	 */
	@Test(expected = InvalidOrderException.class)
	public void excludeAllIngredientsTest() throws InvalidOrderException {
		List<String> orders=new ArrayList<>();
		orders.add("Chai,-sugar,-milk,-water,-tea");
		calculateBeveragesPrice.calculateTotalOrdersPrice(orders);	
	}
	
	/**
	 * Excluding repeated ingredients
	 * @throws InvalidOrderException
	 */
	@Test(expected = InvalidOrderException.class)
	public void invalidOrderIngredientsRepeatedTest() throws InvalidOrderException {
		List<String> orders=new ArrayList<>();
		orders.add("Chai,-sugar,-sugar");
		calculateBeveragesPrice.calculateTotalOrdersPrice(orders);	
	}
	
	
	
	
}
