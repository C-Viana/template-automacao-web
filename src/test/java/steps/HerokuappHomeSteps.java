package steps;

import common.General;
import common.StaticResources;
import pages.HerokuappHomePage;
import reporter.ReportManager;

import org.junit.Assert;

import io.cucumber.java.en.*;

public class HerokuappHomeSteps {
    private HerokuappHomePage home = null;
    
    public HerokuappHomeSteps() {
        home = new HerokuappHomePage();
    }
    
    @Given("que abri a página Herokuapp")
    public void queAbriAPaginaHerokuapp() {
        General.goTo(StaticResources.HEROKUAPP);
        Assert.assertEquals(home.getTitleExpected(), home.getTitle());
        ReportManager.setTestStep(General.getScenario().getStatus(), "Dado que abri a página HerokuApp");
    }

    @When("acessar o link AB Testing")
    public void acessarOLinkABTesting() {
        Assert.assertEquals(home.getLinkTextABTestingExpected(), home.getABTestingLinkText());
        home.clickABTestingLink();
        ReportManager.setTestStep(General.getScenario().getStatus(), "Quando acessar o link A/B Testing");
    }

    @When("acessar o link Add-Remove Elements")
    public void acessarOLinkAddRemoveElements() {
        Assert.assertEquals(home.getLinkTextAddRemoveElementsExpected(), home.getAddRemoveElementsText());
        home.clickAddRemoveElements();
        ReportManager.setTestStep(General.getScenario().getStatus(), "Quando acessar o link Add/Remove Elements");
    }

    @When("acessar o link Basic Auth")
    public void acessarOLinkBasicAuth() {
        Assert.assertEquals(home.getLinkTextBasicAuthExpected(), home.getBasicAuthText());
        home.clickBasicAuth();
        ReportManager.setTestStep(General.getScenario().getStatus(), "Quando acessar o link Basic Auth");
    }

    @When("acessar o link Broken Images")
    public void acessarOLinkBrokenImages() {
        Assert.assertEquals(home.getLinkTextBrokenImagesExpected(), home.getBrokenImagesText());
        home.clickBrokenImages();
        ReportManager.setTestStep(General.getScenario().getStatus(), "Quando acessar o link Broken Images");
    }

    @When("acessar o link Challenging DOM")
    public void acessarOLinkChallengingDOM() {
        Assert.assertEquals(home.getLinkTextChallengingDOMExpected(), home.getChallengingDOMText());
        home.clickChallengingDOM();
        ReportManager.setTestStep(General.getScenario().getStatus(), "Quando acessar o link Challenging DOM");
    }

    @When("acessar o link Checkboxes")
    public void acessarOLinkCheckboxes() {
        Assert.assertEquals(home.getLinkTextCheckboxesExpected(), home.getCheckboxesText());
        home.clickCheckboxes();
        ReportManager.setTestStep(General.getScenario().getStatus(), "Quando acessar o link Challenging DOM");
    }

    @When("acessar o link Context Menu")
    public void acessarOLinkContextMenu() {
        Assert.assertEquals(home.getLinkTextContextMenuExpected(), home.getContextMenuText());
        home.clickContextMenu();
        ReportManager.setTestStep(General.getScenario().getStatus(), "Quando acessar o link Context Menu");
    }

    @When("acessar o link Digest Authentication")
    public void acessarOLinkDigestAuthentication() {
        Assert.assertEquals(home.getLinkTextDigestAuthenticationExpected(), home.getDigestAuthenticationText());
        home.clickDigestAuthentication();
        ReportManager.setTestStep(General.getScenario().getStatus(), "Quando acessar o link Digest Authentication");
    }

    @When("acessar o link Disappearing Elements")
    public void acessarOLinkDisappearingElements() {
        Assert.assertEquals(home.getLinkTextDisappearingElementsExpected(), home.getDisappearingElementsText());
        home.clickDisappearingElements();
        ReportManager.setTestStep(General.getScenario().getStatus(), "Quando acessar o link Disappearing Elements");
    }

    @When("acessar o link Drag and Drop")
    public void acessarOLinkDragAndDrop() {
        Assert.assertEquals(home.getLinkTextDragAndDropExpected(), home.getDragAndDropText());
        home.clickDragAndDrop();
        ReportManager.setTestStep(General.getScenario().getStatus(), "Quando acessar o link Drag and Drop");
    }

