package ru.stqa.pft.addressbook.tests;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class GroupDeletionTest extends TestBase {
  private WebDriver wd;

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().GroupPage();
    if(app.group().all().size()==0){
      app.group().create();
    }
  }

  @Test
  public void testGroupDeletion() throws Exception {
    app.goTo().GroupPage();

    Groups before = app.group().all();
    GroupData deletedGroup = before.iterator().next();
    if(before.size()<1){
      app.group().create();
    }
    app.group().delete(deletedGroup);
    Groups after = app.group().all();
    Assert.assertEquals(after.size(), before.size()-1);
    before.remove(deletedGroup);
    assertThat(after, equalTo(before.without(deletedGroup)));

  }
}
