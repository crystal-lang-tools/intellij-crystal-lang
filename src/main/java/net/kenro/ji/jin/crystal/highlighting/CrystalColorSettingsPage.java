package net.kenro.ji.jin.crystal.highlighting;

import com.intellij.openapi.editor.colors.CodeInsightColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import com.intellij.psi.tree.TokenSet;
import net.kenro.ji.jin.crystal.icons.CrystalIcons;
import net.kenro.ji.jin.crystal.psi.CrystalTokens;
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

        return "module DemoText.View where\n" +
                "\n" +
                "import Prelude hiding (<import_ref>div</import_ref>)\n" +
                "import UserManagement.Models (<type_name>Model(..)</type_name>, <type_name>User(..)</type_name>, <type_name>class Cool</type_name>)\n" +
                "import UserManagement.Query\n" +
                "import Data.Functor (<import_ref>map</import_ref>)\n" +
                "\n" +
                "-- This is a line comment\n" +
                "\n" +
                "{- \n" +
                " This is a block comment\n" +
                "-}\n" +
                "\n" +
                "newtype <type_name>X</type_name> = <type_name>X Int</type_name>\n" +
                "\n" +
                "<type_annotation_name>patternNewtype</type_annotation_name> :: <type_name>Boolean</type_name>\n" +
                "patternNewtype =\n" +
                "  let <type_variable>X</type_variable> a = <type_variable>X</type_variable> 123\n" +
                "  in\n" +
                "   a == 123\n" +
                "\n" +
                "<type_annotation_name>patternDoNewtype</type_annotation_name> :: forall <type_variable>e</type_variable>. <type_name>Eff</type_name> <type_variable>e</type_variable> <type_name>Boolean</type_name>\n" +
                "patternDoNewtype = do\n" +
                "  let <type_variable>X</type_variable> a = <type_variable>X</type_variable> 123\n" +
                "  pure $ a == 123\n" +
                "\n" +
                "data <type_name>Y</type_name> = <type_name>Y Int String Boolean</type_name>\n" +
                "\n" +
                "-- Guards have access to current scope\n" +
                "collatz2 = \\<type_variable>x</type_variable> <type_variable>y</type_variable> -> case x of\n" +
                "  z | y > 0.0 -> z / 2.0\n" +
                "  z -> z * 3.0 + 1.0\n" +
                "\n" +
                "<type_annotation_name>min</type_annotation_name> :: forall <type_variable>a</type_variable>. <type_name>Ord</type_name> <type_variable>a</type_variable> => <type_variable>a</type_variable> -> <type_variable>a</type_variable> -> <type_variable>a</type_variable>\n" +
                "min n m | n < m     = n\n" +
                "        | otherwise = m\n" +
                "\n" +
                "<type_annotation_name>max</type_annotation_name> :: forall <type_variable>a</type_variable>. <type_name>Ord</type_name> <type_variable>a</type_variable> => <type_variable>a</type_variable> -> <type_variable>a</type_variable> -> <type_variable>a</type_variable>\n" +
                "max n m = case unit of\n" +
                "  _ | m < n     -> n\n" +
                "    | otherwise -> m\n" +
                "\n" +
                "<type_annotation_name>testIndentation</type_annotation_name> :: <type_name>Number</type_name> -> <type_name>Number</type_name> -> <type_name>Number</type_name>\n" +
                "testIndentation x y | x > 0.0\n" +
                "  = x + y\n" +
                "                    | otherwise\n" +
                "  = y - x\n" +
                "\n" +
                "-- pattern guard example with two clauses\n" +
                "<type_annotation_name>clunky1</type_annotation_name> :: <type_name>Int</type_name> -> <type_name>Int</type_name> -> <type_name>Int</type_name>\n" +
                "clunky1 a b | x <- max a b , x > 5 = x\n" +
                "clunky1 a _ = a\n" +
                "\n" +
                "<type_annotation_name>clunky2</type_annotation_name> ::<type_name>Int</type_name> -> <type_name>Int</type_name> -> <type_name>Int</type_name>\n" +
                "clunky2 a b | x <- max a b\n" +
                "            , x > 5\n" +
                "            = x\n" +
                "            | otherwise\n" +
                "            = a + b";
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
        return "Purescript";
    }
}

