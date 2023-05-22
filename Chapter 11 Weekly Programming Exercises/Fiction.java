public class Fiction extends Book {
    public Fiction(String title) {
        super(title);
        setPrice(price);
    }
    
    @Override
    public void setPrice(double price) {
        super.price = 24.99;
    }
}
