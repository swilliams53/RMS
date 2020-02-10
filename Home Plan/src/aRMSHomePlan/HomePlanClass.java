package aRMSHomePlan;


import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.*;


public class HomePlanClass {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\williamss\\Downloads\\Web Drivers\\chromedriver_win32\\chromedriver.exe");
		
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--start-maximized");
	    ChromeDriver driver = new ChromeDriver( options );
	    //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	    //Login using proper User to a Browser.
	    driver.get("https://qaint.aims2.us");
	    //driver.get("https://qa.aims2.us");
	   
	    driver.findElement(By.id("txtUsername")).clear();
	    driver.findElement (By.id("txtPassword")).clear();
	    
	    driver.findElement (By.id("txtUsername")).sendKeys("swilliams");
	    driver.findElement (By.id("txtPassword")).sendKeys("QA40)");
	    
	   WebElement Login=driver.findElement(By.id("btnLogin"));
	    
	   boolean loginValue=Login.isEnabled();
	    if (loginValue) {
		System.out.println("Login is available"); 
	    }   else
	    {
		    System.out.println("Login is not available");
	    }
	   	
	    Login.click();
	   
	    WebDriverWait wait = new WebDriverWait(driver, 10); // wait < 1 minute    
	    wait.until(ExpectedConditions.titleIs("Arizona Correctional Information System"));
	    
	    //Select Inmate Location 'Community Corrections'
	    WebElement inmateLocation=driver.findElement (By.id("ctl00_main_rblInmateLocation"));
	    boolean actualValue1=inmateLocation.isEnabled();
	    
	    if (actualValue1) {
	    	System.out.println("Inmate Location is available");
	    	System.out.println("Inmate Location is enabled");	    	
	    }   else
	    {
	    	System.out.println("Inmate Location is disabled.");
	    }
	    
	    Thread.sleep(4000);
	
	    //****************************************************************************************************
	    //Action Queue Search for Home Plan submit a New Home Plan.
	    //Select Action Category
	    WebElement actionCategory=driver.findElement (By.id("ctl00_main_ddlCategory"));
	    boolean actualValue2=actionCategory.isEnabled();
	    
	    	if (actualValue2) {
	    		System.out.println("Home screen is available");
	    		System.out.println("Category button is enabled"); 
	        }   else
	        {
	    	    System.out.println("Category button is disabled");
	        }
	    Select Action_dropdown=new Select(actionCategory);
	    Action_dropdown.selectByIndex(7);
	    System.out.println("Category 'Release' is selected for search");
	    Thread.sleep(5000);
	       
	    //****************************************************************************************************
	    //Select Action Type
	    WebElement actionType=driver.findElement(By.id("ctl00_main_ddlType"));
	    boolean typeValue = actionType.isEnabled();
	    
		if (typeValue) {
			System.out.println("Type button is enabled"); 
	    }   else
	    {
		    System.out.println("Type button is disabled");
	    }
	        
	    Select Type_dropdown=new Select(actionType);
	    Type_dropdown.selectByIndex(3);
	    
	    System.out.println("Type 'Home Plan' is selected for search");
	    Thread.sleep(2000);
	    
	    //*****************************************************************************************************
	    //Select Reason
	    WebElement actionReason=driver.findElement(By.id("ctl00_main_ddlActionReason"));    
	    boolean reasonValue = actionReason.isEnabled();
	    
	   	if (reasonValue) {
	   		System.out.println("Reason is enabled"); 
	       }   else
	       {
	   	    System.out.println("Reason is disabled");
	       }
	    
	    Select Reason_dropdown=new Select(actionReason);
	    Reason_dropdown.selectByIndex(6);
	    System.out.println("Reason 'Home Plan Submit' is selected for search");
	    
	    //*****************************************************************************************************
	    //Click Search
	    WebElement search=driver.findElement(By.id("ctl00_main_lbSearch"));
	    boolean searchValue=search.isEnabled();
	    if (searchValue) {
	    	System.out.println("Search is enabled"); 
	    }   else
	    {
		    System.out.println("Search is disabled");
	    }     
	    
