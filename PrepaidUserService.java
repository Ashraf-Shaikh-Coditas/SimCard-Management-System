import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrepaidUserService {

    public static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


    public void prepaidUser() {

        User user = null;
        try {
            System.out.println("Enter your Mobile Number : ");
            long number = Long.parseLong(bufferedReader.readLine());
            try {
                if(!UserService.numbers.contains(number)) {
                    throw new UserDoesNotExist();
                } else {
                    user = UserService.userHashMap.get(number);
                }
            } catch (UserDoesNotExist e) {
                System.err.println(e.getMessage());
            }

            System.out.println("0) Balance and Validity " +
                    "\n1) Recharge" +
                    "\nSelect your choice : ");

            int choice = Integer.parseInt(bufferedReader.readLine());
            if(choice == 0) {
                System.out.println("Balance = "+user.getBalance()+"  :: Validity = "+ user.getValidity());
            } else {
                System.out.println("Enter amount for recharge :: ");
                int amount = Integer.parseInt(bufferedReader.readLine());
                if(amount <=0 ) {
                    throw new RechargeAmountTooLow();
                } else {
                    amount = amount + user.getBalance();
                    int validity = user.getValidity();
                    user.setBalance(amount);
                    user.setValidity(validity+1);
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
