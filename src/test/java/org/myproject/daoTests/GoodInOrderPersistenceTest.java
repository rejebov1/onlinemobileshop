package org.myproject.daoTests;

//@RunWith(SpringRunner.class)
public class GoodInOrderPersistenceTest {
//
//    @Autowired
//    private GoodInOrderDao goodInOrderDao;
//
//    @Test
//    public void whenPersistedGoodInOrder_thenRetrievedFromDb(){
//        Order testAddress = Order.builder()
//                .address("testAddress")
//                .dateOfOrder(LocalDate.now())
//                .deliveryDate(LocalDate.now())
//                .goodInOrder(new ArrayList<>())
//                .status(OrderStatus.DELIVERED)
//                .build();
//        Brand brand = Brand.builder()
//                .country("testCountry")
//                .name("testName")
//                .id(1L)
//                .build();
//        Product product = Product.builder()
//                .brand(brand)
//                .price(1.0)
//                .productCharacteristic("productCharacTest")
//                .dateOfIssue(LocalDate.now())
//                .phoneModel("testPhoneModel")
//                .id(1L)
//                .build();
//        GoodInOrder testGoodInOrder = GoodInOrder.builder()
//                .id(new GoodInOrder.GoodInOrderPk(1L, 1L))
//                .order(testAddress)
//                .product(product)
//                .quantityOfGoodsInTheOrder(1)
//                .build();
//        goodInOrderDao.add(
//                testGoodInOrder
//        );
//        List<GoodInOrder> all = goodInOrderDao.getAll();
//        Assert.assertTrue(all.contains(testGoodInOrder));
//    }
}
