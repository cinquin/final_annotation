package uk.org.cinquin.final_annotation;

import com.sun.tools.javac.code.Flags;
import com.sun.tools.javac.processing.JavacProcessingEnvironment;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.TreeMaker;
import com.sun.tools.javac.tree.TreeTranslator;

public class FinalTranslator extends TreeTranslator {

	TreeMaker treeMaker;

	public FinalTranslator(JavacProcessingEnvironment javacProcessingEnvironment, TreeMaker treeMaker) {
		this.treeMaker = treeMaker;
	}

	@Override
	public void visitVarDef(JCTree.JCVariableDecl variableDeclaration) {
		super.visitVarDef(variableDeclaration);
		if (isFinalAnnotation(variableDeclaration.getModifiers())) {
			variableDeclaration.mods.flags |= Flags.FINAL;
		}
	}

	private static boolean isFinalAnnotation(JCTree.JCModifiers modifiers) {
		return modifiers.toString().contains("@Final()");
	}

}
