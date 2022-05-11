package manage;

import object.Product;

import java.util.ArrayList;
import java.util.List;

public class ManageProduct {
    private List<Product> productList = new ArrayList<>();

    public ManageProduct() {
    }


    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public void add(Product product) {
        productList.add(product);
    }

    public void display() {
        for (int i = 0; i < productList.size(); i++) {
            System.out.println(productList.get(i));
        }
        System.out.println("-----------------------------------");
    }

    public int findIndexById(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProductid() == id) {
                return i;
            }
        }
        return -1;
    }

    public void delete(int id){
        if (findIndexById(id) != -1){
            productList.remove(findIndexById(id));
        } else {
            System.out.println("No product id found !");
        }
    }

    public void edit(int id,Product product ){
        int idexOfId = findIndexById(id);
        if (idexOfId == -1){
            System.out.println("No product id found !");
        } else {
            productList.set(idexOfId,product);
        }
        System.out.println("Successfully changed !");
    }


}
