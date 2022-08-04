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
        ReportManager.setStepName(new Object(){}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        Assert.assertEquals(page.getExpectedTextTitle(), page.getTitle().getText().trim());
    }

    @And("arrasto o componente A para a posição do componente B")
    public void arrastoComponenteAParaPosicaoComponenteB() {
        ReportManager.setStepName(new Object(){}.getClass().getEnclosingMethod().getAnnotations()[0].toString());
        page.arrastarElementoAParaElementoB("DragAndDrop_A.png", "DragAndDrop_B.png");
        Assert.assertEquals(page.getExpectedTextBoxB(), page.getTextBoxA());
        Assert.assertEquals(page.getExpectedTextBoxA(), page.getTextBoxB());
    }

    

}
