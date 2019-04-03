package selenium.tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;

//import pages.FormPage;
//import pages.ListPage;

public class Task3Bonus {
    WebDriver driver;
//	ListPage listPage = PageFactory.initElements(driver, ListPage.class);
//     should contain what you see when you just open the page (the table with names/jobs)
//	FormPage formPage = PageFactory.initElements(driver, FormPage.class);
//     should be what you see if you click "Add" or "Edit" (2 input field and a button (Add/Edit) and (Cancel)

//    Bonus:
//    try storing people via an Object/separate class

    @Before
    public void openPage() {
        String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/tasks/list_of_people_with_jobs");
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void addPerson() throws InterruptedException {
        /* TODO:
         * implement adding new person using page object
         *
         * in order: store the list of people and jobs currently on page
         * add a person via "Add person button"
         * check the list again, that non of the people where changes, but an additional one with correct name/job was added
         */
        driver.findElement(By.id("addPersonBtn")).click();
        WebElement textName = driver.findElement(By.id("name"));
        WebElement textJob = driver.findElement(By.id("job"));

        textName.sendKeys("Jānis");
        textJob.sendKeys("Student");

        driver.findElement(By.id("modal_button")).click();


        Thread.sleep(5000);



    }

    @Test
    public void editPerson() {
        /* TODO:
         * implement editing a person using page object
         *
         * in order: store the list of people and jobs currently on page
         * edit one of existing persons via the edit link
         * check the list again and that 2 people stayed the same and the one used was changed
         */

        driver.findElement(By.id("addPersonBtn")).click();

        WebElement textName = driver.findElement(By.id("name"));
        WebElement textSurname = driver.findElement(By.id("surname"));
        WebElement textJob = driver.findElement(By.id("job"));
        WebElement textDate = driver.findElement(By.id("dob"));
        WebElement status1 = driver.findElement(By.id("status"));

        textName.sendKeys("Jānis");
        textSurname.sendKeys("Daukšts");
        textJob.sendKeys("Student");
        textDate.sendKeys("11/01/1995");

        Select dropdown = new Select(driver.findElement(By.id("status")));
        assertEquals("Employee", dropdown.getFirstSelectedOption().getText());
        dropdown.selectByVisibleText("Intern");

        driver.findElement(By.id("french")).click();
        driver.findElement(By.id("male")).click();


        driver.findElement(By.id("modal_button")).click();

    }

    @Test
    public void editPersonCancel() throws InterruptedException {
        /* TODO:
         * implement editing a person using page object
         *
         * in order: store the list of people and jobs currently on page
         * edit one of existing persons via the edit link then click "Cancel" on edit form instead of "Edit"
         * check the list again and that no changes where made
         */
        driver.findElement(By.id("#person0")).click();


        Thread.sleep(2000);


    }


    @Test
    public void deletePerson() {
        /* TODO:
         * implement deleting a person using page object
         *
         * in order: store the list of people and jobs currently on page
         * delete 1 person see that there are now 2 people in the table with correct data
         */
    }


    @Test
    public void deletePersonAll() {
        /* TODO:
         * implement deleting a person using page object
         *
         * in order: store the list of people and jobs currently on page
         * delete all people and check that there is no no table on page, but the button Add is still present and working
         */


    }
}
