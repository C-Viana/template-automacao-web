package steps;

import common.General;
import pages.DragAndDropPage;
import reporter.ReportManager;

import org.junit.Assert;

import io.cucumber.java.en.*;

public class DragAndDropSteps {

    private DragAndDropPage page = null;
    
    public DragAndDropSteps() {
        page = new DragAndDropPage();
    }

    @Then("confirmo o acesso à página Drag and Drop")
    public void confirmoAcessPaginaDragAndDrop() {
        General.waitToBeVisible(page.getTitle(), 5);
        Assert.assertEquals(page.getExpectedTextTitle(), page.getTitle().getText().trim());
        ReportManager.setTestStep(General.getScenario().getStatus(), "Então confirmo o acesso à página Drag and Drop");
    }

    @And("arrasto o componente A para a posição do componente B")
    public void arrastoComponenteAParaPosicaoComponenteB() {
        General.dragElementTo(page.getBoxA(), page.getBoxB());
        Assert.assertEquals(page.getExpectedTextBoxB(), page.getTextBoxA());
        Assert.assertEquals(page.getExpectedTextBoxA(), page.getTextBoxB());
        ReportManager.setTestStep(General.getScenario().getStatus(), "E arrasto o componente 'A' para a posição do componente 'B'");
    }

    

}
