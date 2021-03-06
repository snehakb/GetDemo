package Resources;

// enum is special class in java which has collections of constants and methods
public enum APIResources {    
	
	AddPlaceApi("/maps/api/place/add/json"),
	UpdatePlaceAPI("maps/api/place/update/json"),
	getPlaceAPI("maps/api/place/get/json"),
	DeletePlaceAPI("maps/api/place/delete/json");
	
	private String resource;

	APIResources(String resource) {
		this.resource=resource;
	}
	
	public String getResource()
	{
		return resource;
	}
	
	
	

}
