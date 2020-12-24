package CompletableFuture;

public class Order {

    String orderName;
    int id;

    public Order(String orderName, int id) {
        this.orderName = orderName;
        this.id = id;
    }

    public Order() {

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
}
