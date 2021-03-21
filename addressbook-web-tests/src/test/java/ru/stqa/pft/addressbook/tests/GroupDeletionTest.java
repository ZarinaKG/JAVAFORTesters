package ru.stqa.pft.addressbook.tests;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupDeletionTest extends TestBase {
  private WebDriver wd;

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().GroupPage();
    if(app.group().list().size()==0){
      app.group().create();
    }
  }

  @Test
  public void testGroupDeletion() throws Exception {
    app.goTo().GroupPage();
    List<GroupData> before = app.group().list();
    int index = before.size()-1;

    if(before.size()<1){
      app.group().create();
    }
    app.group().delete(index);
    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(), before.size()-1);
    before.remove(index);
    HashSet<GroupData> beforeSet = new HashSet<>(before);
    HashSet<GroupData> afterSet = new HashSet<>(after);
    Assert.assertEquals(afterSet, beforeSet);
  }
}
