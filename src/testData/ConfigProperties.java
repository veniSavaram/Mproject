package testData;

public class ConfigProperties {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		readProperties get = new readProperties();
		
		get.readData();
		String browserPath = readProperties.browserPath;
		String url = readProperties.appurl;
		String uname = readProperties.username;
		String password = readProperties.pwd;
		
		System.out.println(browserPath);
		System.out.println(url);
		System.out.println(uname);
		System.out.println(password);
		
   	}
}