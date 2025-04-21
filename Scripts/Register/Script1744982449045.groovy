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

CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Sign up", "First Name", GlobalVariable.FirstRowNo)

WebUI.sendKeys(findTestObject('Object Repository/Register/First name'), GlobalVariable.test_Data)

CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Sign up", "Last Name", GlobalVariable.FirstRowNo)

WebUI.sendKeys(findTestObject('Object Repository/Register/Last name'), GlobalVariable.test_Data)

CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Sign up", "Address", GlobalVariable.FirstRowNo)

WebUI.sendKeys(findTestObject('Object Repository/Register/Adress'), GlobalVariable.test_Data)

CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Sign up", "City", GlobalVariable.FirstRowNo)

WebUI.sendKeys(findTestObject('Object Repository/Register/City'), GlobalVariable.test_Data)

CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Sign up", "State", GlobalVariable.FirstRowNo)

WebUI.sendKeys(findTestObject('Object Repository/Register/State'), GlobalVariable.test_Data)

CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Sign up", "Zip Code", GlobalVariable.FirstRowNo)

WebUI.sendKeys(findTestObject('Object Repository/Register/Zip code'), GlobalVariable.test_Data)

CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Sign up", "Phone", GlobalVariable.FirstRowNo)

WebUI.sendKeys(findTestObject('Object Repository/Register/Phone'), GlobalVariable.test_Data)

CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Sign up", "SSN", GlobalVariable.FirstRowNo)

WebUI.sendKeys(findTestObject('Object Repository/Register/SSN'), GlobalVariable.test_Data)

CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Sign up", "Username", GlobalVariable.FirstRowNo)

GlobalVariable.CreatedUseName = GlobalVariable.test_Data

WebUI.sendKeys(findTestObject('Object Repository/Register/UserName'), GlobalVariable.test_Data)

CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Sign up", "Password", GlobalVariable.FirstRowNo)

GlobalVariable.CreatedPassWord = GlobalVariable.test_Data

WebUI.sendKeys(findTestObject('Object Repository/Register/Password'), GlobalVariable.test_Data)

CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Sign up", "Confirm", GlobalVariable.FirstRowNo)

WebUI.sendKeys(findTestObject('Object Repository/Register/ConfirmPass'), GlobalVariable.test_Data)

WebUI.click(findTestObject('Object Repository/Register/Save register'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Register/Welcome message'), time)

WebUI.verifyElementPresent(findTestObject('Object Repository/Register/Welcome message'), time)

//WebUI.verifyElementText(findTestObject, confirm_passWord)

