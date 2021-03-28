package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.PersonalData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactEmailTest extends TestBase{
  @Test
  public void testContactPhones(){
    app.goTo().gotoHomePage();
    PersonalData contact=app.contact().all().iterator().next();
    PersonalData contactInfoFromEditForm=app.contact().infoFromEditForm(contact);
    assertThat(contact.getPrivateEmail(), equalTo(cleaned(contactInfoFromEditForm.getPrivateEmail())));
    assertThat(contact.getWorkEmail(), equalTo(cleaned(contactInfoFromEditForm.getWorkEmail())));
    assertThat(contact.getHobbyEmail(), equalTo(cleaned(contactInfoFromEditForm.getHobbyEmail())));
  }
  public String cleaned(String email){
    return email;
  }
}
