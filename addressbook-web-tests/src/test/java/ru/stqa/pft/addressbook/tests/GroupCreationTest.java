package ru.stqa.pft.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupCreationTest extends TestBase{

  @Test
  public void testGroupCreation() throws Exception {
    app.goTo().GroupPage();
    List<GroupData> before = app.group().list();
    GroupData groupData = new GroupData().withName("test1").withHeader("test" +System.currentTimeMillis());
    app.group().createGroup(groupData);
    List<GroupData>  after = app.group().list();
    Assert.assertEquals(after.size(), before.size()+1);
    before.add(groupData);
    HashSet<GroupData> beforeSet = new HashSet<>(before);
    Assert.assertEquals(beforeSet, new HashSet<GroupData>(after));
  }

}
