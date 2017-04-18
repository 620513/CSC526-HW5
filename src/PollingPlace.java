import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by UN on 11-04-2017.
 */
public class PollingPlace {
    int pollingid;
    String pollingplace;
    boolean pollingStatus;
    ArrayList<Vote> candidatesVotes=new ArrayList<Vote>();

    public PollingPlace(int pollingid, String pollingplace, boolean pollingStatus,List<Candidate> candidates) throws FileNotFoundException {
        this.pollingid = pollingid;
        this.pollingplace = pollingplace;
        this.pollingStatus = pollingStatus;
        int i = 1;
        String elctionpollingname="ballots-"+pollingplace.replace(" ","-")+".txt";
        File file = new File(elctionpollingname);
        Scanner inputscanner = new Scanner(file);
        do{
            String votetext = inputscanner.nextLine();
            Vote currentvote = new Vote(votetext,candidates);
            candidatesVotes.add(currentvote);
        }while(inputscanner.hasNext());
    }

    public int getPollingid() {
        return pollingid;
    }

    public void setPollingid(int pollingid) {
        this.pollingid = pollingid;
    }

    public String getPollingplace() {
        return pollingplace;
    }

    public void setPollingplace(String pollingplace) {
        this.pollingplace = pollingplace;
    }

    public boolean isPollingStatus() {
        return pollingStatus;
    }

    public void setPollingStatus(boolean pollingStatus) {
        this.pollingStatus = pollingStatus;
    }

    public ArrayList<Vote> getCandidatesVotes() {
        return candidatesVotes;
    }

    public void setCandidatesVotes(ArrayList<Vote> candidatesVotes) {
        this.candidatesVotes = candidatesVotes;
    }

    public int getVotes(Candidate candidate){
        int countvotes=0;
        for(Vote tempvote:candidatesVotes){
            if(tempvote.isPriorityChoice(candidate.getCandidatename()))
                countvotes++;
        }
        return countvotes;
    }
    public int totalVotesCount(){
        return candidatesVotes.size();
    }
    public void removeCandidate(Candidate candidate){
        for (Vote tempvote:candidatesVotes){
            tempvote.removeCastingVote(candidate.getCandidatename());
        }
    }
}
