import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * CS 121 Project 4: Reader of Books
 *
 * @author Tyler Bowes
 */
public class BookButton extends JButton {

	//Book instance
	private Book book;
	
	
	//constructor
	public BookButton(Book books, ActionListener action) {
		addActionListener(action);
		this.book = books;
		if(book.getTitle().length() > 20) {
			this.setText((String) book.getTitle().subSequence(0, 19));
		}else {
			this.setText(book.getTitle());
		}
		this.setToolTipText(book.getTitle().toString());
	}
	
	//getter method for book
	public Book getbook() {
		return book;
	}
	
	
	

}
