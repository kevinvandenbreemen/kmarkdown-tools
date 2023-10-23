package com.vandenbreemen.kmarkdown

import org.intellij.markdown.flavours.commonmark.CommonMarkFlavourDescriptor

/**
 *
 */
class KMarkdownDescriptor(useSafeLinks: Boolean = true,
                          absolutizeAnchorLinks: Boolean = false):
    CommonMarkFlavourDescriptor(useSafeLinks, absolutizeAnchorLinks) {



}