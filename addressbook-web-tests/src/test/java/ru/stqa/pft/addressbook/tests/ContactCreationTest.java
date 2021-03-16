package ru.stqa.pft.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.PersonalData;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

public class ContactCreationTest extends TestBase{

  @Test
  public void testContactCreation() throws Exception {
    int before = app.getContactHelper().getContactCount();

    List<PersonalData> contactListBefore = app.getContactHelper().getContactList();
    PersonalData personalData = new PersonalData("Nicole", System.currentTimeMillis()  + "","test1");
    app.getContactHelper().createContact(personalData);
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after,before+1);

    contactListBefore.add(personalData);

    List<PersonalData> contactListAfter = app.getContactHelper().getContactList();
    Assert.assertEquals(contactListAfter.size(),contactListBefore.size());

    Assert.assertEquals(new HashSet<>(contactListAfter),new HashSet<>(contactListBefore));
  }
}
