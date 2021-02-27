package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.PersonalData;

import java.util.Date;

import static java.lang.Thread.sleep;

public class ContactHelper extends BaseHelper {

  public ContactHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void fillContactForm(PersonalData personalData) {
    type(By.name("firstname"),personalData.getName() + new Date());
    type(By.name("lastname"),personalData.getSurname());
    type(By.name("company"),personalData.getCompany());
    click(By.name("address"));
    type(By.name("home"),personalData.getTel());
    type(By.name("email"),personalData.getEmail());
    click(By.name("bday"));
    new Select(wd.findElement(By.name("bday"))).selectByVisibleText(personalData.getDay());
    //bday.selectByVisibleText(personalData.getDay());


    //click(By.xpath("//option[@value='22']"));
    //click(By.name("bmonth"));
    new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(personalData.getMonth());
    //click(By.xpath("//option[@value='May']"));
    type(By.name("byear"),personalData.getYear());
    type(By.name("address2"),personalData.getAddress());
  }

  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"),groupData.getName());
    type(By.name("group_header"),groupData.getHeader());
    type(By.name("group_footer"),groupData.getFooter());
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
}