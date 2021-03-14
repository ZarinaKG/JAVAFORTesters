package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.PersonalData;

import java.util.Date;

public class ContactModificationTest extends TestBase {

  @Test
  public void testContactModification(){
    app.getContactHelper().getContactLists();
    int contactNumber= app.getContactHelper().getTotalNumberofContact();
    app.getContactHelper().selectContact(contactNumber);
    app.getContactHelper().editContact(contactNumber);
    PersonalData personalData = new PersonalData("Nicole", "Mustermann1",null);
    app.getContactHelper().fillContactForm(personalData);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
  }
}
