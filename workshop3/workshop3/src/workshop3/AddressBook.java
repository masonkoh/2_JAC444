
// com.sun.javafx.css.parser.Css2Bin.main(Css2Bin.java:40)
//package workshop3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import java.io.*;

public class AddressBook extends Application {
	protected AddressBookPane pane = new AddressBookPane();
	final int NAME = 32; // data type int, or char, same result
	final int STREET = 32;
	final int CITY = 20;
	final int STATE = 2;
	final int ZIP = 5;
	// 32+32+20+2+5 = 91
	protected int count = 0;

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create and register handlers
		pane.btAdd.setOnAction(e -> add());
		pane.btFirst.setOnAction(e -> first());
		pane.btNext.setOnAction(e -> next());
		pane.btPrevious.setOnAction(e -> previous());
		pane.btLast.setOnAction(e -> last());
		pane.btUpdate.setOnAction(e -> update());

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 330, 150); // original: pane, 360, 130
		// primaryStage.setTitle("Exericse_17_09"); // Set the stage title
		primaryStage.setTitle("'WS3:AddressBook.java' by MK"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	// RandomAccessFile.length() : return file length
	// RandomAccessFile.seek(point position value) : set pointer position
	// RandomAccessFile.read(byte array) : from current pointer position, read in as
	// much as byte array length
	// RandomAccessFile.getFilePointer() : return current pointer position
	// RandomAccessFile.close() : file close

	/** Write an address to file */
	private void add() {
		try ( // Create a random access file
				RandomAccessFile inout = new RandomAccessFile("Address.dat", "rw");) { // one of "r", "rw", "rws",
																							// or "rwd"
			inout.seek(inout.length());
			write(inout);
			System.out.println("Adding address #1");
		} catch (FileNotFoundException ex) {
		} catch (IOException ex) {
		} catch (IndexOutOfBoundsException ex) {
		}
	}

	/** Read the first address from the file */
	private void first() {
		try ( // Create a random access file
				RandomAccessFile inout = new RandomAccessFile("Address.dat", "rw");) {
			if (inout.length() > 0) {
				inout.seek(0);
				read(inout);
				System.out.println("Reading address #1");
				count = 1;
			} else {
				System.out.println("Address is empty!");
			}
		} catch (IOException ex) {
		}
	}

	/** Read the next Address from the file */
	private void next() {
		try ( // Create a random access file
				RandomAccessFile inout = new RandomAccessFile("Address.dat", "rw");) {
			// 32+32+20+2+5 = 91
			if (count * 91 < inout.length()) {
				inout.seek(count * 91);
				read(inout);
				count++;
				System.out.println("Reading address #" + count);
			} else {
				System.out.println("End of file!");
			}
		} catch (IOException ex) {
		}
	}

	/** Read the previous Address from the file */
	private void previous() {
		try ( // Create a random access file
				RandomAccessFile inout = new RandomAccessFile("Address.dat", "rw");) {
			if (count > 1)
				count--;
			else
				count = 1;
			inout.seek((count * 91) - 91);
			read(inout);
			System.out.println("Reading address #" + count);
		} catch (IOException ex) {
		}
	}

	/** Read last address from file */
	private void last() {
		try ( // Create a random access file
				RandomAccessFile inout = new RandomAccessFile("Address.dat", "rw");) {
			count = ((int) inout.length() / 91);
//			System.out.println(count);  // trace of lab, talking to prof
			inout.seek((count * 91) - 91);
			read(inout);
			System.out.println("Reading address #" + count);
		} catch (IOException ex) {
		}
	}

	/** Edit and address in file */
	private void update() {
		try ( // Create a random access file
				RandomAccessFile inout = new RandomAccessFile("Address.dat", "rw");) {
			inout.seek(count * 91 - 91);
			write(inout);
		} catch (FileNotFoundException ex) {
		} catch (IOException ex) {
		}
	}

	// Notice the use of JTextField's getText method to retrieve the text currently
	// contained by the text field. The text returned by this method does not
	// include a newline character for the Enter key that fired the action event.
	/** Write addreass to file */
	private void write(RandomAccessFile inout) throws IOException {
		// about .getByte()
		// // Encodes this String into a sequence of bytes using theplatform's default
		// charset, storing the result into a new byte array.
		// The behavior of this method when this string cannot be encoded inthe default
		// charset is unspecified. The CharsetEncoder class should be used when more
		// controlover the encoding process is required.
		// Returns:The resultant byte array

		// about randomaccessfile.write()
		// The java.io.RandomAccessFile.write(byte[] b,int off,int len) method writes
		// len bytes from the specified byte array starting at offset off to this file.

		inout.write(fixedLength(pane.tfName.getText().getBytes(), NAME));
		inout.write(fixedLength(pane.tfStreet.getText().getBytes(), STREET));
		inout.write(fixedLength(pane.tfCity.getText().getBytes(), CITY));
		inout.write(fixedLength(pane.tfState.getText().getBytes(), STATE));
		inout.write(fixedLength(pane.tfZip.getText().getBytes(), ZIP));
		System.out.println("Address #" + count + " saved!");
	}

	// The .setText() method in JAVA is generally used to print the specified string
	// by replacing the already written or current content with the aforementioned
	// String.
	//
	// The .append() method, which is unique to the Text Area is used to add a
	// string to the end of the existing text and so on.

	/** Read address from file */
	private void read(RandomAccessFile inout) throws IOException {
		int pos;
		byte[] name = new byte[NAME];
		pos = inout.read(name);
		pane.tfName.setText(new String(name));

		byte[] street = new byte[STREET];
		pos += inout.read(street);
		pane.tfStreet.setText(new String(street));

		byte[] city = new byte[CITY];
		pos += inout.read(city);
		pane.tfCity.setText(new String(city));

		byte[] state = new byte[STATE];
		pos += inout.read(state);
		pane.tfState.setText(new String(state));

		byte[] zip = new byte[ZIP];
		pos += inout.read(zip);
		pane.tfZip.setText(new String(zip));
	}

	/** Return a byte[] of fixed-length */
	private byte[] fixedLength(byte[] x, int n) {
		byte[] b = new byte[n]; // get the length of NAME, or STREET, or etcetc
		for (int i = 0; i < x.length; i++) {
			b[i] = x[i];
		}
		return b;
	}
}