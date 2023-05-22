public class NonFiction extends Book {
    public NonFiction(String title) {
        super(title);
        setPrice(price);
    }
    
    @Override
    public void setPrice(double price) {
        super.price = 37.99;
    }
}
