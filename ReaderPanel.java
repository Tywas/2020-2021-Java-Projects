import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
/**
 * CS 121 Project 4: Reader of Books
 *
 * @author Tyler Bowes
 */
public class ReaderPanel extends JPanel {

	//initilizaing 
	private JPanel infoPanel;
	private JLabel titleLabel = new JLabel("Title");
	private JLabel authorLabel = new JLabel("Author");
	private JTextArea BookTextArea = new JTextArea();
	private JScrollPane bookTextScrollPane;
	
	public ReaderPanel(){
		//create the general name of the panel
		this.setBorder(BorderFactory.createTitledBorder("ReaderPanel"));
		setLayout(new BorderLayout());

		//info panel
		infoPanel = new JPanel();
		infoPanel.setBorder(BorderFactory.createTitledBorder("InfoPanel"));
		infoPanel.add(titleLabel, BorderLayout.WEST);
		infoPanel.add(authorLabel, BorderLayout.EAST);
		add(infoPanel, BorderLayout.NORTH);
		
		//text panel
		bookTextScrollPane = new JScrollPane(BookTextArea);
		bookTextScrollPane.setBorder(BorderFactory.createTitledBorder("BookTextArea"));
		bookTextScrollPane.setPreferredSize(new Dimension(200, 300));
		
		add(bookTextScrollPane, BorderLayout.CENTER);

	}
	//method to load the information of the book
	public void loadBook(Book book) {

		authorLabel.setText(book.getAuthor());
		if(book.getTitle().length() > 20) {
			titleLabel.setText((String) book.getTitle().subSequence(0, 19));
		}else {
			titleLabel.setText(book.getTitle());
		}
		BookTextArea.setText(book.getText());
		revalidate();
	}
	
	
	
}
