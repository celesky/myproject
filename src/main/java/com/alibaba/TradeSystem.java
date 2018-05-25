package com.alibaba;


import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1.用代码模拟电商交易的简单流程：下单、减库存、支付、配送、收货、确认收货。
 */
public class TradeSystem {

    public static void main(String[] args) {
        //初始化库存
        StockService.initStock();

        Scanner in = new Scanner(System.in);
        System.out.println("创建用户,输入名称:");
        String userName= in.nextLine();
        UserEntity userEntity = new UserService().createUser(userName);
        System.out.println("用户已创建 id: " + userEntity.getUserId()+" 名称:"+userEntity.getUserName());

        System.out.println("可选商品如下 请选择你需要购买的商品,输入商品id : " );
        System.out.println("----------------------- = ");
        StockService.showStocks();
        System.out.println("----------------------- = ");

        String pId= in.nextLine();
        System.out.println("填写购买数量 : " );
        Integer num = Integer.parseInt(in.nextLine());
        OrderEntity order = new OrderService().createOrder(pId,num,userEntity.getUserId());
        System.out.println("订单已提交" );
        System.out.println("----------------------- = ");

        System.out.println("是否现在支付: y/n" );
        String payNow= in.nextLine();
        if("y".equals(payNow)){
            new PaySystem().pay(order.getOrderId(),1);
            System.out.println("已支付完成 " );

            System.out.println("开始配送" );
            new Logistics().dispach(order.getOrderId());

            System.out.println("是否确认收货: y/n" );
            String receive= in.nextLine();
            if("y".equals(receive)){
                new Logistics().recevie(order.getOrderId());
                System.out.println("已确认收货" );
            }
        }
        System.out.println("----------------------- = ");
        StockService.showStocks();
        OrderService.showOrders();
        System.out.println("----------------------- = ");


    }


}


//物流
class Logistics{

    OrderService orderService = new OrderService();
    //发货
    public void dispach(Long orderId){
        System.out.println("对订单 orderId = " + orderId+" 进行派送");
        orderService.updateLogisticsSended(orderId);
    }

    public void recevie(Long orderId){
        System.out.println("对订单 orderId = " + orderId+" 进行收货");
        orderService.updateLogisticsReceived(orderId);
    }

}






//订单
class OrderService{
    static ConcurrentHashMap<Long,OrderEntity> orders = new ConcurrentHashMap<>();
    ReentrantLock orderLock = new ReentrantLock();
    public OrderService(){
    }
    /**
     * 创建订单
     * @param productId
     * @param stockNum
     * @param userId
     */
    public OrderEntity createOrder(String productId,int stockNum,Long userId){
        //锁定商品
        DistributeLock.lock(productId);
        //开启事务
        OrderEntity orderEntity = saveOrderInfo( productId, stockNum, userId);
        StockService.decreaseStockNum(productId,stockNum);
        //关闭事物
        DistributeLock.unLock(productId);
        return orderEntity;
    }

    //保存订单信息
    public OrderEntity  saveOrderInfo(String productId,int stockNum,Long userId){
        Long orderId=IdGererator.getId();
        OrderEntity orderEntity = new OrderEntity(orderId,productId,stockNum,userId);
        //存储订单
        orders.put(orderId,orderEntity);
        return orderEntity;
    }
    //更新订单支付状态
    public  void updatePayState(Long orderId,int payState){
        try{
            orderLock.lock();
            OrderEntity orderEntity = orders.get(orderId);
            orderEntity.setPayState(payState);
            System.out.println("更新订单: "+orderId+" 支付状态 payState:"+payState );
        }finally {
            orderLock.unlock();
        }

    }
    //更新订单物流状态
    public  void updateLogisticsSended(Long orderId){
        try {
            orderLock.lock();
            OrderEntity orderEntity = orders.get(orderId);
            orderEntity.setOrderState(1);
            System.out.println("更新订单: " + orderId + " 物流状态");
        }finally {
            orderLock.unlock();
        }
    }
    public  void updateLogisticsReceived(Long orderId){
        try {
            orderLock.lock();
            OrderEntity orderEntity = orders.get(orderId);
            orderEntity.setOrderState(2);
            System.out.println("更新订单: " + orderId + " 物流状态");
        }finally {
            orderLock.unlock();
        }
    }

    public static void showOrders(){
        Iterator<Long > it =  orders.keySet().iterator();
        while(it.hasNext()){
            Long pId = it.next();
            OrderEntity order = orders.get(pId);
            System.out.println("order = " + order.toString());
        }
    }

}
class UserService{
    public UserEntity createUser(String name){
        Long userId = IdGererator.getId();
        return new UserEntity(userId,name);
    }
}

//库存
class StockService{
    private static ConcurrentHashMap<String,Integer> stocks = new ConcurrentHashMap<String,Integer>();
    private static ReentrantLock lock = new ReentrantLock();
    //初始化库存数据
    public StockService(){

    }

    public static void initStock(){
        stocks.put("p001",10);
        stocks.put("p002",20);
        stocks.put("p003",15);
    }
    public static void showStocks(){
        Iterator<String > it =  stocks.keySet().iterator();
        while(it.hasNext()){
            String pId = it.next();
            Integer stock = stocks.get(pId);
            System.out.println("产品id: " + pId+"    库存:"+stock);
        }
    }
    public static boolean increaseStockNum(String productId,int n){
        System.out.println("正在对productId: " + productId+" 加"+n+"个库存操作...");
        return true;
    }


    public static boolean decreaseStockNum(String productId,int n){
        System.out.println("正在对productId: " + productId+" 减"+n+"个库存操作...");
        try{
            lock.lock();
            Integer num = stocks.get(productId);
            if(n>num){
                throw new RuntimeException("库存不足");
            }
            if(num>0){
                num=num-n;
            }
            stocks.put(productId,num);
        }finally {
            lock.unlock();
        }

        return true;
    }
}

//支付系统
class PaySystem{

    OrderService orderService = new OrderService();
    //用户支付,系统受到回调修改支付状态
    public void pay(Long orderId,int payState){
        orderService.updatePayState( orderId,payState);
    }

}

//锁
class DistributeLock{
    public static boolean lock(String productId){
        System.out.println("正在对productId:"+productId+ " 锁定库存操作");
        return true;
    }
    public static boolean unLock(String productId){
        System.out.println("已对productId:"+productId+ "解除锁定库存操作");
        return true;
    }
}
//id生成器
class IdGererator{
    private static AtomicLong id=new AtomicLong();
    public static Long getId(){
        return id.incrementAndGet();
    }
}

class OrderEntity{
    private Long orderId;
    private String productId;
    private int num;
    private int orderState = 0;
    private int payState=0;
    private Long userId;

    public OrderEntity(Long orderId, String productId, Integer num, Long userId) {
        this.orderId = orderId;
        this.productId = productId;
        this.num = num;
        this.userId = userId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getOrderState() {
        return orderState;
    }

    public void setOrderState(int orderState) {
        this.orderState = orderState;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getPayState() {
        return payState;
    }

    public void setPayState(int payState) {
        this.payState = payState;
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "orderId=" + orderId +
                ", productId='" + productId + '\'' +
                ", num=" + num +
                ", orderState=" + orderState +
                ", payState=" + payState +
                ", userId=" + userId +
                '}';
    }
}
class UserEntity{
    private Long userId;
    private String userName;

    public UserEntity(Long userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}