/**
 * Anna Podolny 322152893
 */

/**
 * @author apodolny
 *
 */
/**Implementation of MVC model for phone book**/
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		PhoneBookGUI gui = new PhoneBookGUI();
		PhoneBook engine = new PhoneBook();
		PhoneBookCtrl ctrl = new PhoneBookCtrl(gui,engine);
		

	}

}
