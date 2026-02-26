import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import java.io.File as File
import java.util.Random as Random
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser('')

WebUI.navigateToUrl('http://localhost:3000/')

WebUI.maximizeWindow()

WebUI.click(findTestObject('Object Repository/Page_EnglishMaster - Nng cao k nng ting Anh ca bn/nav_EnglishMasterTI  C TI KHONBT U'))

WebUI.click(findTestObject('Object Repository/Page_EnglishMaster - Nng cao k nng ting Anh ca bn/button_TI  C TI KHON'))

WebUI.setText(findTestObject('Object Repository/Page_EnglishMaster - Nng cao k nng ting Anh ca bn/input_ng nhp_email'), 
    'themcao20@gmail.com')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_EnglishMaster - Nng cao k nng ting Anh ca bn/input_ng nhp_password'), 
    'tE+PEiSUqqhzstxolVe06g==')

WebUI.click(findTestObject('Object Repository/Page_EnglishMaster - Nng cao k nng ting Anh ca bn/button_ng nhp'))

WebUI.click(findTestObject('Object Repository/Page_EnglishMaster - Nng cao k nng ting Anh ca bn/div_Xem thm'))

WebUI.click(findTestObject('Object Repository/Page_EnglishMaster - Nng cao k nng ting Anh ca bn/div_Thay i tn, email, nh i din v mt khu'))

WebUI.setText(findTestObject('Object Repository/Page_EnglishMaster - Nng cao k nng ting Anh ca bn/input_Tn hin th_name'), 
    Ten_Hien_Thi)

WebUI.setText(findTestObject('Object Repository/Page_EnglishMaster - Nng cao k nng ting Anh ca bn/input_Mt khu hin ti_currentPassword'), 
    Mat_Khau_Hien_Tai)

WebUI.setText(findTestObject('Object Repository/Page_EnglishMaster - Nng cao k nng ting Anh ca bn/input_Mt khu mi_newPassword'), 
    Mat_Khau_Moi)

String projectPath = RunConfiguration.getProjectDir()

String folderPath = projectPath + '/Data Files/DataTest/DataTest'

if ((Avatar != '') && (Avatar != null)) {
    String fileToUpload = (folderPath + '/') + Avatar

    File file = new File(fileToUpload)

    if (file.exists()) {
        println('Đang upload ảnh: ' + fileToUpload)

        WebUI.uploadFile(findTestObject('Object Repository/Page_EnglishMaster - Nng cao k nng ting Anh ca bn/input_AvatarUpload'), 
            fileToUpload)
    } else {
        KeywordUtil.markWarning(('Không tìm thấy file ' + Avatar) + ' trong thư mục DataTest')
    }
} else {
    println('Bộ data không có tên file, bỏ qua upload file cho case này.')
}

WebUI.click(findTestObject('Object Repository/Page_EnglishMaster - Nng cao k nng ting Anh ca bn/button_Lu thay i'))

WebUI.delay(3)

WebUI.setText(findTestObject('Object Repository/Page_EnglishMaster - Nng cao k nng ting Anh ca bn/input_ng nhp_email'), 
    'themcao20@gmail.com')


WebUI.setText(findTestObject('Object Repository/Page_EnglishMaster - Nng cao k nng ting Anh ca bn/input_ng nhp_password'), Mat_Khau_Moi)

WebUI.click(findTestObject('Object Repository/Page_EnglishMaster - Nng cao k nng ting Anh ca bn/button_ng nhp'))

WebUI.delay(3)

String currentURL = WebUI.getUrl()

String expectedURL = 'http://localhost:3000/learn'
String loginURL = 'http://localhost:3000/login'

if (currentURL.equals(expectedURL)) {
	println("Xác minh đăng nhập thành công -> Mật khẩu đã được đổi.")
} else if (currentURL.equals(loginURL)) {
	KeywordUtil.markFailed("Xác minh đăng nhập thất bại")
}

WebUI.click(findTestObject('Object Repository/Page_EnglishMaster - Nng cao k nng ting Anh ca bn/div_Xem thm'))

WebUI.click(findTestObject('Object Repository/Page_EnglishMaster - Nng cao k nng ting Anh ca bn/div_Thay i tn, email, nh i din v mt khu'))

String avatarStyle = WebUI.getAttribute(findTestObject('Object Repository/Page_EnglishMaster - Nng cao k nng ting Anh ca bn/img_AvatarDisplay'), 
    'style')

if (avatarStyle.contains('uploads/avatars')) {
    KeywordUtil.logInfo('Avatar đã cập nhật link ảnh mới.')
}

if ((Mat_Khau_Moi != '') && (Mat_Khau_Moi != null)) {
    KeywordUtil.logInfo('Kiểm tra đăng nhập với pass mới: ' + Mat_Khau_Moi)

    WebUI.click(findTestObject('Object Repository/Page_EnglishMaster/button_Dang_Xuat'))

    WebUI.delay(1)

    WebUI.navigateToUrl('http://localhost:3000/login')

    WebUI.setText(findTestObject('Object Repository/Page_EnglishMaster/input_email'), 'themcao20@gmail.com')

    WebUI.setText(findTestObject('Object Repository/Page_EnglishMaster/input_password'), Mat_Khau_Moi)

    WebUI.click(findTestObject('Object Repository/Page_EnglishMaster/button_ng nhp'))

    boolean isLoginSuccess = WebUI.verifyElementPresent(findTestObject('Object Repository/Page_EnglishMaster/div_Xem thm'), 
        5, FailureHandling.OPTIONAL)

    if (isLoginSuccess) {
        KeywordUtil.markPassed('Mật khẩu mới đã được đổi.')
    } else {
        KeywordUtil.markFailed('Mật khẩu mới không đăng nhập được.')
    }
}

WebUI.closeBrowser()

