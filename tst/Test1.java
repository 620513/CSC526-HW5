import org.junit.Assert;
import org.junit.Test;

import java.sql.Time;
import java.util.ArrayList;

public class Test1 {
    @Test
    public void addPollingPlace(){
        Election election = new Election();
        ArrayList list=new ArrayList();
        Candidate c=new Candidate();
        Candidate c1=new Candidate();
        list.add(c);list.add(c1);
        PollingPlace pollingPlace=new PollingPlace(1,"test",true,list);
        Assert.assertTrue(election.addPollingPlace(pollingPlace));
    }
    @Test
    public void getPollStatus(){
        Election election = new Election();
        Assert.assertTrue(election.getPollStatus());
    }
}
