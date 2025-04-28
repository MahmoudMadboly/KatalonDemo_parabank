package keywordContainer

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.text.ParseException
import java.text.SimpleDateFormat

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.ExcelData
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import groovy.transform.Undefined.EXCEPTION
import internal.GlobalVariable
import javassist.bytecode.stackmap.BasicBlock.Catch
import org.apache.poi.ss.usermodel.*
import org.apache.poi.ss.usermodel.DateUtil

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


	//Fetch test data from Excel/Data Files
	@Keyword
	def getTestData(String sheetName , String coulumnName, int rowIndex) {
		//fetch data sheet
		return findTestData(sheetName).getValue(coulumnName, rowIndex)
	}




	//selecting the right account i want to find its transactions
	@Keyword
	def selectAcountIdBeforeFindTransactions(TestObject accountListObject){

		WebUI.click(findTestObject('Object Repository/Find transaction/Find transaction_AccountID'))

		String createdAccountNumber = GlobalVariable.Data

		WebUI.selectOptionByValue(accountListObject, createdAccountNumber, false)
	}


	//check if fetched test data is date format or normal string format
	@Keyword
	def checkDataIfDate(String excelData) {

		if (excelData == null || excelData.trim().isEmpty()) {
			return excelData
		}

		try {
			if (excelData.contains("/") || excelData.contains("-")) {
				def possibleFormats = [
					"M/d/yyyy", "MM/dd/yyyy",
					"d/M/yyyy", "dd/MM/yyyy",
					"M-d-yyyy", "MM-dd-yyyy",
					"d-M-yyyy", "dd-MM-yyyy"
				]

				for (String format : possibleFormats) {
					try {
						SimpleDateFormat sheetFormat = new SimpleDateFormat(format)
						sheetFormat.setLenient(false)
						Date date = sheetFormat.parse(excelData)

						// Format to target format (returns String)
						SimpleDateFormat portalFormat = new SimpleDateFormat("MM-dd-yyyy")
						return portalFormat.format(date)
					} catch (ParseException pe) {
						continue // Try next format
					}
				}
			}
			return excelData // Return original if not a date
		} catch (Exception e) {
			println "Error processing date: ${e.getMessage()}"
			return excelData
		}
	}
}