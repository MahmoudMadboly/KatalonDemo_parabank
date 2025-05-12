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
import org.openqa.selenium.Keys
import org.testng.Assert
import org.testng.Assert as Keys


int time = 5

CustomKeywords.'keywordContainer.HelperKeywords.navigateToFeature'(findTestObject('Object Repository/Map site/Site map button')
		,findTestObject('Object Repository/Map site/Header'),time
		)

String [] expectedProdusctList = ["About Us","Services","Products","Locations","Admin Page"]

String [] expectedAccountServicesList = ["Open New Account","Accounts Overview","Transfer Funds","Bill Pay","Find Transactions","Update Contact Info","Request Loan","Log Out"]

CustomKeywords.'keywordContainer.HelperKeywords.checkSiteMapScreenContent'(findTestObject('Object Repository/Map site/Solutions list'), expectedProdusctList, time)

CustomKeywords.'keywordContainer.HelperKeywords.checkSiteMapScreenContent'(findTestObject('Object Repository/Map site/Account Services list'), expectedAccountServicesList, time)

