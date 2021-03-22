package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.PersonalData;
import ru.stqa.pft.addressbook.model.Persons;


import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.*;

public class ContactModificationTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){

    app.goTo().GroupPage();
    if(app.group().all().size() < 1){
      app.group().createGroup(new GroupData().withName("test1"));
    }
    app.goTo().gotoHomePage();
    Persons contactListBefore = app.contact().all();

    if(contactListBefore.size() < 1){
      app.contact().createContact();
    }

  }
  @Test
  public void testContactModification() throws InterruptedException {


    Persons contactListBefore = app.contact().all();
    PersonalData personToModify = contactListBefore.iterator().next();
    app.contact().modify(personToModify);
    PersonalData newPerson = new PersonalData().withName("Nicole").withSurname( System.currentTimeMillis()  + "").withGroup("test1");
    app.contact().fillContactForm(newPerson, false);
    app.contact().submitContactModification();
    app.contact().returnToHomePage();
    newPerson.withId(personToModify.getId());

    Persons contactListAfter = app.contact().all();
    assertEquals(contactListAfter.size(),contactListBefore.size());

    assertThat(contactListAfter,equalTo(contactListBefore.without(personToModify).withAdded(newPerson)));

  }
}
