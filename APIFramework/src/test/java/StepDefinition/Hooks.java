package StepDefinition;

import io.cucumber.java.Before;

public class Hooks {

	@Before     //when we are ruuning only delete api, since place id will not be available so this method need to be executed
	public void beforeScenrio() throws Throwable
	{
		MapsStepDefinition m= new MapsStepDefinition();
		if(MapsStepDefinition.place_id==null)
		m.the_body_for_addingPlace_with("Pooja", "Marati", "Belagavi");
		m.user_send_the_from_method("AddPlaceApi", "POST");
		m.verify_the_Placeid_created_maps_to_using("Pooja", "getPlaceAPI");
	}
	
}
