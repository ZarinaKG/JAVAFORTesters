package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.PersonalData;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

public class ContactModificationTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    List<PersonalData> contactListBefore = app.getContactHelper().getContactList();
    if(contactListBefore.size() < 1){
      app.getContactHelper().createContact();
    }
  }

  @Test
  public void testContactModification() throws InterruptedException {
    List<PersonalData> contactListBefore = app.getContactHelper().getContactList();
    app.getContactHelper().getContactLists();
    int contactNumber= app.getContactHelper().getTotalNumberofContact();
    //app.getContactHelper().selectContact(contactNumber-1);
    app.getContactHelper().editContact(contactNumber-1);
    PersonalData personalData = new PersonalData("Nicole", System.currentTimeMillis()  + "",null);
    app.getContactHelper().fillContactForm(personalData, false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
    String idModified = contactListBefore.remove(contactNumber-1).getId();
    personalData.setId(idModified);
    contactListBefore.add(personalData);

    List<PersonalData> contactListAfter = app.getContactHelper().getContactList();
    Assert.assertEquals(contactListAfter.size(),contactListBefore.size());

    Assert.assertEquals(new HashSet<>(contactListAfter),new HashSet<>(contactListBefore));

  }
}
