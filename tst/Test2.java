import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by UN on 11-04-2017.
 */
public class Test2 {
    @Test
    public void testPollingPlace(){
        ArrayList list=new ArrayList();
        Candidate c=new Candidate();
        Candidate c1=new Candidate();
        list.add(c);list.add(c1);
        PollingPlace pollingPlace=new PollingPlace(1,"test",true,list);
        Assert.assertNotNull(pollingPlace);
    }
    @Test
    public void getVotesCount(){
        VotingResult votingResult=new VotingResult();
        Assert.assertEquals("0",""+votingResult.getVotesCount());
    }
}
