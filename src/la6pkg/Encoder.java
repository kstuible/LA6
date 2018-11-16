package la6pkg;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;
import java.util.Scanner;

public class Encoder implements IEncoder {

	String text = "";
	Random rand = new Random();
	int randInt;
	
	@Override
	public void encode(String inputFileName, String outputFilePath) throws IOException {
		try {
			File file = new File(inputFileName);
			Scanner fileIn = new Scanner(file);
			while(fileIn.hasNextLine()) {
				text = text + fileIn.nextLine() + "\n";
			}
			//just testing with this
			//System.out.print(text);
			
			RandomAccessFile randFile = new RandomAccessFile(outputFilePath, "rw");
			
			for(int i = 0; i < text.length(); i++) {
				
				randFile.writeChar(text.charAt(i));
				randInt = rand.nextInt(20)+1;
				randFile.writeInt(randInt);
				randFile.write(randInt);
			}
			
			randFile.close();
			fileIn.close();
		} 
		catch(IOException e){
			System.out.println(e.getMessage());
		}
		
		
	}

}
