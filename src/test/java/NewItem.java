import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class NewItem {
    @Test
    public void testCreateNewItem() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        WebElement createNewItemButton= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//span[@class='task-icon-link']")));
        createNewItemButton.click();

        WebElement writeNameOfItem = getDriver().findElement(By.id("name"));
        writeNameOfItem.sendKeys("Мой проект");
        WebElement chooseProject = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("label")));
        chooseProject.click();
        WebElement pushOkButton=wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[@class='btn-decorator']")));
        pushOkButton.click();
        WebElement saveChanges=getDriver().findElement(By.className("jenkins-button--primary"));
        saveChanges.click();
        Thread.sleep(3000);

        String sucessMesageOfNewProject=getDriver().findElement(By.className("job-index-headline")).getText();
        Assert.assertEquals(sucessMesageOfNewProject,"Project Мой проект");
        Thread.sleep(5000);

        WebElement returnToDashboard= getDriver().findElement(By.linkText("Dashboard"));
        returnToDashboard.click();
        createNewItemButton.click();


        writeNameOfItem.sendKeys("Мой проект");
        chooseProject.click();
        pushOkButton.click();
        saveChanges.click();
        Thread.sleep(50000);

        String effortMessage=getDriver().getTitle();
        Assert.assertEquals(effortMessage,"HTTP ERROR 403 No valid crumb was included in the request");
    }
}
}
