package com.vandenbreemen.kmarkdown

import org.amshove.kluent.shouldContain
import org.intellij.markdown.flavours.gfm.GFMFlavourDescriptor
import org.intellij.markdown.html.HtmlGenerator
import org.intellij.markdown.parser.MarkdownParser
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class KMarkdownDescriptorTest {

    private fun doParse(string: String) : String {
        val flavour = KMarkdownDescriptor()
        val parsedTree = MarkdownParser(flavour).buildMarkdownTreeFromString(string)
        return HtmlGenerator(string, parsedTree, flavour).generateHtml()
    }

    @Test
    fun `should parse some basic markdown`() {
        val markdown = """
# Hello World
            
I like markdown.

I think I will use it in my next project.
        """.trimIndent()

        val parsed = doParse(markdown)
        println(parsed)

        parsed.shouldContain("<h1>Hello World</h1>")

    }

}