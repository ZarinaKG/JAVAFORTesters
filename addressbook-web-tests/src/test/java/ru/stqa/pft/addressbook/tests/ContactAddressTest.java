package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.PersonalData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddressTest extends TestBase{
  @Test
  public void testContactPhones(){
    app.goTo().gotoHomePage();
    PersonalData contact=app.contact().all().iterator().next();
    PersonalData contactInfoFromEditForm=app.contact().infoFromEditForm(contact);
    assertThat(contact.getAddress(), equalTo(cleaned(contactInfoFromEditForm.getAddress())));
   // assertThat(contact.getAddressSecondary(), equalTo(cleaned(contactInfoFromEditForm.getAddressSecondary())));

  }
  public String cleaned(String address){
    return address;
  }
}
