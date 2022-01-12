
public class MutableAndImmutable {

	public static void main(String[] args) {
		
		
		
		String unEditableUrl = "https://ya.ru";
		
		StringBuilder editableUrl = new StringBuilder("google.com");
		
		
		changeUrl(unEditableUrl, editableUrl);
		
		
		System.out.println("editable object/ immutable :" + editableUrl);
		System.out.println("non-editable object/ mutable : " + unEditableUrl);

	}

	private static void changeUrl(String unEditableUrl, StringBuilder editableUrl) {
		unEditableUrl += "/123";
		editableUrl.append("/123");
	}
	
	
	//System.out.print:
	//				editable object/ immutable :google.com/123
	//				non-editable object/ mutable : https://ya.ru

}
