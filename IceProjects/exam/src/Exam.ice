module voting
{
    sequence<int> VoteVector;
    interface Voter
    {
        int vote(int nVoters, out VoteVector votes);
    };
};