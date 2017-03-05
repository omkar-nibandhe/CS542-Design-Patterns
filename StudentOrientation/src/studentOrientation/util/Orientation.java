package studentOrientation.util;

import businessLogic.BookStoreInterface;
import businessLogic.BusRide;
import businessLogic.CampusTourInterface;
import businessLogic.DormOffline;
import businessLogic.DormsInterface;
import businessLogic.DormsOnlineGame;
import businessLogic.MandoBooks;
import businessLogic.OnFoot;
import businessLogic.RegistrationInterface;
import businessLogic.RegistrationOffice;
import businessLogic.RegistrationSelf;
import businessLogic.UniversityBookStore;
import businessLogic.dataStore;
import studentOrientation.driver.Driver.ParamNames;
import studentOrientation.store.abstractOrientation;


public class Orientation extends abstractOrientation{

	private dataStore finalValue;
	private CampusTourInterface myTour = null;
	private BookStoreInterface myBookStore = null;
	private DormsInterface myDorm = null;
	private RegistrationInterface myRegistration = null;
	
	public Orientation(ParamNames campusTour, ParamNames bookStore, ParamNames dorm,
			ParamNames registeration) {
		// TODO Auto-generated constructor stub
		if(campusTour == ParamNames.BUSRIDE){
			myTour = new BusRide();
		}else{
			myTour = new OnFoot();
		}
		if(bookStore == ParamNames.UNIVERSITYBOOKSTORE){
			myBookStore = new UniversityBookStore();
		}else{
			myBookStore = new MandoBooks();
		}
		if(dorm == ParamNames.DORMOFFLINE){
			myDorm = new DormOffline();
		}else{
			myDorm = new DormsOnlineGame();
		}
		if(registeration == ParamNames.REGISTERATIONSELF){
			myRegistration = new RegistrationSelf();
		}else{
			myRegistration = new RegistrationOffice();
		}
		if( myTour == null || myBookStore == null || myDorm == null || myRegistration == null){
			//Report error to logger.
			System.out.println("Error Creating concrete class.");
			System.exit(1);
		}
		finalValue = new dataStore();
	}

	@Override
	public void buildBookStore() {
		// TODO Auto-generated method stub
		finalValue.calorieCount += myBookStore.getCalorieCount();
		finalValue.CO2 += myBookStore.getCarbonCount();
		finalValue.Cost += myBookStore.getCost();
		finalValue.duration += myBookStore.getDuration();
	
	}

	@Override
	public void buildDorms() {
		// TODO Auto-generated method stub
		finalValue.calorieCount += myDorm.getCalorieCount();
		finalValue.CO2 += myDorm.getCarbonCount();
		finalValue.Cost += myDorm.getCost();
		finalValue.duration += myDorm.getDuration();
	}

	@Override
	public void buildCampusTour() {
		// TODO Auto-generated method stub
		finalValue.calorieCount += myTour.getCalorieCount();
		finalValue.CO2 += myTour.getCarbonCount();
		finalValue.Cost += myTour.getCost();
		finalValue.duration += myTour.getDuration();
	}

	@Override
	public void buildRegistration() {
		// TODO Auto-generated method stub
		finalValue.calorieCount += myRegistration.getCalorieCount();
		finalValue.CO2 += myRegistration.getCarbonCount();
		finalValue.Cost += myRegistration.getCost();
		finalValue.duration += myRegistration.getDuration();
	}

	@Override
	public void displayResult(){
		System.out.println("Choices : "+myTour.getClass()+"\n"+myBookStore.getClass()+"\n"+myDorm.getClass()+"\n"+myRegistration.getClass());
		System.out.println("CalorieCount : "+finalValue.calorieCount);
		System.out.println("CO2 : "+finalValue.CO2);
		System.out.println("Cost : "+finalValue.Cost);
		System.out.println("Duration : "+finalValue.duration);
	}

}
