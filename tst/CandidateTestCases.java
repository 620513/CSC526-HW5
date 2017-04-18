import org.junit.Before;
import org.junit.Test;
import org.junit.runner.*;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;



public class CandidateTestCases {
    Candidate candidate=new Candidate(2,"John McCain","REP");
    @Test
    public void testCandidateObject() throws Exception {
        assertNotNull(candidate);
    }

    @Test
    public void testCandidateId() throws Exception {
        int id=2;
        assertEquals(id,candidate.getCandidateid());
    }

    @Test
    public void testCandiateName() throws Exception {
        String name="John McCain";
        assertEquals(name,candidate.getCandidatename());
    }

   @Test
    public void testCandidateSymbol() throws Exception {
        String symbol="REP";
        assertEquals(symbol,candidate.getCandidatepartysymbol());
    }
}
