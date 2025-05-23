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
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable
import keywordContainer.HelperKeywords

import org.openqa.selenium.Keys as Keys

int time = 5

try{

	//navigate to target screen & wait till screen header appear
	CustomKeywords.'keywordContainer.HelperKeywords.navigateToFeature'(findTestObject('Object Repository/Update profile info/Update profile info button'),
		findTestObject('Object Repository/Register/Sign up heading'),
		time)
	
	//fetch test data from test data sheet & store it in a string
	String newFirsName = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Update profile info", "First Name", GlobalVariable.FirstRowNo)
	
	String newLastName = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Update profile info", "Last Name", GlobalVariable.FirstRowNo)
	
	String successMessage = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Update profile info", "Update info_success message", GlobalVariable.FirstRowNo)
	
	// Add only the fields you want to update
	Map<String, String> partialUpdate = [
		firstName: newFirsName,
		lastName: newLastName
	]
	
	CustomKeywords.'keywordContainer.HelperKeywords.updateProfileInfo'(partialUpdate)
	
	WebUI.click(findTestObject('Object Repository/Update profile info/Update info button'))
	
	CustomKeywords.'keywordContainer.HelperKeywords.validateTestCaseIsPassed'(findTestObject('Object Repository/Update profile info/Update info_success message'), time, scenarioSuccessMessage)

}catch(Exception e){

// Log the failure message in the Katalon report with the exception details
	KeywordUtil.markFailed("customer care scenario is failed: " + e.getMessage())

	// Take a screenshot of the current browser state to help with debugging
	WebUI.takeScreenshot()

}

