package dev.foursix.test.uncategorized;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileAppendTest {
	
	public FileAppendTest() {
		try {
			for (int i = 0; i < 5; i++) { 
				File file = new File("./append.txt");
				FileWriter fileWriter = new FileWriter(file, true);
			
				fileWriter.write("banana ");
				fileWriter.write("banana ");
								
				fileWriter.close();
			}
		} catch (IOException e) {
			// cause by FileWriter(), write(), close()
			e.printStackTrace();
		}
	}

}
