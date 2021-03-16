package ru.stqa.pft.addressbook.tests;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupDeletionTest extends TestBase {
  private WebDriver wd;

  @Test
  public void testGroupDeletion() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupList();

    if(before.size()<1){
      app.getGroupHelper().createGroup();
    }
    app.getGroupHelper().selectGroup(before.size()-1);
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size()-1);
    before.remove(before.size()-1);
    HashSet<GroupData> beforeSet = new HashSet<>(before);
    HashSet<GroupData> afterSet = new HashSet<>(after);
    Assert.assertEquals(afterSet, beforeSet);
  }
}
