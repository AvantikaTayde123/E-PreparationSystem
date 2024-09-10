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
			System.out.println("\n ->|| Welcome to E-Prepration ||<- \n");
			System.out.println("Login Account");
					try {
						System.out.print("Enter UserName:");
		                username = sc.readLine();
						System.out.print("Enter Password:");
						password = (sc.readLine());

						if (Login1.loginAccount(username, password)) {
							System.out.println("MSG : Login Successfully!\n");
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
		}
	
	}

