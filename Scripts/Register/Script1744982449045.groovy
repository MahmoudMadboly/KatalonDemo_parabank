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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys
import org.testng.Assert
import org.testng.Assert as Keys

int time = 5


CustomKeywords.'keywordContainer.HelperKeywords.navigateToFeature'(findTestObject('Object Repository/Register/Register button'))

WebUI.waitForElementPresent(findTestObject('Object Repository/Register/Sign up heading'), time)

String firsName = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Sign up", "First Name", GlobalVariable.FirstRowNo)

String lastName = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Sign up", "Last Name", GlobalVariable.FirstRowNo)

String address = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Sign up", "Address", GlobalVariable.FirstRowNo)

String City = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Sign up", "City", GlobalVariable.FirstRowNo)

String State = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Sign up", "State", GlobalVariable.FirstRowNo)

String Zip_Code = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Sign up", "Zip Code", GlobalVariable.FirstRowNo)

String phone = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Sign up", "Phone", GlobalVariable.FirstRowNo)

String ssn = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Sign up", "SSN", GlobalVariable.FirstRowNo)

String userName = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Sign up", "Username", GlobalVariable.FirstRowNo)

GlobalVariable.CreatedUseName = userName

String pass = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Sign up", "Password", GlobalVariable.FirstRowNo)

GlobalVariable.CreatedPassWord = pass

String confirmPass = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Sign up", "Confirm", GlobalVariable.FirstRowNo)

String scenarioSuccessMessage = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Sign up", "Sign up_Success message", GlobalVariable.FirstRowNo)


WebUI.sendKeys(findTestObject('Object Repository/Register/First name'), firsName)

WebUI.sendKeys(findTestObject('Object Repository/Register/Last name'), lastName)

WebUI.sendKeys(findTestObject('Object Repository/Register/Adress'), address)

WebUI.sendKeys(findTestObject('Object Repository/Register/City'), City)

WebUI.sendKeys(findTestObject('Object Repository/Register/State'), State)

WebUI.sendKeys(findTestObject('Object Repository/Register/Zip code'), Zip_Code)

WebUI.sendKeys(findTestObject('Object Repository/Register/Phone'), phone)

WebUI.sendKeys(findTestObject('Object Repository/Register/SSN'), ssn)

WebUI.sendKeys(findTestObject('Object Repository/Register/UserName'), userName)

WebUI.sendKeys(findTestObject('Object Repository/Register/Password'), pass)

WebUI.sendKeys(findTestObject('Object Repository/Register/ConfirmPass'), confirmPass)

WebUI.click(findTestObject('Object Repository/Register/Save register'))

CustomKeywords.'keywordContainer.HelperKeywords.validateTestCaseIsPassed'(findTestObject('Object Repository/Register/Welcome message'), time, scenarioSuccessMessage)