import java.util.ArrayList;

/**
 * Created by UN on 11-04-2017.
 */
public class PollingPlace {
    int pollingid;
    String pollingplace;
    boolean pollingStatus;
    ArrayList addCandidates;
    public PollingPlace(int pollingid,String pollingplace,boolean pollingStatus,ArrayList addCandidates){
        this.pollingid=pollingid;
        this.pollingplace=pollingplace;
        this.pollingStatus=pollingStatus;
        this.addCandidates=addCandidates;
    }
}
