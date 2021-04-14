package nl.deltadak.ktemplate

import org.islandoftex.arara.cli.ruleset.RuleUtils
import java.io.File
import java.nio.file.Path

fun main() {
    val file = Path.of(File("src/main/resources/arara-rule-sage.yaml").absolutePath)
    val rule = RuleUtils.parseRule(file, "sage")
    println(rule.arguments.first())
}