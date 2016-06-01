package com.paytm.bus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class PaytmHomePage {
	WebDriver driver;
	
	String homTitle=null;
	By loginLink=By.xpath("//a[@class='login']");
	By busTicketTab=By.xpath("//a[@href='/bus-tickets']");
	By mobileTab=By.xpath("//a[text()='Mobile']");
	By moviesTab=By.xpath("//a[text()='Movies']");
	By dthTab=By.xpath("//a[text()='DTH']");
	By electricityTab=By.xpath("//a[text()='Electricity']");
	By dataCardTab=By.xpath("//a[text()='DataCard']");
	By landLineTab=By.xpath("//a[text()='Landline']");
	By gasTab=By.xpath("//a[text()='Gas']");
	By educationTab=By.xpath("//a[text()='Education']");
	By insuranceTab=By.xpath("//a[text()='Insurance']");
	//By goldLoanTab=By.xpath("//a[text()='Mobile']");
	By metroTab=By.xpath("//a[text()='Metro']");
	By waterTab=By.xpath("//a[text()='Water']");
	By hotelsTab=By.xpath("//a[text()='Hotels']");
	By entertainmentTab=By.xpath("//a[text()='Entertainment']");
	By addMoneytoWalletTab=By.xpath("//a[text()='Add Money to Wallet']");
	
	
	public String getPageTitle(){
		return driver.getTitle();
	}
	
	public PaytmHomePage(WebDriver driver){
		this.driver=driver;
		homTitle=getPageTitle();
	}
	
	public void clickLoginLink(){
		driver.findElement(loginLink).click();
	}
	
	public void clickBusTicketTab(){
		driver.findElement(busTicketTab).click();
	}
	
	public void clickMobileTab(){
		driver.findElement(mobileTab).click();
	}
	
	public void clickMoviesTab(){
		driver.findElement(moviesTab).click();
	}
	
	public void clickDthTab(){
		driver.findElement(dthTab).click();
	}
	
	public void clickElectricityTab(){
		driver.findElement(electricityTab).click();
	}
	
	public void clickDataCardTab(){
		driver.findElement(dataCardTab).click();
	}
	
	public void clickLandLineTab(){
		driver.findElement(landLineTab).click();
	}
	
	public void clickGasTab(){
		driver.findElement(gasTab).click();
	}
	
	public void clickEducationTab(){
		driver.findElement(educationTab).click();
	}
	
	public void clickInsuranceTab(){
		driver.findElement(insuranceTab).click();
	}
	
	/*public void clickGoldLoanTab(){
		driver.findElement(goldLoanTab).click();
	}   */
	
	public void clickMetroTab(){
		driver.findElement(metroTab).click();
	}
	
	public void clickWaterTab(){
		driver.findElement(waterTab).click();
	}
	
	public void clickHotelsTab(){
		driver.findElement(hotelsTab).click();
	}
	
	public void clickEntertainmentTab(){
		driver.findElement(entertainmentTab).click();
	}
	
	public void clickAddMoneyToWalletTab(){
		driver.findElement(addMoneytoWalletTab).click();
	}

	

}
