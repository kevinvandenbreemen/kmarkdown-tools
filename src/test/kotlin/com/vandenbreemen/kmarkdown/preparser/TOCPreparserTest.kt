package com.vandenbreemen.kmarkdown.preparser

import org.amshove.kluent.shouldContain
import org.junit.jupiter.api.Test

class TOCPreparserTest {

    @Test
    fun `should parse table of contents`() {

        val markdown = """
# Heading 1
Hello world

This is a test

## Heading 2
A sub-heading
        """.trimIndent()

        val parsed = TOCPreparser().parse(markdown)

        parsed.shouldContain("section id=\"heading-2\"")

    }

}