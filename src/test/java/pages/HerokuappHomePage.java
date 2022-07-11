package pages;

import driver.Driver;
import objects.HerokuappHome;

import org.openqa.selenium.support.PageFactory;

public class HerokuappHomePage extends HerokuappHome {
    
    public HerokuappHomePage() {
        PageFactory.initElements( Driver.get(), this );
    }

    public String getTitle() {
        return pageTitle.getText().trim();
    }

    public String getSubtitle() {
        return pageSubtitle.getText().trim();
    }

    public String getTitleExpected() {
        return txtPageTitleExpected;
    }

    public String getSubtitleExpected() {
        return txtPageSubtitleExpected;
    }

    public String getABTestingLinkText() {
        return linkABTesting.getText().trim();
    }

    public void clickABTestingLink() {
        linkABTesting.click();
    }

    public String getLinkTextABTestingExpected() {
        return linkTextABTestingExpected;
    }

    public String getAddRemoveElementsText() {
        return linkAddRemoveElements.getText().trim();
    }

    public void clickAddRemoveElements() {
        linkAddRemoveElements.click();
    }

    public String getLinkTextAddRemoveElementsExpected() {
        return linkTextAddRemoveElementsExpected;
    }

    public String getBasicAuthText() {
        return linkBasicAuth.getText().trim();
    }

    public void clickBasicAuth() {
        linkBasicAuth.click();
    }

    public String getLinkTextBasicAuthExpected() {
        return linkTextBasicAuthExpected;
    }

    public String getBrokenImagesText() {
        return linkBrokenImages.getText().trim();
    }

    public void clickBrokenImages() {
        linkBrokenImages.click();
    }

    public String getLinkTextBrokenImagesExpected() {
        return linkTextBrokenImagesExpected;
    }

    public String getChallengingDOMText() {
        return linkChallengingDOM.getText().trim();
    }

    public void clickChallengingDOM() {
        linkChallengingDOM.click();
    }

    public String getLinkTextChallengingDOMExpected() {
        return linkTextChallengingDOMExpected;
    }

    public String getCheckboxesText() {
        return linkCheckboxes.getText().trim();
    }

    public void clickCheckboxes() {
        linkCheckboxes.click();
    }

    public String getLinkTextCheckboxesExpected() {
        return linkTextCheckboxesExpected;
    }

    public String getContextMenuText() {
        return linkContextMenu.getText().trim();
    }

    public void clickContextMenu() {
        linkContextMenu.click();
    }

    public String getLinkTextContextMenuExpected() {
        return linkTextContextMenuExpected;
    }

    public String getDigestAuthenticationText() {
        return linkDigestAuthentication.getText().trim();
    }

    public void clickDigestAuthentication() {
        linkDigestAuthentication.click();
    }

    public String getLinkTextDigestAuthenticationExpected() {
        return linkTextDigestAuthenticationExpected;
    }

    public String getDisappearingElementsText() {
        return linkDisappearingElements.getText().trim();
    }

    public void clickDisappearingElements() {
        linkDisappearingElements.click();
    }

    public String getLinkTextDisappearingElementsExpected() {
        return linkTextDisappearingElementsExpected;
    }

    public String getDragAndDropText() {
        return linkDragAndDrop.getText().trim();
    }

    public void clickDragAndDrop() {
        linkDragAndDrop.click();
    }

    public String getLinkTextDragAndDropExpected() {
        return linkTextDragAndDropExpected;
    }

    public String getDropdownText() {
        return linkDropdown.getText().trim();
    }

    public void clickDropdown() {
        linkDropdown.click();
    }

    public String getLinkTextDropdownExpected() {
        return linkTextDropdownExpected;
    }

    public String getDynamicContentText() {
        return linkDynamicContent.getText().trim();
    }

    public void clickDynamicContent() {
        linkDynamicContent.click();
    }

    public String getLinkTextDynamicContentExpected() {
        return linkTextDynamicContentExpected;
    }

    public String getDynamicControlsText() {
        return linkDynamicControls.getText().trim();
    }

    public void clickDynamicControls() {
        linkDynamicControls.click();
    }

    public String getLinkTextDynamicControlsExpected() {
        return linkTextDynamicControlsExpected;
    }

    public String getDynamicLoadingText() {
        return linkDynamicLoading.getText().trim();
    }

    public void clickDynamicLoading() {
        linkDynamicLoading.click();
    }

    public String getLinkTextDynamicLoadingExpected() {
        return linkTextDynamicLoadingExpected;
    }

    public String getEntryAdText() {
        return linkEntryAd.getText().trim();
    }

    public void clickEntryAd() {
        linkEntryAd.click();
    }

    public String getLinkTextEntryAdExpected() {
        return linkTextEntryAdExpected;
    }

    public String getExitIntentText() {
        return linkExitIntent.getText().trim();
    }

    public void clickExitIntent() {
        linkExitIntent.click();
    }

    public String getLinkTextExitIntentExpected() {
        return linkTextExitIntentExpected;
    }

    public String getFileDownloadText() {
        return linkFileDownload.getText().trim();
    }

    public void clickFileDownload() {
        linkFileDownload.click();
    }

    public String getLinkTextFileDownloadExpected() {
        return linkTextFileDownloadExpected;
    }

    public String getFileUploadText() {
        return linkFileUpload.getText().trim();
    }

    public void clickFileUpload() {
        linkFileUpload.click();
    }

    public String getLinkTextFileUploadExpected() {
        return linkTextFileUploadExpected;
    }

    public String getFramesText() {
        return linkFrames.getText().trim();
    }

    public void clickFrames() {
        linkFrames.click();
    }

    public String getLinkTextFramesExpected() {
        return linkTextFramesExpected;
    }

    public String getHorizontalSliderText() {
        return linkHorizontalSlider.getText().trim();
    }

    public void clickHorizontalSlider() {
        linkHorizontalSlider.click();
    }

    public String getLinkTextHorizontalSliderExpected() {
        return linkTextHorizontalSliderExpected;
    }

    public String getHoverText() {
        return linkHover.getText().trim();
    }

    public void clickHover() {
        linkHover.click();
    }

    public String getLinkTextHoverExpected() {
        return linkTextHoverExpected;
    }

    public String getJQueryUIText() {
        return linkJQueryUI.getText().trim();
    }

    public void clickJQueryUI() {
        linkJQueryUI.click();
    }

    public String getLinkTextJQueryUIExpected() {
        return linkTextJQueryUIExpected;
    }

    public String getJavaScriptAlertsText() {
        return linkJavaScriptAlerts.getText().trim();
    }

    public void clickJavaScriptAlerts() {
        linkJavaScriptAlerts.click();
    }

    public String getLinkTextJavaScriptAlertsExpected() {
        return linkTextJavaScriptAlertsExpected;
    }
    
}
