package uk.org.cinquin.final_annotation;

import com.sun.tools.javac.code.Flags;
import com.sun.tools.javac.tree.JCTree.JCModifiers;
import com.sun.tools.javac.tree.JCTree.JCVariableDecl;
import com.sun.tools.javac.tree.TreeMaker;

/**
 * Create a new JCVariableDecl instance.
 */
public class CreateStatement {
	private final GetElement getElement;
	private final TreeMaker treeMaker;

	public CreateStatement(GetElement getElement, TreeMaker treeMaker) {
		this.getElement = getElement;
		this.treeMaker = treeMaker;
	}

	public JCVariableDecl apply(JCVariableDecl variableDeclaration) {
		JCModifiers modifiers = treeMaker.Modifiers(variableDeclaration.getModifiers().flags | Flags.FINAL);
		JCVariableDecl newVariableDeclaration = treeMaker.VarDef(modifiers, variableDeclaration.getName(),
			variableDeclaration.vartype, variableDeclaration.getInitializer());
		return newVariableDeclaration;
	}
}
