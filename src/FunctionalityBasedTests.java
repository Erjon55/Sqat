import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class FunctionalityBasedTests {
    NotInBothTeamsClass notInBothTeamsClass = new NotInBothTeamsClass();
    @BeforeEach
    public void setUp()
    {
        notInBothTeamsClass= new NotInBothTeamsClass();
    }

    @Test
    public void sameSizeNoCommonIDsBothNotEmpty()
    {
        Set<String> team1 = new HashSet<>(Arrays.asList("Wade","Dave"));
        Set<String> team2 = new HashSet<>(Arrays.asList("Seth","Ivan"));
        Set<String> result = NotInBothTeamsClass.notInBothTeams(team1,team2);
        Set<String> expected = new HashSet<>(Arrays.asList("Wade","Dave","Seth","Ivan"));
        assertEquals(result,expected);
    }

    @Test
    public void sameSizeAtLeastOneCommon()
    {
        Set<String> team1 = new HashSet<>(Arrays.asList("Wade","Dave"));
        Set<String> team2 = new HashSet<>(Arrays.asList("Dave","Ivan"));
        Set<String> result = NotInBothTeamsClass.notInBothTeams(team1,team2);
        Set<String> expected = new HashSet<>(Arrays.asList("Wade","Ivan"));
        assertEquals(result,expected);
    }

    @Test
    public void sameSizeSameIDs()
    {
        Set<String> team1 = new HashSet<>(Arrays.asList("Wade","Dave"));
        Set<String> team2 = new HashSet<>(Arrays.asList("Wade","Dave"));
        Set<String> result = NotInBothTeamsClass.notInBothTeams(team1,team2);
        Set<String> expected = new HashSet<>();
        assertEquals(result,expected);
    }


    @Test
    public void team1BiggerTeam2Subset()
    {
        Set<String> team1 = new HashSet<>(Arrays.asList("Riley","Gilbert","Jorge"));
        Set<String> team2 = new HashSet<>(Arrays.asList("Riley"));
        Set<String> result = NotInBothTeamsClass.notInBothTeams(team1,team2);
        Set<String> expected = new HashSet<>(Arrays.asList("Gilbert","Jorge"));
        assertEquals(result,expected);
    }
    @Test
    public void team2BiggerTeam1Subset()
    {
        Set<String> team1 = new HashSet<>(Arrays.asList("Dave"));
        Set<String> team2 = new HashSet<>(Arrays.asList("Wade","Dave","Seth"));
        Set<String> result = NotInBothTeamsClass.notInBothTeams(team1,team2);
        Set<String> expected = new HashSet<>(Arrays.asList("Wade","Seth"));
        assertEquals(result,expected);
    }



    @Test
    public void team1BiggerNoCommon()
    {
        Set<String> team1 = new HashSet<>(Arrays.asList("Riley","Gilbert","Jorge"));
        Set<String> team2 = new HashSet<>(Arrays.asList("Mia","Brian"));
        Set<String> result = NotInBothTeamsClass.notInBothTeams(team1,team2);
        Set<String> expected = new HashSet<>(Arrays.asList("Riley","Gilbert","Jorge","Mia","Brian"));
        assertEquals(result,expected);
    }

    @Test
    public void team2BiggerNoCommon()
    {
        Set<String> team1 = new HashSet<>(Arrays.asList("Riley","Gilbert"));
        Set<String> team2 = new HashSet<>(Arrays.asList("Jorge","Mia","Brian"));
        Set<String> result = NotInBothTeamsClass.notInBothTeams(team1,team2);
        Set<String> expected = new HashSet<>(Arrays.asList("Riley","Gilbert","Jorge","Mia","Brian"));
        assertEquals(result,expected);
    }

    @Test
    public void team1EmptyTeam2Bigger()
    {
        Set<String> team1 = new HashSet<>(Arrays.asList());
        Set<String> team2 = new HashSet<>(Arrays.asList("Wade","Dave"));
        Set<String> result = NotInBothTeamsClass.notInBothTeams(team1,team2);
        Set<String> expected = new HashSet<>(Arrays.asList("Wade","Dave"));
        assertEquals(result,expected);
    }

    @Test
    public void team2EmptyTeam1Bigger()
    {
        Set<String> team1 = new HashSet<>(Arrays.asList("Wade","Dave"));
        Set<String> team2 = new HashSet<>(Arrays.asList());
        Set<String> result = NotInBothTeamsClass.notInBothTeams(team1,team2);
        Set<String> expected = new HashSet<>(Arrays.asList("Wade","Dave"));
        assertEquals(result,expected);
    }
}