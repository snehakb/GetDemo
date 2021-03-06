package Resources;

import java.util.ArrayList;
import java.util.List;

import PojoMaps.PojoLocationBody;
import PojoMaps.PojoMapsClass;

public class TestBuildData {
	
	public PojoMapsClass testData(String Name, String language, String Address)
	{
	
	PojoMapsClass m= new PojoMapsClass();
	
	m.setAccuracy("50");
	m.setAddress(Address);
	m.setLanguage(language);
	m.setName(Name);
	m.setPhone_number("99877767789");
	m.setWebsite("www.google.com");
	List<String> typelist= new ArrayList<String>();
	typelist.add("shoe park");
	typelist.add("shoe");
	m.setTypes(typelist);
	
	PojoLocationBody lb= new PojoLocationBody();
	lb.setLat(-38.897);
	lb.setLng(32.7865);
	
	m.setLocation(lb);
	return m;

}
	
	public String deletepayload(String placeID)
	{
		return "{\r\n    \"place_id\":\""+placeID+"\"\r\n}" ;
	}
}