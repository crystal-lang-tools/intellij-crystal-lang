package net.kenro.ji.jin.crystal.highlighting;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import net.kenro.ji.jin.crystal.icons.CrystalIcons;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

import static net.kenro.ji.jin.crystal.highlighting.CrystalSyntaxHighlighter.*;

public class CrystalColorSettingsPage implements ColorSettingsPage {

    @NonNls
    private static final Map<String, TextAttributesKey> TAG_HIGHLIGHTING_MAP = new HashMap<String, TextAttributesKey>();

    private static final AttributesDescriptor[] ATTRIBS = {
            new AttributesDescriptor("Keyword", KEYWORD),
            new AttributesDescriptor("Number", NUMBER),
            new AttributesDescriptor("String", STRING),
            new AttributesDescriptor("Operator", OPERATOR),
            new AttributesDescriptor("Punctuation//Brackets", CRYSTAL_BRACKETS),
            new AttributesDescriptor("Punctuation//Comma", CRYSTAL_COMMA),
    };

    @Nullable
    @Override
    public Icon getIcon() {
        return CrystalIcons.FILE;
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new CrystalSyntaxHighlighter();
    }

    @NotNull
    @Override
    public String getDemoText() {

        return "module Cool\n" +
                "end\n" +
                "\n" +
                "require \"something\"\n" +
                "\n" +
                "class Person\n" +
                "  def initialize(name : String)\n" +
                "    @name = name\n" +
                "    @age = 0\n" +
                "  end\n" +
                "\n" +
                "  def name\n" +
                "    @name\n" +
                "  end\n" +
                "\n" +
                "  def age\n" +
                "    @age\n" +
                "  end\n" +
                "end\n" +
                "\n" +
                "private def method\n" +
                " 42\n" +
                "end\n" +
                "\n" +
                "def brackets_needed(a)\n" +
                " a.is_a?(Array)\n" +
                "end";
    }

    @Nullable
    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return TAG_HIGHLIGHTING_MAP;
    }

    @NotNull
    @Override
    public AttributesDescriptor[] getAttributeDescriptors() {
        return ATTRIBS;
    }

    @NotNull
    @Override
    public ColorDescriptor[] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "Crystal";
    }
}

