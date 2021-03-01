package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.PersonalData;

import java.util.Date;

import static java.lang.Thread.sleep;

public class ContactHelper extends BaseHelper {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void fillContactForm(PersonalData personalData) {
    type(By.name("firstname"),personalData.getName());
    type(By.name("lastname"),personalData.getSurname());
    type(By.name("company"),personalData.getCompany());
    click(By.name("address"));
    type(By.name("home"),personalData.getTel());
    type(By.name("email"),personalData.getEmail());
    click(By.name("bday"));
    new Select(wd.findElement(By.name("bday"))).selectByVisibleText(personalData.getDay());
    new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(personalData.getMonth());
    type(By.name("byear"),personalData.getYear());
    type(By.name("address2"),personalData.getAddress());
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
  public void selectContact(int n) {
    click(By.cssSelector("input[type='checkbox'][value='"+n+"']"));
  }
  public void deleteContact() {
    click(By.cssSelector("input[type='button'][value='Delete']"));
    wd.switchTo().alert().accept();
  }
  public void editContact(int n){
    click(By.cssSelector("a[href^='edit.php?id="+n+"']"));
  }
  public void submitContactModification() {
    click(By.cssSelector("input[type='submit'][value='Update']"));
  }
}