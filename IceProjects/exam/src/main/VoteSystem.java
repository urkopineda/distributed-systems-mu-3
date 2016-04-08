package main;

import engine.VoteEngine;
import voting.VoteVectorHolder;
import voting.VoterPrx;
import voting.VoterPrxHelper;

/**
 * Vote system using ICE Midlleware (EXAM)
 *
 * @author urko
 */
public class VoteSystem {

    private final String adapterIdentity = "VoteSystem";
    private final String proxyIdentity = "VoteProxy";

    private Ice.Communicator communicator;
    private Ice.ObjectAdapter adapter;
    private VoterPrx voterPrx;
    private VoteEngine voteEngine;

    private final int first_port = 6666;
    private int my_port;
    private int next_port;
    private int voter_number;

    public VoteSystem(String [] config) {
        this.my_port = Integer.parseInt(config[0]);
        this.next_port = Integer.parseInt(config[1]);
        this.voter_number = Integer.parseInt(config[2]);
    }

    public void start() {
        communicator = Ice.Util.initialize();
        adapter = communicator.createObjectAdapterWithEndpoints(adapterIdentity, "tcp -h 127.0.0.1 -p " + my_port);
        if (next_port == 0) {
            voterPrx = VoterPrxHelper.checkedCast(
                    communicator.stringToProxy(proxyIdentity + ":tcp -h 127.0.0.1 -p " + next_port));
        }
        voteEngine = new VoteEngine(voterPrx);
        adapter.add(voteEngine, communicator.stringToIdentity(proxyIdentity));
        adapter.activate();
        if (my_port == first_port) {
            VoteVectorHolder voteHolder = new VoteVectorHolder();
            voteEngine.vote(voter_number, voteHolder);
            printVotes(voteHolder);
        }
    }

    private void printVotes(VoteVectorHolder voteHolder) {
        int [] values = voteHolder.value;
        for (int i = 0; i < values.length; i++) {
            System.out.println(i + "º vote: " + values[i] + " // ");
        }
    }

    /**
     * EXAM: Parameter to introduce during the test for each execution.
     *
     * 1º Voter: 6666 6667 4
     * 2º Voter: 6667 6668 3
     * 3º Voter: 6668 6669 2
     * 4º Voter: 6669 6670 1
     * 5º Voter: 6670 0 0
     *
     * @param args
     */
    public static void main(String[] args) {
        VoteSystem voteSystem = new VoteSystem(args);
        voteSystem.start();
    }

}
