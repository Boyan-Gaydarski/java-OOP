import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class ProductStockTest {
    private ProductStock stock;

    @Before
    public void setUp() {
        stock = new Instock();
    }

    @Test
    public void testCountShouldReturnCorrectSize() {
        assertEquals(0, stock.getCount());
        stock.add(createProduct());
        assertEquals(1, stock.getCount());
    }

    @Test
    public void testContainsShouldReturnCorrectBooleanForAllCases() {
        Product product = createProduct();
        assertFalse(stock.contains(product));

        stock.add(product);
        assertTrue(stock.contains(product));

        assertFalse(stock.contains(new Product("not_present_label", 3, 1)));
    }

    @Test
    public void testAddProductShouldStoreTheCorrectProduct() {
        Product product = createProduct();
        stock.add(product);
        assertTrue(stock.contains(product));
    }

    @Test
    public void testFindByIndexShouldReturnCorrectIfFirstProductInStock() {
        Product product = createProduct();
        stock.add(product);
        Product foundByIndex = stock.find(0);
        assertNotNull(foundByIndex);
        assertEquals(product.getLabel(), foundByIndex.getLabel());
    }

    @Test
    public void testFindByIndexShouldReturnCorrectIfLastProductInStock() {
        fillProductsToStock(5);

        Product product = createProduct();
        stock.add(product);
        Product foundByIndex = stock.find(stock.getCount() - 1);
        assertNotNull(foundByIndex);
        assertEquals(product.getLabel(), foundByIndex.getLabel());
    }

    @Test
    public void testFindByIndexShouldReturnCorrectIfMiddleProductInStock() {
        fillProductsToStock(5);

        Product product = createProduct();
        stock.add(product);

        fillProductsToStock(5);

        Product foundByIndex = stock.find(5);
        assertNotNull(foundByIndex);
        assertEquals(product.getLabel(), foundByIndex.getLabel());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindByIndexWithNegativeIndex() {
        stock.find(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindByIndexWithNoItemsInStock() {
        stock.find(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindByIndexWhenEqualToSize() {
        fillProductsToStock(5);
        stock.find(stock.getCount());
    }


    @Test
    public void testChangeQuantityChangesQuantityCorrectly() {
        Product product = createProduct();
        stock.add(product);
        int newQuantity = product.getQuantity() + 10;
        stock.changeQuantity(product.getLabel(), newQuantity);
        Product foundByIndex = stock.find(0);
        assertEquals(newQuantity, product.getQuantity());
        assertNotNull(foundByIndex);
        assertEquals(newQuantity, foundByIndex.getQuantity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeQuantityWhenMissingProduct() {

        Product product = createProduct();
        stock.changeQuantity(product.getLabel(), product.getQuantity() + 10);

    }


    @Test
    public void testFindByLabelShouldReturnCorrectProduct() {
        Product product = createProduct();
        stock.add(product);
        Product byLabel = stock.findByLabel(product.getLabel());
        assertNotNull(byLabel);
        assertEquals(product.getLabel(), byLabel.getLabel());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindByLabelWithNoSuchProduct() {
        stock.findByLabel("not_present_label");
    }


    @Test
    public void testFindFirstByAlphabeticalOrderShouldReturnCorrectNumberOfProducts() {
        fillProductsToStock(10);

        Iterable<Product> products = stock.findFirstByAlphabeticalOrder(8);

        assertNotNull(products);
        List<Product> returnedProducts = createListFromIterable(products);
        assertEquals(8, returnedProducts.size());
    }

    @Test
    public void testFindFirstByAlphabeticalOrderShouldReturnCorrectNumberOfProductsAndOrderedAlphabetically() {
        fillProductsToStock(10);

        Iterable<Product> products = stock.findFirstByAlphabeticalOrder(8);

        assertNotNull(products);
        List<Product> returnedProducts = createListFromIterable(products);
        assertEquals(8, returnedProducts.size());

        Set<String> expectedLabels = returnedProducts.stream()
                .map(Product::getLabel)
                .collect(Collectors.toCollection(TreeSet::new));

        int index = 0;
        for (String expectedLabel : expectedLabels) {
            assertEquals(expectedLabel, returnedProducts.get(index++).getLabel());
        }
    }

    @Test
    public void testFindFirstByAlphabeticalOrderShouldReturnEmptyCollection() {
        fillProductsToStock(10);
        Iterable<Product> iterable = stock.findFirstByAlphabeticalOrder(11);
        assertNotNull(iterable);
        List<Product> list = createListFromIterable(iterable);
        assertTrue(list.isEmpty());
    }

    @Test
    public void testFindAllInPriceRangeShouldReturnCorrectProductsInCorrectOrder() {
        Product product1 = new Product("test_label_1", 1, 1);
        Product product2 = new Product("test_label_2", 2, 1);
        Product product5 = new Product("test_label_5", 5, 1);
        Product product6 = new Product("test_label_6", 6, 1);
        Product product7 = new Product("test_label_7", 7, 1);
        Product product9 = new Product("test_label_9", 9, 1);
        Product product10 = new Product("test_label_10", 10, 1);
        Product product11 = new Product("test_label_11", 11, 1);
        Product product12 = new Product("test_label_12", 12, 1);

        stock.add(product1);
        stock.add(product2);
        stock.add(product5);
        stock.add(product6);
        stock.add(product7);
        stock.add(product9);
        stock.add(product10);
        stock.add(product11);
        stock.add(product12);

        Iterable<Product> iterable = stock.findAllInRange(5, 10);

        assertNotNull(iterable);

        List<Product> products = createListFromIterable(iterable);

        assertEquals(4, products.size());

        assertEquals(10, products.get(0).getPrice(), 0);
        assertEquals(9, products.get(1).getPrice(), 0);
        assertEquals(7, products.get(2).getPrice(), 0);
        assertEquals(6, products.get(3).getPrice(), 0);
    }

    @Test
    public void testFindAllInPriceRangeShouldReturnEmptyCollectionWhenNoneInRange() {
        Product product1 = new Product("test_label_1", 1, 1);
        Product product2 = new Product("test_label_2", 2, 1);
        Product product11 = new Product("test_label_11", 11, 1);
        Product product12 = new Product("test_label_12", 12, 1);

        stock.add(product1);
        stock.add(product2);
        stock.add(product11);
        stock.add(product12);

        Iterable<Product> iterable = stock.findAllInRange(5, 10);

        assertNotNull(iterable);

        List<Product> products = createListFromIterable(iterable);

        assertTrue(products.isEmpty());

    }

    @Test
    public void testFindAllByPriceShouldReturnOnlyCorrectPricedProducts() {
        Product product1 = new Product("test_label_1", 1, 1);
        Product product2 = new Product("test_label_2", 2, 1);
        Product product3 = new Product("test_label_3", 5, 1);
        Product product4 = new Product("test_label_4", 5, 1);
        Product product5 = new Product("test_label_5", 5, 1);
        Product product6 = new Product("test_label_6", 5, 1);
        Product product7 = new Product("test_label_7", 5, 1);
        Product product8 = new Product("test_label_8", 11, 1);
        Product product9 = new Product("test_label_9", 12, 1);

        stock.add(product1);
        stock.add(product2);
        stock.add(product3);
        stock.add(product4);
        stock.add(product5);
        stock.add(product6);
        stock.add(product7);
        stock.add(product8);
        stock.add(product9);

        Iterable<Product> iterable = stock.findAllByPrice(5);

        assertNotNull(iterable);

        List<Product> products = createListFromIterable(iterable);

        assertEquals(5, products.size());

        for (Product product : products) {
            assertEquals(5, product.getPrice(), 0);
        }
    }

    @Test
    public void testFindAllByPriceShouldReturnEmptyCollectionWhenNoProductsWithSpecifiedPrice() {
        fillProductsToStock(10);

        Product product = stock.find(0);
        assertNotNull(product);

        Iterable<Product> iterable = stock.findAllByPrice(product.getPrice() + 10);

        assertNotNull(iterable);

        List<Product> products = createListFromIterable(iterable);

        assertTrue(products.isEmpty());
    }

    @Test
    public void testFindFirstMostExpensiveProductsShouldReturnCorrectProducts() {
        Product product1 = new Product("test_label_1", 1, 1);
        Product product2 = new Product("test_label_2", 2, 1);
        Product product3 = new Product("test_label_3", 3, 1);
        Product product4 = new Product("test_label_4", 4, 1);
        Product product5 = new Product("test_label_5", 5, 1);
        Product product6 = new Product("test_label_6", 6, 1);
        Product product7 = new Product("test_label_7", 7, 1);
        Product product8 = new Product("test_label_8", 8, 1);
        Product product9 = new Product("test_label_9", 9, 1);

        stock.add(product1);
        stock.add(product2);
        stock.add(product3);
        stock.add(product4);
        stock.add(product5);
        stock.add(product6);
        stock.add(product7);
        stock.add(product8);
        stock.add(product9);

        Iterable<Product> iterable = stock.findFirstMostExpensiveProducts(5);

        assertNotNull(iterable);

        List<Product> products = createListFromIterable(iterable);

        assertEquals(5, products.size());

        assertEquals(9, products.get(0).getPrice(), 0);
        assertEquals(8, products.get(1).getPrice(), 0);
        assertEquals(7, products.get(2).getPrice(), 0);
        assertEquals(6, products.get(3).getPrice(), 0);
        assertEquals(5, products.get(4).getPrice(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindFirstMostExpensiveProductsWhenNotEnoughProducts() {
        fillProductsToStock(10);
        stock.findFirstMostExpensiveProducts(11);
    }

    @Test
    public void testFindAllByQuantityShouldReturnCorrectProducts() {
        Product product1 = new Product("test_label_1", 1, 10);
        Product product2 = new Product("test_label_2", 2, 10);
        Product product3 = new Product("test_label_3", 3, 10);
        Product product4 = new Product("test_label_4", 4, 10);
        Product product5 = new Product("test_label_5", 5, 10);
        Product product6 = new Product("test_label_6", 6, 10);
        Product product7 = new Product("test_label_7", 7, 1);
        Product product8 = new Product("test_label_8", 8, 1);
        Product product9 = new Product("test_label_9", 9, 1);

        stock.add(product1);
        stock.add(product2);
        stock.add(product3);
        stock.add(product4);
        stock.add(product5);
        stock.add(product6);
        stock.add(product7);
        stock.add(product8);
        stock.add(product9);

        Iterable<Product> iterable = stock.findAllByQuantity(10);

        assertNotNull(iterable);

        List<Product> products = createListFromIterable(iterable);

        assertEquals(6, products.size());

        assertEquals(10, products.get(0).getQuantity());
        assertEquals(10, products.get(1).getQuantity());
        assertEquals(10, products.get(2).getQuantity());
        assertEquals(10, products.get(3).getQuantity());
        assertEquals(10, products.get(4).getQuantity());
        assertEquals(10, products.get(5).getQuantity());
    }

    @Test
    public void testFindAllByQuantityShouldReturnEmptyCollectionWhenNoSuchProducts() {
        fillProductsToStock(10);

        Product product = stock.find(0);

        assertNotNull(product);

        Iterable<Product> iterable = stock.findAllByQuantity(product.getQuantity() + 10);

        assertNotNull(iterable);

        List<Product> products = createListFromIterable(iterable);

        assertTrue(products.isEmpty());
    }


    @Test
    public void testGetIterableShouldReturnAll() {
        Product product1 = new Product("test_label_1", 1, 10);
        Product product2 = new Product("test_label_2", 2, 10);
        Product product3 = new Product("test_label_3", 3, 10);
        Product product4 = new Product("test_label_4", 4, 10);
        Product product5 = new Product("test_label_5", 5, 10);
        Product product6 = new Product("test_label_6", 6, 10);
        Product product7 = new Product("test_label_7", 7, 1);
        Product product8 = new Product("test_label_8", 8, 1);
        Product product9 = new Product("test_label_9", 9, 1);

        stock.add(product1);
        stock.add(product2);
        stock.add(product3);
        stock.add(product4);
        stock.add(product5);
        stock.add(product6);
        stock.add(product7);
        stock.add(product8);
        stock.add(product9);

        Iterator<Product> iterator = stock.iterator();

        assertNotNull(iterator);

        List<Product> products = createListFromIterable(iterator);

        assertEquals(9, products.size());

    }

    @Test
    public void testGetIterableShouldReturnEmptyCollectionWhenNoProducts() {


        Iterator<Product> iterator = stock.iterator();

        assertNotNull(iterator);

        List<Product> products = createListFromIterable(iterator);

        assertTrue(products.isEmpty());
    }




    private <T> List<T> createListFromIterable(Iterable<T> products) {
        List<T> result = new ArrayList<>();

        for (T product : products) {
            result.add(product);
        }
        return result;
    }

    private <T> List<T> createListFromIterable(Iterator<T> products) {
        List<T> result = new ArrayList<>();

        while (products.hasNext()) {
            result.add(products.next());
        }
        return result;
    }


    public Product createProduct() {
        return new Product("test_label", 3.00, 1);
    }

    public Product[] createMultipleProducts(int count) {
        Product[] products = new Product[count];

        for (int i = 0; i < products.length; i++) {
            products[i] = new Product("test_lable_" + i, 3.00, 1);
        }

        return products;
    }

    private void fillProductsToStock(int count) {
        Product[] products = createMultipleProducts(count);

        for (Product product : products) {
            stock.add(product);
        }
    }
}