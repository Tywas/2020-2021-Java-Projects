
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Book implements BookInterface {

	//attributes
	private String title;
	private String author;
	private String genere;
	private String filename;

	//constructor
	public Book(String title, String author) {
		this.title = title;
		this.author = author;
		genere = "";
		filename = "";
	}


	//get title method
//	@Override
	public String getTitle() {
		return title;
	}

	//set title method
//	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	//get author method
//	@Override
	public String getAuthor() {
		return author;
	}

	//set author method
//	@Override
	public void setAuthor(String author) {
		this.author = author;
	}

	//get genre method
//	@Override
	public String getGenre() {
		return genere;
	}

	//set genre method
//	@Override
	public void setGenre(String genere) {
		this.genere = genere;
	}

	//get file name method
//	@Override
	public String getFilename() {
		return filename;
	}

	//get genre method
//	@Override
	public void setFilename(String filename) {
		this.filename = filename;
	}

	//tostring method
//	@Override
	public String toString() {
		String ret = "Title: " + title + "\tAuthor: " + author + "\tGenere: " + genere + "\tFilename: " + filename;
		return ret;

	}


	//is valid method
//	@Override
	public boolean isValid() {
		boolean ret = false;
		if(title != null && author != null && genere != null && filename != null) {
			File file = new File(filename);
			if(file.exists() && file.isFile()) {
				ret = true;
			}
		}
		return ret;
	}

	//get text method
//	@Override
	public String getText() {
		File file = new File(filename);
		String text = "";
		if(file.exists() && file.isFile()) {
			try {
				Scanner linescanner = new Scanner(file);
				while(linescanner.hasNextLine()) {
					text += linescanner.nextLine() + "\n";

				}
				linescanner.close();
			}catch(FileNotFoundException e){
				System.out.println("file not found");
				e.printStackTrace();
			}
		
		}
		return text;
	}

}

