package file;

import object.Product;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class FileProductCSV {
    String filePath = "/Users/tranquanghuy/Desktop/CODEGYM-BaiTapNew/CaseStudy/src/file/Product.csv";
    public List<Product> readFileProduct(List<Product> productList) throws FileNotFoundException {
        try {
            FileReader fileReader = new FileReader(filePath);
            Scanner scanner = new Scanner(fileReader);
            productList.clear();
            if (scanner.nextLine() != null) {
                while (scanner.hasNext()) {
                    String a = scanner.nextLine();
                    String[] arr = a.split(",");
                    Product product = new Product(Integer.parseInt(arr[0]), arr[1], (arr[2]), (arr[3]), Integer.parseInt(arr[4]), arr[5]);
                    productList.add(product);
                }
            } else {
                throw new Exception();
            }
        } catch (Exception e) {

        }
        return productList;
    }

    public void writeFileProduct(List<Product> productList) throws IOException {
        FileWriter fileWriter = new FileWriter(filePath);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String line = "PRODUCTID , PRODUCTNAME , PRODUCTMANUFACTUREDATE , PRODUCTEXPIREDDATE , PRODUCTQUANTITY , PRODUCTDESCRIPTION  \n";
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