    @When("acessar o link Dropdown")
    public void acessarOLinkDropdown() {
        Assert.assertEquals(home.getLinkTextDropdownExpected(), home.getDropdownText());
        home.clickDropdown();
        ReportManager.setTestStep(General.getScenario().getStatus(), "Quando acessar o link Dropdown");
    }

    @When("acessar o link Dynamic Content")
    public void acessarOLinkDynamicContent() {
        Assert.assertEquals(home.getLinkTextDynamicContentExpected(), home.getDynamicContentText());
        home.clickDynamicContent();
        ReportManager.setTestStep(General.getScenario().getStatus(), "Quando acessar o link Dynamic Content");
    }

    @When("acessar o link Dynamic Controls")
    public void acessarOLinkDynamicControls() {
        Assert.assertEquals(home.getLinkTextDynamicControlsExpected(), home.getDynamicControlsText());
        home.clickDynamicControls();
        ReportManager.setTestStep(General.getScenario().getStatus(), "Quando acessar o link Dynamic Controls");
    }

    @When("acessar o link Dynamic Loading")
    public void acessarOLinkDynamicLoading() {
        Assert.assertEquals(home.getLinkTextDynamicLoadingExpected(), home.getDynamicLoadingText());
        home.clickDynamicLoading();
        ReportManager.setTestStep(General.getScenario().getStatus(), "Quando acessar o link Dynamic Loading");
    }

    @When("acessar o link Entry Ad")
    public void acessarOLinkEntryAd() {
        Assert.assertEquals(home.getLinkTextEntryAdExpected(), home.getEntryAdText());
        home.clickEntryAd();
        ReportManager.setTestStep(General.getScenario().getStatus(), "Quando acessar o link Entry Ad");
    }

    @When("acessar o link Exit Intent")
    public void acessarOLinkExitIntent() {
        Assert.assertEquals(home.getLinkTextExitIntentExpected(), home.getExitIntentText());
        home.clickExitIntent();
        ReportManager.setTestStep(General.getScenario().getStatus(), "Quando acessar o link Exit Intent");
    }

    @When("acessar o link File Download")
    public void acessarOLinkFileDownload() {
        Assert.assertEquals(home.getLinkTextFileDownloadExpected(), home.getFileDownloadText());
        home.clickFileDownload();
        ReportManager.setTestStep(General.getScenario().getStatus(), "Quando acessar o link File Download");
    }

    @When("acessar o link File Upload")
    public void acessarOLinkFileUpload() {
        Assert.assertEquals(home.getLinkTextFileUploadExpected(), home.getFileUploadText());
        home.clickFileUpload();
        ReportManager.setTestStep(General.getScenario().getStatus(), "Quando acessar o link File Upload");
    }

    @When("acessar o link Frames")
    public void acessarOLinkFrames() {
        Assert.assertEquals(home.getLinkTextFramesExpected(), home.getFramesText());
        home.clickFrames();
        ReportManager.setTestStep(General.getScenario().getStatus(), "Quando acessar o link Frames");
    }

    @When("acessar o link Horizontal Slider")
    public void acessarOLinkHorizontalSlider() {
        Assert.assertEquals(home.getLinkTextHorizontalSliderExpected(), home.getHorizontalSliderText());
        home.clickHorizontalSlider();
        ReportManager.setTestStep(General.getScenario().getStatus(), "Quando acessar o link Horizontal Slider");
    }

    @When("acessar o link Hover")
    public void acessarOLinkHover() {
        Assert.assertEquals(home.getLinkTextHoverExpected(), home.getHoverText());
        home.clickHover();
        ReportManager.setTestStep(General.getScenario().getStatus(), "Quando acessar o link Hover");
    }

    @When("acessar o link JQuery UI")
    public void acessarOLinkJQueryUI() {
        Assert.assertEquals(home.getLinkTextJQueryUIExpected(), home.getJQueryUIText());
        home.clickJQueryUI();
        ReportManager.setTestStep(General.getScenario().getStatus(), "Quando acessar o link JQuery UI");
    }

    @When("acessar o link JavaScript Alerts")
    public void acessarOLinkJavaScriptAlerts() {
        Assert.assertEquals(home.getLinkTextJavaScriptAlertsExpected(), home.getJavaScriptAlertsText());
        home.clickJavaScriptAlerts();
        ReportManager.setTestStep(General.getScenario().getStatus(), "Quando acessar o link JavaScript Alerts");
    }

}
