package Page_Objects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base_Page.Test_Base;

public class Doctors_Page extends Constructor {

	public Doctors_Page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy (xpath = "(//*[@class='c-filter__box u-pos-rel c-dropdown'])[2]")
	WebElement PatientStoriesBtn;
	
	@FindBy (xpath = "(//*[@class='c-dropdown__list__item'])[4]")
	WebElement patientStories20;

	@FindBy (xpath = "(//*[@class='c-filter__box u-pos-rel c-dropdown'])[3]")
	WebElement ExperienceBtn;
	
	@FindBy (xpath = "(//*[@class='c-dropdown__list__item'])[7]")
	WebElement experience10;
	
	@FindBy (xpath = "//*[@class='u-d-inlineblock u-color--white u-c-pointer']")
	WebElement FiltersBtn;
	
	@FindBy (xpath = "(//*[@class='u-c-pointer u-d-block c-filter__label'])[4]")
	WebElement Above500;
	
	@FindBy (xpath = "(//*[@class='u-c-pointer u-d-block c-filter__label'])[9]")
	WebElement availability;
	
	@FindBy (xpath = "//*[@class='c-sort-dropdown__selected c-dropdown__selected']")
	WebElement sortBtn;
	
	@FindBy (xpath = "(//*[@class='c-dropdown__list__item'])[12]")
	WebElement sorting;
	
	@FindBy (xpath = "//*[@class='u-xx-large-font u-bold']")
	WebElement Doctors;
	
	@FindBy (xpath = "//*[@class='doctor-name']")
	List<WebElement> DoctorName;
	
	@FindBy (xpath = "//*[@class='c-profile--qualification']")
	WebElement FullDetails;
	
	
	public void selectPatientStories() throws InterruptedException {
		
		System.out.println("Selecting Patient Stories");
		WebDriverWait myWait = new WebDriverWait(driver,Duration.ofSeconds(20));
		PatientStoriesBtn.click();
		myWait.until(ExpectedConditions.visibilityOf(patientStories20)).click();
		Thread.sleep(2000);	
	}
	
	public void selectExperience() throws InterruptedException {
		
		System.out.println("Selecting Experience");
		WebDriverWait myWait = new WebDriverWait(driver,Duration.ofSeconds(20));
		ExperienceBtn.click();
		myWait.until(ExpectedConditions.visibilityOf(experience10)).click();	
		Thread.sleep(2000);
	}
	
	public void selectFilters_1() throws InterruptedException {
		
		System.out.println("Appling Filters");
		WebDriverWait myWait = new WebDriverWait(driver,Duration.ofSeconds(20));
		FiltersBtn.click();
		myWait.until(ExpectedConditions.visibilityOf(Above500)).click();
		Thread.sleep(2000);
	}
	
	public void selectFilters_2() throws InterruptedException {
		
		WebDriverWait myWait = new WebDriverWait(driver,Duration.ofSeconds(20));
		FiltersBtn.click();
		myWait.until(ExpectedConditions.visibilityOf(availability)).click();
		Thread.sleep(2000);
	}
	
	public void sort() throws InterruptedException {
		
		System.out.println("Sorting");
		sortBtn.click();
		WebDriverWait myWait = new WebDriverWait(driver,Duration.ofSeconds(20));
		myWait.until(ExpectedConditions.visibilityOf(sorting)).click();
		Thread.sleep(3000);
		
		System.out.println("--------------------");
		String DoctorsNum = Doctors.getText();
		System.out.println(DoctorsNum);
		Test_Base.addData(DoctorsNum);
		System.out.println("--------------------");
		Test_Base.addData("         ");
		}
	
	public void getDoctorDetails() throws InterruptedException {
		
		for (int i=0; i<5; i++) {
			JavascriptExecutor js= (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,295)", "");
			Thread.sleep(2000);
			
			String Doctor_Name = DoctorName.get(i).getText();
			System.out.println(Doctor_Name);
			Test_Base.addData(Doctor_Name);
			WebElement reqDoc = DoctorName.get(i);
			js.executeScript("arguments[0].click();", reqDoc);
			Set<String> WindowId = driver.getWindowHandles();
			List<String> winid = new ArrayList<String>(WindowId);
			String ParentWinId = winid.get(0);
			String ChildWinId = winid.get(1);
			driver.switchTo().window(ChildWinId);
			WebDriverWait myWait = new WebDriverWait(driver,Duration.ofSeconds(20));
			String reqDocDetails = myWait.until(ExpectedConditions.visibilityOf(FullDetails)).getText();
			System.out.println(reqDocDetails);
			Test_Base.addData(reqDocDetails);
			System.out.println("--------------------");
			driver.close();
			driver.switchTo().window(ParentWinId);
		}
	}
}
