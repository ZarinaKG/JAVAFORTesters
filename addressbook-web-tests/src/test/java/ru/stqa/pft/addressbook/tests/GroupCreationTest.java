package ru.stqa.pft.addressbook.tests;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;
import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

public class GroupCreationTest extends TestBase{

  @DataProvider
  public Iterator<Object[]> validGroupsFromXml() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.xml")));
    String xml = "";
    String line = reader.readLine();
    while(line!=null){
     xml +=line;
     line=reader.readLine();
   }
    XStream xStream = new XStream();
    xStream.processAnnotations(GroupData.class);
    List<GroupData> groups= (List<GroupData>)xStream.fromXML(xml);
    return groups.stream().map((g)-> new Object[]{g}).collect(Collectors.toList()).iterator();
  }

  @DataProvider
  public Iterator<Object[]> validGroupsFromJson() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.json")));
    String json = "";
    String line = reader.readLine();
    while(line!=null){
      json +=line;
      line=reader.readLine();
    }
    Gson gson = new Gson();
    List<GroupData> groups = gson.fromJson(json,new TypeToken<List<GroupData>>(){}.getType()); //List<GroupData>.class
    return groups.stream().map((g)-> new Object[]{g}).collect(Collectors.toList()).iterator();
  }

  @Test(dataProvider = "validGroupsFromJson")
  public void testGroupCreation(GroupData group) throws Exception {
    //GroupData groupData = new GroupData().withName("test1").withHeader("header 1").withFooter("footer 1");
    app.goTo().GroupPage();
    Groups before = app.group().all();
    app.group().createGroup(group);
    assertThat(app.group().count(),equalTo(before.size()+1));
    String[] names = new String[] {"test1'", "test2","test3"};
    Groups  after = app.group().all();
    assertThat(after,equalTo(
              before.withAdded(group.withId(after.stream().mapToInt((g) ->g.getId()).max().getAsInt()))));
  }

  @Test
  public void testBadGroupCreation() throws Exception {
    app.goTo().GroupPage();
    Groups before = app.group().all();
    GroupData groupData = new GroupData().withName("test1'").withHeader("test" +System.currentTimeMillis());
    app.group().createGroup(groupData);
    assertThat(app.group().count(),equalTo(before.size()));
    Groups  after = app.group().all();
    assertThat(after,equalTo(before));
  }
}
