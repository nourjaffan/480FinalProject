package Payment;

public abstract class PaymentImplement {
    protected PaymentStrategy paymentStrategy;
    public void setPaymentStrategy(PaymentStrategy payment){
        paymentStrategy = payment;
    }
    public int performPayment(){
        return paymentStrategy.pay();
    }
}
