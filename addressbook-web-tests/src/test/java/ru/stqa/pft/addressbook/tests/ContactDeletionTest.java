package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.PersonalData;

import java.util.HashSet;
import java.util.List;

import static java.lang.Thread.sleep;

public class ContactDeletionTest extends TestBase{
  @Test
  public void testContactDeletion() throws InterruptedException {
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().getContactLists();
    int contactNumber= app.getContactHelper().getTotalNumberofContact();
    List<PersonalData> contactListBefore = app.getContactHelper().getContactList();
    if(contactListBefore.size() < 1){
      app.getContactHelper().createContact();
      contactListBefore = app.getContactHelper().getContactList();
    }
    app.getContactHelper().selectContact(contactNumber-1);
    app.getContactHelper().deleteContact();

    app.getNavigationHelper().gotoHomePage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before-1);


    contactListBefore.remove(contactNumber-1);

    List<PersonalData> contactListAfter = app.getContactHelper().getContactList();
    Assert.assertEquals(contactListAfter.size(),contactListBefore.size());

    Assert.assertEquals(new HashSet<>(contactListAfter),new HashSet<>(contactListBefore));
  }
}
