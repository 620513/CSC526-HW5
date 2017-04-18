import java.util.ArrayList;
import java.util.List;

public class Vote {
    List<String> votespriority=new ArrayList<String>();
    public Vote(String votetext,List<Candidate> candidateslist){
        String[] votestokens=votetext.split(",");
        for(int j=0;j<votestokens.length;j++) {
            String vote=votestokens[j];
            boolean isexist=false;
            for(int i=0;i<candidateslist.size();i++) {
                Candidate candidate=(Candidate)candidateslist.get(i);
                if(calculate(candidate.getCandidatename(),vote)<=3) {
                    isexist=true;
                    votespriority.add(candidate.getCandidatename());
                }
            }
            if(!isexist){
                Candidate can=new Candidate(candidateslist.size()+1,vote,"???");
                candidateslist.add(can);
                votespriority.add(vote);
            }

        }
    }
    public void removeCastingVote(String vote)
    {
        votespriority.remove(vote);
    }
    public boolean isPriorityChoice(String vote){
        if(votespriority.indexOf(vote)==0) {
            return true;
        }
        return false;
    }
    public  int calculate(String text1, String text2) {
        int text1Length = text1.length() + 1;
        int text2Length = text2.length() + 1;
        int[] cast = new int[text1Length];
        int[] newcast = new int[text1Length];
        for (int i = 0; i < text1Length; i++)
            cast[i] = i;
        for (int j = 1; j < text2Length; j++) {
            newcast[0] = j - 1;
            for (int i = 1; i < text1Length; i++) {
                int match = (text1.charAt(i - 1) == text2.charAt(j - 1)) ? 0 : 1;
                int cost_replace = cast[i - 1] + match;
                int cost_insert = cast[i] + 1;
                int cost_delete = newcast[i - 1] + 1;
                newcast[i] = Math.min(Math.min(cost_insert, cost_delete),
                        cost_replace);
            }
            int[] swapcast = cast;
            cast = newcast;
            newcast = swapcast;
        }
        text1Length=text1Length- 1;
        return cast[text1Length];
    }

}
