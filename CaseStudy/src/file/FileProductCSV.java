package file;

import account.User;
import object.Product;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class FileProductCSV {
    public List<Product> readFileProduct(List<Product> productList, String filePath) throws FileNotFoundException {
        try {
            FileReader fileReader = new FileReader(filePath);
            Scanner scanner = new Scanner(fileReader);
            productList.clear();
            if (scanner.nextLine() != null) {
                while (scanner.hasNext()) {
                    String a = scanner.nextLine();
                    String[] arr = a.split(",");
                    Product product = new Product(Integer.parseInt(arr[0]), arr[1], Integer.parseInt(arr[2]), Integer.parseInt(arr[3]), Integer.parseInt(arr[4]), arr[5]);
                    productList.add(product);
                }
            } else {
                throw new Exception();
            }
        } catch (Exception e) {

        }
        return productList;
    }

    public void writeFileProduct(List<Product> productList, String filePath) throws IOException {
        FileWriter fileWriter = new FileWriter(filePath);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String line = "PRODUCT_ID , PRODUCT_NAME , PRODUCT_MANUFACTURE_DATE , PRODUCT_EXPIRED_DATE , PRODUCT_QUANTITY , PRODUCT_DESCRIPTION  \n";
        for (Product p : productList) {
            line += p.getProductid() + ","
                    + p.getProductName() + ","
                    + p.getManufactureDate() + ","
                    + p.getExpireDate() + ","
                    + p.getQuantity() + ","
                    + p.getDescription() + "," + "\n";
        }
        bufferedWriter.write(line);
        bufferedWriter.close();
        fileWriter.close();
    }

}
