package dbscripts;

import java.util.List;

/**
 * This class contains the execution for the problem described in the package-info.
 */
public class ExecutionPlan {

    /**
     * Returns a sane order of scripts of VulnerabilityScript.
     * @param script an object containing a list of scriptIds that need to be executed before itself
     * @return a sequential order of scriptIds + script's ID
     */
    public List<Integer> execute(VulnerabilityScript script) {
        List<Integer> list = script.getDependencies();
        list.add(script.getScriptId());
        return list;
    }
}