	    search.isEnabled();
	    search.isDisplayed();
	    search.click();
	    System.out.println("Search is clicked successfully");
	    Thread.sleep(3000);
	    
	    //*****************************************************************************************************
	    //Expand Search Results (Total); 
	    WebElement expandTotal=driver.findElement(By.id("ctl00_main_gvResults_ctl02_btnDueTotal"));
	    boolean expandValue=expandTotal.isEnabled();
	    if (expandValue) {
	    	System.out.println("Total is enabled"); 
	    }   else
	    {
		    System.out.println("Total is disabled");
	    }   
	    
	    expandTotal.isEnabled();
	    expandTotal.isDisplayed();
	    expandTotal.click();
	    System.out.println("Action Queue Search Total is expanded"); 
	    Thread.sleep(5000);
	    
	    //*****************************************************************************************************
	    //Click Go on first record
	    WebElement goSubmit=driver.findElement(By.id("ctl00_main_gvResults_ctl02_gvItemResults_ctl02_hlGo"));
	    boolean goButton=goSubmit.isEnabled();
	    if (goButton) {
	    	System.out.println("Action Queue Go Button is enabled"); 
	    }   else
	    {
		    System.out.println("Action Queue Go Button is disabled");
	    }   
	    
	    goSubmit.isEnabled();
	    goSubmit.isDisplayed();
	    goSubmit.click();
	    System.out.println("Action Queue Go Button 'Submit a New Home Plan' is clicked"); 
	    Thread.sleep(8000);
		
	    driver.getWindowHandle();
	    String subWindowHandler = null;

	    Set<String> handles = driver.getWindowHandles(); // get all window handles
	    Iterator<String> iterator = handles.iterator();
	    while (iterator.hasNext()) {
	          subWindowHandler = iterator.next();
	    }
	    
	    driver.switchTo().window(subWindowHandler); 
	    // switch to pop-up window
	    // Now you are in the pop-up window, perform necessary actions here.
	    
	    WebDriverWait wait1 = new WebDriverWait(driver, 10); // wait < 1 minute
	    wait1.until(ExpectedConditions.titleIs("Arizona Correctional Information System")); 
	 
	    WebElement addHomePlan=driver.findElement(By.id("ctl00_main_lbtnAddHP"));
	    boolean addButton=addHomePlan.isEnabled();
	    if (addButton) {
	    	System.out.println("Add Home Plan Button is enabled"); 
	    }   else
	    {
		    System.out.println("Add Home Plan Button is disabled");
	    }   
	    
	    addHomePlan.isDisplayed();
	    addHomePlan.isSelected();
	    addHomePlan.click();  
	    Thread.sleep(12000);
	    
	    //*************************************************************************************************
	    //Entering Home Plan details
	    
	    //Sponsor Name
	    WebElement sponsorFirstName=driver.findElement(By.id("ctl00_main_txtFirstName")); 
	    
	    System.out.println("Add Home Plan Screen is displayed");
	    
	    sponsorFirstName.isDisplayed();
	    sponsorFirstName.isEnabled();
	    sponsorFirstName.click();
	    sponsorFirstName.sendKeys("John");
	    
	    WebElement sponsorLastName=driver.findElement(By.id("ctl00_main_txtLastName")); 
	    sponsorLastName.isDisplayed();
	    sponsorLastName.isEnabled();
	    sponsorLastName.click();
	    sponsorLastName.sendKeys("Doe");
	    
	    //Sponsor Relationship
	    WebElement relationship=driver.findElement(By.id("ctl00_main_ddlRelation"));
	    Select relationship_dropdown=new Select(relationship);
	    relationship_dropdown.selectByIndex(9);
	    System.out.println("Sponsor is added succussfully");
	    
	    //Address - Street Number
	    WebElement streenNumber=driver.findElement(By.id("ctl00_main_ucHPAddress_txtStreetNum"));
	    
