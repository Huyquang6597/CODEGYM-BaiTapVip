package manage;

import object.OrderDetail;
import object.Product;

import java.util.ArrayList;
import java.util.List;

public class ManageOrder {
    private List<OrderDetail> orderList = new ArrayList<>();
  ManageProduct manageProduct = new ManageProduct();

    public ManageOrder() {
    }

    public List<OrderDetail> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderDetail> orderList) {
        this.orderList = orderList;
    }

    public void add1(OrderDetail orderDetail) {
        orderList.add(orderDetail);
    }

    public void display() {
        for (int i = 0; i < orderList.size(); i++) {
            System.out.println(orderList.get(i));
        }
        System.out.println("-----------------------------------");
    }

    public int findIndexById1(int id) {

        for (int i = 0; i < manageProduct.getProductList().size(); i++) {
            if (manageProduct.getProductList().get(i).getProductid() == id) {
                return i;
            }
        }
        return -1;
    }

    public void delete(int id){
        if (findIndexById1(id) != -1){
            orderList.remove(findIndexById1(id));
        } else {
            System.out.println("No product id found !");
        }
    }

    public void edit(int id,OrderDetail orderDetail ){
        int idexOfId = findIndexById1(id);
        if (idexOfId == -1){
            System.out.println("No product id found !");
        } else {
            orderList.set(idexOfId,orderDetail);
        }
        System.out.println("Successfully changed !");
    }

}
