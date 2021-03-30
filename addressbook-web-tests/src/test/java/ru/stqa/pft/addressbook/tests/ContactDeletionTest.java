package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import static java.lang.Thread.sleep;

public class ContactDeletionTest extends TestBase{

  @BeforeMethod
  public void ensurePreconditions(){
    app.getContactHelper().getContactLists();
    int contactNumber= app.getContactHelper().getTotalNumberofContact();
    if(contactNumber < 1){
      app.getContactHelper().createContact();
    }
  }
  @Test
  public void testContactDeletion() throws InterruptedException {
    app.getContactHelper().getContactLists();
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().selectFirstContact();
    app.getContactHelper().deleteContact();
    app.getContactHelper().getContactLists();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before-1);
  }
}
