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

    public String getABTestingLinkText() {
        return obj.linkABTesting.getText().trim();
    }

    public void clickABTestingLink() {
        obj.linkABTesting.click();
    }

    public String getTitleExpected() {
        return obj.txtPageTitleExpected;
    }

    public String getSubtitleExpected() {
        return obj.txtPageSubtitleExpected;
    }

    public String getLinkTextExpected() {
        return obj.linkTextABTestingExpected;
    }
}
