package facebook;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class FacebookJUnitExample extends FacebookBaseTest{
	
	@Test
	@FileParameters("./data/params.csv")//Documento con los parámetros para mi prueba
	public void testFacebookLogin(String browser, String url,
			String user, String password, String friendName, String nameTag, String nameFaile) {
		
		setUp(browser, url);
		
		logIntoFacebook(user, password);
		
		searchFacebookFriend(friendName);
		
		gotoPhotos();
		
	    valitedTag(nameTag);
		
	    valitedTagFaile(nameFaile);
	}

}
