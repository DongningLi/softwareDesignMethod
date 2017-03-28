
import java.io.IOException;

public class CustomInfoSystem {

	public boolean infoVerify(String customId) throws IOException {

		CustomAuth custom = new CustomAuth();

		//call for id authority which does NOT belong to this machine
		if (custom.authInfoFromDB(customId)) {
			
			return true;
		} else {

			return false;
		}

	}
}
