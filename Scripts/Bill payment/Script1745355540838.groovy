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
import org.openqa.selenium.Keys as Keys


int time = 5

try {

	//navigate to the target screen & wait till screen header appear
	CustomKeywords.'keywordContainer.HelperKeywords.navigateToFeature'(findTestObject('Object Repository/Bill pay/Bill pay button'),
			findTestObject('Object Repository/Bill pay/Bill Payment Service heading'),
			time)

	//get test data from test sheet
	String payee_Name = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Pay bill", "Payee Name", GlobalVariable.FirstRowNo)

	String address = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Pay bill", "Address", GlobalVariable.FirstRowNo)

	String city = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Pay bill", "City", GlobalVariable.FirstRowNo)

	String state = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Pay bill", "State", GlobalVariable.FirstRowNo)

	String zip_Code = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Pay bill", "Zip Code", GlobalVariable.FirstRowNo)

	String phone = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Pay bill", "Phone", GlobalVariable.FirstRowNo)

	String account = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Pay bill", "Account", GlobalVariable.FirstRowNo)

	String verify_Account = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Pay bill", "Verify Account", GlobalVariable.FirstRowNo)

	String amount = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Pay bill", "Amount", GlobalVariable.FirstRowNo)

	String PayBillSuccessMeaage = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Pay bill", "Sucees Message", GlobalVariable.FirstRowNo)


	//insert data in the fields
	WebUI.sendKeys(findTestObject('Object Repository/Bill pay/Payee Name'), payee_Name)

	WebUI.sendKeys(findTestObject('Object Repository/Bill pay/Bill pay address'), address)

	WebUI.sendKeys(findTestObject('Object Repository/Bill pay/Bill pay city'), city)

	WebUI.sendKeys(findTestObject('Object Repository/Bill pay/Bill pay state'), state)

	WebUI.sendKeys(findTestObject('Object Repository/Bill pay/Pay bill zip code'), zip_Code)

	WebUI.sendKeys(findTestObject('Object Repository/Bill pay/Bill pay phone'), phone)

	WebUI.sendKeys(findTestObject('Object Repository/Bill pay/Pay bill account'), account)

	WebUI.sendKeys(findTestObject('Object Repository/Bill pay/Bill pay Verify Account'), verify_Account)

	WebUI.sendKeys(findTestObject('Object Repository/Bill pay/Bill pay amount'), amount)

	//click on send button to perform payment process
	WebUI.click(findTestObject('Object Repository/Bill pay/Send payment'))

	//validate test case is passed
	CustomKeywords.'keywordContainer.HelperKeywords.validateTestCaseIsPassed'(findTestObject('Object Repository/Bill pay/Bill Payment_success message'), time, PayBillSuccessMeaage)

}catch(Exception e) {

	// Log the failure message in the Katalon report with the exception details
	KeywordUtil.markFailed("Register scenario is failed: " + e.getMessage())

	// Take a screenshot of the current browser state to help with debugging
	WebUI.takeScreenshot()

}

