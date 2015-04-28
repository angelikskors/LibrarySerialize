package ua.org.angelikskors;

import java.awt.List;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

public class Library {
	public static void main(String[] args) throws IOException {
		ArrayList<LibraryList> list = new ArrayList<LibraryList>();
		String filename = "LibraryData.ser";
		if (args.length > 0) {
			filename = args[0];
		}
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("������� ��� ������ ");
		String line ;
		while ((line = sc.readLine())!= null){
			if(line.equals("��")){
				break;
			}else {
				String author = line;

				if (author.matches("[a-zA-Z]+$") | author.matches("[�-��-�]+$")) {

					System.out.println("������� �������� ������������");
					String name = sc.readLine();
					if (name.matches("[a-zA-Z]+$") | name.matches("[�-��-�]+$")) {
						Scanner newCs = new Scanner(System.in);
						System.out.println("������� ��� ������� ");

						if (newCs.hasNextInt()) {
							String year1 = newCs.nextLine();
							int year = Integer.parseInt(year1);
							LibraryList first = new LibraryList(name, author, year);

							list.add(first);
						}
					}
				}else {
					System.out.println("wrong input");
					break;
				}
			}
		}

		write(filename, list);

		read(filename);

		System.out.println("Thanks for input");

	}

	public static void write(String filename, ArrayList<LibraryList> list){
		ObjectOutputStream out = null;
		try {
			FileOutputStream fos = new FileOutputStream(filename, false);
			out = new ObjectOutputStream(fos);

			out.writeObject(list);
		} catch (IOException ex) {
			ex.printStackTrace();
		}finally {
			if(out!= null){
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void read(String filename){
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new BufferedInputStream(
					new FileInputStream(filename)));
			ArrayList<LibraryList> list = (ArrayList) in.readObject();
			print("����� �� �����", list);
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
		}
	}

	public static void additionalOption() throws IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<LibraryList> list;
		System.out.println("������� ��� ������? ");
		if (sc.readLine().equals("��")) {
			ObjectInputStream in = null;
			try {
				in = new ObjectInputStream(new BufferedInputStream(
						new FileInputStream("LibraryData.ser")));
				list = (ArrayList) in.readObject();
				print("����� �� �����", list);
			} catch (IOException ex) {
				ex.printStackTrace();
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				if (in != null)
					try {
						in.close();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
			}

		}

		else {
			System.out.println("Thanks for input");
		}

	}

	static void print(String title, ArrayList<LibraryList> list) {
		System.out.println(title);
		for (LibraryList object : list) {
			System.out.println("______________________________");
			System.out.println("Author " + object.getAuthor());
			System.out.println("Name: " + object.getName());
			System.out.println("Year: " + object.getYear());
		}
	}

}