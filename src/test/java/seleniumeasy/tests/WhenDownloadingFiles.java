package seleniumeasy.tests;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.junit5.SerenityJUnit5Extension;

import net.thucydides.model.configuration.SessionLocalTempDirectory;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import seleniumeasy.pageobjects.DownloadPage;

import java.io.File;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.awaitility.Awaitility.await;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenDownloadingFiles {

    @Managed
    WebDriver driver;

    DownloadPage downloadPage;

    @Test
    public void weCanDownloadTheFileToOurHardDrive() {
        downloadPage.open();

        downloadPage.downloadSampleFile();

        File downloadedFile = SessionLocalTempDirectory.forTheCurrentSession().resolve("sample.png").toFile();

        await().atMost(15, SECONDS).until(downloadedFile::exists);

        assertThat(downloadedFile).exists();

        assertThat(downloadedFile.getName()).isEqualTo("sample.png");
    }
}
