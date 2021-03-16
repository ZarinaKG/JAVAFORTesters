package ru.stqa.pft.addressbook.tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GroupCreationTest extends TestBase{

  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    GroupData groupData = new GroupData("test1", "test" +System.currentTimeMillis(), null);
    app.getGroupHelper().createGroup(groupData);
    List<GroupData>  after = app.getGroupHelper().getGroupList();
   Assert.assertEquals(after.size(), before.size()+1);

    before.add(groupData);

    HashSet<GroupData> beforeSet = new HashSet<>(before);
    Assert.assertEquals(beforeSet, new HashSet<GroupData>(after));
  }

}
