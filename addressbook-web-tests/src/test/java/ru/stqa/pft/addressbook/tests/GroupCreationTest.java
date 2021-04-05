package ru.stqa.pft.addressbook.tests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

public class GroupCreationTest extends TestBase{

  @DataProvider
  public Iterator<Object[]> validGroups() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.csv")));
   String line = reader.readLine();
   while(line!=null){
     String[] split = line.split(";");
     list.add(new Object[]{ new GroupData().withName(split[0]).withHeader(split[1]).withFooter(split[2])});

     line=reader.readLine();
   }
    return list.iterator();
  }

  @Test(dataProvider = "validGroups")
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