	    streenNumber.isEnabled();
	    streenNumber.isDisplayed();
	    streenNumber.click();
	    streenNumber.sendKeys("100");
	    
	    //Address - Street Name
	    WebElement streetName=driver.findElement(By.id("ctl00_main_ucHPAddress_txtStreetName"));
	    
	    streetName.isEnabled();
	    streetName.isDisplayed();
	    streetName.click();
	    streetName.sendKeys("Main");
	    
	    //Address - Street Suffix
	    WebElement suffix=driver.findElement(By.id("ctl00_main_ucHPAddress_ddlStreetSuffix"));
	    Select suffix_dropdown=new Select(suffix);
	    suffix_dropdown.selectByIndex(4);
	    
	    //Address - City
	    WebElement city=driver.findElement(By.id("ctl00_main_ucHPAddress_ddlCity"));
	    Select city_dropdown=new Select(city);
	    city_dropdown.selectByIndex(1);
	    System.out.println("Home Plan Address is entered successfully");
	    Thread.sleep(7000);
	    
	    //Address - Save
	    WebElement saveBtn=driver.findElement(By.id("ctl00_main_lbtnAddressSave"));
	    saveBtn.isEnabled();
	    saveBtn.isDisplayed();
	    saveBtn.click();
	    Thread.sleep(7000);
	    System.out.println("Address is saved successfully");
	    
	    //Address - Submit
	    WebElement submitBtn=driver.findElement(By.id("ctl00_main_lbtnSubmit"));
	    submitBtn.isEnabled();
	    submitBtn.isDisplayed();
	    submitBtn.click();
	    Thread.sleep(16000);
	    System.out.println("Home Plan Address is submitted successfully");
		
