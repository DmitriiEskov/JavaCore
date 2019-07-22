/**
 * Description of the problem:
 * "Let's say I have a database of scripts. Each script has an arbitrary number of dependencies.
 * The dependencies are expressed as a list of scriptIds that need to be executed before a given script.
 * There are no circular dependencies. I want to come up with an execution plan so that I can run all
 * of the scripts in a sane order."
 *
 * The VulnerabilityScript class represents the script.
 * The ExecutionPlan class contains a solution.
 */
package dbscripts;