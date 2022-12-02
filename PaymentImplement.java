abstract class PaymentImplement {
    protected PaymentStrategy paymentStrategy;
    public void setPaymentStrategy(PaymentStrategy payment){
        paymentStrategy = payment;
    }
    public void performPayment(){
        paymentStrategy.pay();
    }
}
