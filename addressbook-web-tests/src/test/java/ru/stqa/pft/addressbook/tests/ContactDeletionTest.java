package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import static java.lang.Thread.sleep;

public class ContactDeletionTest extends TestBase{
  @Test
  public void testContactDeletion() throws InterruptedException {
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().getContactLists();
    int contactNumber= app.getContactHelper().getTotalNumberofContact();
    if(contactNumber < 1){
      app.getContactHelper().createContact();
    }
    app.getContactHelper().selectFirstContact();
    app.getContactHelper().deleteContact();
    sleep(5000);
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before-1);
  }
}
