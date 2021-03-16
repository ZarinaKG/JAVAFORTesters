package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactDeletionTest extends TestBase{
  @Test
  public void testContactDeletion(){
    app.getContactHelper().getContactLists();
    int contactNumber= app.getContactHelper().getTotalNumberofContact();
    app.getContactHelper().selectFirstContact();
    app.getContactHelper().deleteContact();
  }
}
