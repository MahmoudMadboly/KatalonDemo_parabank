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

CustomKeywords.'keywordContainer.HelperKeywords.navigateToFeature'(findTestObject('Object Repository/Customer care/Customer care button'))

WebUI.waitForElementPresent(findTestObject('Object Repository/Customer care/Customer care heading'), GlobalVariable.FirstRowNo)

String customerName = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Customer Care", "Customer name", GlobalVariable.FirstRowNo)

String customerEmail = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Customer Care", "Customer email", GlobalVariable.FirstRowNo)

String customerPhone = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Customer Care", "Customer phone", GlobalVariable.FirstRowNo)

String message = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Customer Care", "Message", GlobalVariable.FirstRowNo)

String successMessage = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Customer Care", "Customer care_Success message", GlobalVariable.FirstRowNo)
// + CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Sign up", "Username", GlobalVariable.FirstRowNo)

println("expected message is" + successMessage)

WebUI.sendKeys(findTestObject('Object Repository/Customer care/Customer name'), customerName)

WebUI.sendKeys(findTestObject('Object Repository/Customer care/Customer email'), customerEmail)

WebUI.sendKeys(findTestObject('Object Repository/Customer care/Customer phone'), customerPhone)

WebUI.sendKeys(findTestObject('Object Repository/Customer care/Message'), message)

WebUI.click(findTestObject('Object Repository/Customer care/Send to customer care button'))

CustomKeywords.'keywordContainer.HelperKeywords.validateTestCaseIsPassed'(findTestObject('Object Repository/Customer care/Success message'), time, successMessage)