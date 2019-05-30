package dbscripts;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.*;

public class ExecutionPlanTest {

    @Test
    public void whenScriptWithDependenciesThenExecutionPlan() {
        List<Integer> list = new ArrayList<>();
        list.add(78);
        list.add(23);
        list.add(45);
        list.add(1);
        VulnerabilityScript script = new VulnerabilityScript(3, list);
        List<Integer> result = new ExecutionPlan().execute(script);
        List<Integer> expect = Arrays.asList(78, 23, 45, 1, 3);
        assertThat(result, is(expect));
    }

    @Test
    public void whenScriptWithNoDependenciesThenOneID() {
        List<Integer> list = new ArrayList<>();
        VulnerabilityScript script = new VulnerabilityScript(3, list);
        List<Integer> result = new ExecutionPlan().execute(script);
        List<Integer> expect = Arrays.asList(3);
        assertThat(result, is(expect));
    }
}