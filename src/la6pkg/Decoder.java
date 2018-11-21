package la6pkg;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Decoder implements IDecoder {

	String text = "";
	int pos = 0;
	int s = 0;
	
	/**
	 * Reads from the encoded file and prints the correct message to the console
	 * by indexing the pointer by 2 or 4 respectively.
	 * 
	 * @param encodedFileName   name of encoded file
	 */
	@Override
	public void decode(String encodedFileName) throws IOException{
		try {
			RandomAccessFile randy = new RandomAccessFile(encodedFileName, "r");
			randy.seek(0);
		
			while(s != 1) {
				text += randy.readChar();
				pos += 2;
				s = randy.readInt();
				s += 4;
				pos += s;
				randy.seek(pos);
			}randy.close();
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		System.out.print(text);
	}
}
