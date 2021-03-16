package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.PersonalData;

import java.util.Date;

public class ContactModificationTest extends TestBase {

  @Test
  public void testContactModification() throws InterruptedException {
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().getContactLists();
    int contactNumber= app.getContactHelper().getTotalNumberofContact();
    if(contactNumber < 1){
      app.getContactHelper().createContact();
    }
    //app.getContactHelper().selectContact(contactNumber-1);
    app.getContactHelper().editContact(contactNumber-1);
    PersonalData personalData = new PersonalData("Nicole", "Mustermann1",null);
    app.getContactHelper().fillContactForm(personalData, false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after,before);

  }
}
