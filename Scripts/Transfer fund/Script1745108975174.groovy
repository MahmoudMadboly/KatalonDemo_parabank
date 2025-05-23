import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import javax.xml.bind.annotation.XmlElementDecl.GLOBAL

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
import org.openqa.selenium.Keys as Keys

int time = 5


try{

	//step1: will enter to open transfer fund screen
	CustomKeywords.'keywordContainer.HelperKeywords.navigateToFeature'(findTestObject('Object Repository/Transfer fund/Transfer fund button'))
	
	//verify that i am in the right screen
	//WebUI.verifyElementPresent(findTestObject('Object Repository/Transfer fund/Transfer fund heading'), time)
	
	String transfer_Amount = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Transfer fund","Transfer amount" , GlobalVariable.FirstRowNo)
	
	String scenarioSuccessMessage = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Transfer fund","Transfer fund_success message" , GlobalVariable.FirstRowNo)
	
	//enter an amount to be transferred
	WebUI.sendKeys(findTestObject('Object Repository/Transfer fund/Fund amount'), transfer_Amount)
	
	//open from account list
	WebUI.click(findTestObject('Object Repository/Transfer fund/From account list'))
	 
	//select the first account
	WebUI.click(findTestObject('Object Repository/Transfer fund/Account option_1'))
	
	//open to account list
	WebUI.click(findTestObject('Object Repository/Transfer fund/To account list'))
	 
	//select the newly created account
	WebUI.click(findTestObject('Object Repository/Transfer fund/Account option_2'))
	
	//hit transfer button
	WebUI.click(findTestObject('Object Repository/Transfer fund/Transfer button'))
	
	//validate test case is passed
	CustomKeywords.'keywordContainer.HelperKeywords.validateTestCaseIsPassed'(findTestObject('Object Repository/Transfer fund/Transfer fund_Success message'), time, scenarioSuccessMessage)
	

}catch(Exception e){

// Log the failure message in the Katalon report with the exception details
	KeywordUtil.markFailed("customer care scenario is failed: " + e.getMessage())

	// Take a screenshot of the current browser state to help with debugging
	WebUI.takeScreenshot()

}

