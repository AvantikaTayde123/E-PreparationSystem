package E_preparationSystem;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;

public class Login {
	public static void main(String args[]) //main class of bank
		throws IOException
	{

		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		String username = "";
		String password ="";
        int ch;
		while (true) {
			System.out.println(
				"\n ->|| Welcome to E-Prepration ||<- \n");
			System.out.println("1)register Account");
			System.out.println("2)Login Account");

			try {
				System.out.print("\n Enter Input:"); 
				 ch = Integer.parseInt(sc.readLine());

				switch (ch) {
				case 1:
					try {
						System.out.print("Enter Unique UserName:");
						username = sc.readLine();
						System.out.print("Enter New Password:");
						password= sc.readLine();

						if (Login1.registration(username, password)) {
							System.out.println("MSG : Account Created Successfully!\n");
						}
						else {
							System.out.println("ERR : Account Creation Failed!\n");
						}
					}
					catch (Exception e) {
						System.out.println(" ERR : Enter Valid Data::Insertion Failed!\n");
					}
					break;

				case 2:
					try {
						System.out.print("Enter UserName:");
		                username = sc.readLine();
						System.out.print("Enter Password:");
						password = (sc.readLine());

						if (Login1.loginAccount(username, password)) {
							System.out.println("MSG : Logout Successfully!\n");
						}
						else {
							System.out.println(
								"ERR : login Failed!\n");
						}
					}
					catch (Exception e) {
						System.out.println(
							" ERR : Enter Valid Data::Login Failed!\n");
					}

					break;

				default:
					System.out.println("Invalid Entry!\n");
				}

				if (ch == 3) {
					System.out.println("Exited Successfully!\n\n Thank You :)");
					break;
				}
			}
			catch (Exception e) {
				System.out.println("Enter Valid Entry!");
			}
		}
		sc.close();
	}
}
