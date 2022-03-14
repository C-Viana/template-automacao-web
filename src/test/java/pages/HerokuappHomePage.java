package pages;

import driver.Driver;
import objects.HerokuappHome;

import org.openqa.selenium.support.PageFactory;

public class HerokuappHomePage {
    
    public HerokuappHome obj = null;

    public HerokuappHomePage() {
        obj = new HerokuappHome();
        PageFactory.initElements( Driver.get(), obj );
    }

    public String getTitle() {
        return obj.pageTitle.getText().trim();
    }

    public String getSubtitle() {
        return obj.pageSubtitle.getText().trim();
    }

    public String getTitleExpected() {
        return obj.txtPageTitleExpected;
    }

    public String getSubtitleExpected() {
        return obj.txtPageSubtitleExpected;
    }

    public String getABTestingLinkText() {
        return obj.linkABTesting.getText().trim();
    }

    public void clickABTestingLink() {
        obj.linkABTesting.click();
    }

    public String getLinkTextABTestingExpected() {
        return obj.linkTextABTestingExpected;
    }

    public String getAddRemoveElementsText() {
        return obj.linkAddRemoveElements.getText().trim();
    }

    public void clickAddRemoveElements() {
        obj.linkAddRemoveElements.click();
    }

    public String getLinkTextAddRemoveElementsExpected() {
        return obj.linkTextAddRemoveElementsExpected;
    }

    public String getBasicAuthText() {
        return obj.linkBasicAuth.getText().trim();
    }

    public void clickBasicAuth() {
        obj.linkBasicAuth.click();
    }

    public String getLinkTextBasicAuthExpected() {
        return obj.linkTextBasicAuthExpected;
    }

    public String getBrokenImagesText() {
        return obj.linkBrokenImages.getText().trim();
    }

    public void clickBrokenImages() {
        obj.linkBrokenImages.click();
    }

    public String getLinkTextBrokenImagesExpected() {
        return obj.linkTextBrokenImagesExpected;
    }
}
