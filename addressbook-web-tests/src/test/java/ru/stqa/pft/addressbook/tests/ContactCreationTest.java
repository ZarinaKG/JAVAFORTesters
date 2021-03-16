package ru.stqa.pft.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.PersonalData;

import java.util.Date;

public class ContactCreationTest extends TestBase{

  @Test
  public void testContactCreation() throws Exception {
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().createContact();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after,before+1);
  }
}
