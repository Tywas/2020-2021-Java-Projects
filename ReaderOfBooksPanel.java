import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

/**
 * CS 121 Project 4: Reader of Books
 *
 * @author Tyler Bowes
 */
public class ReaderOfBooksPanel extends JPanel {

	//inistating variables to connect it to the specified classes
	private LibraryPanel libraryPanel;
	private ReaderPanel readerPanel;

	
	public ReaderOfBooksPanel(){
		this.setPreferredSize(new Dimension(500, 400));	
		setLayout(new BorderLayout());
		
		//implementing LibraryPanel class
		libraryPanel = new LibraryPanel(new bookButtonListener());
		add(libraryPanel, BorderLayout.WEST);
		//implementing ReaderPanel class
		readerPanel = new ReaderPanel();
		add(readerPanel, BorderLayout.CENTER);
		

	}
	
	private class bookButtonListener implements ActionListener{

		@Override//method to see the button (book) that was pressed to load the book information
		public void actionPerformed(ActionEvent e) {
			BookButton book = (BookButton) e.getSource();
			readerPanel.loadBook(book.getbook());
			revalidate();

			System.out.println("clickedd");
		}
		 
	 }
	
	
}
