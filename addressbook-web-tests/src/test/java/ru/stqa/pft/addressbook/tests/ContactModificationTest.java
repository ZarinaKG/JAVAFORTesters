package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.PersonalData;

import java.util.Date;

public class ContactModificationTest extends TestBase {
  @BeforeMethod
  public void ensurePreconditions(){
    app.getContactHelper().getContactLists();
    int contactNumber= app.getContactHelper().getTotalNumberofContact();
    if(contactNumber < 1){
      app.getContactHelper().createContact();
    }
  }
  @Test
  public void testContactModification() throws InterruptedException {
    app.getContactHelper().getContactLists();
    int before = app.getContactHelper().getContactCount();

    //app.getContactHelper().selectContact(contactNumber-1);
    app.getContactHelper().editContact(before-1);
    PersonalData personalData = new PersonalData("Nicole", "Mustermann1",null);
    app.getContactHelper().fillContactForm(personalData, false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after,before);

  }
}
