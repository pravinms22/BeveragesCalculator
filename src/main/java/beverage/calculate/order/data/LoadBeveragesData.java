package beverage.calculate.order.data;

import java.util.HashMap;
import java.util.Map;

import beverage.calculate.order.constant.BeveragesConstants;

public class LoadBeveragesData {
	
	
	public static  HashMap<String,Map<String,Double>> orderIngredientMap=new HashMap<>();
	
	
	
	static {
		
		Map<String,Double> chaiIngredientsMap=new HashMap<>();
		chaiIngredientsMap.put(BeveragesConstants.MILK, 1.0);
		chaiIngredientsMap.put(BeveragesConstants.SUGAR,0.5 );
		chaiIngredientsMap.put(BeveragesConstants.WATER,0.5 );
		chaiIngredientsMap.put(BeveragesConstants.TEA,2.0 );
		orderIngredientMap.put(BeveragesConstants.CHAI, chaiIngredientsMap);
		
		Map<String,Double> coffeeIngredientsMap=new HashMap<>();
		coffeeIngredientsMap.put(BeveragesConstants.MILK, 1.0);
		coffeeIngredientsMap.put(BeveragesConstants.SUGAR,0.5 );
		coffeeIngredientsMap.put(BeveragesConstants.WATER,0.5 );
		coffeeIngredientsMap.put(BeveragesConstants.COFFEE,3.0 );
		orderIngredientMap.put(BeveragesConstants.COFFEE2, coffeeIngredientsMap);
		
		Map<String,Double> bananaSmoothieIngredientsMap=new HashMap<>();
		bananaSmoothieIngredientsMap.put(BeveragesConstants.MILK, 1.0);
		bananaSmoothieIngredientsMap.put(BeveragesConstants.SUGAR,0.5 );
		bananaSmoothieIngredientsMap.put(BeveragesConstants.WATER,0.5 );
		bananaSmoothieIngredientsMap.put(BeveragesConstants.BANANA,4.0 );
		orderIngredientMap.put(BeveragesConstants.BANANA_SMOOTHIE, bananaSmoothieIngredientsMap);
		
		Map<String,Double> strawberryShakeIngredientsMap=new HashMap<>();
		strawberryShakeIngredientsMap.put(BeveragesConstants.MILK, 1.0);
		strawberryShakeIngredientsMap.put(BeveragesConstants.SUGAR,0.5 );
		strawberryShakeIngredientsMap.put(BeveragesConstants.WATER,0.5 );
		strawberryShakeIngredientsMap.put(BeveragesConstants.STRAWBERRY,5.0 );
		orderIngredientMap.put(BeveragesConstants.STRAWBERRY_SHAKE, strawberryShakeIngredientsMap);
		
		Map<String,Double> mojitoIngredientsMap=new HashMap<>();
		mojitoIngredientsMap.put(BeveragesConstants.SODA, 0.5);
		mojitoIngredientsMap.put(BeveragesConstants.SUGAR,0.5 );
		mojitoIngredientsMap.put(BeveragesConstants.WATER,0.5 );
		mojitoIngredientsMap.put(BeveragesConstants.LEMON,5.5 );
		mojitoIngredientsMap.put(BeveragesConstants.MINT,0.5);
		orderIngredientMap.put(BeveragesConstants.MOJITO, mojitoIngredientsMap);
		
		
		
		
		
		
	}

}

