import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * CS 121 Project 4: Reader of Books
 *
 * 
 * @author BSU CS 121 Instructors
 * @author Tyler Bowes
 */
public class ReaderOfBooks extends JPanel {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Reader Of Books");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ReaderOfBooksPanel panel = new ReaderOfBooksPanel();
		frame.getContentPane().add(panel);
		
		frame.pack();
		frame.setVisible(true);
	}

}
