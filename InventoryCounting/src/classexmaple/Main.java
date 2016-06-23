package classexmaple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Main {

	public static void main(String[] args) {

		List<Product> productList = new ArrayList<>();

		productList.add(new Product(ProductType.TV));
		productList.add(new Product(ProductType.TV));
		productList.add(new Product(ProductType.CD_PLAYER));
		productList.add(new Product(ProductType.FLOPPY_DISK));
		productList.add(new Product(ProductType.WALKMEN));

		Map<ProductType, Integer> inventoryCount = countProductTypes(productList);

		System.out.println(inventoryCount);

		ProductType mostCommonType = getMostCommonProductType(inventoryCount);
		
		System.out.println(mostCommonType);

	}

	private static ProductType getMostCommonProductType(Map<ProductType, Integer> inventoryCount) {
		int maxCount = 0;
		ProductType mostCommonType = null;
		for (Entry<ProductType, Integer> entry : inventoryCount.entrySet()) {
			if (entry.getValue() > maxCount) {
				maxCount = entry.getValue();
				mostCommonType = entry.getKey();
			}
		}
		return mostCommonType;
	}

	private static Map<ProductType, Integer> countProductTypes(List<Product> productList) {
		Map<ProductType, Integer> inventoryCount = new HashMap<ProductType, Integer>();
		Iterator<Product> iterator = productList.iterator();

		while (iterator.hasNext()) {
			Product p = iterator.next();
			ProductType pt = p.getType();

			if (inventoryCount.containsKey(pt)) {
				int counter = inventoryCount.get(pt);
				inventoryCount.put(pt, ++counter);
			}
			else {
				inventoryCount.put(pt, 1);
			}
		}
		return inventoryCount;
	}

}
