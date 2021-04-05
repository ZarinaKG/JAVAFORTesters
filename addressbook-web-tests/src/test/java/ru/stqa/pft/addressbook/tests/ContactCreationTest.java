package ru.stqa.pft.addressbook.tests;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.PersonalData;
import ru.stqa.pft.addressbook.model.Persons;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;


public class ContactCreationTest extends TestBase{

  @DataProvider
  public Iterator<Object[]> validContactsFromXml() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")));
    String xml = "";
    String line = reader.readLine();
    while(line!=null){
      xml +=line;
      line=reader.readLine();
    }
    XStream xStream = new XStream();
    xStream.processAnnotations(PersonalData.class);
    List<PersonalData> contacts= (List<PersonalData>)xStream.fromXML(xml);
    return contacts.stream().map((g)-> new Object[]{g}).collect(Collectors.toList()).iterator();
  }



  private static final String GROUP_NAME = "test1";

  @BeforeMethod
  public void ensurePreconditions(){

    app.goTo().GroupPage();
    if(app.group().all().size() < 1){
      app.group().createGroup(new GroupData().withName(GROUP_NAME));
    }
    app.goTo().gotoHomePage();

  }

  @Test(dataProvider = "validContactsFromXml")
  public void testContactCreation(PersonalData personalData) throws Exception {
    Persons before = app.contact().all();
    //PersonalData personalData = new PersonalData("Nicole", System.currentTimeMillis()  + "",GROUP_NAME);
    app.contact().createContact(personalData);
    before.add(personalData);
    Persons after = app.contact().all();
    assertThat(after.size(),equalTo(before.size()));
    assertThat(after, equalTo( before.withAdded(after.stream().max((p1, p2) -> Integer.compare(p1.getId(), p2.getId())).get())));
  }

  @Test
  public void testCurrentDir(){
    File currentDir = new File(".");
    System.out.println("currentDir = " + currentDir.getAbsolutePath());
    File photo = new File("src/resources/test.jpg");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());
  }

}
