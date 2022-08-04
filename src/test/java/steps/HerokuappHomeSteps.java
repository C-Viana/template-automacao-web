package steps;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.HerokuappHomePage;
import reporter.ReportManager;

public class HerokuappHomeSteps {
    private HerokuappHomePage home = null;
    
    public HerokuappHomeSteps() {
        home = new HerokuappHomePage();
    }
    
    @Given("que abri a página Herokuapp")
    public void queAbriAPaginaHerokuapp() {
        ReportManager.setStepName(new Object() {}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        Assert.assertEquals(home.getTitleExpected(), home.getTitle());
    }

    @When("acessar o link AB Testing")
    public void acessarOLinkABTesting() {
        ReportManager.setStepName(new Object() {}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        Assert.assertEquals(home.getLinkTextABTestingExpected(), home.getABTestingLinkText());
        home.clickABTestingLink();
    }

    @When("acessar o link Add-Remove Elements")
    public void acessarOLinkAddRemoveElements() {
        ReportManager.setStepName(new Object() {}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        Assert.assertEquals(home.getLinkTextAddRemoveElementsExpected(), home.getAddRemoveElementsText());
        home.clickAddRemoveElements();
    }

    @When("acessar o link Basic Auth")
    public void acessarOLinkBasicAuth() {
        ReportManager.setStepName(new Object() {}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        Assert.assertEquals(home.getLinkTextBasicAuthExpected(), home.getBasicAuthText());
        home.clickBasicAuth();
    }

    @When("acessar o link Broken Images")
    public void acessarOLinkBrokenImages() {
        ReportManager.setStepName(new Object() {}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        Assert.assertEquals(home.getLinkTextBrokenImagesExpected(), home.getBrokenImagesText());
        home.clickBrokenImages();
    }

    @When("acessar o link Challenging DOM")
    public void acessarOLinkChallengingDOM() {
        ReportManager.setStepName(new Object() {}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        Assert.assertEquals(home.getLinkTextChallengingDOMExpected(), home.getChallengingDOMText());
        home.clickChallengingDOM();
    }

    @When("acessar o link Checkboxes")
    public void acessarOLinkCheckboxes() {
        ReportManager.setStepName(new Object() {}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        Assert.assertEquals(home.getLinkTextCheckboxesExpected(), home.getCheckboxesText());
        home.clickCheckboxes();
    }

    @When("acessar o link Context Menu")
    public void acessarOLinkContextMenu() {
        ReportManager.setStepName(new Object() {}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        Assert.assertEquals(home.getLinkTextContextMenuExpected(), home.getContextMenuText());
        home.clickContextMenu();
    }

    @When("acessar o link Digest Authentication")
    public void acessarOLinkDigestAuthentication() {
        ReportManager.setStepName(new Object() {}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        Assert.assertEquals(home.getLinkTextDigestAuthenticationExpected(), home.getDigestAuthenticationText());
        home.clickDigestAuthentication();
    }

    @When("acessar o link Disappearing Elements")
    public void acessarOLinkDisappearingElements() {
        ReportManager.setStepName(new Object() {}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        Assert.assertEquals(home.getLinkTextDisappearingElementsExpected(), home.getDisappearingElementsText());
        home.clickDisappearingElements();
    }

    @When("acessar o link Drag and Drop")
    public void acessarOLinkDragAndDrop() {
        ReportManager.setStepName(new Object() {}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        Assert.assertEquals(home.getLinkTextDragAndDropExpected(), home.getDragAndDropText());
        home.clickDragAndDrop();
    }

    @When("acessar o link Dropdown")
    public void acessarOLinkDropdown() {
        ReportManager.setStepName(new Object() {}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        Assert.assertEquals(home.getLinkTextDropdownExpected(), home.getDropdownText());
        home.clickDropdown();
    }

    @When("acessar o link Dynamic Content")
    public void acessarOLinkDynamicContent() {
        ReportManager.setStepName(new Object() {}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        Assert.assertEquals(home.getLinkTextDynamicContentExpected(), home.getDynamicContentText());
        home.clickDynamicContent();
    }

    @When("acessar o link Dynamic Controls")
    public void acessarOLinkDynamicControls() {
        ReportManager.setStepName(new Object() {}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        Assert.assertEquals(home.getLinkTextDynamicControlsExpected(), home.getDynamicControlsText());
        home.clickDynamicControls();
    }

    @When("acessar o link Dynamic Loading")
    public void acessarOLinkDynamicLoading() {
        ReportManager.setStepName(new Object() {}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        Assert.assertEquals(home.getLinkTextDynamicLoadingExpected(), home.getDynamicLoadingText());
        home.clickDynamicLoading();
    }

    @When("acessar o link Entry Ad")
    public void acessarOLinkEntryAd() {
        ReportManager.setStepName(new Object() {}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        Assert.assertEquals(home.getLinkTextEntryAdExpected(), home.getEntryAdText());
        home.clickEntryAd();
    }

    @When("acessar o link Exit Intent")
    public void acessarOLinkExitIntent() {
        ReportManager.setStepName(new Object() {}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        Assert.assertEquals(home.getLinkTextExitIntentExpected(), home.getExitIntentText());
        home.clickExitIntent();
    }

    @When("acessar o link File Download")
    public void acessarOLinkFileDownload() {
        ReportManager.setStepName(new Object() {}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        Assert.assertEquals(home.getLinkTextFileDownloadExpected(), home.getFileDownloadText());
        home.clickFileDownload();
    }

    @When("acessar o link File Upload")
    public void acessarOLinkFileUpload() {
        ReportManager.setStepName(new Object() {}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        Assert.assertEquals(home.getLinkTextFileUploadExpected(), home.getFileUploadText());
        home.clickFileUpload();
    }

    @When("acessar o link Frames")
    public void acessarOLinkFrames() {
        ReportManager.setStepName(new Object() {}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        Assert.assertEquals(home.getLinkTextFramesExpected(), home.getFramesText());
        home.clickFrames();
    }

    @When("acessar o link Horizontal Slider")
    public void acessarOLinkHorizontalSlider() {
        ReportManager.setStepName(new Object() {}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        Assert.assertEquals(home.getLinkTextHorizontalSliderExpected(), home.getHorizontalSliderText());
        home.clickHorizontalSlider();
    }

    @When("acessar o link Hover")
    public void acessarOLinkHover() {
        ReportManager.setStepName(new Object() {}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        Assert.assertEquals(home.getLinkTextHoverExpected(), home.getHoverText());
        home.clickHover();
    }

    @When("acessar o link JQuery UI")
    public void acessarOLinkJQueryUI() {
        ReportManager.setStepName(new Object() {}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        Assert.assertEquals(home.getLinkTextJQueryUIExpected(), home.getJQueryUIText());
        home.clickJQueryUI();
    }

    @When("acessar o link JavaScript Alerts")
    public void acessarOLinkJavaScriptAlerts() {
        ReportManager.setStepName(new Object() {}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        Assert.assertEquals(home.getLinkTextJavaScriptAlertsExpected(), home.getJavaScriptAlertsText());
        home.clickJavaScriptAlerts();
    }

}
