package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.PersonalData;
import ru.stqa.pft.addressbook.model.Persons;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.*;

public class ContactDeletionTest extends TestBase{

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().gotoHomePage();
    if(app.contact().all().size() < 1){
      app.contact().createContact();
    }
  }

  @Test
  public void testContactDeletion() throws InterruptedException {

    Persons contactListBefore = app.contact().all();

    PersonalData deletePerson = contactListBefore.iterator().next();
    app.contact().delete(deletePerson);

    app.goTo().gotoHomePage();
    Persons contactListAfter = app.contact().all();

    assertThat(contactListAfter.size(),equalTo(contactListBefore.size() - 1));

    assertThat(contactListAfter,equalTo(contactListBefore.without(deletePerson)));
  }
}
