package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactDeletionTest extends TestBase{
  @Test
  public void testContactDeletion(){
    int before = app.getGroupHelper().getGroupCount();
    app.getContactHelper().getContactLists();
    int contactNumber= app.getContactHelper().getTotalNumberofContact();
    app.getContactHelper().selectContact(contactNumber);
    app.getContactHelper().deleteContact();
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before-1);
  }
}
