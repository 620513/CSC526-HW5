import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Election {
    List<PollingPlace> pollingPlaceslist=new ArrayList<PollingPlace>();
    List<Candidate> candidateslist=new ArrayList<Candidate>();
    boolean pollstatus=false;
    public boolean addElectionPollingPlace(String pollingPlaceNameText) {
        try {
            PollingPlace addpollingPlace = new PollingPlace(pollingPlaceslist.size() + 1, pollingPlaceNameText, false,candidateslist);
            pollingPlaceslist.add(addpollingPlace);
            return true;
        }
        catch (Exception ex){
            return false;
        }
    }
    public PollingPlace getElectionPollingPlace(String pollingPlaceNameText){
        for(int i=0;i<pollingPlaceslist.size();i++) {
            PollingPlace currentPollingPlace=(PollingPlace)pollingPlaceslist.get(i);
            if(currentPollingPlace.getPollingplace().toLowerCase().equals(pollingPlaceNameText.toLowerCase()))
                return currentPollingPlace;
        }
        return null;
    }

    public void addPollingCandidates() throws FileNotFoundException {
        int i = 1;
        File file = new File("candidates.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            String candidateString = scanner.nextLine();
            String[] candidateNames = candidateString.split(",");
            Candidate candidate = new Candidate(i++, candidateNames[0], candidateNames[1]);
            candidateslist.add(candidate);
        }
    }
    public int allPlacesTotalCandidateVotes(){
        int countvotes=0;
        for(int i=0;i<pollingPlaceslist.size();i++) {
            PollingPlace currentPollingPlace=(PollingPlace)pollingPlaceslist.get(i);
            countvotes+=currentPollingPlace.totalVotesCount();
        }
        return countvotes;
    }
    public int allPlacesCandidateVotes(Candidate candidate){
        int countvotes=0;
        for(int i=0;i<pollingPlaceslist.size();i++) {
            PollingPlace currentPollingPlace=(PollingPlace)pollingPlaceslist.get(i);
            countvotes+=currentPollingPlace.getVotes(candidate);
        }
        return countvotes;
    }
    public void eliminateLowestVotsGotCandidate(Candidate candidate){
        for(int i=0;i<pollingPlaceslist.size();i++) {
            PollingPlace currentPollingPlace=(PollingPlace)pollingPlaceslist.get(i);
            currentPollingPlace.removeCandidate(candidate);
        }
        candidateslist.remove(candidate);
    }
    public void closePollingElection(){
        for(int i=0;i<candidateslist.size();i++){
            Candidate candidate=candidateslist.get(i);
            if(candidate.getCandidatepartysymbol().equals("???")&&allPlacesCandidateVotes(candidate)==0)
                candidateslist.remove(candidate);
        }
        pollstatus=true;
    }

    public boolean isClosedPolling() {
        return pollstatus;
    }
    public List<Candidate> getCandidates() {
        return candidateslist;
    }
    public Candidate eliminateLowestCandidates(){
        int totalvotescount=allPlacesTotalCandidateVotes();
        int minimumvotes=totalvotescount+1;
        Candidate minCandidate=null;
        for(int i=0;i<candidateslist.size();i++) {
            Candidate candidate=(Candidate)candidateslist.get(i);
            int candidatevotes = allPlacesCandidateVotes(candidate);
            if(candidatevotes*2>totalvotescount) {
                return null;
            }
            if(candidatevotes<minimumvotes){
                minimumvotes=candidatevotes;
                minCandidate=candidate;
            }else if(minimumvotes==candidatevotes&&minCandidate.getCandidatename().compareTo(candidate.getCandidatename())<0){
                minCandidate=candidate;
            }
        }
        return minCandidate;
    }
    public void individualPlaceResults(PollingPlace pollingPlace){
        int totalvotescount=pollingPlace.totalVotesCount();
        ArrayList results=new ArrayList();
        for(int i=0;i<candidateslist.size();i++) {
            Candidate candidate=(Candidate)candidateslist.get(i);
            int candidatevotes=pollingPlace.getVotes(candidate);
            float percentvotesgot=(float)candidatevotes*100/(float)totalvotescount;
            GetResult result=new GetResult(candidate,candidatevotes,percentvotesgot);
            results.add(result);
        }
        Collections.sort(results,
                new Comparator<GetResult>(){
                    @Override
                    public int compare(final GetResult getResult1,GetResult getResult2) {
                        if (getResult1.getVotescount() < getResult2.getVotescount()) {
                            return 1;
                        } else if (getResult1.getVotescount() > getResult2.getVotescount()) {
                            return -1;
                        } else if (getResult1.getCandidate().getCandidatename().compareTo(getResult2.getCandidate().getCandidatename()) < 0) {
                            return 1;
                        } else if (getResult1.getCandidate().getCandidatename().compareTo(getResult2.getCandidate().getCandidatename()) > 0) {
                            return -1;
                        } else {
                            return 0;
                        }
                    }});
        for(Object displayresult:results){
            GetResult getResult=(GetResult)displayresult;
            System.out.printf("%-34s%-10s%6d%9.3f\n",getResult.getCandidate().getCandidatename(),getResult.getCandidate().getCandidatepartysymbol(),getResult.getVotescount(),getResult.getGotpercentage());
        }
    }
    public void displayAllPlacesResults(){
        int totalVotes=allPlacesTotalCandidateVotes();
        ArrayList results=new ArrayList();
        for(int i=0;i<candidateslist.size();i++) {
            Candidate candidate=(Candidate)candidateslist.get(i);
            int candidategotvotes=allPlacesCandidateVotes(candidate);
            float percentvotesgot=(float)candidategotvotes*100/(float)totalVotes;
            GetResult getResult=new GetResult(candidate,candidategotvotes,percentvotesgot);
            results.add(getResult);
        }
        Collections.sort(results,
                new Comparator<GetResult>(){
                    @Override
                    public int compare(final GetResult getResult1,GetResult getResult2) {
                        if (getResult1.getVotescount() < getResult2.getVotescount()) {
                            return 1;
                        } else if (getResult1.getVotescount() > getResult2.getVotescount()) {
                            return -1;
                        } else if (getResult1.getCandidate().getCandidatename().compareTo(getResult2.getCandidate().getCandidatename()) < 0) {
                            return 1;
                        } else if (getResult1.getCandidate().getCandidatename().compareTo(getResult2.getCandidate().getCandidatename()) > 0) {
                            return -1;
                        } else {
                            return 0;
                        }
                    }});
        for(Object displayresult:results){
            GetResult getResult=(GetResult)displayresult;
            System.out.printf("%-34s%-10s%6d%9.3f\n",getResult.getCandidate().getCandidatename(),getResult.getCandidate().getCandidatepartysymbol(),getResult.getVotescount(),getResult.getGotpercentage());
        }
    }
}
