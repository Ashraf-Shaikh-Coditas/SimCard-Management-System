import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class UserService {

    public static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static ArrayList<User> users = new ArrayList<>();
    public static ArrayList<Long> numbers = new ArrayList<>();

    public static HashMap<Long,User> userHashMap = new HashMap<>();

    public void addUser() {
        User user = new User();
        try {
            System.out.println("Enter your Name : ");
            user.setName(bufferedReader.readLine());
            System.out.println("Enter your email : ");
            user.setEmail(bufferedReader.readLine());
            System.out.println("Enter your address : ");
            user.setAddress(bufferedReader.readLine());
            System.out.println("Enter your aadhar number : ");
            user.setAadharNo(Long.parseLong(bufferedReader.readLine()));
            System.out.println("Please choose your sim type : " +
                    "\n1.Prepaid" +
                    "\n2.PostPaid");
            int choice = Integer.parseInt(bufferedReader.readLine());
            if(choice==1) {
                user.setSimType("Prepaid");
            } else if(choice==2) {
                user.setSimType("PostPaid");
            }

            user.setSimNumber(randomSimNumberGenerator());
            numbers.add(user.getSimNumber());
            System.out.println("Enter Initial Balance : ");
            user.setBalance(Integer.parseInt(bufferedReader.readLine()));
            user.setValidity(1);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        users.add(user);
        userHashMap.put(user.getSimNumber(),user);
    }

    public long randomSimNumberGenerator() {
        return ThreadLocalRandom.current().nextLong(10,1000000000)*10;
    }

  public static void displayUsers() {
      Collections.sort(users,new SortByName());
      for(User u : users) {
          System.out.println(u);
      }
  }


}
