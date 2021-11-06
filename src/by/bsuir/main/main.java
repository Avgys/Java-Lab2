package by.bsuir.main;

import by.bsuir.dao.DAOProduct;
import by.bsuir.entity.Kettle;
import by.bsuir.entity.Product;

import java.util.ArrayList;

public class main {

    public static class FindKettles implements DAOProduct.CriteriaFunc {
        private ArrayList<Kettle> prList = new ArrayList<Kettle>();

        @Override
        public void ProcessProduct(Product product){
            if(product.GetType() == Product.Types.Kettle)
            {
                prList.add((Kettle) product);
            }
        }

        public ArrayList<Kettle> GetResult(){
            return prList;
        }
    }

    public static class FindLowestPrice implements DAOProduct.CriteriaFunc {
        private int lowestPrice = -1;
        private Product result;

        @Override
        public void ProcessProduct(Product product){
            if(result == null){
                result = product;
                return;
            }

            if(result.GetPrice() > product.GetPrice()){
                result = product;
            }
        }

        public Product GetResult(){
            return result;
        }
    }

    public static void main(String[] args) {
        DAOProduct DAOproduct = new DAOProduct("products.xml");
        var cr1 = new FindKettles();
        var cr2 = new FindLowestPrice();
        DAOproduct.FindProducts(cr1);
        DAOproduct.FindProducts(cr2);
        var result1 = cr1.GetResult();

        var result2 = cr2.GetResult();
    }
}
