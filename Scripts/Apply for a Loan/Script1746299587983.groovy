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
	CustomKeywords.'keywordContainer.HelperKeywords.navigateToFeature'(findTestObject('Object Repository/Apply for a Loan/Apply for a Loan button'),
			findTestObject('Object Repository/Apply for a Loan/Apply for a loan heading'),
			time)

	//fetch data from test data sheet
	String loanAmount = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Apply for a Loan", "Loan amount", GlobalVariable.FirstRowNo)

	String downPayment = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Apply for a Loan", "Down payment", GlobalVariable.FirstRowNo)

	String successMessage = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Apply for a Loan", "Apply for load_Success message", GlobalVariable.FirstRowNo)

	//insert data in the fields
	WebUI.sendKeys(findTestObject('Object Repository/Apply for a Loan/Loan Amount'), loanAmount)

	WebUI.sendKeys(findTestObject('Object Repository/Apply for a Loan/Down Payment'), downPayment)

	//select the right account no.
	CustomKeywords.'keywordContainer.HelperKeywords.selectAcountIdBeforeFindTransactions'(findTestObject('Object Repository/Apply for a Loan/Request loan_accounts list'))

	//click on apply button
	WebUI.click(findTestObject('Object Repository/Apply for a Loan/Request button_Apply now button'))

	//validate test case is passed
	CustomKeywords.'keywordContainer.HelperKeywords.validateTestCaseIsPassed'(findTestObject('Object Repository/Apply for a Loan/Loan Request Processed heading'), time, successMessage)

}catch(Exception e) {

	// Log the failure message in the Katalon report with the exception details
	KeywordUtil.markFailed("Register scenario is failed: " + e.getMessage())

	// Take a screenshot of the current browser state to help with debugging
	WebUI.takeScreenshot()

}