		//*****************************************************************************************************
	    // Click on search field to enable browser page
	    long timeout = 0;
	    new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(By.id("ctl00_CrumbTrail1_rptCrumbs_ctl01_linkCrumb")));
	    
	    WebElement homeButton=driver.findElement(By.id("ctl00_CrumbTrail1_rptCrumbs_ctl01_linkCrumb"));
	    homeButton.isEnabled();
	    homeButton.isDisplayed();
	    homeButton.click();
	    
	    driver.findElement(By.id("ctl00_quickSearchToAppArea_txtAdcNumber")).isDisplayed();
	    driver.findElement(By.id("ctl00_quickSearchToAppArea_txtAdcNumber")).isEnabled();
	    driver.findElement(By.id("ctl00_quickSearchToAppArea_txtAdcNumber")).click();
	    Thread.sleep(3000);
	    
	    // Refresh browser
	    driver.findElement(By.id("ctl00_quickSearchToAppArea_txtAdcNumber")).sendKeys(Keys.F5);
	    Thread.sleep(3000);
	    
	    //Select Inmate Location 'Community Corrections'   
	    driver.findElementByXPath("//table[@id='ctl00_main_rblInmateLocation']/tbody/tr/td[2]/label/span").click();
	    
	    Thread.sleep(4000);
	    
	    /*********************************************************************************************
	     ***************** Automated Action Queue - Search Home Plan Assign CCO **********************   
	     *********************************************************************************************/   
	    //Action Queue Search for Home Plan assign CCO.
	    //Select Category
	    
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ctl00_main_ddlCategory")));
	    
	    WebElement category2=driver.findElement (By.id("ctl00_main_ddlCategory"));
	    boolean actualValue3=category2.isEnabled();
	    
	    	if (actualValue3) {
	    		System.out.println("Home screen is available");
	    		System.out.println("Category button is enabled"); 
	        }   else
	        {
	    	    System.out.println("Category button is disabled");
	        }
	    	
	    driver.findElement(By.id("ctl00_main_ddlCategory"));
	    Select Action_dropdown1=new Select(category2);
	    Action_dropdown1.selectByIndex(7);
	    System.out.println("Action Category 'Release' is selected for search");
	    Thread.sleep(3000);   
	    
	    //*****************************************************************************************************
	    //Select Action Type
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ctl00_main_ddlType")));
	    
	    WebElement type2=driver.findElement(By.id("ctl00_main_ddlType"));
	    boolean typeValue2 = type2.isEnabled();
	    
		if (typeValue2) {
			System.out.println("Type button is enabled"); 
	    }   else
	    {
		    System.out.println("Type button is disabled");
	    }
	        
	    Select Type_dropdown1=new Select(type2);
	    Type_dropdown1.selectByIndex(3);
	    System.out.println("Type 'Home Plan' is selected for search");
	    Thread.sleep(5000);   
	    
	    //*****************************************************************************************************
	    //Select Reason
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ctl00_main_ddlActionReason")));
	    
	    WebElement reason1=driver.findElement(By.id("ctl00_main_ddlActionReason"));    
	    boolean reasonValue1 = reason1.isEnabled();
	    
	   	if (reasonValue1) {
	   		System.out.println("Reason is enabled"); 
	       }   else
	       {
	   	    System.out.println("Reason is disabled");
	       }
	    
	    Select Reason_dropdown1=new Select(reason1);
	    Reason_dropdown1.selectByIndex(1);
	    System.out.println("Reason 'Assign CCO' is selected for search");
	    Thread.sleep(5000);   
	   
	    //*****************************************************************************************************
	    //Click Search
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ctl00_main_lbSearch")));
	    
	    WebElement searchADC=driver.findElement(By.id("ctl00_main_lbSearch"));
	    boolean searchValue1=searchADC.isEnabled();
	    if (searchValue1) {
	    	System.out.println("Search is enabled"); 
	    }   else
	    {
		    System.out.println("Search is disabled");
	    }   

	    searchADC.isEnabled();
	    searchADC.isDisplayed();
	    searchADC.click();
	    
	    Thread.sleep(10000);
	    System.out.println("Search is clicked successfully");
	    
	    //*****************************************************************************************************
	    //Expand Search Results for New Today
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ctl00_main_gvResults_ctl02_btnNewToday")));
	    
	    WebElement expandNew=driver.findElement(By.id("ctl00_main_gvResults_ctl02_btnNewToday"));
	    boolean expandValue1=expandNew.isEnabled();
	    if (expandValue1) {
	    	System.out.println("New Today is enabled"); 
	    }   else
	    {
		    System.out.println("New Today is disabled");
	    }   
	    
	    expandNew.isEnabled();
	    expandNew.isDisplayed();
	    expandNew.click();
	    System.out.println("Action Queue Search New Today is expanded"); 
	    Thread.sleep(5000);
	    
	    //*****************************************************************************************************
	    //Click Go on first record
	    
	    WebElement goSubmitCCO=driver.findElement(By.id("ctl00_main_gvResults_ctl02_gvItemResults_ctl02_hlGo"));
	    boolean goButton1=goSubmitCCO.isEnabled();
	    if (goButton1) {
	    	System.out.println("Action Queue Assign CCO Go Button is enabled"); 
	    }   else
	    {
		    System.out.println("Action Queue Assign CCO Go Button is disabled");
	    }   
	      
	    goSubmitCCO.isEnabled();
	    goSubmitCCO.isDisplayed();
	    goSubmitCCO.click();
	    System.out.println("Action Queue Go Button 'Assign CCO - Submit' is clicked"); 
	    Thread.sleep(8000);
	    
	    //*****************************************************************************************************
	    //Select CC Office 
	    
	    driver.getWindowHandle();
	    String subWindowHandler1 = null;

	    Set<String> handles1 = driver.getWindowHandles(); // get all window handles
	    Iterator<String> iterator1 = handles1.iterator();
	    while (iterator1.hasNext()) {
	          subWindowHandler1 = iterator1.next();
	    }
	    driver.switchTo().window(subWindowHandler1); 
	    // switch to pop-up or new window
	    // Now you are in the pop-up window, perform necessary actions here.
	    
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ctl00_main_ddlCCOOffice")));
	    
	    WebElement ccoffice=driver.findElement(By.id("ctl00_main_ddlCCOOffice"));
	    boolean ccofficeselect=ccoffice.isEnabled();
	    if (ccofficeselect) {
	    	System.out.println("Select CC Office is enabled"); 
	    }   else
	    {
		    System.out.println("Select CC Office is disabled");
	    }   
	    
	    //Select CCOffice_dropdown=new Select(ccoffice);
	    //CCOffice_dropdown.selectByIndex(3);
	    //System.out.println("CC Office is selected");
	    Thread.sleep (8000);
	    //*****************************************************************************************************
	    //Select CC Staff
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ctl00_main_ddlCCOStaff")));
	    WebElement ccstaff=driver.findElement(By.id("ctl00_main_ddlCCOStaff"));
	    boolean ccstaffselect=ccstaff.isEnabled();
	    if (ccstaffselect) {
	    	System.out.println("Select CC Staff is enabled"); 
	    }   else
	    {
		    System.out.println("Select CC Staff is disabled");
	    }   
	    
	    Select CCStaff_select=new Select(ccstaff);
	    CCStaff_select.selectByIndex(1);
	    System.out.println("CC Staff is selected");
	    Thread.sleep(4000);
	    
	    //*****************************************************************************************************
	    //Select Offender table Check box
	    
	    WebElement assignTable=driver.findElement(By.id("ctl00_main_gvOffNotAssigned"));
	    boolean offendertable=assignTable.isEnabled();
	    if (offendertable) {
	    	System.out.println("Select Offender Not Assigned Table is enabled");
	    }   else
	    {
	    	System.out.println("Select Offender Not Assigned Table is not enabled");
	    }
	    
	    
	    WebElement element=wait
	    		.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_main_gvOffNotAssigned")));
	    element.isDisplayed();
	    Thread.sleep(2000);
	    
	    driver.findElementByXPath("//table[@id='ctl00_main_gvOffNotAssigned']/tbody/tr[2]/td/div/label/span");
	    driver.findElementByXPath("//table[@id='ctl00_main_gvOffNotAssigned']/tbody/tr[2]/td/div/label/span").click();
	    Thread.sleep(5000);
	    {
	    
	    //*****************************************************************************************************
	    //Select Assign CCO Submit
	    
	    WebElement assignsubmit=driver.findElement(By.id("ctl00_main_lbAssign"));
	    boolean assign=assignsubmit.isEnabled();
	    if (assign) {
	    	System.out.println("Submit assignment is enabled");
	    }   else
	    {
	    	System.out.println("Submit assignment is not enabled");
	    }
	    
	    assignsubmit.isDisplayed();
	    assignsubmit.isEnabled();
	    assignsubmit.click();
	    
	    Thread.sleep(8000);
	    System.out.println("Submit CCO assignment is completed");
	    
	    //****************************************************************************************************
	    // Click on search field to enable browser page
	    // Go to home page
	    new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(By.id("ctl00_CrumbTrail1_rptCrumbs_ctl01_linkCrumb")));
	    driver.findElement(By.id("ctl00_CrumbTrail1_rptCrumbs_ctl01_linkCrumb")).click();
	    Thread.sleep(5000);
	    //*********************************************************************************************


	}
	

    //*********************************************************************************************
    // ***************** Automated Action Queue - Search Home Plan CCO Recommendation **************  
    // *********************************************************************************************   
    //Action Queue Search for Home Plan assign CCO.
    
	//Select Inmate Location 'Community Corrections'   
	driver.findElementByXPath("//table[@id='ctl00_main_rblInmateLocation']/tbody/tr/td[2]/label/span").click();
    Thread.sleep(2000);
    
	//Select Category
	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ctl00_main_ddlCategory")));
    
	WebElement category5=driver.findElement (By.id("ctl00_main_ddlCategory"));
    category5.isEnabled();
    
    	if (actualValue3) {
    		System.out.println("Home screen is available");
    		System.out.println("Category button is enabled"); 
        }   else
        {
    	    System.out.println("Category button is disabled");
        }
    	
    driver.findElement(By.id("ctl00_main_ddlCategory"));
    Select Action_dropdown4=new Select(category5);
    Action_dropdown4.selectByIndex(7);
    System.out.println("Action Category is selected for search");
    Thread.sleep(3000);   
    {
    
    //*****************************************************************************************************
    //Select Action Type

    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ctl00_main_ddlType")));
    
    WebElement type3=driver.findElement(By.id("ctl00_main_ddlType"));
    boolean typeValue3 = type3.isEnabled();
    
	if (typeValue3) {
		System.out.println("Type button is enabled"); 
    }   else
    {
	    System.out.println("Type button is disabled");
    }
       
    Select Type_dropdown3=new Select(type3);
    Type_dropdown3.selectByIndex(3);
    System.out.println("Type 'Home Plan' is selected for search");
    Thread.sleep(5000); 
 
    //*****************************************************************************************************
    //Select Reason
	
    WebElement reason3=driver.findElement(By.id("ctl00_main_ddlActionReason"));    
    boolean reasonValue3 = reason3.isEnabled();
    
   	if (reasonValue3) {
   		System.out.println("Reason is enabled"); 
       }   else
       {
   	    System.out.println("Reason is disabled");
       }
    
    Select Reason_dropdown3=new Select(reason3);
    Reason_dropdown3.selectByIndex(3);
    System.out.println("Reason 'CCO Recommendation' is selected for search");
    Thread.sleep(5000);
    
    //*****************************************************************************************************
    //Click Search
   
    WebElement searchADC3=driver.findElement(By.id("ctl00_main_lbSearch"));
    boolean searchValue3=searchADC3.isEnabled();
    if (searchValue3) {
    	System.out.println("Search is enabled"); 
    }   else
    {
	    System.out.println("Search is disabled");
    }   
   
    searchADC3.isEnabled();
    searchADC3.isDisplayed();
    searchADC3.click();
    System.out.println("Search is clicked successfully");
    Thread.sleep(5000);
    
    //*****************************************************************************************************
    //Expand Search Results
    
    WebElement expandNew2=driver.findElement(By.id("ctl00_main_gvResults_ctl02_btnNewToday"));
    boolean expandValue2=expandNew2.isEnabled();
    if (expandValue2) {
    	System.out.println("New Today is enabled"); 
    }   else
    {
	    System.out.println("New Today is disabled");
    }   
    
    expandNew2.isEnabled();
    expandNew2.isDisplayed();
    expandNew2.click();
    System.out.println("Action Queue Search New Today is expanded"); 
    Thread.sleep(5000);
     
    {
	
  }
     
    //*****************************************************************************************************
    //Click Go on first record
    
    WebElement goCCOApprove=driver.findElement(By.id("ctl00_main_gvResults_ctl02_gvItemResults_ctl02_hlGo"));
    boolean goButton2=goCCOApprove.isEnabled();
    if (goButton2) {
    	System.out.println("Action Queue Go Button is enabled"); 
    }   else
    {
	    System.out.println("Action Queue Go Button is disabled");
    }   
    
    goCCOApprove.isEnabled();
    goCCOApprove.isDisplayed();
    goCCOApprove.click();
    System.out.println("Action Queue Go Button 'CCO Recommendation - Submit' is clicked"); 
    Thread.sleep(18000);
  
   
	//***********************************************************************************************************
    // Home Plan CCO Recommendation Process
    // New Window
   
	driver.getWindowHandle();
    String subWindowHandler2 = null;

    Set<String> handles2 = driver.getWindowHandles(); // get all window handles
    Iterator<String> iterator2 = handles2.iterator();
    while (iterator2.hasNext()) {
          subWindowHandler2 = iterator2.next();
    }
    driver.switchTo().window(subWindowHandler2); 
    // switch to pop-up or new window
    // Now you are in the pop-up window, perform necessary actions here.    
    
    
    //***********************************************************************************************************
    // Load Consent File
    
    WebElement consentPlacement=driver.findElementByXPath("//div[@id='ctl00_main_pnlUpld']/div/div/div/span/label/span[2]");
    boolean consentPlace = consentPlacement.isEnabled();
    if (consentPlace) {
    	System.out.println("Consent to Placement Button is enabled"); 
    }   else
    {
	    System.out.println("Consent to Placement Radio is disabled");
    }   
       
    consentPlacement.isEnabled();
    consentPlacement.isDisplayed();
    //consentPlacement.click();
    Thread.sleep(3000);
    
    driver.getWindowHandle();
    String subWindowHandler3 = null;

    driver.getWindowHandles();
    handles1.iterator();
    while (iterator2.hasNext()) {
          subWindowHandler3 = iterator1.next();
    }
    driver.switchTo().window(subWindowHandler3); 
    // switch to pop-up or new window
    // Now you are in the pop-up window, perform necessary actions here.
    
    
    consentPlacement.sendKeys("C:\\Users\\williamss\\OneDrive\\documents\\consent to Placement.docx");  
    
    
    // Scroll down window command
    JavascriptExecutor jse = (JavascriptExecutor)driver;
    jse.executeScript("window.scrollBy(0,1150)","");
    Thread.holdsLock(2000);
    
    //Enter Sponsor First Name
    WebElement sponsorFirst = driver.findElement(By.id("ctl00_main_txtFirstNameRec"));
    boolean designeeFirst = sponsorFirst.isDisplayed();
    if (designeeFirst) {
    	System.out.println("Sponsor First Name field is enabled"); 
    } else
    {
    	System.out.println("Sponsor First Name field is disabled"); 
    }
    
    sponsorFirst.isDisplayed();
    sponsorFirst.click();
    sponsorFirst.sendKeys("Jerry");
    
    ////Enter Sponsor Last Name
    WebElement sponsorLast = driver.findElement(By.id("ctl00_main_txtLastNameRec"));
    boolean designeeLast = sponsorLast.isDisplayed();
    if (designeeLast) {
    	System.out.println("Sponsor Last Name field is enabled"); 
    } else
    {
    	System.out.println("Sponsor Last Name field is disabled"); 
    }
    
    sponsorLast.isDisplayed();
    sponsorLast.click();
    sponsorLast.sendKeys("West");
    Thread.sleep(3000);
    
    //Signature Pad Designee
    //Signature Pad is not available
    WebElement sponsorSigPad = driver.findElementByXPath("//div[@id='ctl00_main_ucSigDesignee_divSigPadAvail']/div/div/label");
    boolean sigpadNA = sponsorSigPad.isDisplayed();
    if (sigpadNA) {
    	System.out.println("Signature Pad 'Not Available' button is enabled"); 
    } else
    {
    	System.out.println("Signature Pad 'Not Available' is disabled"); 
    }
    
    //Click in Sponsor LName and tab to designee name fields  
    sponsorSigPad.isDisplayed();
    sponsorSigPad.isEnabled();
    sponsorSigPad.click();
    Thread.sleep(7000);
    
    //FName sponsor signature pad
    //Clicked sponsor FName field to get here
    WebElement sfNameSP = driver.findElement(By.id("ctl00_main_ucSigDesignee_tbFirstName"));
    sfNameSP.click();
    boolean sponsorFN=sfNameSP.isDisplayed();
    if (sponsorFN) {
    	System.out.println("Signature First Name is enabled");
    } else 	
    {
    	System.out.println("Signature Last Name availiable is disabled");
    }
    
    sfNameSP.isEnabled();
    sfNameSP.sendKeys("Jerry");
    sfNameSP.sendKeys(Keys.TAB);
    Thread.sleep(2000);
    
    //LName signature pad
    //Clicked to get to Last Name of sponsor
    WebElement slNameSP = driver.findElement(By.id("ctl00_main_ucSigDesignee_tbLastName"));
    slNameSP.click();
    boolean sponsorLN=slNameSP.isDisplayed();
    if (sponsorLN) {
    	System.out.println("Signature Last Name is enabled");
    } else 	
    {
    	System.out.println("Signature Last Name is disabled");
    }
    
    slNameSP.isEnabled();
    slNameSP.sendKeys("West");
    Thread.sleep(2000);
    
    //title
    //Clicked Tab to get to Title of sponsor
    WebElement sTitleSP = driver.findElement(By.id("ctl00_main_ucSigDesignee_tbTitle"));
    sTitleSP.click();
    boolean sponsorT=sTitleSP.isDisplayed();
    if (sponsorT) {
    	System.out.println("Signature Last Name is enabled");
    } else 	
    {
    	System.out.println("Signature Last Name is disabled");
    }
    
    sTitleSP.isEnabled();
    sTitleSP.sendKeys("Brother");
    Thread.sleep(3000);
    System.out.println("Sponsor Signature is completed");
    
    //CCO SigPad Not Available 
    driver.findElementByXPath("//div[@id='ctl00_main_ucSigCCO_divSigPadAvail']/div/div/label");
    driver.findElementByXPath("//div[@id='ctl00_main_ucSigCCO_divSigPadAvail']/div/div/label").isDisplayed();
    driver.findElementByXPath("//div[@id='ctl00_main_ucSigCCO_divSigPadAvail']/div/div/label").isEnabled();
    driver.findElementByXPath("//div[@id='ctl00_main_ucSigCCO_divSigPadAvail']/div/div/label").click();
    Thread.sleep(6000);
    //CC Same as User
    driver.findElementByXPath("//div[@id='ctl00_main_ucSigCCO_divSameAsUser']/label");
    driver.findElementByXPath("//div[@id='ctl00_main_ucSigCCO_divSameAsUser']/label").isDisplayed();
    driver.findElementByXPath("//div[@id='ctl00_main_ucSigCCO_divSameAsUser']/label").isEnabled();
    driver.findElementByXPath("//div[@id='ctl00_main_ucSigCCO_divSameAsUser']/label").click();
    Thread.sleep(6000);
    
  //Recommend radio button
    driver.findElementByXPath("//div[@id='ctl00_main_UpdatePanel7']/div/span/div/label");
    driver.findElementByXPath("//div[@id='ctl00_main_UpdatePanel7']/div/span/div/label").isEnabled();
    driver.findElementByXPath("//div[@id='ctl00_main_UpdatePanel7']/div/span/div/label").isDisplayed();
    driver.findElementByXPath("//div[@id='ctl00_main_UpdatePanel7']/div/span/div/label").click();
    Thread.sleep(3000);
    System.out.println("Recommend Radio Button is clicked");
    Thread.sleep(5000);
    
    //Click in Comments and add comment
    driver.findElement(By.id("ctl00_main_txtCCORComment"));
    driver.findElement(By.id("ctl00_main_txtCCORComment")).isEnabled();
    driver.findElement(By.id("ctl00_main_txtCCORComment")).isDisplayed();
    driver.findElement(By.id("ctl00_main_txtCCORComment")).click();
    driver.findElement(By.id("ctl00_main_txtCCORComment")).sendKeys("Recommend");
    System.out.println("Comment is added");
    Thread.sleep(3000);
 
    //Click on submit ctl00_main_lbCCORSubmit
    
    driver.findElement(By.id("ctl00_main_lbCCORSubmit"));
    driver.findElement(By.id("ctl00_main_lbCCORSubmit")).isEnabled();
    driver.findElement(By.id("ctl00_main_lbCCORSubmit")).isDisplayed();
    driver.findElement(By.id("ctl00_main_lbCCORSubmit")).click();
    System.out.println("CCO Recommendation is submitted");
    Thread.sleep(10000);
    
    
   
    }
  }
}


