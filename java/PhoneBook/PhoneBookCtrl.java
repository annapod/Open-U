import java.awt.event.*;

/**
 * Anna Podolny 322152893
 */

/**
 * @author apodolny
 *
 */

public class PhoneBookCtrl {

	private PhoneBookGUI _view;
	private PhoneBook _model;
	
	public PhoneBookCtrl(PhoneBookGUI view, PhoneBook model)
	{
		_view = view;
		_model = model;
		
		_view.displayText(_model.toString());
		//add listeners
		_view.addAddListener(new AddListener());
		_view.addRemoveListener(new RemoveListener());
		_view.addUpdateListener(new UpdateListener());
		_view.addFindListener(new FindListener());
		
	}
	
	class AddListener implements ActionListener {
		@Override
        public void actionPerformed(ActionEvent e) 
        {
            System.out.println("Button Add");
            //get user input
            String name = _view.showDialog("Please enter name:");
            String phone = _view.showDialog("Please enter phone:");
            if (PhoneBook.isNumeric(phone))
            {
            	 System.out.println(name+" "+phone);
                 //add record to map
                 _model.addRecord(name, phone);
                 //update view and file
                 _view.displayText(_model.toString());
            	
            }
            else
            {
            	_view.showError("Phone number must be numeric!");
            }
           
     
        }
	}
        
    class UpdateListener implements ActionListener {
    	@Override
        public void actionPerformed(ActionEvent e)
        {
            System.out.println("Button Update");
            String name = _view.showDialog("Please enter name:");
            if (!_model.isExists(name))
            {
            	_view.showError("No such person in the phone book!");
            	return;
            }
            String phone = _view.showDialog("Please enter phone:");
            if (PhoneBook.isNumeric(phone))
            {
            	 System.out.println(name+" "+phone);
                 //update record to map
                 _model.updateRecord(name, phone);
                 //update view and file
                 _view.displayText(_model.toString());
            	
            }
            else
            {
            	_view.showError("Phone number must be numeric!");
            }
        }
    }
    class RemoveListener implements ActionListener {
    	@Override
    	public void actionPerformed(ActionEvent e) 
        {
            System.out.println("Button Remove");
            String name = _view.showDialog("Please enter name:");
            if (!_model.isExists(name))
            {
            	_view.showError("No such person in the phone book!");
            	return;
            }
           System.out.println(name);
           //remove record from map
           _model.removeRecord(name);
           //update view and file
           _view.displayText(_model.toString());
            	
        
        } 
    }
    class FindListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
        	System.out.println("Button Find");
        	String name = _view.showDialog("Please enter name:");
            if (!_model.isExists(name))
            {
             	_view.showError("No such person in the phone book!");
               	return;
            }
            System.out.println(name);
            //show phone number
            _view.showInfo(_model.findRecord(name));
                	
            
        }    
    }
    
}
