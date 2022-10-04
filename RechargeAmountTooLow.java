public class RechargeAmountTooLow extends RuntimeException {
    public RechargeAmountTooLow() {
        System.err.println("Recharge amount low...");
    }

    public RechargeAmountTooLow(String message) {
        System.err.println("Recharge amount low..."+message);
    }
}
