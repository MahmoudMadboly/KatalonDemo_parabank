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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

int time = 5

CustomKeywords.'keywordContainer.HelperKeywords.navigateToFeature'(findTestObject('Object Repository/Forgot login info/Forgot login info button'),
	 findTestObject('Object Repository/Forgot login info/Forgot login info heading'), 
	 time)



String firsName = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Update profile info", "First Name", GlobalVariable.SecondRowNo)

String lastName = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Update profile info", "Last Name", GlobalVariable.SecondRowNo)

String address = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Update profile info", "Address", GlobalVariable.SecondRowNo)

String city = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Update profile info", "City", GlobalVariable.SecondRowNo)

String state = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Update profile info", "State", GlobalVariable.SecondRowNo)

String zipCode = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Update profile info", "Zip Code", GlobalVariable.SecondRowNo)

String ssn = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Sign up", "SSN", GlobalVariable.FirstRowNo)

String scenarioSuccessMessage = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("", "", GlobalVariable)



WebUI.sendKeys(findTestObject('Object Repository/Register/First name'), firsName)

WebUI.sendKeys(findTestObject('Object Repository/Register/Last name'), lastName)

WebUI.sendKeys(findTestObject('Object Repository/Register/Adress'), address)

WebUI.sendKeys(findTestObject('Object Repository/Register/City'), city)

WebUI.sendKeys(findTestObject('Object Repository/Register/State'), state)

WebUI.sendKeys(findTestObject('Object Repository/Register/Zip code'), zipCode)

WebUI.sendKeys(findTestObject('Object Repository/Register/SSN'), ssn)


WebUI.click(findTestObject('Object Repository/Forgot login info/Find my login info button'))






