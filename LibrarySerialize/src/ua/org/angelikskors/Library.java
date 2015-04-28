package ua.org.angelikskors;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Library {
	public static void main(String[] args) throws IOException {
		String filename = "time.ser";
		if (args.length > 0) {
			filename = args[0];
		}
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("������� ��� ������ ");

		String author = sc.readLine();
		if (author.matches("[a-zA-Z]+$") | author.matches("[�-��-�]+$")) {

			System.out.println("������� �������� ������������");
			String name = sc.readLine();
			if (name.matches("[a-zA-Z]+$") | name.matches("[�-��-�]+$")) {
				Scanner newCs = new Scanner(System.in);
				System.out.println("������� ��� ������� ");

				if (newCs.hasNextInt()) {

					ArrayList<LibraryList> list = new ArrayList<>();
					LibraryList first = new LibraryList("margaret", "master",
							1993);
					LibraryList second = new LibraryList("ragg", "msdsdaster",
							234);
					LibraryList third = new LibraryList("margfgsgaret",
							"sfgsgsg", 2342);
					list.add(first);
					list.add(second);
					list.add(third);
					FileOutputStream fos = null;
					ObjectOutputStream out = null;
					try {
						fos = new FileOutputStream(filename);
						out = new ObjectOutputStream(fos);
						out.writeObject(list);
						out.close();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
					System.out.println("������� ��� ������? ");
					if (sc.readLine().equals("��")) {
						for (LibraryList object : list) {
							System.out
									.println("______________________________");
							System.out.println("Author " + object.getAuthor());
							System.out.println("Name: " + object.getName());
							System.out.println("Year: " + object.getYear());
						}
					} else {
						System.out.println("Thanks for input");
					}

				} else {
					System.out.println("wrong input");
				}
			}
		}
	}
}