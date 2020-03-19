package codacy.codesniffer.docsgen.parsers

import better.files.File
import codacy.codesniffer.docsgen.VersionsHelper
import com.codacy.plugins.api.results.Pattern

import scala.util.matching.Regex

class DrupalCoderDocsParser extends DocsParser {

  override val repositoryURL = "https://github.com/pfrenssen/coder.git"

  override val checkoutCommit: String = VersionsHelper.drupalCoder

  override val sniffRegex: Regex = """.*coder_sniffer\/(Drupal)\/Sniffs\/(.*?)\/(.*?)Sniff.php""".r

  override def patternIdPartsFor(relativizedFilePath: String): PatternIdParts = {
    val sniffRegex(drupalCoderVersion, sniffType, patternName) = relativizedFilePath
    PatternIdParts(drupalCoderVersion, sniffType, patternName)
  }

  override def descriptionWithDocs(rootDir: File,
                                   patternIdParts: PatternIdParts,
                                   patternFile: File): (Pattern.Description, Option[String]) =
    (description(patternIdParts), None)

  private[this] def description(patternIdParts: PatternIdParts): Pattern.Description = {
    val caseRegexPattern = """((?<=\p{Ll})\p{Lu}|\p{Lu}(?=\p{Ll}))""".r
    val patternName = caseRegexPattern.replaceAllIn(patternIdParts.patternName, " $1").trim
    val sniffName = caseRegexPattern.replaceAllIn(patternIdParts.sniffType, " $1").trim
    val title = Pattern.Title(s"$sniffName: $patternName")
    Pattern.Description(patternIdParts.patternId, title, None, None, None)
  }

}
