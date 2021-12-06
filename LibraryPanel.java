import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 * CS 121 Project 4: Reader of Books
 *
 * @author Tyler Bowes
 */
public class LibraryPanel extends JPanel {

	//instance variables
	private Library library;
	private JPanel bookListPanel;
	private JScrollPane bookListScrollPane;
	private ActionListener bookButtonListener;
	private JPanel importPanel;
	private JTextField importTextField;
	private JButton importButton;
	
	

	//class for LibraryPanel
	public LibraryPanel(ActionListener actionlistener) {
		//naming general panel on outside
		this.setBorder(BorderFactory.createTitledBorder("LibraryPanel"));
		setLayout(new BorderLayout());
		
		bookButtonListener = actionlistener;
		library = new Library();
		
		//book list panel
		bookListPanel = new JPanel();
		bookListPanel.setLayout(new BoxLayout(bookListPanel, BoxLayout.Y_AXIS));
		
		//scroll pane
		bookListScrollPane = new JScrollPane(bookListPanel);
		bookListScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		bookListScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		bookListScrollPane.setBorder(BorderFactory.createTitledBorder("BookListScrollPane"));
		bookListScrollPane.setPreferredSize(new Dimension(20, 300));
		add(bookListScrollPane, BorderLayout.NORTH);
		
		//Load Library Panel
		importPanel = new JPanel();
		importPanel.setBorder(BorderFactory.createTitledBorder("LibraryPanel"));
		add(importPanel, BorderLayout.SOUTH);
		
		//text and button for load library panel
		importTextField = new JTextField(15);
		importPanel.add(importTextField, BorderLayout.WEST);
		importButton = new JButton("LOAD");
		importPanel.add(importButton, BorderLayout.CENTER);
		importButton.addActionListener(new ImportActionListener());
		
		
		
		
		
		
	}
	
	//actionlistener to see text area to load the books
	private class ImportActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String input = importTextField.getText();
			library.loadLibraryFromCSV(input);
			System.out.println("clicked");

			for(int i = 0 ; i < library.getBooks().size() ; i++) {
				importButton = new BookButton(library.getBook(i), bookButtonListener);
				bookListPanel.add(importButton, BorderLayout.LINE_START);
				revalidate();
			}
		}
		
	}
		

	
}
