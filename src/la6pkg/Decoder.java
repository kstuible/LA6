package la6pkg;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Decoder implements IDecoder {

	String text = "";
	int pos = 0;
	int num = 0;
	
	/**
	 * Reads from the encoded file and prints the correct message to the console
	 * by indexing the pointer by 2 or 4 respectively.
	 * 
	 * @param encodedFileName   name of encoded file
	 */
	@Override
	public void decode(String encodedFileName) throws IOException{
		try {
			RandomAccessFile randy = new RandomAccessFile(encodedFileName, "rw");
			randy.seek(0);
		
			while(num != -1) {
				text += randy.readChar();
				pos += 2;
				num = randy.readInt();
				pos += 4;
				pos += num;
				randy.seek(pos);
			}
			randy.close();
			System.out.print(text);
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
