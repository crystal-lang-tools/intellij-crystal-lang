package net.kenro.ji.jin.crystal.psi.cst;

import com.intellij.psi.PsiLanguageInjectionHost;
import com.intellij.psi.impl.source.tree.injected.StringLiteralEscaper;

public class CrystalStringLiteralEscaper extends StringLiteralEscaper<PsiLanguageInjectionHost> {
    public CrystalStringLiteralEscaper(PsiLanguageInjectionHost host) {
        super(host);
    }
}