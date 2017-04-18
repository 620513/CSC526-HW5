import java.util.Comparator;

public class GetResult {
    Candidate candidate;
    int votescount;
    float gotpercentage;

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public int getVotescount() {
        return votescount;
    }

    public void setVotescount(int votescount) {
        this.votescount = votescount;
    }

    public float getGotpercentage() {
        return gotpercentage;
    }

    public void setGotpercentage(float gotpercentage) {
        this.gotpercentage = gotpercentage;
    }

    public GetResult(Candidate candidate, int votescount, float gotpercentage) {
        this.candidate = candidate;
        this.votescount = votescount;
        this.gotpercentage = gotpercentage;
    }
}