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

int time = 3



//step1: will enter to open a new account screen
CustomKeywords.'keywordContainer.HelperKeywords.navigateToFeature'(findTestObject('Object Repository/Open new account/Open New account button'))

//step2: chech that we are in the right page
WebUI.verifyElementPresent(findTestObject('Object Repository/Open new account/Open new account heading'), time)

//step3: open account type list
WebUI.click(findTestObject('Object Repository/Open new account/account type list'))

//step4: select the requested account type
WebUI.click(findTestObject('Object Repository/Open new account/Checking account'))

//step5: save the account
WebUI.click(findTestObject('Object Repository/Open new account/Save new account button'))

//get & store the created account no.
CustomKeywords.'keywordContainer.HelperKeywords.storeInfo'(findTestObject('Object Repository/Open new account/newly created account number'))

//get success message value from test data sheet
String AccountCreatedSuccessfully = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Open new account", "Account created success message", GlobalVariable.FirstRowNo)

//step6: verify that the account created successfully
CustomKeywords.'keywordContainer.HelperKeywords.validateTestCaseIsPassed'(findTestObject('Object Repository/Open new account/account added_success message'), time, AccountCreatedSuccessfully)