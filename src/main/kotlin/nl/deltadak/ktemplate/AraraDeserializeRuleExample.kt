package nl.deltadak.ktemplate

import org.islandoftex.arara.api.files.MPPPath
import org.islandoftex.arara.cli.ruleset.RuleUtils
import java.io.File

fun main() {
    val file = MPPPath(File("src/main/resources/arara-rule-sage.yaml").absolutePath)
    val rule = RuleUtils.parseYAMLRule(file, "sage")
    println(rule.arguments.first())
}