package products;

public class ProductRepository {
    private Product[] products = {
            new Coffee(1,"Americano", 3000, false),
            new Coffee(2,"Caffe Latte", 3500, false),
            new Tea(3,"Peppermint tea", 4000, false),
            new Tea(4,"Rooibos tea", 4500, false)
    };

    public Product[] getProducts() {
        return products;
    }

    public Product findByID(int id) {
        for(Product product: products) {
            if (id == product.getId()) return product;
        }
        return null;
    }
}
