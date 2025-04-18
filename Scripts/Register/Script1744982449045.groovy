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
import org.openqa.selenium.Keys as Keys


if(WebUI) {
	
}
//load test data from the file
def testData = findTestData("Sign up")

//load values from the first row
def first_name = testData.getValue("First Name", 1)
def last_name = testData.getValue("Last Name", 1)
def adress = testData.getValue("Address", 1)
def city = testData.getValue("City", 1)
def state = testData.getValue("State", 1)
def zip_code = testData.getValue("Zip Code", 1)
def phone = testData.getValue("Phone", 1)
def ssn = testData.getValue("SSN", 1)
def user_name = testData.getValue("Username", 1)
def pass_word = testData.getValue("Password", 1)
def confirm_passWord = testData.getValue("Confirm", 1)


int time = 5


// pass each test data to each step
WebUI.click(findTestObject('Object Repository/Register/Register button'))

WebUI.waitForElementPresent(findTestObject('Object Repository/Register/Sign up heading'), time)

WebUI.sendKeys(findTestObject('Object Repository/Register/First name'), first_name)

WebUI.sendKeys(findTestObject('Object Repository/Register/Last name'), last_name)

WebUI.sendKeys(findTestObject('Object Repository/Register/Adress'), adress)

WebUI.sendKeys(findTestObject('Object Repository/Register/City'), city)

WebUI.sendKeys(findTestObject('Object Repository/Register/State'), state)

WebUI.sendKeys(findTestObject('Object Repository/Register/Zip code'), zip_code)

WebUI.sendKeys(findTestObject('Object Repository/Register/Phone'), phone)

WebUI.sendKeys(findTestObject('Object Repository/Register/SSN'), ssn)

WebUI.sendKeys(findTestObject('Object Repository/Register/UserName'), user_name)

WebUI.sendKeys(findTestObject('Object Repository/Register/Password'), pass_word)

WebUI.sendKeys(findTestObject('Object Repository/Register/ConfirmMail'), confirm_passWord)

WebUI.click(findTestObject('Object Repository/Register/Save register'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Register/Welcome message'), time)

WebUI.verifyElementPresent(findTestObject('Object Repository/Register/Welcome message'), time)