package com.vandenbreemen.kmarkdown.preparser

import java.util.*

/**
 * Table of contents preparsing.  This can be used as a standalone program
 */
class TOCPreparser {
    fun parse(markdownContent: String, tocHeader: String = "Table of Contents"): String {

        val headersRegex = Regex("(?m)^#+\\s+(.*)$")

        val headers = headersRegex.findAll(markdownContent)
            .map {
                it.groupValues[0] to it.groupValues[1] }
            .toList()

        val headerLinks = mutableMapOf<String, String>()

        val tableOfContents = StringBuilder()

        if (headers.isNotEmpty()) {
            tableOfContents.append("$tocHeader\n")
            for ((hashes, header) in headers) {
                val indentation = "  ".repeat(hashes.count { it == '#' } - 1)
                tableOfContents.append("$indentation- [${header.trim()}](#${
                    header.lowercase(Locale.getDefault()).replace("\\s+".toRegex(), "-").also { link->
                        headerLinks[hashes] = link
                    }})\n")
            }
        }

        var updatedMarkdown = markdownContent
        headerLinks.entries.forEach { headerToLink->
            updatedMarkdown = updatedMarkdown.replace(headerToLink.key, "<section id=\"${headerToLink.value}\">\n\n${headerToLink.key}\n</section>\n")
        }

        return StringBuilder(tableOfContents.toString()).append("\n\n").append(updatedMarkdown).toString()

    }


}