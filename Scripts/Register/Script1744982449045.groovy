import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys
import org.testng.Assert
import org.testng.Assert as Keys

int time = 5

try {
	
	//navigate to the target screen & wait till screen header appear
	CustomKeywords.'keywordContainer.HelperKeywords.navigateToFeature'(findTestObject('Object Repository/Register/Register button'), findTestObject('Object Repository/Register/Sign up heading'), time)
	
	//fetch first name from test data sheet
	String firsName = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Sign up", "First Name", GlobalVariable.FirstRowNo)
	
	//fetch last name from test data sheet
	String lastName = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Sign up", "Last Name", GlobalVariable.FirstRowNo)
	
	//fetch address from test data sheet
	String address = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Sign up", "Address", GlobalVariable.FirstRowNo)
	
	//fetch city from test data sheet
	String City = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Sign up", "City", GlobalVariable.FirstRowNo)
	
	//fetch state from test data sheet
	String State = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Sign up", "State", GlobalVariable.FirstRowNo)
	
	//fetch zip_code from test data sheet
	String Zip_Code = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Sign up", "Zip Code", GlobalVariable.FirstRowNo)
	
	//fetch phone from test data sheet
	String phone = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Sign up", "Phone", GlobalVariable.FirstRowNo)
	
	//fetch ssn from test data sheet
	String ssn = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Sign up", "SSN", GlobalVariable.FirstRowNo)
	
	//fetch username from test data sheet
	String userName = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Sign up", "Username", GlobalVariable.FirstRowNo)
	
	//store username value in GlobalVariable "CreatedUseName"
	GlobalVariable.CreatedUseName = userName
	
	//fetch pass from test data sheet
	String pass = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Sign up", "Password", GlobalVariable.FirstRowNo)
	
	//store pass value in GlobalVariable "CreatedPassWord"
	GlobalVariable.CreatedPassWord = pass
	
	//fetch confirm pass from test data sheet
	String confirmPass = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Sign up", "Confirm", GlobalVariable.FirstRowNo)
	
	//fetch register success message from test data sheet
	String scenarioSuccessMessage = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Sign up", "Sign up_Success message", GlobalVariable.FirstRowNo)
	
	//insert first name in first name field
	WebUI.sendKeys(findTestObject('Object Repository/Register/First name'), firsName)
	
	//insert last name in last name field
	WebUI.sendKeys(findTestObject('Object Repository/Register/Last name'), lastName)
	
	//insert address in address field
	WebUI.sendKeys(findTestObject('Object Repository/Register/Adress'), address)
	
	//insert city in city field
	WebUI.sendKeys(findTestObject('Object Repository/Register/City'), City)
	
	//insert state in state field
	WebUI.sendKeys(findTestObject('Object Repository/Register/State'), State)
	
	//insert zip code in zip code field
	WebUI.sendKeys(findTestObject('Object Repository/Register/Zip code'), Zip_Code)
	
	//insert phone in phone field
	WebUI.sendKeys(findTestObject('Object Repository/Register/Phone'), phone)
	
	//insert ssn in ssn field
	WebUI.sendKeys(findTestObject('Object Repository/Register/SSN'), ssn)
	
	//insert username in username field
	WebUI.sendKeys(findTestObject('Object Repository/Register/UserName'), userName)
	
	//insert pass in pass field
	WebUI.sendKeys(findTestObject('Object Repository/Register/Password'), pass)
	
	//insert confirm pass in confirm pass field
	WebUI.sendKeys(findTestObject('Object Repository/Register/ConfirmPass'), confirmPass)
	
	//click on save register button
	WebUI.click(findTestObject('Object Repository/Register/Save register'))
	
	//validate that test case is passed
	CustomKeywords.'keywordContainer.HelperKeywords.validateTestCaseIsPassed'(findTestObject('Object Repository/Register/Welcome message'), time, scenarioSuccessMessage)
	
}catch(Exception e) {
	
// Log the failure message in the Katalon report with the exception details	
KeywordUtil.markFailed("Register scenario is failed: " + e.getMessage())

// Take a screenshot of the current browser state to help with debugging
WebUI.takeScreenshot()
		
}