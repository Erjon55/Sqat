import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class InterfaceBasedTests {
    NotInBothTeamsClass notInBothTeamsClass = new NotInBothTeamsClass();

    @BeforeEach
    public void setUp()
    {
        notInBothTeamsClass= new NotInBothTeamsClass();
    }

    @Test
    public void bothTeamsNotEmptyNotNull()
    {
        Set<String> team1 = new HashSet<>(Arrays.asList("Erjon","Haled"));
        Set<String> team2 = new HashSet<>(Arrays.asList("Despina","Marija"));
        Set<String> result = NotInBothTeamsClass.notInBothTeams(team1,team2);
        Set<String> expected = new HashSet<>(Arrays.asList("Erjon","Haled","Despina","Marija"));
        assertEquals(result,expected);
    }

    @Test
    public void team1Empty()
    {
        Set<String> team1 = new HashSet<>(Arrays.asList());
        Set<String> team2 = new HashSet<>(Arrays.asList("Despina","Marija"));
        Set<String> result = NotInBothTeamsClass.notInBothTeams(team1,team2);
        Set<String> expected = new HashSet<>(Arrays.asList("Despina","Marija"));
        assertEquals(result,expected);
    }

    @Test
    public void team2Empty()
    {
        Set<String> team1 = new HashSet<>(Arrays.asList("Erjon","Haled"));
        Set<String> team2 = new HashSet<>(Arrays.asList());
        Set<String> result = NotInBothTeamsClass.notInBothTeams(team1,team2);
        Set<String> expected = new HashSet<>(Arrays.asList("Erjon","Haled"));
        assertEquals(result,expected);
    }

}