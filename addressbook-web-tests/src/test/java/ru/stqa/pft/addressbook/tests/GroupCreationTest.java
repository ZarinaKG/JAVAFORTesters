package ru.stqa.pft.addressbook.tests;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

public class GroupCreationTest extends TestBase{

  @Test
  public void testGroupCreation() throws Exception {
    app.goTo().GroupPage();
    Groups before = app.group().all();
    GroupData groupData = new GroupData().withName("test1").withHeader("test" +System.currentTimeMillis());
    app.group().createGroup(groupData);
    Groups  after = app.group().all();
    assertThat(after,equalTo(
            before.withAdded(groupData.withId(after.stream().mapToInt((g) ->g.getId()).max().getAsInt()))));
    assertThat(after.size(),equalTo(before.size()+1));
  }

}
