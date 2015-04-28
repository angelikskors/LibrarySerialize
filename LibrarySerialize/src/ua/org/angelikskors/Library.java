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
		ArrayList<LibraryList> list;
		String filename = "LibraryData.ser";
		if (args.length > 0) {
			filename = args[0];
		}
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Введите имя автора ");
		String author = sc.readLine();
		if (author.matches("[a-zA-Z]+$") | author.matches("[а-яА-Я]+$")) {

			System.out.println("Введите название произведения");
			String name = sc.readLine();
			if (name.matches("[a-zA-Z]+$") | name.matches("[а-яА-Я]+$")) {
				Scanner newCs = new Scanner(System.in);
				System.out.println("Введите год выпуска ");

				if (newCs.hasNextInt()) {
					String year1 = newCs.nextLine();
					int year = Integer.parseInt(year1);
					list = new ArrayList<>();
					LibraryList first = new LibraryList(name, author, year);

					list.add(first);

					FileOutputStream fos = null;
					ObjectOutputStream out = null;
					try {
						fos = new FileOutputStream(filename, true);
						out = new ObjectOutputStream(fos);

						out.writeObject(list);
						out.close();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}
			}
		} else {
			System.out.println("wrong input");
		}
		additionalOption();

	}

	public static void additionalOption() throws IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<LibraryList> list;
		System.out.println("Вывести все данные? ");
		if (sc.readLine().equals("да")) {
			ObjectInputStream in = null;
			try {
				in = new ObjectInputStream(new BufferedInputStream(
						new FileInputStream("LibraryData.ser")));
				list = (ArrayList) in.readObject();
				print("Взято из файла", list);
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