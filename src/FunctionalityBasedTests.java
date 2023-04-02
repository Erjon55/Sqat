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
        Set<String> team1 = new HashSet<>(Arrays.asList("Erjon","Haled"));
        Set<String> team2 = new HashSet<>(Arrays.asList("Despina","Marija"));
        Set<String> result = NotInBothTeamsClass.notInBothTeams(team1,team2);
        Set<String> expected = new HashSet<>(Arrays.asList("Erjon","Haled","Despina","Marija"));
        assertEquals(result,expected);
    }

    @Test
    public void sameSizeAtLeastOneCommon()
    {
        Set<String> team1 = new HashSet<>(Arrays.asList("Erjon","Haled"));
        Set<String> team2 = new HashSet<>(Arrays.asList("Haled","Marija"));
        Set<String> result = NotInBothTeamsClass.notInBothTeams(team1,team2);
        Set<String> expected = new HashSet<>(Arrays.asList("Erjon","Marija"));
        assertEquals(result,expected);
    }

    @Test
    public void sameSizeSameIDs()
    {
        Set<String> team1 = new HashSet<>(Arrays.asList("Erjon","Haled"));
        Set<String> team2 = new HashSet<>(Arrays.asList("Erjon","Haled"));
        Set<String> result = NotInBothTeamsClass.notInBothTeams(team1,team2);
        Set<String> expected = new HashSet<>();
        assertEquals(result,expected);
    }


    @Test
    public void team1BiggerTeam2Subset()
    {
        Set<String> team1 = new HashSet<>(Arrays.asList("Aleksandar","Mario","Sara"));
        Set<String> team2 = new HashSet<>(Arrays.asList("Aleksandar"));
        Set<String> result = NotInBothTeamsClass.notInBothTeams(team1,team2);
        Set<String> expected = new HashSet<>(Arrays.asList("Mario","Sara"));
        assertEquals(result,expected);
    }
    @Test
    public void team2BiggerTeam1Subset()
    {
        Set<String> team1 = new HashSet<>(Arrays.asList("Haled"));
        Set<String> team2 = new HashSet<>(Arrays.asList("Erjon","Haled","Despina"));
        Set<String> result = NotInBothTeamsClass.notInBothTeams(team1,team2);
        Set<String> expected = new HashSet<>(Arrays.asList("Erjon","Despina"));
        assertEquals(result,expected);
    }



    @Test
    public void team1BiggerNoCommon()
    {
        Set<String> team1 = new HashSet<>(Arrays.asList("Aleksandar","Mario","Sara"));
        Set<String> team2 = new HashSet<>(Arrays.asList("Mia","Venhar"));
        Set<String> result = NotInBothTeamsClass.notInBothTeams(team1,team2);
        Set<String> expected = new HashSet<>(Arrays.asList("Aleksandar","Mario","Sara","Mia","Venhar"));
        assertEquals(result,expected);
    }

    @Test
    public void team2BiggerNoCommon()
    {
        Set<String> team1 = new HashSet<>(Arrays.asList("Aleksandar","Mario"));
        Set<String> team2 = new HashSet<>(Arrays.asList("Sara","Mia","Venhar"));
        Set<String> result = NotInBothTeamsClass.notInBothTeams(team1,team2);
        Set<String> expected = new HashSet<>(Arrays.asList("Aleksandar","Mario","Sara","Mia","Venhar"));
        assertEquals(result,expected);
    }

    @Test
    public void team1EmptyTeam2Bigger()
    {
        Set<String> team1 = new HashSet<>(Arrays.asList());
        Set<String> team2 = new HashSet<>(Arrays.asList("Erjon","Haled"));
        Set<String> result = NotInBothTeamsClass.notInBothTeams(team1,team2);
        Set<String> expected = new HashSet<>(Arrays.asList("Erjon","Haled"));
        assertEquals(result,expected);
    }

    @Test
    public void team2EmptyTeam1Bigger()
    {
        Set<String> team1 = new HashSet<>(Arrays.asList("Erjon","Haled"));
        Set<String> team2 = new HashSet<>(Arrays.asList());
        Set<String> result = NotInBothTeamsClass.notInBothTeams(team1,team2);
        Set<String> expected = new HashSet<>(Arrays.asList("Erjon","Haled"));
        assertEquals(result,expected);
    }
}