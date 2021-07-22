package Mobile.test;

import Mobile.controller.Hompage.AllHistoryController;
import Mobile.controller.Hompage.DetailTransferController;
import Mobile.controller.Hompage.HomePageController;
import Mobile.controller.OTPController;
import Mobile.controller.OnBoarding.Login.LoginController;
import Mobile.controller.OnBoarding.Register.*;
import Mobile.controller.OnBoarding.StarActivityController;
import Mobile.controller.Transaction.ReceiptController;
import Mobile.controller.Transaction.TransferHijraController;
import Mobile.test.OnBoarding.LoginSucces;
import Mobile.test.Transaction.TransferToHijraTest;
import Mobile.utils.VariableProperties;
import Mobile.utils.listeners.TestListener;
import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Listeners({TestListener.class})
@Epic("ON BOARDING")
@Feature("Register Data, Upload Document, Selfie Ekyc, Signature, Review Data, Personal Info")
public class e2eTest extends BaseTest {

    private StarActivityController starActivityController;
    private RegisterDataController registerController;
    private OTPController otpController;
    private UploadDocumentController documentController;
    private SignatureController signatureController;
    private ReviewDataController customerDataController;
    private PersonalInfoController personalInfoController;
    private EndProsesController endProsesController;
    private VariableProperties vp = new VariableProperties();
    private TransferHijraController transferHijraController;
    private ReceiptController receiptController;
    private LoginController loginController;
    private HomePageController homePageController;
    private DetailTransferController detailTransferController;
    private AllHistoryController allHistoryController;

    @Test(priority = 0)
    @Severity(SeverityLevel.NORMAL)
    @Description("Start Application and choice menu bahasa")
    @Story("Start Application and choice menu bahasa")
    public void startActivityBahasa() throws InterruptedException {
        starActivityController = new StarActivityController(driver);
        starActivityController
                .click_salam()
                .click_bahasa();
    }

