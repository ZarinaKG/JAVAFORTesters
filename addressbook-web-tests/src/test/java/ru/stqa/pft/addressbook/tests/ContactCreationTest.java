package ru.stqa.pft.addressbook.tests;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.PersonalData;

import java.util.Date;

public class ContactCreationTest extends TestBase{

  @Test
  public void testContactCreation() throws Exception {
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new PersonalData("Nicole", "Mustermann"  + new Date(), "MiniCompany", "0049177558855", "test@google.com", "5", "May", "1983", "Bahnhof Street 5\nBad-Durkheim"));
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
  }
}
