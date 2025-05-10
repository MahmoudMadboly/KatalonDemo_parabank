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

int time = 10

WebUI.click(findTestObject('Object Repository/Forum/Forum button'))

WebUI.delay(time)

String ActualParaSoftForumUrl = WebUI.getUrl()

println(ActualParaSoftForumUrl)

String ExpectedParaSoftForumUrl = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Parasoft Forums", "Site link", GlobalVariable.FirstRowNo)

//verify the site link
Assert.assertEquals(ActualParaSoftForumUrl, ExpectedParaSoftForumUrl)

String paraSoftHeader = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("Parasoft Forums", "Parasoft heading", GlobalVariable.FirstRowNo)

//verify that the portal redirected successfully
WebUI.verifyElementText(findTestObject('Object Repository/Forum/Parasoft Forum heading'), paraSoftHeader)