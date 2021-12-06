import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Library implements LibraryInterface {

	
	//atributes
	private ArrayList<Book> books;
	
	//constructor
	public Library() {
		books = new ArrayList<Book>();
	}
	
	
	//methods
//	@Override// removing book method
	public void removeBook(int index) {
		if(index < books.size() && index >= 0) {
			books.remove(index);
		}
	}

//	@Override //copy books in new arary method
	public ArrayList<Book> getBooks() {
		ArrayList<Book> copyBooks = new ArrayList<Book>();
		copyBooks.addAll(books);
		return copyBooks;
	}

//	@Override // add book method
	public void addBook(Book newBook) {
		books.add(newBook);
	}

//	@Override //get book method
	public Book getBook(int index) {
		Book ret = null;
		if(index < books.size() && index >= 0) {
			ret = books.get(index);
		}
		return ret;
	}

	public String toString() {
		String ret = "";
		for(Book x : books) {
			ret += x.toString();
			
		}
		return ret;
	}


	// new method for project 4	
//	@Override
	public void loadLibraryFromCSV(String csvFilename) {
		File csvFile = new File(csvFilename);
		if(csvFile.exists() && csvFile.isFile()) {
			try {
				Scanner lineScanner = new Scanner(csvFile);
				while(lineScanner.hasNextLine()) {  //reading each part of the line to get the parameters of the book
					String currentLine = lineScanner.nextLine();
					Scanner tokenScanner = new Scanner(currentLine);
					tokenScanner.useDelimiter(",");
					String title = tokenScanner.next();
					String author = tokenScanner.next();
					String genre = tokenScanner.next();
					String filePatch = tokenScanner.next();	
					tokenScanner.close();
					Book newBook = new Book(title, author); 
					newBook.setGenre(genre);
					newBook.setFilename(filePatch);
					books.add(newBook); // adding book too library constructor
					
				}
				lineScanner.close();
			} catch (FileNotFoundException e){
				JOptionPane.showMessageDialog(null, "file not found");
				e.printStackTrace();
			}	
		}else {
			JOptionPane.showMessageDialog(null, "File not found");
		}
	}
}
