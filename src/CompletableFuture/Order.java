package CompletableFuture;

public class Order {

    String orderName;
    int id;

    public Order(String orderName, int id) {
        this.orderName = orderName;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", id=" + id +
                '}';
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static Order selectOrder(String id) {
        //Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName()+" selecting order");
        return new Order(id,Integer.valueOf(id));
    }

    public static Order paymentForOrder(Order order) {
        //Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName()+" doing payment");
        return order;
    }

    public static void emailOrder(Order order)  {
       // Thread.sleep(3000);
        System.out.println(Thread.currentThread().getName()+" emailed to customer:: "+order);

    }
}
