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

WebUI.openBrowser('')

WebUI.navigateToUrl('http://localhost:3000/')

WebUI.click(findTestObject('Object Repository/Page_EnglishMaster - Nng cao k nng ting Anh ca bn/button_TI  C TI KHON'))

WebUI.setText(findTestObject('Object Repository/Page_EnglishMaster - Nng cao k nng ting Anh ca bn/input_ng nhp_email'), 
    'themcao20@gmail.com')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_EnglishMaster - Nng cao k nng ting Anh ca bn/input_ng nhp_password'), 
    'tE+PEiSUqqhzstxolVe06g==')

WebUI.click(findTestObject('Object Repository/Page_EnglishMaster - Nng cao k nng ting Anh ca bn/button_ng nhp'))

WebUI.click(findTestObject('Object Repository/Page_EnglishMaster - Nng cao k nng ting Anh ca bn/div_Mc tiu hc tp'))

WebUI.click(findTestObject('Object Repository/Page_EnglishMaster - Nng cao k nng ting Anh ca bn/button_Thm mc tiu mi'))

WebUI.setText(findTestObject('Object Repository/Page_EnglishMaster - Nng cao k nng ting Anh ca bn/input_Tiu_title'), Tieu_De)

WebUI.setText(findTestObject('Object Repository/Page_EnglishMaster - Nng cao k nng ting Anh ca bn/input_M t_description'), 
    Mo_Ta)

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_EnglishMaster - Nng cao k nng ting Anh ca bn/select_Pomodoroim sChng hcBi kim traBi hc'), 
    Loai_Muc_Tieu, true)

WebUI.selectOptionByLabel(findTestObject("Object Repository/Page_EnglishMaster - Nng cao k nng ting Anh ca bn/select_ReadingListeningWritingSpeakingVocab_b1fef0"), Ky_Nang.trim(), false)

if (Loai_Muc_Tieu == 'POMODORO') {
    WebUI.setText(findTestObject('Object Repository/Page_EnglishMaster - Nng cao k nng ting Anh ca bn/input_Mi phin 25pht lm vic 5pht ngh_target'), 
        So_Phien)

    WebUI.setText(findTestObject('Object Repository/Page_EnglishMaster - Nng cao k nng ting Anh ca bn/input_Lm vic_workDuration'), 
        Lam_Viec)

    WebUI.setText(findTestObject('Object Repository/Page_EnglishMaster - Nng cao k nng ting Anh ca bn/input_Ngh ngn_shortBreakDuration'), 
        Nghi_Ngan)

    WebUI.setText(findTestObject('Object Repository/Page_EnglishMaster - Nng cao k nng ting Anh ca bn/input_Sau mi_longBreakInterval'), 
        Sau_Moi)

    WebUI.setText(findTestObject('Object Repository/Page_EnglishMaster - Nng cao k nng ting Anh ca bn/input_Ngh di_longBreakDuration'), 
        Nghi_Dai)
} else {
    WebUI.setText(findTestObject('Page_EnglishMaster - Nng cao k nng ting Anh ca bn/Page_EnglishMaster - Nng cao k nng ting Anh ca bn/input_im s mc tiu_target'), 
        Diem_So)

    WebUI.setText(findTestObject('Page_EnglishMaster - Nng cao k nng ting Anh ca bn/Page_EnglishMaster - Nng cao k nng ting Anh ca bn/input_Hn hon thnh_deadline'), 
        Han_Hoan_Thanh)
}

WebUI.click(findTestObject('Object Repository/Page_EnglishMaster - Nng cao k nng ting Anh ca bn/div_Lm vicphtNgh ngnphtSau miphinNgh dipht'))

WebUI.click(findTestObject('Object Repository/Page_EnglishMaster - Nng cao k nng ting Anh ca bn/button_To mc tiu'))

WebUI.verifyTextPresent(Expected_Result, false)

