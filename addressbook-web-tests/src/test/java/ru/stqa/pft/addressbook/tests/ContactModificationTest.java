package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.PersonalData;

import java.util.Date;

public class ContactModificationTest extends TestBase {

  @Test
  public void testContactModification(){
    app.getContactHelper().getContactLists();
    int contactNumber= app.getContactHelper().getTotalNumberofContact();
    app.getContactHelper().selectFirstContact();
    app.getContactHelper().editFirstContact();
    PersonalData personalData = new PersonalData("Nicole", "Mustermann1" + new Date(), "MiniCompany1", "0049177558853", "test1@google.com", "5", "May", "1983", "Bahnhof Street 5\nBad-Durkheim");
    app.getContactHelper().fillContactForm(personalData);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
  }
}
