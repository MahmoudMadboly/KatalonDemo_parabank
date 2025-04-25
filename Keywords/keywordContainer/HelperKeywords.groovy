package keywordContainer

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class HelperKeywords {

	//Navigate to a feature (UI element)
	@Keyword
	def navigateToFeature(TestObject testObject) {

		WebUI.click(testObject)
	}


	@Keyword
	//Store text info from a UI element into GlobalVariable
	def storeInfo(TestObject TestObject) {

		String data = WebUI.getText(TestObject)
		GlobalVariable.Data  = data
		println("Storied data/ " + data)
	}

	@Keyword
	//Fetch test data from Excel/Data Files
	def getTestData(String sheetName , String coulumnName, int rowIndex) {

		//fetch data sheet
		return findTestData(sheetName).getValue(coulumnName, rowIndex)
	}


	@Keyword
	//method to find transaction with a specific criteria
	def findTransactionWithSpecificCriteria(String sheetName , String columnName , int rowIndex , TestObject accountListObject ,TestObject dateField ,TestObject searchButton) {

		WebUI.click(findTestObject('Object Repository/Find transaction/Find transaction_AccountID'))

		String createdAccountNumber = GlobalVariable.Data

		WebUI.selectOptionByValue(accountListObject, createdAccountNumber, false)

		String input = getTestData(sheetName, columnName, rowIndex)

		println("Account Number: " + createdAccountNumber)

		println("Input is  " + input)

		WebUI.sendKeys(dateField, input)

		WebUI.click(searchButton)
	}


	/*
	 @Keyword
	 //method to fetch test data
	 def getTestData(String sheetName , String coulumnName, int rowIndex) {
	 //fetch data sheet
	 def dataSheet = findTestData(sheetName)
	 //get test data
	 def testData = dataSheet.getValue(coulumnName, rowIndex)
	 GlobalVariable.test_Data = testData
	 }
	 */
}