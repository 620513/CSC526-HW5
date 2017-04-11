import java.util.ArrayList;

/**
 * Created by UN on 11-04-2017.
 */
public class Election {
    ArrayList addpollingplaces;
    boolean pollstatus;
    ArrayList eliminateLowestCandidates;
    ArrayList candidateResults;
    ArrayList resultPerPollingPlace;
    public boolean addPollingPlace(PollingPlace place){
        return true;
    }
    public boolean getPollStatus(){
        return true;
    }
    public void doEliminateLowestCandidates(){
        System.out.println(" Display Candidate Results");
    }
    public void displayCandidateResults(){
        System.out.println(" Display Candidate Results");
    }
    public void displayResultsPerPollingPlace(){
        System.out.println(" Display Results Per Polling Place");
    }
}
