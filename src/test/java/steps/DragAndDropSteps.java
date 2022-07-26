package steps;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.DragAndDropPage;
import reporter.ReportManager;

public class DragAndDropSteps {

    private DragAndDropPage page = null;
    
    public DragAndDropSteps() {
        page = new DragAndDropPage();
    }

    @Then("confirmo o acesso à página Drag and Drop")
    public void confirmoAcessPaginaDragAndDrop() {
        Assert.assertEquals(page.getExpectedTextTitle(), page.getTitle().getText().trim());
        ReportManager.setTestStep(ReportManager.getScenario().getStatus(), "Então confirmo o acesso à página Drag and Drop");
    }

    @And("arrasto o componente A para a posição do componente B")
    public void arrastoComponenteAParaPosicaoComponenteB() {
//    	BasePage.dragElementTo(page.getBoxA(), page.getBoxB());
        page.arrastarElementoAParaElementoB("DragAndDrop_A.png", "DragAndDrop_B.png");
        Assert.assertEquals(page.getExpectedTextBoxB(), page.getTextBoxA());
        Assert.assertEquals(page.getExpectedTextBoxA(), page.getTextBoxB());
        ReportManager.setTestStep(ReportManager.getScenario().getStatus(), "E arrasto o componente 'A' para a posição do componente 'B'");
    }

    

}
