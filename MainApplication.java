import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainApplication {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        boolean flag = true ;

        while(flag) {
            System.out.println("\n0) Exit" +
                    "\n1) Prepaid User" +
                    "\n2) Add New Connection " +
                    "\n3) Show User" );

            int choice ;
            try {
                choice = Integer.parseInt(bufferedReader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            switch (choice) {
                case 0 :
                    flag = false;
                    break;
                case 1 :
                    new PrepaidUserService().prepaidUser();
                    break;
                case 2 :
                    new UserService().addUser();
                    break;
                case 3 :
                    UserService.displayUsers();
                    break;

            }
        }
    }
}
