package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.PersonalData;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import static java.lang.Thread.sleep;

public class ContactHelper extends BaseHelper {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void fillContactForm(PersonalData personalData, boolean creation) {
    type(By.name("firstname"),personalData.getName());
    type(By.name("lastname"),personalData.getSurname());

    if(creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(personalData.getGroup());
    }
    else
      Assert.assertFalse(isElementPresent(By.name("new_group")));
  }



  public void returnToHomePage() {
    click(By.linkText("home page"));
  }

  public void submitContactCreation() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }
  public void getContactLists() {
    click(By.linkText("home"));
  }
  public int getTotalNumberofContact(){
    String lastContact=wd.findElement(By.id("search_count")).getText();
    int totalNumberOfContact = Integer.parseInt(lastContact);
    return totalNumberOfContact;
  }
  public void selectFirstContact() {
    click(By.cssSelector("input[type='checkbox']"));
  }
  public void deleteContact() {
    click(By.cssSelector("input[type='button'][value='Delete']"));
    wd.switchTo().alert().accept();
  }
  public void editContact(int n){

    wd.findElements(By.cssSelector("a[href^='edit.php?id=']")).get(n).click();
  }
  public void submitContactModification() {
    click(By.cssSelector("input[type='submit'][value='Update']"));
  }

  public int getContactCount() {
    List<WebElement> elements = wd.findElements(By.name("selected[]"));
    return elements.size();
  }

  public void createContact(){

    initContactCreation();
    fillContactForm(new PersonalData("Nicole", "Mustermann","test1"), true);
    submitContactCreation();
    returnToHomePage();
  }
}