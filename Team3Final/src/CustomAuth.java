
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*
 * mimic system does NOT belong to this machine
 * compare customId with file 'infoDatabase.txt'
 * see if id is authorized
 */

public class CustomAuth {

	public boolean authInfoFromDB(String Id) throws IOException {

		File file = new File("infoDatabase.txt");
		FileReader fileReader = new FileReader(file);
		BufferedReader br = new BufferedReader(fileReader);

		String line = null;
		while ((line = br.readLine()) != null) {
			if (line.equals(Id)) {
				return true;
			}
		}

		br.close();

		return false;
	}
}
