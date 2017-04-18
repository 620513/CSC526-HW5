/**
 * Created by UN on 11-04-2017.
 */
public class Candidate {
    int candidateid;
    String candidatename;
    String candidatepartysymbol;
    int pollingid;

    public int getCandidateid() {
        return candidateid;
    }

    public void setCandidateid(int candidateid) {
        this.candidateid = candidateid;
    }

    public String getCandidatename() {
        return candidatename;
    }

    public void setCandidatename(String candidatename) {
        this.candidatename = candidatename;
    }

    public String getCandidatepartysymbol() {
        return candidatepartysymbol;
    }

    public void setCandidatepartysymbol(String candidatepartysymbol) {
        this.candidatepartysymbol = candidatepartysymbol;
    }

    public int getPollingid() {
        return pollingid;
    }

    public void setPollingid(int pollingid) {
        this.pollingid = pollingid;
    }

    public Candidate(int id, String candidatename, String symbol) {
        this.candidateid = id;
        this.candidatename = candidatename;
        this.candidatepartysymbol = symbol;
    }
}
