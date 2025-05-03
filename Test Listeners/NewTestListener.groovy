import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.junit.After

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import groovy.transform.Undefined.EXCEPTION

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable
import javassist.bytecode.stackmap.BasicBlock.Catch

import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext

class NewTestListener {

	int time = 10
	/**
	 * Executes before every test case starts.
	 * @param testCaseContext related information of the executed test case.
	 */
	/*	@BeforeTestCase
	 def sampleBeforeTestCase(TestCaseContext testCaseContext) {
	 println testCaseContext.getTestCaseId()
	 println testCaseContext.getTestCaseVariables()
	 }*/

	@BeforeTestCase
	def beforeTestCase(TestCaseContext TestCaseContext) {

		//get current test case id
		String testCaseID = TestCaseContext.getTestCaseId();


		//open browser
		WebUI.openBrowser('')

		//get test data
		String URl = CustomKeywords.'keywordContainer.HelperKeywords.getTestData'("General Data", "End point", GlobalVariable.FirstRowNo)

		println "Opening browser..."

		WebUI.navigateToUrl(URl)

		WebUI.waitForPageLoad(time)

		try {


			//if current test case id is sign up then skip login
			if(testCaseID.contains("Register")) {

				println("⏭ Skipping login for SignUp test case: $testCaseId")

			}else {


				//login to app with the registered username & password
				WebUI.sendKeys(findTestObject('Object Repository/Login/userName'), GlobalVariable.CreatedUseName)

				WebUI.sendKeys(findTestObject('Object Repository/Login/passWord'), GlobalVariable.CreatedPassWord)

				WebUI.click(findTestObject('Object Repository/Login/loginButton'))

				WebUI.waitForPageLoad(time)

			}

		}catch(Exception e) {

			println("Some error happened, please check what`s wrong!: " + e.getMessage())

		}

	}

}