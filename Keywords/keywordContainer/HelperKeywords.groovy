package keywordContainer

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static org.junit.Assert.assertArrayEquals

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
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import groovy.transform.Undefined.EXCEPTION
import internal.GlobalVariable
import javassist.bytecode.stackmap.BasicBlock.Catch
import org.apache.poi.ss.usermodel.*
import org.apache.poi.ss.usermodel.DateUtil
import org.openqa.selenium.WebElement
import org.testng.Assert

public class HelperKeywords {

	String firstName
	String lastName
	String address
	String city
	String state
	String zipCode
	String phone
	int time



	//Navigate to a feature (UI element)
	@Keyword
	def navigateToFeature(TestObject targetFeatureToBeOpened, TestObject validatedObject , int time) {

		WebUI.click(targetFeatureToBeOpened)

		WebUI.waitForElementPresent(validatedObject, time)
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
					"M/d/yyyy",
					"MM/dd/yyyy",
					"d/M/yyyy",
					"dd/MM/yyyy",
					"M-d-yyyy",
					"MM-dd-yyyy",
					"d-M-yyyy",
					"dd-MM-yyyy"
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


	/*
	 @Keyword
	 //verify find transaction scenario successfully done
	 def verifyFindTransactionScnario(TestObject object,String sheetName , String coulumnName, int rowIndex) {
	 //get transaction result text fron test data sheet
	 String transactionResultText = getTestData(sheetName, coulumnName, rowIndex)
	 //verify transaction result displayed successfully
	 WebUI.verifyElementText(object, transactionResultText)
	 }
	 */

	//check fields should be updated & update them either partially or fully
	@Keyword
	def updateProfileInfo(Map<String, String> profileData) {
		Map<String, String> fields = [
			"First name": profileData.get("firstName"),
			"Last name": profileData.get("lastName"),
			"Adress": profileData.get("address"),
			"City": profileData.get("city"),
			"State": profileData.get("state"),
			"Zip code": profileData.get("zipCode"),
			"Phone": profileData.get("phone")
		]

		fields.each { fieldName, fieldValue ->
			if (fieldValue) {
				TestObject fieldObject = findTestObject("Register/" + fieldName)
				WebUI.clearText(fieldObject)
				WebUI.setText(fieldObject, fieldValue)
			}
		}
	}


	//verify that test case is passed
	@Keyword
	def validateTestCaseIsPassed(TestObject testobject , int time , String successMessage) {

		WebUI.waitForElementVisible(testobject, time)

		WebUI.verifyElementText(testobject, successMessage)
	}


	//loop inside list
	@Keyword
	def loopInsideList(TestObject object , int time) {

		List<WebElement> solutionList = WebUiCommonHelper.findWebElements(object, time)

		List<String> result = []

		for(WebElement item : solutionList) {

			String text = item.getText()

			result.add(text)
		}

		return result.toArray(new String[0])
	}


	//check site map screen content
	@Keyword
	def checkSiteMapScreenContent(TestObject listObject , String [] expectedList , int time) {

		String[] actualList = loopInsideList(listObject, time)

		if(actualList.length == 0) {

			println("The actual list is empty.")
		}else {

			println("The actual list contains: " + Arrays.toString(actualList))
		}

		Assert.assertEquals(actualList, expectedList)
	}


	//redirect to another portal & check the redirected link
	@Keyword
	def verifyPortalRedirectionAndHeader(TestObject hyperLinkObject, int time, String URLsheetName , String URLcoulumnName, int URlrowIndex,String headerSheetName,String headerCoulmnName,int headerRowIndex,TestObject headerObject) {

		WebUI.click(hyperLinkObject)

		WebUI.delay(time)

		String actualURL = WebUI.getUrl()

		println("the actual url is/ " + actualURL)

		String expedtedURL = getTestData(URLsheetName, URLcoulumnName, URlrowIndex)

		Assert.assertEquals(actualURL, expedtedURL)

		String homePageHeader = getTestData(headerSheetName, headerCoulmnName, headerRowIndex)

		WebUI.verifyElementText(headerObject, homePageHeader)
	}
}