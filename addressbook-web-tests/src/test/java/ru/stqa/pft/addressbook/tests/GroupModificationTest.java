package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupModificationTest extends TestBase{


  @BeforeMethod
  public void ensurePreconditions(){
   app.goTo().GroupPage();
    if(app.group().list().size()==0){
      app.group().create();
    }
  }

  @Test
  public void testGroupModification(){
    List<GroupData> before = app.group().list();
    int index = before.size()-1;
    GroupData group = new GroupData()
            .withId(before.get(index).getId()).withName("test1").withHeader("test" +System.currentTimeMillis()).withFooter("test3");
    app.group().modify(index, group);
    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(), before.size());
    before.remove(index);
    before.add(group);

    HashSet<GroupData> beforeSet = new HashSet<>(before);
    Assert.assertEquals(beforeSet, new HashSet<GroupData>(after));

  }


}
