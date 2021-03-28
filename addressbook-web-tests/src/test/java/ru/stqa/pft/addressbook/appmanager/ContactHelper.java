package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.PersonalData;
import ru.stqa.pft.addressbook.model.Persons;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
  public void selectContact(int n) {
    wd.findElements(By.cssSelector("input[type='checkbox']")).get(n).click();
  }
  public void selectContact(PersonalData personalData) {
    wd.findElement(By.cssSelector("input[value='"+personalData.getId()+"']")).click();
  }

  public PersonalData infoFromEditForm(PersonalData contact){
    initContactModification(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String homePhone = wd.findElement(By.name("home")).getAttribute("value");
    String mobilePhone= wd.findElement(By.name("mobile")).getAttribute("value");
    String workPhone = wd.findElement(By.name("work")).getAttribute("value");
    String privateEmail= wd.findElement(By.name("email")).getAttribute("value");
    String workEmail = wd.findElement(By.name("email2")).getAttribute("value");
    String hobbyEmail = wd.findElement(By.name("email3")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    String address2 = wd.findElement(By.name("address2")).getAttribute("value");
    wd.navigate().back();
    return new PersonalData().withId(contact.getId()).withName(firstname).withSurname(lastname)
            .withHomePhone(homePhone).withMobilePhone(mobilePhone).withWorkPhone(workPhone)
            .withPrivateEmail(privateEmail).withWorkEmail(workEmail).withHobbyEmail(hobbyEmail)
            .withAddress(address).withAddressSecondary(address2);
  }


  private void initContactModification(int id){
    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']",id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List <WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(7).findElement(By.tagName("a")).click();

    //wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']",id))).click();
  }
  public void deleteContact() {
    click(By.cssSelector("input[type='button'][value='Delete']"));
    wd.switchTo().alert().accept();
  }

  public void delete(PersonalData personalData) {
    selectContact(personalData);
    click(By.cssSelector("input[type='button'][value='Delete']"));
    wd.switchTo().alert().accept();
  }

  public void modify(PersonalData personalData){
    wd.findElement(By.cssSelector("a[href^='edit.php?id="+personalData.getId()+"']")).click();
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
    fillContactForm(new PersonalData("Nicole", System.currentTimeMillis()  + "","test1"), true);
    submitContactCreation();
    returnToHomePage();
  }

  public void createContact(PersonalData personalData){

    initContactCreation();
    fillContactForm(personalData, true);
    submitContactCreation();
    returnToHomePage();
  }

  public Persons all() {
    Persons personalDataList = new Persons();
    List<WebElement> elements = wd.findElement(By.id("maintable")).findElements(By.name("entry"));
   /* for (WebElement element:elements){
      List<WebElement> elementList = element.findElements(By.cssSelector("td"));
      String id = element.findElement(By.tagName("input")).getAttribute("value");
      PersonalData personalData = new PersonalData(Integer.parseInt(id), elementList.get(2).getText(), elementList.get(1).getText(), "");
      personalDataList.add(personalData);
    }
    */

    List<WebElement> rows = wd.findElements(By.name("entry"));
    for(WebElement row: rows){
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      String lastname = cells.get(1).getText();
      String firstname = cells.get(2).getText();
      String [] phones= cells.get(5).getText().split("\n");
      String address = cells.get(3).getText();
      String [] eMails= cells.get(4).getText().split("\n");
      personalDataList.add(new PersonalData().withId(id).withName(firstname).withSurname(lastname)
              .withHomePhone(phones[0]).withMobilePhone(phones[1]).withWorkPhone(phones[2])
              .withPrivateEmail(eMails[0]).withWorkEmail(eMails[1]).withHobbyEmail(eMails[2])
              .withAddress(address));
    }
    return personalDataList;
  }

/*
  public Set<PersonalData> all(){
    Set<PersonalData> contacts = new HashSet<PersonalData>();
    List<WebElement> rows = wd.findElements(By.name("entry"));
    for(WebElement row: rows){
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      String lastname = cells.get(1).getText();
      String firstname = cells.get(2).getText();
      String [] phones= cells.get(5).getText().split("\n");
      contacts.add(new PersonalData().withId(id).withName(firstname).withSurname(lastname)
              .withHomePhone(phones[0]).withMobilePhone(phones[1]).withWorkPhone(phones[2]));
    }
    return contacts;
  }
*/

}