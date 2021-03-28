package ru.stqa.pft.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.PersonalData;
import ru.stqa.pft.addressbook.model.Persons;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

import java.util.HashSet;
import java.util.List;

public class ContactCreationTest extends TestBase{

  private static final String GROUP_NAME = "test1";

  @BeforeMethod
  public void ensurePreconditions(){

    app.goTo().GroupPage();
    if(app.group().all().size() < 1){
      app.group().createGroup(new GroupData().withName(GROUP_NAME));
    }
    app.goTo().gotoHomePage();

  }

  @Test(enabled = false)
  public void testContactCreation() throws Exception {


    Persons before = app.contact().all();
    PersonalData personalData = new PersonalData("Nicole", System.currentTimeMillis()  + "",GROUP_NAME);
    app.contact().createContact(personalData);
    before.add(personalData);

    Persons after = app.contact().all();
    assertThat(after.size(),equalTo(before.size()));

    assertThat(after, equalTo( before.withAdded(after.stream().max((p1, p2) -> Integer.compare(p1.getId(), p2.getId())).get())));
  }


}
