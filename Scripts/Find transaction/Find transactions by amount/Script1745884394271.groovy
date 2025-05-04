import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.beans.Customizer
import java.sql.Date
import java.text.SimpleDateFormat

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
CustomKeywords.'keywordContainer.HelperKeywords.navigateToFeature'(findTestObject('Object Repository/Find transaction/Find Transactions button'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Find transaction/Find transaction heading'), time)

//select the right acount id
CustomKeywords.'keywordContainer.HelperKeywords.selectAcountIdBeforeFindTransactions'(findTestObject('Object Repository/Find transaction/Find transaction_AccountID'))

//fetch the related test data
String fetchedAmount = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Find transaction", "Transfer amount", GlobalVariable.FirstRowNo)

String scnarioSuccessMessage = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Find transaction", "Account Created Success Message", GlobalVariable.FirstRowNo)


//verify the fetched data
if(fetchedAmount == null) {
	
	throw new RuntimeException("Failed to get test data from Excel")
	
}


//check test data if date format or normal string format
String finalAmount = CustomKeywords.'keywordContainer.HelperKeywords.checkDataIfDate'(fetchedAmount)


// Verify processed data
if (finalAmount == null) {
	
	throw new RuntimeException("Failed to process test data")
	
}


//enter test data in test field
WebUI.sendKeys(findTestObject('Object Repository/Find transaction/Find transaction button_findByAmount'), finalAmount)

//verify transaction result displayed successfully
CustomKeywords.'keywordContainer.HelperKeywords.validateTestCaseIsPassed'(findTestObject('Object Repository/Bill pay/Bill Payment_success message'), time, scnarioSuccessMessage)