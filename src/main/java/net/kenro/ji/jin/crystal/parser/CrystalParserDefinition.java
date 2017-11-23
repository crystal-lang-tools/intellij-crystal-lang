package net.kenro.ji.jin.crystal.parser;


import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import net.kenro.ji.jin.crystal.file.CrystalFile;
import net.kenro.ji.jin.crystal.file.CrystalFileStubType;
import net.kenro.ji.jin.crystal.lexer.CrystalLexer;
import net.kenro.ji.jin.crystal.psi.CrystalTokens;
import net.kenro.ji.jin.crystal.psi.cst.CrystalASTWrapperElement;
import org.jetbrains.annotations.NotNull;

public class CrystalParserDefinition implements ParserDefinition, CrystalTokens {
    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new CrystalLexer();
    }

    @Override
    public PsiParser createParser(Project project) {
        return new CrystalParser();
    }

    @Override
    public IFileElementType getFileNodeType() {
        return CrystalFileStubType.INSTANCE;
    }

    @NotNull
    @Override
    public TokenSet getWhitespaceTokens() {
        return TokenSet.EMPTY;
    }

    @NotNull
    @Override
    public TokenSet getCommentTokens() {
        return TokenSet.EMPTY;
    }

    @NotNull
    @Override
    public TokenSet getStringLiteralElements() {
        return strings;
    }

    @NotNull
    @Override
    public PsiElement createElement(ASTNode node) {
        IElementType type = node.getElementType();
       return new CrystalASTWrapperElement(node);
    }

    @Override
    public PsiFile createFile(FileViewProvider viewProvider) {
        return new CrystalFile(viewProvider);
    }

    @Override
    public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode left, ASTNode right) {
        return SpaceRequirements.MAY;
    }
}