    @Test(priority = 1)
    @Severity(SeverityLevel.NORMAL)
    @Description("As a user, I want to skip carousel, so that I can shorten the process")
    @Story("HIJRA-531 [Android-FE] Enable Skip On Carousel - As a user, I want to skip carousel, so that I can shorten the process ")
    public void skipCarousel() throws InterruptedException {
        starActivityController = new StarActivityController(driver);
        starActivityController.skip_button();
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Term and Conditon")
    @Story("HIJRA-14 [Android-FE] T&C Page - As a user, I want to know the terms & conditions so that I know the legal matters and the limitations of the product.")
    public void termCondition() throws Exception {
        registerController = new RegisterDataController(driver);
        registerController
                .click_daftar()
                .click_mulai()
                .click_checkbox()
                .click_lanjut();

    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Enabling the users to have personified data to log in to the account.")
    @Story("HIJRA-24 [Android-FE] The User Account Creation Page - As a user, I want to be able to set up my username and password, so that I can log in and sign up to the app using those account IDs.")
    public void inputFormDaftar() throws Exception {
        registerController = new RegisterDataController(driver);
        registerController
                .input_HijraID(vp.getHijraID())
                .input_Email(vp.getEmail())
                .inputPassword(vp.getPassword())
                .inputKonfirmPswrd(vp.getPassword())
                .inputNoHp(vp.getNoHp())
                .click_lanjut_regis();

    }

    @Test(priority = 4)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Android] OTP Authentication - As a user, I want to be able to receive OTP so that my phone number can be authenticated.")
    @Story("HIJRA-260 [Android-FE] OTP Authentication - As a user, I want to be able to receive OTP so that my phone number can be authenticated.")
    @Parameters("validationCitcall")
    public void otpDB(String validationCitcall) throws Exception {
        otpController = new OTPController(driver);
        otpController
                .validationCitcall(validationCitcall)
                .getOtp();
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.NORMAL)
    @Description("Next Step for Upload Document")
    @Story("HIJRA-236 [Android-FE] Continue Sign-up - As a user, I want to continue my sign-up process, so that I can shorten up the process, and afford if I should drop off the onboarding process")
    public void nextStepupload() throws Exception {
        documentController = new UploadDocumentController(driver);
        documentController
                .nextUpload();
    }

    @Test(priority = 6)
    @Severity(SeverityLevel.NORMAL)
    @Description("To enable the users to prepare for documents, take photographs in a proper condition, and allow the users to give the permission of accessing camera and gallery to the app\n" +
            "\n")
    @Story("HIJRA-236[Android-FE] e-KTP KYC Page - As a user, I want to be able to do an NPWP for KYC purposes, so that the registration process could be done faster.")
    public void allowPermissonCamera() throws Exception {
        documentController = new UploadDocumentController(driver);
        documentController
                .allow_permission()
                .click_camera();
    }

    @Test(priority = 7)
    @Severity(SeverityLevel.NORMAL)
    @Description("Upload Document Success")
    @Story("HIJRA-237 [Android-FE] Information Input Review Page - As a user, I want to be able to review and edit the required information inputted by the auto-fill and myself, so that I can ensure the information is correct.")
    public void uploadDocumentSuccess() throws Exception {
        documentController = new UploadDocumentController(driver);
        documentController
                .input_ktp(vp.getNoKtp())
                .input_nama(vp.getNameKtp())
                .set_day(vp.getDay(), vp.getMonth(), vp.getYears())
                .click_gunakan()
                .take_Selfie()
                .uploadSelfie()
                .take_Selfie()
                .uploadSelfie();
    }

    @Test(priority = 8)
    @Severity(SeverityLevel.NORMAL)
    @Description("Create Signature with upload, camera and touch ")
    @Story("HIJRA-488 [Android-FE] Signature Input - As a user, I want to be able to input signature as KYC process, so that I can continue my sign-up process")
    public void createSignature() throws Exception {
        signatureController = new SignatureController(driver);
        signatureController
                .signatureThread()
                .lanjut_signature();

    }

    @Test(priority = 9)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Review Data has been successfully input")
    @Story("HIJRA-237 [Android-FE] Information Input Review Page - As a user, I want to be able to review and edit the required information inputted by the auto-fill and myself, so that I can ensure the information is correct.")
    public void reviewDataSuccess() throws Exception {
        customerDataController = new ReviewDataController(driver);
        customerDataController
                //.validation_nextReview()
                .scrollTL()
                .input_tempatLahir(vp.getTempatLahir())
                .select_Provinsi(vp.getProvinsi())
                .select_kota(vp.getKota())
                .scrollTL()
                .select_kecamatan(vp.getKecamatan())
                .select_kelurahan(vp.getKelurahan())
                .scrollEnd()
                .input_RTRW(vp.getRTRW())
                .input_Alamat(vp.getAlamat())
                .select_Perkawinan(vp.getStatus())
                .select_Jenis(vp.getJenisKelamin())
                .select_Kewarganegaraan(vp.getKewarganegaraan())
                .click_Lanjut();
    }

    @Test(priority = 10)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Personal Info has been successfully input")
    @Story("HIJRA-293 [Android-FE] Personal Info - As a user, I want to fill out the additional information about my current state, so that I might use that data to access more financial products.")
    public void PersonalInfoSuccess() throws Exception {
        personalInfoController = new PersonalInfoController(driver);
        personalInfoController
                .validation_informasi()
                .input_pendidikan(vp.getPendidikan())
                .input_pekerjaan(vp.getPekerjaan())
                .input_jabatan(vp.getJabatan())
                .input_kantor(vp.getKantor())
                .input_alamat(vp.getAlamatKantor())
                .input_sumberDana(vp.getDana())
                .input_penghasilan(vp.getPenghasilan())
                .input_tujuan(vp.getTujuan())
                .input_nama(vp.IbuKandung())
                .click_lanjut();
    }

    @Test(priority = 11)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Validation Success")
    @Story("HIJRA-490 [Android-FE] Successful Sign-up - As a user, I want to know when I have finished my sign-up process, so that I can wait for the account activation")
    public void validationSuccess() throws Exception {
        endProsesController = new EndProsesController(driver);
        endProsesController
                .validationSuccessRegister();
    }

    @Test(priority = 12)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Transfer To Hijra")
    @Story("HIJRA-461 [Android-FE] Transfer to Hijra - As a user, I want to transfer my money to another Hijra account, so that I can do transactions within Hijra app.")
    @Parameters({"rekPenerima", "nominalTf", "catatan"})
    public void transferHijra(String rekPenerima, String nominalTf, String catatan) throws Exception {

        homePageController = new HomePageController(driver);
        homePageController.balancedSaldo();
        transferHijraController = new TransferHijraController(driver);
        transferHijraController
                .transferToHijra()
                .inputRekHijraID(rekPenerima)
                .clickbtnLanjut()
                .inputNominal(nominalTf)
                .inputCatatan(catatan)
                .clickbtnLanjut()
                .validationDtlNamePenerima(rekPenerima, vp.getIDLogin())
                .validationDetailRekPenerima(rekPenerima, vp.getIDLogin())
                .btnLanjutKirim();
    }

    @Test(priority = 13)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Transfer Authentication")
    @Story("HIJRA-463 [Android-FE] Transfer Authentication - As a user, I want to input password or biometrics before finalizing the transfer, so that I can ensure its security")
    @Parameters({"optionAuth"})
    public void transferAuthentication(String optionAuth) throws Exception {
        transferHijraController = new TransferHijraController(driver);
        transferHijraController
                .transferAuthentication(optionAuth, vp.getPasswordLogin());
    }

    @Test(priority = 14)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Transfer To Hijra Success Validation Receipt (Rekening Pengirim)")
    @Story("HIJRA-464 [Android-FE] Transfer Success - As a user, I want to be confirmed when my transfer has been succeeded, so I know that my balance has been updated")
    public void transferHijraReceiptRekPengirim() throws Exception {
        receiptController = new ReceiptController(driver);
        receiptController
                .validationRekPengirimDb(vp.getIDLogin())
                .backNavigate()
                .backHome();
    }

    @Test(priority = 15)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Transfer To Hijra Success Validation Saldo Balanced")
    @Story("HIJRA-464 [Android-FE] Transfer Success - As a user, I want to be confirmed when my transfer has been succeeded, so I know that my balance has been updated")
    public void validationBalancesAmount() throws Exception {
        homePageController = new HomePageController(driver);
        homePageController.validationBalanced(10000);
    }

    @Test(priority = 16)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Transfer To Hijra Success Status")
    @Story("HIJRA-464 [Android-FE] Transfer Success - As a user, I want to be confirmed when my transfer has been succeeded, so I know that my balance has been updated")
    @Parameters({"validationStatus"})
    public void transferHijraStatus(String validationStatus) throws Exception {
        transferHijraController = new TransferHijraController(driver);
        transferHijraController
                .statusTransfer(validationStatus)
                .scrollEnd()
                .viewReceipt();
    }

    @Test(priority = 17)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Transfer To Hijra Success Validation Receipt (Amount)")
    @Story("HIJRA-464 [Android-FE] Transfer Success - As a user, I want to be confirmed when my transfer has been succeeded, so I know that my balance has been updated")
    public void transferHijraReceiptAmount() throws Exception {
        receiptController = new ReceiptController(driver);
        receiptController
                .validationAmountOUT(vp.getIDLogin());
    }

    @Test(priority = 18)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Transfer To Hijra Success Validation Receipt (Nama Penerima)")
    @Story("HIJRA-464 [Android-FE] Transfer Success - As a user, I want to be confirmed when my transfer has been succeeded, so I know that my balance has been updated")
    @Parameters({"idPenerimaReceipt"})
    public void transferHijraReceiptNamePenerima(String idPenerimaReceipt) throws Exception {
        receiptController = new ReceiptController(driver);
        receiptController
                .validationNamePenerimaDb(idPenerimaReceipt)
                .validationRekPenerimaInDb(idPenerimaReceipt);
    }

    @Test(priority = 19)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Transfer To Hijra Success Validation Receipt (Rekening Penerima)")
    @Story("HIJRA-464 [Android-FE] Transfer Success - As a user, I want to be confirmed when my transfer has been succeeded, so I know that my balance has been updated")
    @Parameters({"idPenerimaReceipt"})
    public void transferHijraReceiptRekPenerima(String idPenerimaReceipt) throws Exception {
        receiptController = new ReceiptController(driver);
        receiptController
                .validationRekPenerimaInDb(idPenerimaReceipt);
    }

    @Test(priority = 20)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Transfer To Hijra Success Validation Receipt (Tanggal Transaksi)")
    @Story("HIJRA-464 [Android-FE] Transfer Success - As a user, I want to be confirmed when my transfer has been succeeded, so I know that my balance has been updated")
    public void transferHijraReceiptDateTime() throws Exception {
        receiptController = new ReceiptController(driver);
        receiptController
                .validationDateTimeDb();
    }

    @Test(priority = 21)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Transfer To Hijra Success Validation Receipt (BANK)")
    @Story("HIJRA-464 [Android-FE] Transfer Success - As a user, I want to be confirmed when my transfer has been succeeded, so I know that my balance has been updated")
    public void transferHijraReceiptBank() throws Exception {
        receiptController = new ReceiptController(driver);
        receiptController
                .validationBankDb(vp.getIDLogin());
    }

    @Test(priority = 22)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Transfer To Hijra Success Validation Receipt (Name Pengirim)")
    @Story("HIJRA-464 [Android-FE] Transfer Success - As a user, I want to be confirmed when my transfer has been succeeded, so I know that my balance has been updated")
    public void transferHijraReceiptNamePengirim() throws Exception {
        receiptController = new ReceiptController(driver);
        receiptController
                .validationNamePengirimDb(vp.getIDLogin());
    }

    @Test(priority = 23)
    @Severity(SeverityLevel.CRITICAL)
    @Description("List Transaksi IN")
    @Story("HIJRA-462 [Android-FE] Transfer Review - As a user, I want to review transfer information before finalizing the transaction, so that I am sure that I input the correct information")
    @Parameters({"listInOut"})
    public void detailTransferOut(String listInOut) throws Exception {
        allHistoryController = new AllHistoryController(driver);
        allHistoryController
                .allTransaksi()
                .listTransaksi(listInOut)
                .chooseList();
    }

    @Test(priority = 24)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Transaksi Status OUT")
    @Story("HIJRA-462 [Android-FE] Transfer Review - As a user, I want to review transfer information before finalizing the transaction, so that I am sure that I input the correct information")
    @Parameters({"userPenerima"})
    public void transferStatusOutNamePenerima(String userPenerima) throws Exception {
        detailTransferController = new DetailTransferController(driver);
        detailTransferController
                .validationNamePenerimaDb(userPenerima);
    }

    @Test(priority = 25)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Transaksi Status OUT")
    @Story("HIJRA-462 [Android-FE] Transfer Review - As a user, I want to review transfer information before finalizing the transaction, so that I am sure that I input the correct information")
    public void transferStatusOutBank() throws Exception {
        detailTransferController = new DetailTransferController(driver);
        detailTransferController
                .validationBankDb(vp.getIDLogin(), "Status")
                .scrollEnd();

    }

    @Test(priority = 26)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Transaksi Status OUT")
    @Story("HIJRA-462 [Android-FE] Transfer Review - As a user, I want to review transfer information before finalizing the transaction, so that I am sure that I input the correct information")
    @Parameters({"userPenerima"})
    public void transferStatusOutRekPenerima(String userPenerima) throws Exception {
        detailTransferController = new DetailTransferController(driver);
        detailTransferController
                .validationRekPenerimaDb(userPenerima, "Status");
    }

    @Test(priority = 27)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Transaksi Status OUT")
    @Story("HIJRA-462 [Android-FE] Transfer Review - As a user, I want to review transfer information before finalizing the transaction, so that I am sure that I input the correct information")
    public void transferStatusOutDate() throws Exception {
        detailTransferController = new DetailTransferController(driver);
        detailTransferController
                .validationDateManual("19 Juli 2021,", "Status");
    }

    @Test(priority = 28)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Transaksi Status OUT")
    @Story("HIJRA-462 [Android-FE] Transfer Review - As a user, I want to review transfer information before finalizing the transaction, so that I am sure that I input the correct information")
    public void transferStatusOutTime() throws Exception {
        detailTransferController = new DetailTransferController(driver);
        detailTransferController
                .validationTimeDb(vp.getIDLogin(), "TransferIn", "Status");

    }

    @Test(priority = 29)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Transaksi Status OUT")
    @Story("HIJRA-462 [Android-FE] Transfer Review - As a user, I want to review transfer information before finalizing the transaction, so that I am sure that I input the correct information")
    public void transferStatusOutNamePengirim() throws Exception {
        detailTransferController = new DetailTransferController(driver);
        detailTransferController
                .validationNamePengirimDb(vp.getIDLogin());
    }

    @Test(priority = 30)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Transaksi Status OUT")
    @Story("HIJRA-462 [Android-FE] Transfer Review - As a user, I want to review transfer information before finalizing the transaction, so that I am sure that I input the correct information")
    public void transferStatusOutRekPengirim() throws Exception {
        detailTransferController = new DetailTransferController(driver);
        detailTransferController
                .validationRekPengirimDb(vp.getIDLogin());
    }

    @Test(priority = 31)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Detail Transaksi OUT")
    @Story("HIJRA-462 [Android-FE] Transfer Review - As a user, I want to review transfer information before finalizing the transaction, so that I am sure that I input the correct information")
    public void transferDetailOutAmount() throws Exception {
        detailTransferController = new DetailTransferController(driver);
        detailTransferController
                .lihatBuktiTf()
                .validationAmount(vp.getIDLogin(), "TransferOut");
    }

    @Test(priority = 32)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Detail Transaksi OUT")
    @Story("HIJRA-462 [Android-FE] Transfer Review - As a user, I want to review transfer information before finalizing the transaction, so that I am sure that I input the correct information")
    @Parameters({"userPenerima"})
    public void transferDetailOutNamePenerima(String userPenerima) throws Exception {
        detailTransferController = new DetailTransferController(driver);
        detailTransferController
                .validationNamePenerimaDb(userPenerima);

    }

    @Test(priority = 33)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Detail Transaksi OUT")
    @Story("HIJRA-462 [Android-FE] Transfer Review - As a user, I want to review transfer information before finalizing the transaction, so that I am sure that I input the correct information")
    @Parameters({"userPenerima"})
    public void transferDetailOutRekPenerima(String userPenerima) throws Exception {
        detailTransferController = new DetailTransferController(driver);
        detailTransferController
                .validationRekPenerimaDb(userPenerima, "Detail");

    }

    @Test(priority = 34)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Detail Transaksi OUT")
    @Story("HIJRA-462 [Android-FE] Transfer Review - As a user, I want to review transfer information before finalizing the transaction, so that I am sure that I input the correct information")
    public void transferDetailOutBank() throws Exception {
        detailTransferController = new DetailTransferController(driver);
        detailTransferController
                .validationBankDb(vp.getIDLogin(), "Detail");
    }

    @Test(priority = 35)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Detail Transaksi OUT")
    @Story("HIJRA-462 [Android-FE] Transfer Review - As a user, I want to review transfer information before finalizing the transaction, so that I am sure that I input the correct information")
    public void transferDetailOutDate() throws Exception {
        detailTransferController = new DetailTransferController(driver);
        detailTransferController
                .validationDateManual("21 Juli 2021,", "Detail");
    }

    @Test(priority = 36)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Detail Transaksi OUT")
    @Story("HIJRA-462 [Android-FE] Transfer Review - As a user, I want to review transfer information before finalizing the transaction, so that I am sure that I input the correct information")
    public void transferDetailOutTime() throws Exception {
        detailTransferController = new DetailTransferController(driver);
        detailTransferController
                .validationTimeDb(vp.getIDLogin(), "TransferIn", "Detail");
    }

    @Test(priority = 37)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Detail Transaksi IN")
    @Story("HIJRA-462 [Android-FE] Transfer Review - As a user, I want to review transfer information before finalizing the transaction, so that I am sure that I input the correct information")
    public void transferDetailOutNamePengirim() throws Exception {
        detailTransferController = new DetailTransferController(driver);
        detailTransferController
                .validationNamePengirimDb(vp.getIDLogin());
    }

    @Test(priority = 38)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Detail Transaksi OUT")
    @Story("HIJRA-462 [Android-FE] Transfer Review - As a user, I want to review transfer information before finalizing the transaction, so that I am sure that I input the correct information")
    public void transferDetailInRekPengirim() throws Exception {
        detailTransferController = new DetailTransferController(driver);
        detailTransferController
                .scrollEnd()
                .validationRekPengirimDb(vp.getIDLogin());

    }

    @Test(priority = 39)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Detail Transaksi OUT")
    @Story("HIJRA-462 [Android-FE] Transfer Review - As a user, I want to review transfer information before finalizing the transaction, so that I am sure that I input the correct information")
    @Parameters({"validationSave"})
    public void transferDetailOutValidation(String validationSave) throws Exception {
        detailTransferController = new DetailTransferController(driver);
        detailTransferController
                .saveBuktiTransfer()
                .validationSaveBukti(validationSave)
                .backHomePage();
    }


}
