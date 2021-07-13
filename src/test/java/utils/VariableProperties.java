package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class VariableProperties {
    String URL;
    private static Properties temp;

    private static Properties conf() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("data.properties"));
        temp = properties;
        return temp;
    }

    public String getAppActy() throws IOException {
        return URL = conf().getProperty("app_activity");
    }

    public String getAppPckg() throws IOException {
        return URL = conf().getProperty("app_package");
    }

    public String getHijraID() throws IOException {
        return URL = conf().getProperty("HijraID");
    }

    public String getEmail() throws IOException {
        return URL = conf().getProperty("Email");
    }

    public String getPassword() throws IOException {
        return URL = conf().getProperty("Password");
    }

    public String getNoHp() throws IOException {
        return URL = conf().getProperty("NoHP");
    }

    public String getDay() throws IOException {
        return URL = conf().getProperty("Day");
    }

    public String getMonth() throws IOException {
        return URL = conf().getProperty("Month");
    }

    public String getYears() throws IOException {
        return URL = conf().getProperty("Years");

    }

    public String getJDBC() throws IOException {
        return URL = conf().getProperty("JDBC_DRIVER");
    }

    public String getDbUrl() throws IOException {
        return URL = conf().getProperty("DB_URL");
    }

    public String getUserDB() throws IOException {
        return URL = conf().getProperty("USER");
    }

    public String getPassDB() throws IOException {
        return URL = conf().getProperty("PASS");
    }

    public String getNoKtp() throws IOException {
        return URL = conf().getProperty("NoKtp");
    }

    public String getNameKtp() throws IOException {
        return URL = conf().getProperty("NamaKtp");
    }

    public String getTempatLahir() throws IOException {
        return URL = conf().getProperty("TempatLahir");
    }

    public String getProvinsi() throws IOException {
        return URL = conf().getProperty("Provinsi");
    }

    public String getKota() throws IOException {
        return URL = conf().getProperty("Kota");
    }

    public String getKecamatan() throws IOException {
        return URL = conf().getProperty("Kecamatan");
    }

    public String getKelurahan() throws IOException {
        return URL = conf().getProperty("Kelurahan");
    }

    public String getKewarganegaraan() throws IOException {
        return URL = conf().getProperty("Kewarganegaraan");
    }

    public String getRTRW() throws IOException {
        return URL = conf().getProperty("RTRW");
    }

    public String getAlamat() throws IOException {
        return URL = conf().getProperty("Alamat");
    }

    public String getStatus() throws IOException {
        return URL = conf().getProperty("Status");
    }

    public String getJenisKelamin() throws IOException {
        return URL = conf().getProperty("JenisKelamin");
    }

    public String getPendidikan() throws IOException {
        return URL = conf().getProperty("Pendidikan");
    }

    public String getPekerjaan() throws IOException {
        return URL = conf().getProperty("Pekerjaan");
    }

    public String getJabatan() throws IOException {
        return URL = conf().getProperty("Jabatan");
    }

    public String getKantor() throws IOException {
        return URL = conf().getProperty("Kantor");
    }

    public String getAlamatKantor() throws IOException {
        return URL = conf().getProperty("AlamatKantor");
    }

    public String getDana() throws IOException {
        return URL = conf().getProperty("Dana");
    }

    public String getPenghasilan() throws IOException {
        return URL = conf().getProperty("Penghasilan");
    }

    public String getTujuan() throws IOException {
        return URL = conf().getProperty("Tujuan");
    }

    public String IbuKandung() throws IOException {
        return URL = conf().getProperty("IbuKandung");
    }

    public String getIDLogin() throws IOException {
        return URL = conf().getProperty("IDLogin");
    }
    public String getPasswordLogin() throws IOException {
        return URL = conf().getProperty("PasswordLogin");
    }


}
