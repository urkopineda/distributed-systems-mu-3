package engine;

import Ice.Current;
import voting.VoteVectorHolder;
import voting.VoterPrx;
import voting._VoterDisp;

import java.util.Arrays;
import java.util.Random;

/**
 * VoteEngine that counts the voters and saves a random vote for each voter.
 *
 * @author urko
 */
public class VoteEngine extends _VoterDisp {

    private VoterPrx voter;
    private Random random;

    public VoteEngine(VoterPrx voter) {
        this.voter = voter;
        this.random = new Random();
    }

    @Override
    public int vote(int nVoters, VoteVectorHolder votes, Current __current) {
        if (votes.value == null) {
            votes.value = new int[1];
        } else votes.value = Arrays.copyOf(votes.value, votes.value.length + 1);
        if (voter != null) {
            voter.vote(nVoters - 1, votes);
        }
        votes.value[votes.value.length - 1] = random.nextInt(1000);
        return nVoters;
    }

}
