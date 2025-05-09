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

String customeName = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("", "", GlobalVariable.FirstRowNo)

String customeEmail = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("", "", GlobalVariable.FirstRowNo)

String customePhone = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("", "", GlobalVariable.FirstRowNo)

String message = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("", "", GlobalVariable.FirstRowNo)

String successMessage = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("", "", GlobalVariable.FirstRowNo) + CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("", "", GlobalVariable.FirstRowNo)

println("expected message is" + successMessage)

WebUI.sendKeys(findTestObject('Object Repository/Customer care/Customer name'), customeName)

WebUI.sendKeys(findTestObject('Object Repository/Customer care/Customer email'), customeName)

WebUI.sendKeys(findTestObject('Object Repository/Customer care/Customer phone'), customeName)

WebUI.sendKeys(findTestObject('Object Repository/Customer care/Message'), customeName)

CustomKeywords.'keywordContainer.HelperKeywords.validateTestCaseIsPassed'(findTestObject('Object Repository/Customer care/Success message'), time, successMessage)